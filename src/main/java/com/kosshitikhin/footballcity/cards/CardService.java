package com.kosshitikhin.footballcity.cards;

import com.kosshitikhin.footballcity.cards.dto.CardDto;
import com.kosshitikhin.footballcity.cards.dto.CardRequest;
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
public class CardService {

    private final LeagueRepository leagueRepository;
    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;
    private final CardRepository cardRepository;

    public CardService(LeagueRepository leagueRepository,
                       PlayerRepository playerRepository,
                       MatchRepository matchRepository,
                       CardRepository cardRepository) {
        this.leagueRepository = leagueRepository;
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
        this.cardRepository = cardRepository;
    }

    public void addCard(Long leagueId, Long matchId, Long playerId, CardRequest request) {
        League league = leagueRepository.findById(leagueId).orElseThrow(NotFoundException::league);
        Player player = playerRepository.findById(playerId).orElseThrow(NotFoundException::player);
        Match match = matchRepository.findById(matchId).orElseThrow(NotFoundException::match);
        Card card = new Card(request.getFirstName(), request.getSurname(), request.getMinute(), request.getColor());
        card.setLeague(league);
        card.setPlayer(player);
        card.setMatch(match);
        cardRepository.save(card);
    }

    public void deleteCard(Long leagueId, Long cardId) {
        Card card = cardRepository.findByLeagueIdAndId(leagueId, cardId).orElseThrow(NotFoundException::card);
        cardRepository.delete(card);
    }

    public List<CardDto> getAllCardsOfPlayerFromLeague(Long leagueId, Long playerId) {
        return cardRepository.findAllByLeagueIdAndPlayerId(leagueId, playerId).stream()
                .map(CardDto::new)
                .collect(Collectors.toList());
    }

    public List<CardDto> getAllCardsOfMatch(Long leagueId, Long matchId) {
        return cardRepository.findAllByLeagueIdAndMatchId(leagueId, matchId).stream()
                .map(CardDto::new)
                .collect(Collectors.toList());
    }

}
