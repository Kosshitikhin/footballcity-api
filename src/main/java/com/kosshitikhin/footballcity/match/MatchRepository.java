package com.kosshitikhin.footballcity.match;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {

    Optional<Match> findByLeagueIdAndId(Long leagueId, Long matchId);

}
