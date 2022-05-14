package com.kosshitikhin.footballcity.coach.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CoachRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String surname;

    @NotNull
    private String patronymic;

    @NotNull
    private LocalDate birthday;

    public CoachRequest() {
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
