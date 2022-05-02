package com.kosshitikhin.footballcity.statistics.player;

import com.kosshitikhin.footballcity.assists.AssistRepository;
import com.kosshitikhin.footballcity.cards.Card;
import com.kosshitikhin.footballcity.cards.CardRepository;
import com.kosshitikhin.footballcity.common.rest.exception.NotFoundException;
import com.kosshitikhin.footballcity.goals.GoalRepository;
import com.kosshitikhin.footballcity.match.MatchRepository;
import com.kosshitikhin.footballcity.player.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerStatisticsService {

    private final MatchRepository matchRepository;
    private final AssistRepository assistRepository;
    private final CardRepository cardRepository;
    private final GoalRepository goalRepository;
    private final PlayerRepository playerRepository;

    public PlayerStatisticsService(MatchRepository matchRepository,
                                   AssistRepository assistRepository,
                                   CardRepository cardRepository,
                                   GoalRepository goalRepository,
                                   PlayerRepository playerRepository) {
        this.matchRepository = matchRepository;
        this.assistRepository = assistRepository;
        this.cardRepository = cardRepository;
        this.goalRepository = goalRepository;
        this.playerRepository = playerRepository;
    }

    public PlayerStatisticsDto getPlayerStatisticsFromLeague(Long leagueId, Long playerId) {
        Long teamId = playerRepository.findById(playerId).orElseThrow(NotFoundException::team).getTeam().getId();
        return new PlayerStatisticsDto(
                matchRepository.countAllByLeagueIdAndHomeTeamId(leagueId, teamId) + matchRepository.countAllByLeagueIdAndAwayTeamId(leagueId, teamId),
                goalRepository.countAllByLeagueIdAndPlayerId(leagueId, playerId),
                assistRepository.countAllByLeagueIdAndPlayerId(leagueId, playerId),
                cardRepository.countAllByLeagueIdAndPlayerIdAndColor(leagueId, playerId, Card.Color.YELLOW),
                cardRepository.countAllByLeagueIdAndPlayerIdAndColor(leagueId, playerId, Card.Color.RED)
        );
    }
}
