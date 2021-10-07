package com.kosshitikhin.footballcity.statistics.teams;

import com.kosshitikhin.footballcity.statistics.teams.dto.TeamStatisticsDto;
import com.kosshitikhin.footballcity.statistics.teams.dto.TeamStatisticsRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("leagues/{leagueId}")
public class TeamStatisticsController {

    private final TeamStatisticsService teamStatisticsService;

    public TeamStatisticsController(TeamStatisticsService teamStatisticsService) {
        this.teamStatisticsService = teamStatisticsService;
    }

    @GetMapping("/teams/{teamId}/statistics")
    public TeamStatisticsDto getTeamStatistics(@PathVariable Long leagueId, @PathVariable Long teamId) {
        return teamStatisticsService.getTeamStatistics(leagueId, teamId);
    }

    @GetMapping("league-table")
    public List<TeamStatisticsDto> getAllTeamStatisticsFromLeague(@PathVariable Long leagueId) {
        return teamStatisticsService.getAllTeamStatisticsFromLeague(leagueId);
    }

    //if didn't fill in the results of match correctly, the statistics were incorrectly calculated,
    // in this case it can be corrected here
    @PutMapping("/teams/{teamId}/statistics")
    public TeamStatisticsDto updateTeamStatistics(@PathVariable Long leagueId,
                                                  @PathVariable Long teamId,
                                                  @Valid @RequestBody TeamStatisticsRequest request) {
        return teamStatisticsService.updateTeamStatistics(leagueId, teamId, request);
    }
}
