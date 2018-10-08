package com.example.utkarsh.sarvodayaventurestask.model;

public class UsersDetails {
    private static final UsersDetails ourInstance = new UsersDetails();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;
    public static UsersDetails getInstance() {
        return ourInstance;
    }

    public UsersDetails() {
    }
}
