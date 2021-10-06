package com.kosshitikhin.footballcity.goals;

import com.kosshitikhin.footballcity.common.dbo.IdEntity;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.match.Match;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Goal extends IdEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private int minute;

    @ManyToOne
    private Match match;

    @ManyToOne
    private League league;

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

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goal)) return false;
        if (!super.equals(o)) return false;
        Goal goal = (Goal) o;
        return minute == goal.getMinute() &&
                Objects.equals(firstName, goal.getFirstName()) &&
                Objects.equals(surname, goal.getSurname()) &&
                Objects.equals(match, goal.getMatch()) &&
                Objects.equals(league, goal.league);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, surname, match, minute, league);
    }
}
