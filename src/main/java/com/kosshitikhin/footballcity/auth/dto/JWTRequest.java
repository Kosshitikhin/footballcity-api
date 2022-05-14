package com.kosshitikhin.footballcity.auth.dto;


import javax.validation.constraints.NotNull;

public class JWTRequest {

    @NotNull
    private String email;

    @NotNull
    private String password;

    public JWTRequest() {
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
}
