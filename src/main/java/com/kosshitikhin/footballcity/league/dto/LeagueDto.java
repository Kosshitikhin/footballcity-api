package com.kosshitikhin.footballcity.league.dto;

import com.kosshitikhin.footballcity.league.League;

public class LeagueDto {

    private Long leagueId;

    private String name;

    private String startYear;

    private String endYear;

    public LeagueDto(League league) {
        this.leagueId = league.getId();
        this.name = league.getName();
        this.startYear = league.getStartYear();
        this.endYear = league.getEndYear();
    }


    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }
}
