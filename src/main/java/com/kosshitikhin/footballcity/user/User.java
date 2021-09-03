package com.kosshitikhin.footballcity.user;

import com.kosshitikhin.footballcity.common.dbo.IdEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
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

    private boolean active;

    @Column(nullable = false)
    private String roles;

    public User() {

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

    public enum Role implements GrantedAuthority {
        USER("USER"),
        ADMIN("ADMIN");
        private final String text;

        Role(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }

        @Override
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
                Objects.equals(email, user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, surname, email, isActive());
    }
}
