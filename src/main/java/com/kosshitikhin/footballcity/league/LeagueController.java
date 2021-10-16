package com.kosshitikhin.footballcity.league;

import com.kosshitikhin.footballcity.league.dto.LeagueDto;
import com.kosshitikhin.footballcity.league.dto.LeagueRequest;
import com.kosshitikhin.footballcity.statistics.team.TeamStatisticsDto;
import com.kosshitikhin.footballcity.statistics.team.TeamStatisticsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("leagues")
public class LeagueController {

    private final LeagueService leagueService;
    private final TeamStatisticsService teamStatisticsService;

    public LeagueController(LeagueService leagueService, TeamStatisticsService teamStatisticsService) {
        this.leagueService = leagueService;
        this.teamStatisticsService = teamStatisticsService;
    }

    @GetMapping("{leagueId}")
    public LeagueDto getOneLeague(@PathVariable Long leagueId) {
        return leagueService.getOneLeague(leagueId);
    }

    @GetMapping
    public List<LeagueDto> getAllLeagues() {
        return leagueService.getAllLeagues();
    }

    @GetMapping("{leagueId}/league-table")
    public List<TeamStatisticsDto> getLeagueTable(@PathVariable Long leagueId) {
        return teamStatisticsService.getAllTeamStatisticsFromLeague(leagueId);
    }

    @PostMapping
    public LeagueDto createLeague(@RequestBody LeagueRequest request) {
        return leagueService.createLeague(request);
    }

    @PutMapping("{leagueId}")
    public LeagueDto updateLeague(@PathVariable Long leagueId, @Valid @RequestBody LeagueRequest request) {
        return leagueService.updateLeague(leagueId, request);
    }

    @DeleteMapping("{leagueId}")
    public void deleteLeague(@PathVariable Long leagueId) {
        leagueService.deleteLeague(leagueId);
    }

}
