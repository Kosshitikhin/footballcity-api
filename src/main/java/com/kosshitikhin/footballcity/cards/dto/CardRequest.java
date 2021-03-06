package com.kosshitikhin.footballcity.cards.dto;

import com.kosshitikhin.footballcity.cards.Card;

import javax.validation.constraints.NotNull;

public class CardRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String surname;

    @NotNull
    private int minute;

    @NotNull
    private Card.Color color;

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

    public Card.Color getColor() {
        return color;
    }

    public void setColor(Card.Color color) {
        this.color = color;
    }
}
