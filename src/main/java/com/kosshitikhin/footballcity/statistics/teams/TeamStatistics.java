package com.kosshitikhin.footballcity.statistics.teams;

import com.kosshitikhin.footballcity.common.dbo.IdEntity;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.team.Team;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class TeamStatistics extends IdEntity {

    @Column(name = "played_games", columnDefinition = "SMALLINT DEFAULT 0")
    private int playedGames;

    @Column(name = "win_games", columnDefinition = "SMALLINT DEFAULT 0")
    private int winGames;

    @Column(name = "draw_games" ,columnDefinition = "SMALLINT DEFAULT 0")
    private int drawGames;

    @Column(name = "lost_games" ,columnDefinition = "SMALLINT DEFAULT 0")
    private int lostGames;

    @Column(name = "scored_goals" ,columnDefinition = "SMALLINT DEFAULT 0")
    private int scoredGoals;

    @Column(name = "conceded_goals" ,columnDefinition = "SMALLINT DEFAULT 0")
    private int concededGoals;

    @Column(name = "goal_difference" ,columnDefinition = "SMALLINT DEFAULT 0")
    private int goalDifference;

    @Column(name = "point_scored" ,columnDefinition = "SMALLINT DEFAULT 0")
    private int pointsScored;

    @OneToOne(cascade = CascadeType.REMOVE, optional = false)
    private League league;

    @OneToOne(cascade = CascadeType.REMOVE, optional = false)
    private Team team;

    public TeamStatistics() {
        this.playedGames = 0;
        this.winGames = 0;
        this.drawGames = 0;
        this.lostGames = 0;
        this.scoredGoals = 0;
        this.concededGoals = 0;
        this.goalDifference = 0;
        this.pointsScored = 0;
    }

    public TeamStatistics(League league, Team team) {
        this();
        this.league = league;
        this.team = team;
    }

    public TeamStatistics(League league) {
        this.league = league;
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

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
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
        TeamStatistics teamStatistics = (TeamStatistics) o;
        return playedGames == teamStatistics.getPlayedGames() &&
                winGames == teamStatistics.getWinGames() &&
                drawGames == teamStatistics.getDrawGames() &&
                lostGames == teamStatistics.getLostGames() &&
                scoredGoals == teamStatistics.getScoredGoals() &&
                concededGoals == teamStatistics.getConcededGoals() &&
                goalDifference == teamStatistics.getGoalDifference() &&
                pointsScored == teamStatistics.getPointsScored() &&
                Objects.equals(league, teamStatistics.league);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), playedGames, winGames, drawGames, lostGames, scoredGoals, concededGoals, goalDifference, pointsScored, league);
    }
}