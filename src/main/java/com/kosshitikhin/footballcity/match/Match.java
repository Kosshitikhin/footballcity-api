package com.kosshitikhin.footballcity.match;

import com.kosshitikhin.footballcity.assists.Assist;
import com.kosshitikhin.footballcity.cards.Card;
import com.kosshitikhin.footballcity.common.dbo.IdEntity;
import com.kosshitikhin.footballcity.goals.Goal;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.team.Team;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Match extends IdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private League league;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Team homeTeam;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Team awayTeam;

    @Column(nullable = false)
    private LocalDateTime matchDay;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Goal> goals;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Card> cards;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Assist> assists;

    private Integer tour;
    private Integer homeGoals;
    private Integer awayGoals;

    public Match() {

    }

    public Match(League league, Team homeTeam, Team awayTeam, LocalDateTime matchDay, Integer tour, Integer homeGoals, Integer awayGoals) {
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

    public Integer getTour() {
        return tour;
    }

    public void setTour(Integer tour) {
        this.tour = tour;
    }

    public Integer getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(Integer homeGoals) {
        this.homeGoals = homeGoals;
    }

    public Integer getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(Integer awayGoals) {
        this.awayGoals = awayGoals;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
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
        if (this == o) return true;
        if (!(o instanceof Match)) return false;
        if (!super.equals(o)) return false;
        Match match = (Match) o;
        return  Objects.equals(tour, match.tour) &&
                Objects.equals(homeGoals, match.homeGoals) &&
                Objects.equals(awayGoals, match.awayGoals) &&
                Objects.equals(homeTeam, match.homeTeam) &&
                Objects.equals(awayTeam, match.awayTeam) &&
                Objects.equals(league, match.league) &&
                Objects.equals(matchDay, match.matchDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), homeTeam, awayTeam, matchDay, tour, homeGoals, awayGoals, league);
    }
}
