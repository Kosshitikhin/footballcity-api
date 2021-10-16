package com.kosshitikhin.footballcity.cards.dto;

import com.kosshitikhin.footballcity.cards.Card;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
public class CardDto {

    private String firstName;

    private String surname;

    private int minute;

    private Card.Color color;

    public CardDto() {
    }

    public CardDto(String firstName, String surname, int minute, Card.Color color) {
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
}
