package com.kosshitikhin.footballcity.statistics.team;

public class TeamStatisticsDto {

    private int playedGames;

    private int winGames;

    private int drawGames;

    private int lostGames;

    private int scoredGoals;

    private int concededGoals;

    private int goalDifference;

    private int pointsScored;

    public TeamStatisticsDto(int playedGames,
                             int winGames,
                             int drawGames,
                             int lostGames,
                             int scoredGoals,
                             int concededGoals,
                             int goalDifference,
                             int pointsScored) {
        this.playedGames = playedGames;
        this.winGames = winGames;
        this.drawGames = drawGames;
        this.lostGames = lostGames;
        this.scoredGoals = scoredGoals;
        this.concededGoals = concededGoals;
        this.goalDifference = goalDifference;
        this.pointsScored = pointsScored;
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
}
