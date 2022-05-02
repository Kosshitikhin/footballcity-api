package com.kosshitikhin.footballcity.player;

import com.kosshitikhin.footballcity.assists.AssistRepository;
import com.kosshitikhin.footballcity.cards.CardRepository;
import com.kosshitikhin.footballcity.common.rest.exception.NotFoundException;
import com.kosshitikhin.footballcity.goals.GoalRepository;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.league.LeagueRepository;
import com.kosshitikhin.footballcity.match.MatchRepository;
import com.kosshitikhin.footballcity.player.dto.PlayerDto;
import com.kosshitikhin.footballcity.player.dto.PlayerRequest;
import com.kosshitikhin.footballcity.player.dto.PlayerUpdateRequest;
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
    private final MatchRepository matchRepository;
    private final GoalRepository goalRepository;
    private final AssistRepository assistRepository;
    private final CardRepository cardRepository;

    public PlayerService(PlayerRepository playerRepository,
                         TeamRepository teamRepository,
                         LeagueRepository leagueRepository,
                         MatchRepository matchRepository,
                         GoalRepository goalRepository,
                         AssistRepository assistRepository,
                         CardRepository cardRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.leagueRepository = leagueRepository;
        this.matchRepository = matchRepository;
        this.goalRepository = goalRepository;
        this.assistRepository = assistRepository;
        this.cardRepository = cardRepository;
    }

    public PlayerDto getPlayer(Long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow(NotFoundException::player);
        return new PlayerDto(player);
    }

    public List<PlayerDto> getAllPlayersOfTeam(Long teamId) {
        return playerRepository.findAllByTeamId(teamId)
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

    public PlayerDto updatePlayer(Long playerId, PlayerUpdateRequest request) {
        Player player = playerRepository.findById(playerId).orElseThrow(NotFoundException::player);

        if (request.getFirstName() != null) {
            player.setFirstName(request.getFirstName());
        }
        if (request.getSurname() != null) {
            player.setSurname(request.getSurname());
        }
        if (request.getPatronymic() != null) {
            player.setPatronymic(request.getPatronymic());
        }
        if (request.getBirthday() != null) {
            player.setBirthday(request.getBirthday());
        }

        return new PlayerDto(playerRepository.save(player));
    }

    public void deletePlayer(Long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow(NotFoundException::player);
        playerRepository.delete(player);
    }
}
