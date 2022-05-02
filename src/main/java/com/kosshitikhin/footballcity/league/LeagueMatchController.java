package com.kosshitikhin.footballcity.league;

import com.kosshitikhin.footballcity.assists.AssistService;
import com.kosshitikhin.footballcity.assists.dto.AssistDto;
import com.kosshitikhin.footballcity.assists.dto.AssistRequest;
import com.kosshitikhin.footballcity.cards.CardService;
import com.kosshitikhin.footballcity.cards.dto.CardDto;
import com.kosshitikhin.footballcity.cards.dto.CardRequest;
import com.kosshitikhin.footballcity.goals.GoalService;
import com.kosshitikhin.footballcity.goals.dto.GoalDto;
import com.kosshitikhin.footballcity.goals.dto.GoalRequest;
import com.kosshitikhin.footballcity.match.MatchService;
import com.kosshitikhin.footballcity.match.dto.MatchDto;
import com.kosshitikhin.footballcity.match.dto.MatchRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("league/{leagueId}/matches")
public class LeagueMatchController {

    private final MatchService matchService;
    private final GoalService goalService;
    private final CardService cardService;
    private final AssistService assistService;

    public LeagueMatchController(MatchService matchService,
                                 GoalService goalService,
                                 CardService cardService,
                                 AssistService assistService) {
        this.matchService = matchService;
        this.goalService = goalService;
        this.cardService = cardService;
        this.assistService = assistService;
    }

    @GetMapping("{matchId}/goals")
    public List<GoalDto> getAllGoalsOfMatch(@PathVariable Long leagueId, @PathVariable Long matchId) {
        return goalService.getAllGoalsOfMatch(leagueId, matchId);
    }

    @GetMapping("{matchId}/cards")
    public List<CardDto> getAllCardsOfMatch(@PathVariable Long leagueId, @PathVariable Long matchId) {
        return cardService.getAllCardsOfMatch(leagueId, matchId);
    }

    @GetMapping("{matchId}/assists")
    public List<AssistDto> getAllAssistsOfMatch(@PathVariable Long leagueId, @PathVariable Long matchId) {
        return assistService.getAllAssistsOfMatch(leagueId, matchId);
    }

    @PostMapping
    public MatchDto createMatch(@PathVariable Long leagueId, @Valid @RequestBody MatchRequest request) {
        return matchService.createMatch(leagueId, request);
    }

    @PostMapping("{matchId}/players/{playerId}/assists")
    public void addAssist(@PathVariable Long leagueId,
                          @PathVariable Long matchId,
                          @PathVariable Long playerId,
                          @Valid @RequestBody AssistRequest request) {
        assistService.addAssist(leagueId, matchId, playerId, request);
    }

    @PostMapping("{matchId}/players/{playerId}/cards")
    public void addCard(@PathVariable Long leagueId,
                        @PathVariable Long matchId,
                        @PathVariable Long playerId,
                        @Valid @RequestBody CardRequest request) {
        cardService.addCard(leagueId, matchId, playerId, request);
    }

    @PostMapping("{matchId}/teams/{teamId}/goals/add")
    public void addGoal(@PathVariable Long leagueId,
                        @PathVariable Long matchId,
                        @PathVariable Long teamId,
                        @Valid @RequestBody GoalRequest request) {
        goalService.addGoal(leagueId, matchId, teamId, request);
    }
}
