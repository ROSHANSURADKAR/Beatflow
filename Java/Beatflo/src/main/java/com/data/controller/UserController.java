package com.data.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.entity.user;
import com.data.service.UserService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity<?> loginUser(@RequestBody user loginRequest) {
        Optional<user> foundUser = userService.getUserByEmail(loginRequest.getEmail());

        if (foundUser.isPresent() && foundUser.get().getPassword().equals(loginRequest.getPassword())) {
            // Return the object so Angular gets JSON: { "userid": 1, "name": "..." }
            return ResponseEntity.ok(foundUser.get());
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
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
