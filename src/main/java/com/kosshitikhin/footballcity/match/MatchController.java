package com.kosshitikhin.footballcity.match;

import com.kosshitikhin.footballcity.match.dto.MatchDto;
import com.kosshitikhin.footballcity.match.dto.MatchRequest;
import com.kosshitikhin.footballcity.match.goals.GoalRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("leagues/{leagueId}/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("{matchId}")
    public MatchDto getMatch(@PathVariable Long leagueId,
                             @PathVariable Long matchId) {
        return null;
    }

    @GetMapping
    public Page<MatchDto> getMatchesWithFilterByTours(@PathVariable Long leagueId,
                                                      @RequestParam(required = false) int tour,
                                                      Pageable pageable) {
        return null;
    }

    @PostMapping
    public MatchDto createMatch(@PathVariable Long leagueId,
                                @Valid @RequestBody MatchRequest request) {
        return null;
    }

    @PutMapping("{matchId}")
    public MatchDto updateMatch(@PathVariable Long leagueId,
                                @PathVariable Long matchId) {
        return null;
    }

    @DeleteMapping("{matchId}")
    public void deleteMatch(@PathVariable Long leagueId,
                            @PathVariable Long matchId) {

    }

    @PostMapping("{matchId}/goal")
    public void addGoal(@PathVariable Long leagueId,
                        @PathVariable Long matchId,
                        @RequestBody GoalRequest request) {

    }
}
