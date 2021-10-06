package com.kosshitikhin.footballcity.match;

import com.kosshitikhin.footballcity.match.dto.MatchDto;
import com.kosshitikhin.footballcity.match.dto.MatchRequest;
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
        return matchService.getMatch(leagueId, matchId);
    }

    //todo do it later
    @GetMapping
    public Page<MatchDto> getMatchesWithFilterByTours(@RequestParam(required = false) int tour,
                                                      Pageable pageable) {
        return null;
    }

    @PostMapping
    public MatchDto createMatch(@PathVariable Long leagueId, @Valid @RequestBody MatchRequest request) {
        return matchService.createMatch(leagueId, request);
    }

    @PutMapping("{matchId}")
    public MatchDto updateMatch(@PathVariable Long leagueId,
                                @PathVariable Long matchId,
                                @Valid @RequestBody MatchRequest request) {
        return matchService.updateMatch(leagueId, matchId, request);
    }

    @DeleteMapping("{matchId}")
    public void deleteMatch(@PathVariable Long leagueId,
                            @PathVariable Long matchId) {
        matchService.deleteMatch(leagueId, matchId);
    }
}
