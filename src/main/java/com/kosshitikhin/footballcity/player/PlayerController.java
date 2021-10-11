package com.kosshitikhin.footballcity.player;

import com.kosshitikhin.footballcity.player.dto.PlayerDto;
import com.kosshitikhin.footballcity.player.dto.PlayerRequest;
import com.kosshitikhin.footballcity.statistics.PlayerStatisticsDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leagues/{leagueId}")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("players/{playerId}")
    public PlayerDto getPlayer(@PathVariable Long leagueId,
                               @PathVariable Long playerId) {
        return playerService.getPlayer(leagueId, playerId);
    }

    @GetMapping("/teams/{teamId}/players")
    public List<PlayerDto> getAllPlayersOfTeam(@PathVariable Long leagueId, @PathVariable Long teamId) {
        return playerService.getAllPlayersOfTeam(leagueId, teamId);
    }

    @PostMapping("/teams/{teamId}/players")
    public PlayerDto addPlayer(@PathVariable Long leagueId,
                               @PathVariable Long teamId,
                               @RequestBody PlayerRequest request) {
        return playerService.addPlayer(leagueId, teamId, request);
    }

    @PutMapping("players/{playerId}")
    public PlayerDto updatePlayer(@PathVariable Long leagueId,
                                  @PathVariable Long playerId,
                                  @RequestBody PlayerRequest request) {
        return playerService.updatePlayer(leagueId, playerId, request);
    }

    @DeleteMapping("players/{playerId}")
    public void deletePlayer(@PathVariable Long leagueId,
                             @PathVariable Long playerId) {
        playerService.deletePlayer(leagueId, playerId);
    }

    @GetMapping("player/{playerId}/statistics")
    public PlayerStatisticsDto getPlayerStatistics(@PathVariable Long leagueId, @PathVariable Long playerId) {
        return null;
    }
}
