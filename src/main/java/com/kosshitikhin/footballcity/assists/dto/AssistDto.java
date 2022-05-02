package com.kosshitikhin.footballcity.assists.dto;

import com.kosshitikhin.footballcity.assists.Assist;

public class AssistDto {

    private String firstName;

    private String surname;

    private Integer minute;

    public AssistDto() {
    }

    public AssistDto(String firstName, String surname, Integer minute) {
        this.firstName = firstName;
        this.surname = surname;
        this.minute = minute;
    }

    public AssistDto(Assist assist) {
        this.firstName = assist.getFirstName();
        this.surname = assist.getSurname();
        this.minute = assist.getMinute();
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
