package com.kosshitikhin.footballcity.team;

import com.kosshitikhin.footballcity.team.dto.TeamDto;
import com.kosshitikhin.footballcity.team.dto.UpdateTeamRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("{teamId}")
    public TeamDto getTeam(@PathVariable Long teamId) {
        return teamService.getTeam(teamId);
    }

    @PutMapping("{teamId}")
    public TeamDto updateTeam(@PathVariable Long teamId,
                              @RequestBody UpdateTeamRequest request) {
        return teamService.updateTeam(teamId, request);
    }

    @DeleteMapping("teams/{teamId}")
    public void deleteTeam(@PathVariable Long teamId) {
        teamService.deleteTeam(teamId);
    }

}

