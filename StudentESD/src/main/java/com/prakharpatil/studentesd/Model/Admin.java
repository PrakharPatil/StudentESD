package com.prakharpatil.studentesd.Model;
// LoginRequest.java

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {

    @Id
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
// Getters and setters
    // Constructors
    // Other necessary methods
}