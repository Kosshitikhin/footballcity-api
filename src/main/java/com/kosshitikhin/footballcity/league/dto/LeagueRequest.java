package com.kosshitikhin.footballcity.league.dto;

import javax.validation.constraints.NotEmpty;

public class LeagueRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String startYear;

    @NotEmpty
    private String endYear;

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
