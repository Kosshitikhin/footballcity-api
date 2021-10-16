package com.kosshitikhin.footballcity.team;

import com.kosshitikhin.footballcity.statistics.team.TeamStatisticsDto;
import com.kosshitikhin.footballcity.statistics.team.TeamStatisticsService;
import com.kosshitikhin.footballcity.team.dto.TeamDto;
import com.kosshitikhin.footballcity.team.dto.TeamRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leagues/{leagueId}")
public class TeamController {

    private final TeamService teamService;
    private final TeamStatisticsService teamStatisticsService;

    public TeamController(TeamService teamService, TeamStatisticsService teamStatisticsService) {
        this.teamService = teamService;
        this.teamStatisticsService = teamStatisticsService;
    }

    @GetMapping("teams/{teamId}")
    public TeamDto getOneTeamFromLeague(@PathVariable Long leagueId, @PathVariable Long teamId) {
        return teamService.getOneTeamFromLeague(leagueId, teamId);
    }

    @GetMapping
    public List<TeamDto> getAllTeamsFromLeague(@PathVariable Long leagueId) {
        return teamService.getAllTeamsFromLeague(leagueId);
    }

    @GetMapping("teams/{teamId}/statistics")
    public TeamStatisticsDto getTeamStatistics(@PathVariable Long leagueId, @PathVariable Long teamId) {
        return teamStatisticsService.getTeamStatisticsFromLeague(leagueId, teamId);
    }

    @PutMapping("teams/{teamId}")
    public TeamDto updateTeam(@PathVariable Long leagueId,
                              @PathVariable Long teamId,
                              @RequestBody TeamRequest request) {
        return teamService.updateTeam(leagueId, teamId, request);
    }

    @PostMapping("teams")
    public TeamDto addTeam(@PathVariable Long leagueId, @RequestBody TeamRequest request) {
        return teamService.addTeam(leagueId, request);
    }

    @DeleteMapping("teams/{teamId}")
    public void deleteTeam(@PathVariable Long leagueId, @PathVariable Long teamId) {
        teamService.deleteTeam(leagueId, teamId);
    }

}

