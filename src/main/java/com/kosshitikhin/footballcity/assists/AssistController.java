package com.kosshitikhin.footballcity.assists;

import com.kosshitikhin.footballcity.assists.dto.AssistDto;
import com.kosshitikhin.footballcity.assists.dto.AssistRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("league/{leagueId}")
public class AssistController {

    private final AssistService assistService;

    public AssistController(AssistService assistService) {
        this.assistService = assistService;
    }

    @PostMapping("matches/{matchId}/players/{playerId}/assists/add")
    public void addAssist(@PathVariable Long leagueId,
                          @PathVariable Long matchId,
                          @PathVariable Long playerId,
                          @RequestBody AssistRequest request) {
        assistService.addAssist(leagueId, matchId, playerId, request);
    }

    @DeleteMapping("assists/{assistId}/delete")
    public void deleteAssist(@PathVariable Long leagueId, @PathVariable Long assistId) {
        assistService.deleteAssist(leagueId, assistId);
    }

    @GetMapping("players/{playerId}")
    public List<AssistDto> getAllAssistsOfPlayerFromLeague(@PathVariable Long leagueId, @PathVariable Long playerId) {
        return assistService.getAllAssistsOfPlayerFromLeague(leagueId, playerId);
    }
}
