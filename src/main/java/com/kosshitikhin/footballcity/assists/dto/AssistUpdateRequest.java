package com.kosshitikhin.footballcity.assists.dto;

import javax.validation.constraints.NotNull;

public class AssistUpdateRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String surname;

    @NotNull
    private Integer minute;

    public AssistUpdateRequest() {
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
