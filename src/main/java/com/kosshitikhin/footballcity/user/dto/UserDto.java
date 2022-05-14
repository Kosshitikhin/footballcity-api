package com.kosshitikhin.footballcity.user.dto;

import com.kosshitikhin.footballcity.common.dto.IdDto;
import com.kosshitikhin.footballcity.user.User;

import java.util.Set;

public class UserDto extends IdDto {

    private String firstName;
    private String surname;
    private String email;
    private Set<User.Role> roles;
    private boolean active;

    private String fcmToken;

    public UserDto() {
    }

    public UserDto(User user) {
        super(user.getId());
        this.firstName = user.getFirstName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.roles = user.getRoles();
        this.active = user.isActive();
        this.fcmToken = user.getFcmToken();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<User.Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<User.Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }
}
