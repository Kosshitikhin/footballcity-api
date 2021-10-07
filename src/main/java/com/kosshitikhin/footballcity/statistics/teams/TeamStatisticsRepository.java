package com.kosshitikhin.footballcity.statistics.teams;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamStatisticsRepository extends JpaRepository<TeamStatistics, Long> {

    Optional<TeamStatistics> findByLeagueIdAndTeamId(Long leagueId, Long teamId);

    List<TeamStatistics> findByLeagueIdOrderByPointsScored(Long leagueId);
}
