package com.kosshitikhin.footballcity.goals.dto;

import javax.validation.constraints.NotNull;

public class GoalRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String surname;

    @NotNull
    private int minute;

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

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
