package com.crud.test.rest;



public class User {
    
    private long user_id;
    private String username;
    private String email;
    private String phoneNo;
    private String password;
    private String role;
    private String token;

    

    public User() {
    }


    public User(long user_id, String username, String email,String phoneNo, String password,String role) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.role = this.role;
    }


    public User(String email, String password,String token) {
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }


    public long getUser_id() {
        return user_id;
    }


    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
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
    }


    public String getPhoneNo() {
        return phoneNo;
    }


    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }


    

    
}
