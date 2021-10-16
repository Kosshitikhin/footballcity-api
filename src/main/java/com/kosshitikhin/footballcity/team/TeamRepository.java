package com.kosshitikhin.footballcity.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> findByLeagueIdAndId(Long leagueId, Long teamId);

    List<Team> findAllByLeagueId(Long leagueId);

    Optional<Team> findByName(String name);

    @Transactional
    @Modifying
    @Query("UPDATE Team SET playedGames=playedGames + ?1  where id=?2")
    void savePlayedGame(int oneGame, Long teamId);

    @Transactional
    @Modifying
    @Query("UPDATE Team SET winGames=winGames + ?1  where id=?2")
    void saveWinGames(int winGame, Long teamId);

    @Transactional
    @Modifying
    @Query("UPDATE Team SET drawGames=drawGames + ?1  where id=?2")
    void saveDrawGames(int drawGame, Long teamId);

    @Transactional
    @Modifying
    @Query("UPDATE Team SET lostGames=lostGames + ?1  where id=?2")
    void saveLostGames(int lostGame, Long teamId);

    @Transactional
    @Modifying
    @Query("UPDATE Team SET scoredGoals=scoredGoals + ?1  where id=?2")
    void saveScoredGoals(int scoredGoals, Long teamId);

    @Transactional
    @Modifying
    @Query("UPDATE Team SET concededGoals=concededGoals + ?1  where id=?2")
    void saveConcededGoals(int concededGoals, Long teamId);

    @Transactional
    @Modifying
    @Query("UPDATE Team SET goalDifference= goalDifference + ?1  where id=?2")
    void saveGoalDifference(int difference, Long teamId);

    @Transactional
    @Modifying
    @Query("UPDATE Team SET pointsScored=pointsScored + ?1 where id=?2")
    void savePointScored(int pointScored, Long teamId);

    @Transactional
    @Modifying
    @Query("UPDATE Team SET playedGames=playedGames - ?1  where id=?2")
    void saveDecreasePlayedGame(int oneGame, Long teamId);

    @Transactional
    @Modifying
    @Query("UPDATE Team SET winGames=winGames - ?1  where id=?2")
    void saveDecreaseWinGames(int winGame, Long teamId);

    @Transactional
    @Modifying
    @Query("UPDATE Team SET drawGames=drawGames - ?1  where id=?2")
    void saveDecreaseDrawGames(int drawGame, Long teamId);

    @Transactional
    @Modifying
    @Query("UPDATE Team SET lostGames=lostGames - ?1  where id=?2")
    void saveDecreaseLostGames(int lostGame, Long teamId);

    @Transactional
    @Modifying
    @Query("UPDATE Team SET scoredGoals=scoredGoals - ?1  where id=?2")
    void saveDecreaseScoredGoals(int scoredGoals, Long teamId);

    @Transactional
    @Modifying
    @Query("UPDATE Team SET concededGoals=concededGoals - ?1  where id=?2")
    void saveDecreaseConcededGoals(int concededGoals, Long teamId);

    @Transactional
    @Modifying
    @Query("UPDATE Team SET goalDifference= goalDifference - ?1  where id=?2")
    void saveDecreaseGoalDifference(int difference, Long teamId);

    @Transactional
    @Modifying
    @Query("UPDATE Team SET pointsScored=pointsScored - ?1 where id=?2")
    void saveDecreasePointScored(int pointScored, Long teamId);
}
