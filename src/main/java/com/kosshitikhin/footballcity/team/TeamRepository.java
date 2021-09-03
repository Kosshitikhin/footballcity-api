package com.kosshitikhin.footballcity.team;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> findByLeagueIdAndId(Long leagueId, Long teamId);

    List<Team> findAllByLeagueId(Long leagueId);
}
