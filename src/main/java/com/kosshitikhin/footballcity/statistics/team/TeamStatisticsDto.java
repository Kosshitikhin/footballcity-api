package com.kosshitikhin.footballcity.statistics.team;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
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

}
