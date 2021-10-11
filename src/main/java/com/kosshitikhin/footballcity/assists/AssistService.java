package com.kosshitikhin.footballcity.assists;

import com.kosshitikhin.footballcity.assists.dto.AssistDto;
import com.kosshitikhin.footballcity.assists.dto.AssistRequest;
import com.kosshitikhin.footballcity.common.rest.NotFoundException;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.league.LeagueRepository;
import com.kosshitikhin.footballcity.match.Match;
import com.kosshitikhin.footballcity.match.MatchRepository;
import com.kosshitikhin.footballcity.player.Player;
import com.kosshitikhin.footballcity.player.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssistService {

    private final LeagueRepository leagueRepository;
    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;
    private final AssistRepository assistRepository;

    public AssistService(LeagueRepository leagueRepository,
                         MatchRepository matchRepository,
                         PlayerRepository playerRepository,
                         AssistRepository assistRepository) {
        this.leagueRepository = leagueRepository;
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
        this.assistRepository = assistRepository;
    }

    public void addAssist(Long leagueId, Long matchId, Long playerId, AssistRequest request) {
        League league = leagueRepository.findById(leagueId).orElseThrow(NotFoundException::league);
        Player player = playerRepository.findById(playerId).orElseThrow(NotFoundException::player);
        Match match = matchRepository.findById(matchId).orElseThrow(NotFoundException::match);
        Assist assist = new Assist(request.getFirstName(), request.getSurname(), request.getMinute());
        assist.setLeague(league);
        assist.setMatch(match);
        assist.setPlayer(player);
        assistRepository.save(assist);
    }

    public void deleteAssist(Long leagueId, Long assistId) {
        Assist assist = assistRepository.findByLeagueIdAndId(leagueId, assistId).orElseThrow(NotFoundException::assist);
    }

    public List<AssistDto> getAllAssistsOfPlayerFromLeague(Long leagueId, Long playerId) {
        return assistRepository.findAllByLeagueIdAndPlayerId(leagueId, playerId).stream()
                .map(AssistDto::new)
                .collect(Collectors.toList());
    }

    public List<AssistDto> getAllAssistsOfMatch(Long leagueId, Long matchId) {
        return assistRepository.findAllByLeagueIdAndMatchId(leagueId, matchId).stream()
                .map(AssistDto::new)
                .collect(Collectors.toList());
    }
}
