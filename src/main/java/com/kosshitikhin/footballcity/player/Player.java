package com.kosshitikhin.footballcity.player;

import com.kosshitikhin.footballcity.common.dbo.NamedEntity;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.team.Team;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Player extends NamedEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Team team;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private League league;

    public Player() {

    }

    public Player(String firstName, String surname, String patronymic, int age, Team team, League league) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.team = team;
        this.league = league;
    }

    public Player(String firstName, String surname, String patronymic, int age) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return team.equals(player.getTeam());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), team);
    }
}
