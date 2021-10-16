package com.kosshitikhin.footballcity.cards;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByLeagueIdAndId(Long leagueId, Long cardId);

    List<Card> findAllByLeagueIdAndPlayerId(Long leagueId, Long playerId);

    List<Card> findAllByLeagueIdAndMatchId(Long leagueId, Long matchId);

    int countAllByLeagueIdAndPlayerIdAndColor(Long leagueId, Long playerId, Card.Color color);

}
