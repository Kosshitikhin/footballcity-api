package com.kosshitikhin.footballcity.statistics.teams;

import com.kosshitikhin.footballcity.common.rest.NotFoundException;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.league.LeagueRepository;
import com.kosshitikhin.footballcity.statistics.teams.dto.TeamStatisticsDto;
import com.kosshitikhin.footballcity.team.Team;
import com.kosshitikhin.footballcity.team.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamStatisticsService {

    private final TeamStatisticsRepository teamStatisticsRepository;
    private final LeagueRepository leagueRepository;
    private final TeamRepository teamRepository;

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

}
