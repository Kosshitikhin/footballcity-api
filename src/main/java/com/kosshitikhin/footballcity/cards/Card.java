package com.kosshitikhin.footballcity.cards;


import com.kosshitikhin.footballcity.common.dbo.StatisticsEntity;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.match.Match;
import com.kosshitikhin.footballcity.player.Player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Card extends StatisticsEntity {

    @Column(nullable = false)
    private Color color;

    @ManyToOne()
    private League league;

    @ManyToOne(fetch = FetchType.LAZY)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    private Match match;

    public Card() {
    }

    public Card(String firstName, String surname, int minute, Color color) {
        this.firstName = firstName;
        this.surname = surname;
        this.minute = minute;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public enum Color {
        YELLOW("YELLOW"),
        RED("RED");

        private final String text;

        Color(final String text) {
            this.text = text;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return minute == card.getMinute() &&
                Objects.equals(firstName, card.getFirstName()) &&
                Objects.equals(surname, card.getSurname()) &&
                color == card.getColor() &&
                Objects.equals(league, card.getLeague()) &&
                Objects.equals(player, card.getPlayer()) &&
                Objects.equals(match, card.getMatch());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, league, player);
    }
}
