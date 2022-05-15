package com.kosshitikhin.footballcity.auth.dto;


import javax.validation.constraints.NotNull;

public class JWTRequest {

    @NotNull
    private String email;

    @NotNull
    private String password;

    private String fcmToken;

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

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }
}
