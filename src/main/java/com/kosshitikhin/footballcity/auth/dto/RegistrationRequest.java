package com.kosshitikhin.footballcity.auth.dto;

import javax.validation.constraints.*;

public class RegistrationRequest {

    @Email
    @NotNull
    private String email;

    @Size(min = 6)
    @NotEmpty
    private String password;

    public RegistrationRequest() {
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
