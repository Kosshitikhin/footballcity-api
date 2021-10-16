package com.kosshitikhin.footballcity.statistics.player;

public class PlayerStatisticsDto {

    private int playedGame;

    private int goalsScored;

    private int assist;

    private int yellowCard;

    private int redCard;

    public PlayerStatisticsDto() {
    }

    public PlayerStatisticsDto(int playedGame, int goalsScored, int assist, int yellowCard, int redCard) {
        this.playedGame = playedGame;
        this.goalsScored = goalsScored;
        this.assist = assist;
        this.yellowCard = yellowCard;
        this.redCard = redCard;
    }

    public int getPlayedGame() {
        return playedGame;
    }

    public void setPlayedGame(int playedGame) {
        this.playedGame = playedGame;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public int getYellowCard() {
        return yellowCard;
    }

    public void setYellowCard(int yellowCard) {
        this.yellowCard = yellowCard;
    }

    public int getRedCard() {
        return redCard;
    }

    public void setRedCard(int redCard) {
        this.redCard = redCard;
    }
}
