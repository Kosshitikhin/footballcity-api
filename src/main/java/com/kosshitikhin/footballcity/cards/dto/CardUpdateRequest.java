package com.kosshitikhin.footballcity.cards.dto;

import com.kosshitikhin.footballcity.cards.Card;

public class CardUpdateRequest {

    private String firstName;

    private String surname;

    private Integer minute;

    private Card.Color color;

    public CardUpdateRequest() {
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

    public Card.Color getColor() {
        return color;
    }

    public void setColor(Card.Color color) {
        this.color = color;
    }
}
