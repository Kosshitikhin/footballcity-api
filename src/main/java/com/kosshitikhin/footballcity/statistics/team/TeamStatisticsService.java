package com.kosshitikhin.footballcity.statistics.team;

import com.kosshitikhin.footballcity.common.rest.NotFoundException;
import com.kosshitikhin.footballcity.match.MatchRepository;
import com.kosshitikhin.footballcity.team.Team;
import com.kosshitikhin.footballcity.team.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamStatisticsService {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    private final int INCREASE_OR_DECREASE_GAME = 1;
    private final int POINTS_IF_WON = 3;
    private final int POINTS_IF_DRAW = 1;

    public TeamStatisticsService(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    public TeamStatisticsDto getTeamStatisticsFromLeague(Long leagueId, Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(NotFoundException::league);
        return new TeamStatisticsDto(
                matchRepository.countAllByLeagueIdAndHomeTeamId(leagueId, teamId) + matchRepository.countAllByLeagueIdAndAwayTeamId(leagueId, teamId),
                team.getWinGames(),
                team.getDrawGames(),
                team.getLostGames(),
                team.getScoredGoals(),
                team.getConcededGoals(),
                team.getGoalDifference(),
                team.getPointsScored()
        );
    }

    public List<TeamStatisticsDto> getAllTeamStatisticsFromLeague(Long leagueId) {
        return teamRepository.findAllByLeagueId(leagueId).stream()
                .map(team -> new TeamStatisticsDto(
                            matchRepository.countAllByLeagueIdAndHomeTeamId(leagueId, team.getId()) + matchRepository.countAllByLeagueIdAndAwayTeamId(leagueId, team.getId()),
                            team.getWinGames(),
                            team.getDrawGames(),
                            team.getLostGames(),
                            team.getScoredGoals(),
                            team.getConcededGoals(),
                            team.getGoalDifference(),
                            team.getPointsScored()
                ))
                .sorted(Comparator.comparingInt(TeamStatisticsDto::getPointsScored).reversed())
                .collect(Collectors.toList());
    }

    public void editTeamStatistics(Team home, Team away, int homeGoals, int awayGoals) {
        if (homeGoals > awayGoals) {
            editTeamStatisticsIfWon(home, homeGoals, awayGoals);
            editTeamStatisticsIfLost(away, awayGoals, homeGoals);
        } else if (homeGoals < awayGoals) {
            editTeamStatisticsIfLost(home, homeGoals, awayGoals);
            editTeamStatisticsIfWon(away, awayGoals, homeGoals);
        } else {
            editTeamStatisticsIfDraw(home, homeGoals, awayGoals);
            editTeamStatisticsIfDraw(away, awayGoals, homeGoals);
        }
    }

    public void deleteStatisticsData(Team home, Team away, int homeGoals, int awayGoals) {
        if (homeGoals > awayGoals) {
            decreaseTeamStatisticsIfWon(home, homeGoals, awayGoals);
            decreaseTeamStatisticsIfLost(away, awayGoals, homeGoals);
        } else if (homeGoals < awayGoals) {
            decreaseTeamStatisticsIfLost(home, homeGoals, awayGoals);
            decreaseTeamStatisticsIfWon(away, awayGoals, homeGoals);
        } else {
            decreaseTeamStatisticsIfDraw(home, homeGoals, awayGoals);
            decreaseTeamStatisticsIfDraw(away, awayGoals, homeGoals);
        }
    }

    private void editTeamStatisticsIfWon(Team team, int scoredGoals, int concededGoals) {
        Long teamId = team.getId();
        teamRepository.savePlayedGame(INCREASE_OR_DECREASE_GAME, teamId);
        teamRepository.saveWinGames(INCREASE_OR_DECREASE_GAME, teamId);
        teamRepository.saveScoredGoals(scoredGoals, teamId);
        teamRepository.saveConcededGoals(concededGoals, teamId);
        teamRepository.saveGoalDifference(scoredGoals - concededGoals, teamId);
        teamRepository.savePointScored(POINTS_IF_WON, teamId);
    }

    private void editTeamStatisticsIfDraw(Team team, int scoredGoals, int concededGoals) {
        Long teamId = team.getId();
        teamRepository.savePlayedGame(INCREASE_OR_DECREASE_GAME, teamId);
        teamRepository.saveDrawGames(INCREASE_OR_DECREASE_GAME, teamId);
        teamRepository.saveScoredGoals(scoredGoals, teamId);
        teamRepository.saveConcededGoals(concededGoals, teamId);
        teamRepository.saveGoalDifference(scoredGoals - concededGoals, teamId);
        teamRepository.savePointScored(POINTS_IF_DRAW, teamId);
    }

    private void editTeamStatisticsIfLost(Team team, int scoredGoals, int concededGoals) {
        Long teamId = team.getId();
        teamRepository.savePlayedGame(INCREASE_OR_DECREASE_GAME, teamId);
        teamRepository.saveLostGames(INCREASE_OR_DECREASE_GAME, teamId);
        teamRepository.saveScoredGoals(scoredGoals, teamId);
        teamRepository.saveConcededGoals(concededGoals, teamId);
        teamRepository.saveGoalDifference(scoredGoals - concededGoals, teamId);
    }

    private void decreaseTeamStatisticsIfWon(Team team, int scoredGoals, int concededGoals) {
        Long teamId = team.getId();
        teamRepository.saveDecreasePlayedGame(INCREASE_OR_DECREASE_GAME, teamId);
        teamRepository.saveDecreaseWinGames(INCREASE_OR_DECREASE_GAME, teamId);
        teamRepository.saveDecreaseScoredGoals(scoredGoals, teamId);
        teamRepository.saveDecreaseConcededGoals(concededGoals, teamId);
        teamRepository.saveDecreaseGoalDifference(scoredGoals - concededGoals, teamId);
        teamRepository.saveDecreasePointScored(POINTS_IF_WON, teamId);
    }

    private void  decreaseTeamStatisticsIfDraw(Team team, int scoredGoals, int concededGoals) {
        Long teamId = team.getId();
        teamRepository.saveDecreasePlayedGame(INCREASE_OR_DECREASE_GAME, teamId);
        teamRepository.saveDecreaseDrawGames(INCREASE_OR_DECREASE_GAME, teamId);
        teamRepository.saveDecreaseScoredGoals(scoredGoals, teamId);
        teamRepository.saveDecreaseConcededGoals(concededGoals, teamId);
        teamRepository.saveDecreaseGoalDifference(scoredGoals - concededGoals, teamId);
        teamRepository.saveDecreasePointScored(POINTS_IF_DRAW, teamId);
    }

    private void  decreaseTeamStatisticsIfLost(Team team, int scoredGoals, int concededGoals) {
        Long teamId = team.getId();
        teamRepository.saveDecreasePlayedGame(INCREASE_OR_DECREASE_GAME, teamId);
        teamRepository.saveDecreaseLostGames(INCREASE_OR_DECREASE_GAME, teamId);
        teamRepository.saveDecreaseScoredGoals(scoredGoals, teamId);
        teamRepository.saveDecreaseConcededGoals(concededGoals, teamId);
        teamRepository.saveDecreaseGoalDifference(scoredGoals - concededGoals, teamId);
    }
}
