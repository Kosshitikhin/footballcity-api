package com.kosshitikhin.footballcity.goals.dto;

import com.kosshitikhin.footballcity.goals.Goal;

public class GoalDto {

    private String firstName;

    private String surname;

    private Integer minute;

    public GoalDto(String firstName, String surname, Integer minute) {
        this.firstName = firstName;
        this.surname = surname;
        this.minute = minute;
    }

    public GoalDto(Goal goal) {
        this.firstName = goal.getFirstName();
        this.surname = goal.getSurname();
        this.minute = goal.getMinute();
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

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }
}
