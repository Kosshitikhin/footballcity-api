package com.kosshitikhin.footballcity.match.dto;

import com.kosshitikhin.footballcity.goals.Goal;
import com.kosshitikhin.footballcity.match.Match;

import java.util.List;

public class MatchDto {

    private String nameHomeTeam;
    private String nameAwayTeam;
    private Integer homeGoals;
    private Integer awayGoals;
    private List<Goal> goals;

    public MatchDto() {
    }

    public MatchDto(String nameHomeTeam, String nameAwayTeam, Integer homeGoals, Integer awayGoals) {
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

    public String getNameHomeTeam() {
        return nameHomeTeam;
    }

    public void setNameHomeTeam(String nameHomeTeam) {
        this.nameHomeTeam = nameHomeTeam;
    }

    public String getNameAwayTeam() {
        return nameAwayTeam;
    }

    public void setNameAwayTeam(String nameAwayTeam) {
        this.nameAwayTeam = nameAwayTeam;
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
}
