package com.kosshitikhin.footballcity.auth.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ConfirmPasswordResetRequest extends ConfirmationRequest {
    @Size(min = 6)
    @NotEmpty
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
