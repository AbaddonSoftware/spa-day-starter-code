package org.launchcode.spaday.models;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    private int ID;
    private static int nextID = 1;

    @NotNull(message="Passwords do not match.")
    private String verifyPassword;

    @NotBlank(message="Name is required.")
    @Size(min = 5, max = 15, message="Name must be between 5 and 15 characters long.")
    private String name;

    @Size(min = 6, message = "Password field must be longer than six characters.")
    private String password;

    @Email(message = "Optional: If entered must be a valid email.")
    private String email;

    private LocalDateTime timeJoined;

    public User() {
        this.ID = nextID;
        nextID++;
        timeJoined = LocalDateTime.now();
    }

    public User(String name, String password, String email) {
        this();
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public LocalDateTime getTimeJoined() {
        return timeJoined;
    }

    public int getID() {
        return ID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }
    
    public String getVerifyPassword() {
        return verifyPassword;
    }
    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword() {
        verifyPassword = password == null || verifyPassword == null || !password.equals(verifyPassword) ? null : verifyPassword;
    }
        
}