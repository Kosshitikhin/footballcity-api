package com.kosshitikhin.footballcity.team;

import com.kosshitikhin.footballcity.player.PlayerService;
import com.kosshitikhin.footballcity.player.dto.PlayerDto;
import com.kosshitikhin.footballcity.team.dto.TeamDto;
import com.kosshitikhin.footballcity.team.dto.UpdateTeamRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teams")
public class TeamController {

    private final TeamService teamService;
    private final PlayerService playerService;

    public TeamController(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @GetMapping("{teamId}")
    public TeamDto getTeam(@PathVariable Long teamId) {
        return teamService.getTeam(teamId);
    }

    @GetMapping("{teamId}/players")
    public List<PlayerDto> getAllPlayersOfTeam(@PathVariable Long teamId) {
        return playerService.getAllPlayersOfTeam(teamId);
    }

    @PutMapping("{teamId}")
    public TeamDto updateTeam(@PathVariable Long teamId,
                              @RequestBody UpdateTeamRequest request) {
        return teamService.updateTeam(teamId, request);
    }

    @DeleteMapping("{teamId}")
    public void deleteTeam(@PathVariable Long teamId) {
        teamService.deleteTeam(teamId);
    }

}

