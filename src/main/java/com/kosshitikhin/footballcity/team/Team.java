package com.kosshitikhin.footballcity.team;

import com.kosshitikhin.footballcity.coach.Coach;
import com.kosshitikhin.footballcity.common.dbo.IdEntity;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.player.Player;
import com.kosshitikhin.footballcity.statistics.TeamStatistics;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Team extends IdEntity {

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Player> players;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Coach coach;

    @ManyToOne(fetch = FetchType.LAZY)
    private League league;

    @OneToOne(cascade = CascadeType.REMOVE)
    private TeamStatistics teamStatistics;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public TeamStatistics getTeamStatistics() {
        return teamStatistics;
    }

    public void setTeamStatistics(TeamStatistics teamStatistics) {
        this.teamStatistics = teamStatistics;
    }


    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.getName()) &&
                Objects.equals(coach, team.getCoach()) &&
                Objects.equals(teamStatistics, team.getTeamStatistics()) &&
                Objects.equals(league, team.getLeague());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, coach, teamStatistics, league);
    }
}
