package com.example.utkarsh.sarvodayaventurestask.model;

public class Users {

    String name;
    String email;
    String phone;
    String password;
    String gender;

    public Users()
    {

    }

    public Users(String email,String name,String gender,String phone,String password)
    {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.gender = gender;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
