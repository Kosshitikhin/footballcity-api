package com.kosshitikhin.footballcity.team.dto;

import com.kosshitikhin.footballcity.team.Team;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class TeamDto {

    private Long teamId;

    private String name;

    private Long coachId;

    private Long leagueId;

    public TeamDto(Team team) {
        this.teamId = team.getId();
        this.name = team.getName();
        this.coachId = team.getCoach().getId();
        this.leagueId = team.getLeague().getId();
    }
}
