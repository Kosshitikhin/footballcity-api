package com.kosshitikhin.footballcity.player;

import com.kosshitikhin.footballcity.player.dto.PlayerDto;
import com.kosshitikhin.footballcity.player.dto.PlayerRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leagues/{leagueId}/teams/{teamId}/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("{playerId}")
    public PlayerDto getPlayer(@PathVariable Long leagueId,
                               @PathVariable Long teamId,
                               @PathVariable Long playerId) {
        return playerService.getPlayer(leagueId, teamId, playerId);
    }

    @GetMapping
    public List<PlayerDto> getAllPlayersOfTeam(@PathVariable Long leagueId, @PathVariable Long teamId) {
        return playerService.getAllPlayersOfTeam(leagueId, teamId);
    }

    @PostMapping
    public PlayerDto addPlayer(@PathVariable Long leagueId,
                               @PathVariable Long teamId,
                               @RequestBody PlayerRequest request) {
        return playerService.addPlayer(leagueId, teamId, request);
    }

    @PutMapping("{playerId}")
    public PlayerDto updatePlayer(@PathVariable Long leagueId,
                                  @PathVariable Long teamId,
                                  @PathVariable Long playerId,
                                  @RequestBody PlayerRequest request) {
        return playerService.updatePlayer(leagueId, teamId, playerId, request);
    }

    @DeleteMapping("{playerId}")
    public void deletePlayer(@PathVariable Long leagueId,
                             @PathVariable Long teamId,
                             @PathVariable Long playerId) {
        playerService.deletePlayer(leagueId, teamId, playerId);
    }
}
