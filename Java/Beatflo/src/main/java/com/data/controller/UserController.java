package com.data.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.entity.user;
import com.data.service.UserService;

//@CrossOrigin(origins = "http://localhost:4200") // Allow Angular frontend access
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // ✅ Register new user
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody user user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    // ✅ User login (email + password)
    @PostMapping("/login")
    public String loginUser(@RequestBody user loginRequest) {
        boolean isAuthenticated = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());

        if (isAuthenticated) {
            return "Login successful!";
        } else {
            return "Invalid email or password!";
        }
    }

    // ✅ Get user by email
    @GetMapping("/email/{email}")
    public Optional<user> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    // ✅ Get all users
    @GetMapping("/all")
    public List<user> getAllUsers() {
        return userService.getAllUsers();
    }
}
