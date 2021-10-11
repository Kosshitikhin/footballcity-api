package com.kosshitikhin.footballcity.player;

import com.kosshitikhin.footballcity.assists.Assist;
import com.kosshitikhin.footballcity.cards.Card;
import com.kosshitikhin.footballcity.common.dbo.NamedEntity;
import com.kosshitikhin.footballcity.goals.Goal;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.match.Match;
import com.kosshitikhin.footballcity.team.Team;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


@Entity
public class Player extends NamedEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Team team;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private League league;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Match> matches;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Goal> goals;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Card> cards;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Assist> assists;

    public Player() {

    }

    public Player(String firstName, String surname, String patronymic, LocalDate birthday, Team team, League league) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.team = team;
        this.league = league;
    }

    public Player(String firstName, String surname, String patronymic, LocalDate birthday) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

    public Set<Goal> getGoals() {
        return goals;
    }

    public void setGoals(Set<Goal> goals) {
        this.goals = goals;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public Set<Assist> getAssists() {
        return assists;
    }

    public void setAssists(Set<Assist> assists) {
        this.assists = assists;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return Objects.equals(team, player.getTeam()) &&
                Objects.equals(league, player.getLeague());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), team, league);
    }
}
