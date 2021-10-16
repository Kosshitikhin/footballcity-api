package com.kosshitikhin.footballcity.player;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByLeagueIdAndId(Long leagueId, Long playerId);

    List<Player> findAllByLeagueIdAndTeamIdOrderBySurname(Long leagueId, Long teamId);

    List<Player> findAllByTeamId(Long teamId);

    Optional<Player> findByFirstNameAndSurnameAndTeamId(String firstName, String surname, Long teamId);

}
