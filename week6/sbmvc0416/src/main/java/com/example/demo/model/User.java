package com.example.demo.model;

public class User {
    private String userName;
    private String email;
    private String role;
    private String gender;
    public User() {}
    public User(String name, String email, String role, String gender) {
        this.userName = name;
        this.email = email;
        this.role = role;
        this.gender = gender;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String name) {
        this.userName = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
}


