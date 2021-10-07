package com.kosshitikhin.footballcity.statistics.teams;

import com.kosshitikhin.footballcity.common.rest.NotFoundException;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.league.LeagueRepository;
import com.kosshitikhin.footballcity.statistics.teams.dto.TeamStatisticsDto;
import com.kosshitikhin.footballcity.statistics.teams.dto.TeamStatisticsRequest;
import com.kosshitikhin.footballcity.team.Team;
import com.kosshitikhin.footballcity.team.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamStatisticsService {

    private final TeamStatisticsRepository teamStatisticsRepository;
    private final LeagueRepository leagueRepository;
    private final TeamRepository teamRepository;

    private final int WIN_POINT = 3;
    private final int DRAW_POINT = 1;
    private final int INCREASE_NUMBER_GAME = 1;
    private final int INCREASE_WIN_GAME = 1;
    private final int INCREASE_LOSE_GAME = 1;
    private final int INCREASE_DRAW_GAME = 1;

    public TeamStatisticsService(TeamStatisticsRepository teamStatisticsRepository,
                                 LeagueRepository leagueRepository,
                                 TeamRepository teamRepository) {
        this.teamStatisticsRepository = teamStatisticsRepository;
        this.leagueRepository = leagueRepository;
        this.teamRepository = teamRepository;
    }

    public TeamStatisticsDto createStatisticForTeam(Long leagueId, Long teamId) {
        League league = leagueRepository.findById(leagueId).orElseThrow(NotFoundException::league);
        Team team = teamRepository.findById(teamId).orElseThrow(NotFoundException::team);
        return new TeamStatisticsDto(teamStatisticsRepository.save(new TeamStatistics(league, team)));
    }

    public void editTeamStatistic(League league, Team homeTeam, Team awayTeam, int homeGoals, int awayGoals) {
        if (homeGoals > awayGoals) {
            editTeamStatisticIfWin(league, homeTeam, homeGoals, awayGoals);
            editTeamStatisticIfLost(league, awayTeam, awayGoals, homeGoals);
        } else if (homeGoals < awayGoals) {
            editTeamStatisticIfLost(league, homeTeam, homeGoals, awayGoals);
            editTeamStatisticIfWin(league, awayTeam, awayGoals, homeGoals);
        } else {
            editTeamStatisticIfDraw(league, homeTeam, homeGoals, awayGoals);
            editTeamStatisticIfDraw(league, awayTeam, awayGoals, homeGoals);
        }
    }

    public TeamStatisticsDto updateTeamStatistics(Long leagueId, Long teamId, TeamStatisticsRequest request) {
        TeamStatistics ts = teamStatisticsRepository.findByLeagueIdAndTeamId(leagueId, teamId).orElseThrow(NotFoundException::teamStatistics);
        ts.setPlayedGames(request.getPlayedGames());
        ts.setWinGames(request.getWinGames());
        ts.setDrawGames(request.getDrawGames());
        ts.setLostGames(request.getLostGames());
        ts.setScoredGoals(request.getScoredGoals());
        ts.setConcededGoals(request.getConcededGoals());
        ts.setGoalDifference(request.getGoalDifference());
        ts.setPointsScored(request.getPointsScored());
        return new TeamStatisticsDto(teamStatisticsRepository.save(ts));
    }

    public TeamStatisticsDto getTeamStatistics(Long leagueId, Long teamId) {
        TeamStatistics ts = teamStatisticsRepository.findByLeagueIdAndTeamId(leagueId, teamId).orElseThrow(NotFoundException::teamStatistics);
        return new TeamStatisticsDto(ts);
    }

    public List<TeamStatisticsDto> getAllTeamStatisticsFromLeague(Long leagueId) {
        return teamStatisticsRepository.findByLeagueIdOrderByPointsScored(leagueId).stream()
                .map(TeamStatisticsDto::new)
                .collect(Collectors.toList());
    }

    private void editTeamStatisticIfWin(League league, Team team, int scoredGoals, int concededGoals) {
        TeamStatistics ts = team.getTeamStatistics();
        if (ts == null) {
            ts = new TeamStatistics(league, team);
        }
        ts.setPlayedGames(ts.getPlayedGames()  + INCREASE_NUMBER_GAME);
        ts.setWinGames(ts.getWinGames()  + INCREASE_WIN_GAME);
        ts.setGoalDifference(ts.getGoalDifference() + (scoredGoals - concededGoals));
        ts.setScoredGoals(ts.getScoredGoals()  + scoredGoals);
        ts.setConcededGoals(ts.getConcededGoals()  + concededGoals);
        ts.setPointsScored(ts.getPointsScored() + WIN_POINT);
        teamStatisticsRepository.save(ts);
    }

    private void editTeamStatisticIfLost(League league, Team team, int scoredGoals, int concededGoals) {
        TeamStatistics ts = team.getTeamStatistics();
        if (ts == null) {
            ts = new TeamStatistics(league, team);
        }
        ts.setPlayedGames(ts.getPlayedGames()  + INCREASE_NUMBER_GAME);
        ts.setLostGames(ts.getLostGames()  + INCREASE_LOSE_GAME);
        ts.setGoalDifference(ts.getGoalDifference() + (scoredGoals - concededGoals));
        ts.setScoredGoals(ts.getScoredGoals()  + scoredGoals);
        ts.setConcededGoals(ts.getConcededGoals()  + concededGoals);
        teamStatisticsRepository.save(ts);
    }

    private void editTeamStatisticIfDraw(League league, Team team, int scoredGoals, int concededGoals) {
        TeamStatistics ts = team.getTeamStatistics();
        if (ts == null) {
            ts = new TeamStatistics(league, team);
        }
        ts.setPlayedGames(ts.getPlayedGames()  + INCREASE_NUMBER_GAME);
        ts.setDrawGames(ts.getDrawGames() + INCREASE_DRAW_GAME);
        ts.setGoalDifference(ts.getGoalDifference() + (scoredGoals - concededGoals));
        ts.setScoredGoals(ts.getScoredGoals()  + scoredGoals);
        ts.setConcededGoals(ts.getConcededGoals()  + concededGoals);
        ts.setPointsScored(ts.getPointsScored() + DRAW_POINT);
        teamStatisticsRepository.save(ts);
    }


}
