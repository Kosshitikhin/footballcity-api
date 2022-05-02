package com.kosshitikhin.footballcity.cards.dto;

import com.kosshitikhin.footballcity.cards.Card;

public class CardDto {

    private String firstName;

    private String surname;

    private Integer minute;

    private Card.Color color;

    public CardDto() {
    }

    public CardDto(String firstName, String surname, Integer minute, Card.Color color) {
        this.firstName = firstName;
        this.surname = surname;
        this.minute = minute;
        this.color = color;
    }

    public CardDto(Card card) {
        this.firstName = card.getFirstName();
        this.surname = card.getSurname();
        this.minute = card.getMinute();
        this.color = card.getColor();
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

    public Card.Color getColor() {
        return color;
    }

    public void setColor(Card.Color color) {
        this.color = color;
    }
}
