package com.data.entity;
import jakarta.persistence.*;


@Entity

public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long userid;

   String name;

    @Column(unique = true)
     String email;

     String password;
    String role = "USER"; // Default role

    public user() {}

    public user(Long id, String name, String email, String password, String role) {
        this.userid = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // ✅ Getters & Setters
    public Long getId() { return userid; }
    public void setId(Long id) { this.userid = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}


