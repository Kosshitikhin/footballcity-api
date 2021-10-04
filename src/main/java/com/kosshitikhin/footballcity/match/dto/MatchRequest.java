package com.kosshitikhin.footballcity.match.dto;

import com.kosshitikhin.footballcity.match.goals.Goal;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class MatchRequest {
    @NotNull
    private String nameHomeTeam;

    @NotNull
    private String nameAwayTeam;

    @NotNull
    private int homeGoals;

    @NotNull
    private int awayGoals;

    @NotNull
    private LocalDateTime matchDay;

    @NotNull
    private int tour;

    private List<Goal> authorsOfGoals;

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

    public List<Goal> getAuthorsOfGoals() {
        return authorsOfGoals;
    }

    public void setAuthorsOfGoals(List<Goal> authorsOfGoals) {
        this.authorsOfGoals = authorsOfGoals;
    }
}
