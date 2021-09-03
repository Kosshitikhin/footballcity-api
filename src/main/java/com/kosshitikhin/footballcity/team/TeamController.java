package com.kosshitikhin.footballcity.team;

import com.kosshitikhin.footballcity.team.dto.TeamDto;
import com.kosshitikhin.footballcity.team.dto.TeamRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leagues/{leagueId}/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("{teamId}")
    public TeamDto getOneTeamFromLeague(@PathVariable Long leagueId,
                              @PathVariable Long teamId) {
        return teamService.getOneTeamFromLeague(leagueId, teamId);
    }

    @GetMapping
    public List<TeamDto> getAllTeamsFromLeague(@PathVariable Long leagueId) {
        return teamService.getAllTeamsFromLeague(leagueId);
    }

    @PutMapping("{teamId}")
    public TeamDto updateTeam(@PathVariable Long leagueId,
                              @PathVariable Long teamId,
                              @RequestBody TeamRequest request) {
        return teamService.updateTeam(leagueId,teamId, request);
    }

    @PostMapping
    public TeamDto addTeam(@PathVariable Long leagueId, @RequestBody TeamRequest request) {
        return teamService.addTeam(leagueId, request);
    }

    @DeleteMapping("{teamId}")
    public void deleteTeam(@PathVariable Long leagueId,
                           @PathVariable Long teamId) {
        teamService.deleteTeam(leagueId, teamId);
    }

}

