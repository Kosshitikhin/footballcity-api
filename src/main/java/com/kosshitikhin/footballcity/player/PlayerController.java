package com.kosshitikhin.footballcity.player;

import com.kosshitikhin.footballcity.player.dto.PlayerDto;
import com.kosshitikhin.footballcity.player.dto.PlayerUpdateRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("{playerId}")
    public PlayerDto getPlayer(@PathVariable Long playerId) {
        return playerService.getPlayer(playerId);
    }

    @PutMapping("{playerId}")
    public PlayerDto updatePlayer(@PathVariable Long playerId,
                                  @RequestBody PlayerUpdateRequest request) {
        return playerService.updatePlayer(playerId, request);
    }

    @DeleteMapping("players/{playerId}")
    public void deletePlayer(@PathVariable Long playerId) {
        playerService.deletePlayer(playerId);
    }
}
