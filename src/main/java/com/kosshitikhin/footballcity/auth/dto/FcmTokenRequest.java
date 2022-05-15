package com.kosshitikhin.footballcity.auth.dto;

import javax.validation.constraints.NotNull;

public class FcmTokenRequest {

    @NotNull
    private String fcmToken;

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }
}