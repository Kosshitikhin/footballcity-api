package com.kosshitikhin.footballcity.league;

import com.kosshitikhin.footballcity.league.dto.CreateLeagueRequest;
import com.kosshitikhin.footballcity.league.dto.LeagueDto;
import com.kosshitikhin.footballcity.league.dto.UpdateLeagueRequest;
import com.kosshitikhin.footballcity.statistics.team.TeamStatisticsDto;
import com.kosshitikhin.footballcity.statistics.team.TeamStatisticsService;
import com.kosshitikhin.footballcity.team.TeamService;
import com.kosshitikhin.footballcity.team.dto.TeamDto;
import com.kosshitikhin.footballcity.team.dto.TeamRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("leagues")
public class LeagueController {

    private final LeagueService leagueService;
    private final TeamStatisticsService teamStatisticsService;
    private final TeamService teamService;

    public LeagueController(LeagueService leagueService,
                            TeamStatisticsService teamStatisticsService,
                            TeamService teamService) {
        this.leagueService = leagueService;
        this.teamStatisticsService = teamStatisticsService;
        this.teamService = teamService;
    }

    @GetMapping("{leagueId}")
    public LeagueDto getOneLeague(@PathVariable Long leagueId) {
        return leagueService.getOneLeague(leagueId);
    }

    @GetMapping
    public List<LeagueDto> getAllLeagues() {
        return leagueService.getAllLeagues();
    }

    @GetMapping("{leagueId}/teams")
    public List<TeamDto> getAllTeamsFromLeague(@PathVariable Long leagueId) {
        return teamService.getAllTeamsFromLeague(leagueId);
    }

    @GetMapping("{leagueId}/league-table")
    public List<TeamStatisticsDto> getLeagueTable(@PathVariable Long leagueId) {
        return teamStatisticsService.getAllTeamStatisticsFromLeague(leagueId);
    }

    @GetMapping("{leagueId}/teams/{teamId}/statistics")
    public TeamStatisticsDto getTeamStatisticsFromLeague(@PathVariable Long leagueId, @PathVariable Long teamId) {
        return teamStatisticsService.getTeamStatisticsFromLeague(leagueId, teamId);
    }

    @PostMapping
    public LeagueDto createLeague(@Valid @RequestBody CreateLeagueRequest request) {
        return leagueService.createLeague(request);
    }

    @PostMapping("{leagueId}/teams")
    public TeamDto addTeam(@PathVariable Long leagueId, @Valid @RequestBody TeamRequest request) {
        return leagueService.addTeam(leagueId, request);
    }

    @PutMapping("{leagueId}")
    public LeagueDto updateLeague(@PathVariable Long leagueId, @RequestBody UpdateLeagueRequest request) {
        return leagueService.updateLeague(leagueId, request);
    }

    @DeleteMapping("{leagueId}")
    public void deleteLeague(@PathVariable Long leagueId) {
        leagueService.deleteLeague(leagueId);
    }

}
