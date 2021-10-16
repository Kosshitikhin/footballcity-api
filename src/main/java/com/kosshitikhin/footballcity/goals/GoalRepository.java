package com.kosshitikhin.footballcity.goals;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GoalRepository extends JpaRepository<Goal, Long> {

    Optional<Goal> findByLeagueIdAndMatchIdAndId(Long leagueId, Long matchId, Long goalId);

    List<Goal> findAllByLeagueIdAndPlayerId(Long leagueId, Long playerId);

    List<Goal> findAllByLeagueIdAndMatchId(Long leagueId, Long matchId);

    int countAllByLeagueIdAndPlayerId(Long leagueId, Long playerId);
}
