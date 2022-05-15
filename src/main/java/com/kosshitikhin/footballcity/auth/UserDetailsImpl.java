package com.kosshitikhin.footballcity.auth;

import com.kosshitikhin.footballcity.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {
    protected final Collection<? extends GrantedAuthority> authorities;
    private final String password;
    protected User user;

    public UserDetailsImpl(Collection<? extends GrantedAuthority> authorities, String password) {
        this.authorities = authorities;
        this.password = password;
    }

    public UserDetailsImpl(User user, Collection<? extends GrantedAuthority> authorities, String password) {
        this(authorities, password);
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.user == null || this.user.isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "UserDetailsImpl{" +
                "authorities=" + authorities +
                ", user=" + user +
                '}';
    }
}