package com.kosshitikhin.footballcity.player;

import com.kosshitikhin.footballcity.common.rest.NotFoundException;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.league.LeagueRepository;
import com.kosshitikhin.footballcity.player.dto.PlayerDto;
import com.kosshitikhin.footballcity.player.dto.PlayerRequest;
import com.kosshitikhin.footballcity.team.Team;
import com.kosshitikhin.footballcity.team.TeamRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final LeagueRepository leagueRepository;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository, LeagueRepository leagueRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.leagueRepository = leagueRepository;
    }

    public PlayerDto getPlayer(Long leagueId, Long playerId) {
        Player player = playerRepository.findByLeagueIdAndId(leagueId, playerId).orElseThrow(NotFoundException::player);
        return new PlayerDto(player);
    }

    public List<PlayerDto> getAllPlayersOfTeam(Long leagueId, Long teamId) {
        return playerRepository.findAllByLeagueIdAndTeamIdOrderBySurname(leagueId, teamId)
                .stream()
                .map(PlayerDto::new)
                .collect(Collectors.toList());
    }

    public PlayerDto addPlayer(Long leagueId, Long teamId, PlayerRequest request) {
        Team team = teamRepository.findById(teamId).orElseThrow(NotFoundException::team);
        League league = leagueRepository.findById(leagueId).orElseThrow(NotFoundException::league);
        String firstName = request.getFirstName();
        String surname = request.getSurname();
        String patronymic = request.getPatronymic();
        LocalDate birthday = request.getBirthday();
        Player player = new Player(firstName, surname, patronymic, birthday, team, league);
        return new PlayerDto(playerRepository.save(player));
    }

    public PlayerDto updatePlayer(Long leagueId, Long playerId, PlayerRequest request) {
        Player player = playerRepository.findByLeagueIdAndId(leagueId, playerId).orElseThrow(NotFoundException::player);
        player.setFirstName(request.getFirstName());
        player.setSurname(request.getSurname());
        player.setPatronymic(request.getPatronymic());
        player.setBirthday(request.getBirthday());

        return new PlayerDto(playerRepository.save(player));
    }

    public void deletePlayer(Long leagueId, Long playerId) {
        Player player = playerRepository.findByLeagueIdAndId(leagueId, playerId).orElseThrow(NotFoundException::player);
        playerRepository.delete(player);
    }
}
