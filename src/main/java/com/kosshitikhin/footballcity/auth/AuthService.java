package com.kosshitikhin.footballcity.auth;

import com.kosshitikhin.footballcity.user.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean isTheSameUser(Long id) {
        return getCurrentUserId().equals(id);
    }

    public User getCurrentUser() {
        return getCurrentPrincipal().getUser();
    }

    public Long getCurrentUserId() {
        return getCurrentUser().getId();
    }

    protected UserDetailsImpl getCurrentPrincipal() {
        return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public boolean isAuthenticated() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return !principal.getClass().equals(String.class);
    }
}
