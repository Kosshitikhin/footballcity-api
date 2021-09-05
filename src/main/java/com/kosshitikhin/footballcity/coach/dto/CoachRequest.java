package com.kosshitikhin.footballcity.coach.dto;

import javax.validation.constraints.NotNull;

public class CoachRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String surname;

    @NotNull
    private String patronymic;

    @NotNull
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
