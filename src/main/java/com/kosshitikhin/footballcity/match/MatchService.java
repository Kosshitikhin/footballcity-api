package com.kosshitikhin.footballcity.match;

import com.kosshitikhin.footballcity.common.rest.NotFoundException;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.league.LeagueRepository;
import com.kosshitikhin.footballcity.match.dto.MatchDto;
import com.kosshitikhin.footballcity.match.dto.MatchRequest;
import com.kosshitikhin.footballcity.statistics.teams.TeamStatisticsService;
import com.kosshitikhin.footballcity.team.Team;
import com.kosshitikhin.footballcity.team.TeamRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final LeagueRepository leagueRepository;
    private final TeamRepository teamRepository;
    private final TeamStatisticsService teamStatisticsService;

    public MatchService(MatchRepository matchRepository,
                        LeagueRepository leagueRepository,
                        TeamRepository teamRepository,
                        TeamStatisticsService teamStatisticsService) {
        this.matchRepository = matchRepository;
        this.leagueRepository = leagueRepository;
        this.teamRepository = teamRepository;
        this.teamStatisticsService = teamStatisticsService;
    }

    public MatchDto getMatch(Long leagueId, Long matchId) {
        Match match = matchRepository.findByLeagueIdAndId(leagueId, matchId).orElseThrow(NotFoundException::match);
        return new MatchDto(match);
    }

    public MatchDto createMatch(Long leagueId, MatchRequest request) {
        League league = leagueRepository.findById(leagueId).orElseThrow(NotFoundException::league);
        Team homeTeam = teamRepository.findByName(request.getNameHomeTeam()).orElseThrow(NotFoundException::team);
        Team awayTeam = teamRepository.findByName(request.getNameAwayTeam()).orElseThrow(NotFoundException::team);
        LocalDateTime matchDay = request.getMatchDay();
        int tour = request.getTour();
        int homeGoals = request.getHomeGoals();
        int awayGoals = request.getAwayGoals();

        teamStatisticsService.editTeamStatistic(league, homeTeam, awayTeam, homeGoals, awayGoals);

        return new MatchDto(matchRepository.save(new Match(league, homeTeam, awayTeam, matchDay, tour, homeGoals, awayGoals)));
    }

    public MatchDto updateMatch(Long leagueId, Long matchId, MatchRequest request) {
        Match match = matchRepository.findByLeagueIdAndId(leagueId, matchId).orElseThrow(NotFoundException::match);
        match.setHomeTeam(teamRepository.findByName(request.getNameHomeTeam()).orElseThrow(NotFoundException::team));
        match.setAwayTeam(teamRepository.findByName(request.getNameAwayTeam()).orElseThrow(NotFoundException::team));
        match.setHomeGoals(request.getHomeGoals());
        match.setAwayGoals(request.getAwayGoals());
        match.setMatchDay(request.getMatchDay());
        match.setTour(request.getTour());
        return new MatchDto(matchRepository.save(match));
    }

    public void deleteMatch(Long leagueId, Long matchId) {
        Match match = matchRepository.findByLeagueIdAndId(leagueId, matchId).orElseThrow(NotFoundException::match);
        matchRepository.delete(match);
    }
}
