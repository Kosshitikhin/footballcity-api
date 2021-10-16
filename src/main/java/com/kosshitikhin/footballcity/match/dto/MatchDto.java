package com.kosshitikhin.footballcity.match.dto;

import com.kosshitikhin.footballcity.match.Match;
import com.kosshitikhin.footballcity.goals.Goal;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
public class MatchDto {

    private String nameHomeTeam;
    private String nameAwayTeam;
    private int homeGoals;
    private int awayGoals;
    private List<Goal> goals;

    public MatchDto() {
    }

    public MatchDto(String nameHomeTeam, String nameAwayTeam, int homeGoals, int awayGoals) {
        this.nameHomeTeam = nameHomeTeam;
        this.nameAwayTeam = nameAwayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public MatchDto(Match match) {
        this.nameHomeTeam = match.getHomeTeam().getName();
        this.nameAwayTeam = match.getAwayTeam().getName();
        this.homeGoals = match.getHomeGoals();
        this.awayGoals = match.getAwayGoals();
        this.goals = match.getGoals();
    }
}
