package com.kosshitikhin.footballcity.assists;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssistRepository extends JpaRepository<Assist, Long> {

    Optional<Assist> findByLeagueIdAndId(Long leagueId, Long assistId);

    List<Assist> findAllByLeagueIdAndPlayerId(Long leagueId, Long playerId);

    List<Assist> findAllByLeagueIdAndMatchId(Long leagueId, Long match);

    int countAllByLeagueIdAndPlayerId(Long leagueId, Long playerId);

}
