package com.kosshitikhin.footballcity.league.dto;

import com.kosshitikhin.footballcity.league.League;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
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

}
