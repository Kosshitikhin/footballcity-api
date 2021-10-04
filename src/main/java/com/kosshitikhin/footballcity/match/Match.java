package com.kosshitikhin.footballcity.match;

import com.kosshitikhin.footballcity.common.dbo.IdEntity;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.team.Team;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Match extends IdEntity {

    @ManyToOne(cascade = CascadeType.REMOVE)
    private League league;

    @OneToOne(optional = false)
    @Column(nullable = false)
    private Team homeTeam;

    @OneToOne(optional = false)
    @Column(nullable = false)
    private Team awayTeam;

    @Column(nullable = false)
    private LocalDateTime matchDay;

    private int tour;
    private int homeGoals;
    private int awayGoals;

    public Match() {

    }

    public Match(League league, Team homeTeam, Team awayTeam, LocalDateTime matchDay, int tour, int homeGoals, int awayGoals) {
        this.league = league;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchDay = matchDay;
        this.tour = tour;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public LocalDateTime getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(LocalDateTime matchDay) {
        this.matchDay = matchDay;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match)) return false;
        if (!super.equals(o)) return false;
        Match match = (Match) o;
        return tour == match.tour &&
                homeGoals == match.homeGoals &&
                awayGoals == match.awayGoals &&
                Objects.equals(homeTeam, match.homeTeam) &&
                Objects.equals(awayTeam, match.awayTeam) &&
                Objects.equals(matchDay, match.matchDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), homeTeam, awayTeam, matchDay, tour, homeGoals, awayGoals);
    }
}
