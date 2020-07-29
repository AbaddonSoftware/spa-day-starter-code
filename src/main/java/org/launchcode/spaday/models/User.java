package org.launchcode.spaday.models;

public class User {

    private final int ID;
    private static int nextID = 1;
    private String userName;
    private String password;
    private String email;

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.ID = nextID;
        nextID++;
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