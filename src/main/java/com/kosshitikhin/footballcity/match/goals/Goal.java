package com.kosshitikhin.footballcity.match.goals;

public class Goal {

    private String firstName;

    private String surname;

    private int minute;

    public Goal() {
    }

    public Goal(String firstName, String surname, int minute) {
        this.firstName = firstName;
        this.surname = surname;
        this.minute = minute;
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
