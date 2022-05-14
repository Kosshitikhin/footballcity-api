package com.kosshitikhin.footballcity.auth;

import com.kosshitikhin.footballcity.auth.dto.*;
import com.kosshitikhin.footballcity.common.rest.exception.*;
import com.kosshitikhin.footballcity.user.User;
import com.kosshitikhin.footballcity.user.UserRepository;
import com.kosshitikhin.footballcity.user.dto.UserDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JWTTokenUtil jwtTokenUtil;
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    private static final Random random = new Random();

    public AuthenticationService(AuthenticationManager authenticationManager,
                                 UserRepository userRepository,
                                 JWTTokenUtil jwtTokenUtil,
                                 AuthService authService,
                                 PasswordEncoder passwordEncoder,
                                 UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authService = authService;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    public JWTResponse authenticate(JWTRequest request) throws Exception {
        try {
            UserDetailsImpl userDetails = (UserDetailsImpl) authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())).getPrincipal();
            return jwtTokenUtil.generateToken(userDetails);
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    public UserDto register(RegistrationRequest registrationRequest) {
        User user = userRepository.findByEmail(registrationRequest.getEmail());

        if (user == null) {
            user = new User();
            user.setRoles(User.Role.USER.name().toLowerCase());
        } else if (user.isActive()) {
            throw ConflictException.active();
        }

        user.setEmail(registrationRequest.getEmail().toLowerCase());
        user.setPassHash(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setActive(false);
        //todo send confirm code by email then replace UserDto to void
        user.setConfirmCode(generateConfirmCode());
        return new UserDto(userRepository.save(user));
    }

    public JWTResponse confirmRegistration(ConfirmationRequest confirmationRequest) {
        User user = userRepository.findByEmail(confirmationRequest.getEmail());

        if (user == null) {
            throw NotFoundException.user();
        }

        if (confirmationRequest.getConfirmCode().equals(user.getConfirmCode())) {
            if (!user.isActive()) {
                user.setActive(true);
                user.setConfirmCode("");
                userRepository.save(user);
            }
        } else {
            throw new ForbiddenException("Wrong confirm code!");
        }

        return jwtTokenUtil.generateToken(user);
    }

    public UserDto sendEmailWithRecoveryCode(PasswordResetRequest passwordResetRequest) {
        User user;
        if (passwordResetRequest.getEmail() != null) {
            user = userRepository.findByEmail(passwordResetRequest.getEmail());
        } else {
            throw new NotAcceptableException();
        }
        if (user != null) {
            //todo send confirm code by email then replace UserDto to void
            user.setConfirmCode(generateConfirmCode());
            return new UserDto(userRepository.save(user));
        } else {
            throw NotFoundException.user();
        }
    }

    public void resetPasswordWithCodeFromEmail(ConfirmPasswordResetRequest confirmPasswordResetRequest) {
        User user = userRepository.findByEmail(confirmPasswordResetRequest.getEmail());
        if (user != null) {
            if (user.getConfirmCode().equals(confirmPasswordResetRequest.getConfirmCode())) {
                updatePassword(user, confirmPasswordResetRequest.getPassword());
            } else {
                throw new ForbiddenException();
            }
        } else {
            throw new ForbiddenException();
        }
    }

    public JWTResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String email = jwtTokenUtil.getUsernameFromToken(refreshTokenRequest.getRefreshToken());
        UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(email);
        if (jwtTokenUtil.validateToken(refreshTokenRequest.getRefreshToken(), userDetails)) {
            return jwtTokenUtil.generateToken(userDetails);
        } else {
            throw new UnauthorizedException();
        }
    }

    public void removeFcmToken(FcmTokenRequest fcmTokenRequest) {
        User user = authService.getCurrentUser();
        if (fcmTokenRequest.getFcmToken().equals(user.getFcmToken())) {
            user.setFcmToken(null);
            userRepository.save(user);
        }
    }

    private String generateConfirmCode() {
        int min = 10000;
        int max = 99999;
        int diff = max - min;
        int result = random.nextInt(diff + 1);
        result += min;
        return String.valueOf(result);
    }

    private void updatePassword(User user, String newPassword) {
        user.setPassHash(passwordEncoder.encode(newPassword));
        user.setLastPasswordResetTime(new Date());
        userRepository.save(user);
    }
}
