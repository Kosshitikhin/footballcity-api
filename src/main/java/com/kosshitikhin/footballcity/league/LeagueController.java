package com.kosshitikhin.footballcity.league;

import com.kosshitikhin.footballcity.league.dto.LeagueDto;
import com.kosshitikhin.footballcity.league.dto.LeagueRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("leagues")
public class LeagueController {

    private final LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("{leagueId}")
    public LeagueDto getOneLeague(@PathVariable Long leagueId) {
        return leagueService.getOneLeague(leagueId);
    }

    @GetMapping
    public List<LeagueDto> getAllLeagues() {
        return leagueService.getAllLeagues();
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
