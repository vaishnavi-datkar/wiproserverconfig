package com.wipro.threeboot.model;

public class User {
    private String username;
    private String userEmail;
    private String userPhone;

    // Constructors
    public User() {}

    public User(String username, String userEmail, String userPhone) {
        this.username = username;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

    // Getters & Setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
