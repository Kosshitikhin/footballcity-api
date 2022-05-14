package com.kosshitikhin.footballcity.auth;

import com.kosshitikhin.footballcity.auth.dto.*;
import com.kosshitikhin.footballcity.user.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("register")
    public UserDto register(@Valid @RequestBody RegistrationRequest registrationRequest) {
        return authenticationService.register(registrationRequest);
    }

    @PostMapping("confirm-register")
    public JWTResponse confirmRegistration(@Valid @RequestBody ConfirmationRequest confirmationRequest) {
        return authenticationService.confirmRegistration(confirmationRequest);
    }

    @PostMapping("login")
    public JWTResponse login(@Valid @RequestBody JWTRequest request) throws Exception {
        return authenticationService.authenticate(request);
    }

    @PostMapping("reset")
    public UserDto sendEmailWithResetCodeByEmailOrUsername(@Valid @RequestBody PasswordResetRequest passwordResetRequest) {
        return authenticationService.sendEmailWithRecoveryCode(passwordResetRequest);
    }

    @PostMapping("reset-confirm")
    public void resetPasswordWithCodeFromEmail(@Valid @RequestBody ConfirmPasswordResetRequest confirmPasswordResetRequest) {
        authenticationService.resetPasswordWithCodeFromEmail(confirmPasswordResetRequest);
    }

    @PostMapping("refresh-token")
    public JWTResponse refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authenticationService.refreshToken(refreshTokenRequest);
    }

    @PutMapping("logout")
    public void setInactive(@Valid @RequestBody FcmTokenRequest fcmTokenRequest) {
        authenticationService.removeFcmToken(fcmTokenRequest);
    }
}
