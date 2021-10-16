package com.kosshitikhin.footballcity.goals.dto;

import com.kosshitikhin.footballcity.goals.Goal;

public class GoalDto {

    private String firstName;

    private String surname;

    private int minute;

    public GoalDto(String firstName, String surname, int minute) {
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

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
