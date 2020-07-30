package org.launchcode.spaday.models;

import java.time.LocalDateTime;


public class User {

    private int ID;
    private static int nextID = 1;
    private String userName;
    private String password;
    private String email;
    private LocalDateTime timeJoined;



    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.ID = nextID;
        nextID++;
        timeJoined = LocalDateTime.now();
    }

    public LocalDateTime getTimeJoined() {
        return timeJoined;
    }

    public int getID() {
        return ID;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

        
}