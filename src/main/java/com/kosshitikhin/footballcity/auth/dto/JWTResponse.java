package com.kosshitikhin.footballcity.auth.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;

public class JWTResponse {

    private static final String tokenType = "Bearer";
    private final String accessToken;
    private final Date accessTokenExpiresAt;
    private final String refreshToken;
    private final Date refreshTokenExpiresAt;
    private final Collection<? extends GrantedAuthority> authorities;
    private Long userId;

    public JWTResponse(String accessToken, Date accessTokenExpiresAt, String refreshToken, Date refreshTokenExpiresAt, Collection<? extends GrantedAuthority> authorities) {
        this.accessToken = accessToken;
        this.accessTokenExpiresAt = accessTokenExpiresAt;
        this.refreshToken = refreshToken;
        this.refreshTokenExpiresAt = refreshTokenExpiresAt;
        this.authorities = authorities;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Date getAccessTokenExpiresAt() {
        return accessTokenExpiresAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public Date getRefreshTokenExpiresAt() {
        return refreshTokenExpiresAt;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
