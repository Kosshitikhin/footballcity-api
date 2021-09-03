package com.kosshitikhin.footballcity.player;

import com.kosshitikhin.footballcity.common.dbo.NamedEntity;
import com.kosshitikhin.footballcity.team.Team;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Player extends NamedEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Team team;

    public Player() {

    }

    public Player(String firstName, String surname, String patronymic, int age, Team team) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.team = team;
    }

    public Player(String firstName, String surname, String patronymic) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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
