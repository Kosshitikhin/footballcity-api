package com.kosshitikhin.footballcity.goals;

public class GoalRequest {

    private String firstName;

    private String surname;

    private int minute;

    private int rowGoal;

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

    public int getRowGoal() {
        return rowGoal;
    }

    public void setRowGoal(int rowGoal) {
        this.rowGoal = rowGoal;
    }
}
