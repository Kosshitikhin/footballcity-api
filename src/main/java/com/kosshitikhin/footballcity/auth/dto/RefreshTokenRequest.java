package com.kosshitikhin.footballcity.auth.dto;

import javax.validation.constraints.NotEmpty;

public class RefreshTokenRequest {

    @NotEmpty
    private String refreshToken;

    public RefreshTokenRequest() {
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
