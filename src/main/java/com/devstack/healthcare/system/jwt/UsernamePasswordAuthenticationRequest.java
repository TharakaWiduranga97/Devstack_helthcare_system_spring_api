package com.devstack.healthcare.system.jwt;

public class UsernamePasswordAuthenticationRequest {
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private String password;

    public UsernamePasswordAuthenticationRequest() {
    }

    public UsernamePasswordAuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
