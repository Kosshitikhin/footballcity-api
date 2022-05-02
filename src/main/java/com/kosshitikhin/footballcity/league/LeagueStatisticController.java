package com.kosshitikhin.footballcity.league;

import com.kosshitikhin.footballcity.assists.AssistService;
import com.kosshitikhin.footballcity.assists.dto.AssistDto;
import com.kosshitikhin.footballcity.cards.CardService;
import com.kosshitikhin.footballcity.cards.dto.CardDto;
import com.kosshitikhin.footballcity.goals.GoalService;
import com.kosshitikhin.footballcity.goals.dto.GoalDto;
import com.kosshitikhin.footballcity.statistics.player.PlayerStatisticsDto;
import com.kosshitikhin.footballcity.statistics.player.PlayerStatisticsService;
import com.kosshitikhin.footballcity.statistics.team.TeamStatisticsDto;
import com.kosshitikhin.footballcity.statistics.team.TeamStatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("league/{leagueId}")
public class LeagueStatisticController {

    private final PlayerStatisticsService playerStatisticsService;
    private final TeamStatisticsService teamStatisticsService;
    private final AssistService assistService;
    private final CardService cardService;
    private final GoalService goalService;

    public LeagueStatisticController(PlayerStatisticsService playerStatisticsService,
                                     TeamStatisticsService teamStatisticsService,
                                     AssistService assistService,
                                     CardService cardService,
                                     GoalService goalService) {
        this.playerStatisticsService = playerStatisticsService;
        this.teamStatisticsService = teamStatisticsService;
        this.assistService = assistService;
        this.cardService = cardService;
        this.goalService = goalService;
    }

    @GetMapping("league-table")
    public List<TeamStatisticsDto> getLeagueTable(@PathVariable Long leagueId) {
        return teamStatisticsService.getAllTeamStatisticsFromLeague(leagueId);
    }

    @GetMapping("players/{playerId}/statistics")
    public PlayerStatisticsDto getPlayerStatisticsFromLeague(@PathVariable Long leagueId, @PathVariable Long playerId) {
        return playerStatisticsService.getPlayerStatisticsFromLeague(leagueId, playerId);
    }

    @GetMapping("players/{playerId}/assists")
    public List<AssistDto> getAllAssistsOfPlayerFromLeague(@PathVariable Long leagueId, @PathVariable Long playerId) {
        return assistService.getAllAssistsOfPlayerFromLeague(leagueId, playerId);
    }

    @GetMapping("players/{playerId}/cards")
    public List<CardDto> getAllCardsOfPlayerFromLeague(@PathVariable Long leagueId, @PathVariable Long playerId) {
        return cardService.getAllCardsOfPlayerFromLeague(leagueId, playerId);
    }

    @GetMapping("players/{playerId}/goals")
    public List<GoalDto> getAllGoalsOfPlayerFromLeague(@PathVariable Long leagueId, @PathVariable Long playerId) {
        return goalService.getAllGoalsOfPlayerFromLeague(leagueId, playerId);
    }

}
