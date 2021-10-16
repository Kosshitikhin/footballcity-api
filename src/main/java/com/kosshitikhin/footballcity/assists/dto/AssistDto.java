package com.kosshitikhin.footballcity.assists.dto;

import com.kosshitikhin.footballcity.assists.Assist;

public class AssistDto {

    private String firstName;

    private String surname;

    private int minute;

    public AssistDto() {
    }

    public AssistDto(String firstName, String surname, int minute) {
        this.firstName = firstName;
        this.surname = surname;
        this.minute = minute;
    }

    public AssistDto(Assist assist) {
        this.firstName = assist.getFirstName();
        this.surname = assist.getSurname();
        this.minute = assist.getMinute();
    }
}
