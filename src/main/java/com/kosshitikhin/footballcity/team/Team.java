package com.kosshitikhin.footballcity.team;

import com.kosshitikhin.footballcity.coach.Coach;
import com.kosshitikhin.footballcity.common.dbo.IdEntity;
import com.kosshitikhin.footballcity.goals.Goal;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.match.Match;
import com.kosshitikhin.footballcity.player.Player;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Team extends IdEntity {

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Player> players;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Coach coach;

    @ManyToOne(fetch = FetchType.LAZY)
    private League league;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Match> match;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Goal> goals;

    private int playedGames;
    private int winGames;
    private int drawGames;
    private int lostGames;
    private int scoredGoals;
    private int concededGoals;
    private int goalDifference;
    private int pointsScored;

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

    public Set<Match> getMatch() {
        return match;
    }

    public void setMatch(Set<Match> match) {
        this.match = match;
    }

    public Set<Goal> getGoals() {
        return goals;
    }

    public void setGoals(Set<Goal> goals) {
        this.goals = goals;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public int getWinGames() {
        return winGames;
    }

    public void setWinGames(int winGames) {
        this.winGames = winGames;
    }

    public int getDrawGames() {
        return drawGames;
    }

    public void setDrawGames(int drawGames) {
        this.drawGames = drawGames;
    }

    public int getLostGames() {
        return lostGames;
    }

    public void setLostGames(int lostGames) {
        this.lostGames = lostGames;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public int getConcededGoals() {
        return concededGoals;
    }

    public void setConcededGoals(int concededGoals) {
        this.concededGoals = concededGoals;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public int getPointsScored() {
        return pointsScored;
    }

    public void setPointsScored(int pointsScored) {
        this.pointsScored = pointsScored;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.getName()) &&
                Objects.equals(coach, team.getCoach()) &&
                Objects.equals(league, team.getLeague()) &&
                playedGames == team.getPlayedGames() &&
                winGames == team.getWinGames() &&
                drawGames == team.getDrawGames() &&
                lostGames == team.getLostGames() &&
                scoredGoals == team.getScoredGoals() &&
                concededGoals == team.getConcededGoals() &&
                goalDifference == team.goalDifference &&
                pointsScored == team.getPointsScored();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, coach, league, playedGames, winGames, drawGames, lostGames, scoredGoals, concededGoals, goalDifference, pointsScored);
    }
}
