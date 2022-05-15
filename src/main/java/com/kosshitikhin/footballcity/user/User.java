package com.kosshitikhin.footballcity.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kosshitikhin.footballcity.common.dbo.IdEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "`user`")
public class User extends IdEntity {

    @Column(nullable = false)
    private String firstName;

    @Column (nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String passHash;
    private boolean active;

    @Column(nullable = false)
    private String roles;

    private Date lastPasswordResetTime;

    private String confirmCode;

    private String fcmToken;

    public User() {
        this.firstName = "";
        this.surname = "";
    }

    public User(String firstName, String surname, String email) {
        this.roles = Role.USER.name().toLowerCase();
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
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

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return Arrays.stream(roles.split(" ")).map(r -> Role.valueOf(r.toUpperCase())).collect(Collectors.toSet());
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Date getLastPasswordResetTime() {
        return lastPasswordResetTime;
    }

    public void setLastPasswordResetTime(Date lastPasswordResetTime) {
        this.lastPasswordResetTime = lastPasswordResetTime;
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum Role implements GrantedAuthority {
        ADMIN("ROLE_ADMIN"),
        USER("ROLE_USER");

        @JsonProperty
        private final String text;

        Role(final String text) {
            this.text = text;
        }

        @JsonProperty
        public String getName() {
            return this.name();
        }

        @Override
        public String toString() {
            return text;
        }

        @Override
        @JsonIgnore
        public String getAuthority() {
            return text;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        User user = (User) o;
        return isActive() == user.isActive() &&
                Objects.equals(firstName, user.getFirstName()) &&
                Objects.equals(surname, user.getSurname()) &&
                Objects.equals(passHash, user.passHash) &&
                Objects.equals(lastPasswordResetTime, user.lastPasswordResetTime) &&
                Objects.equals(email, user.getEmail()) &&
                Objects.equals(confirmCode, user.confirmCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, surname, email, active, lastPasswordResetTime, confirmCode);
    }
}
