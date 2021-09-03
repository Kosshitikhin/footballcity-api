package com.kosshitikhin.footballcity.team;

import com.kosshitikhin.footballcity.common.rest.NotFoundException;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.league.LeagueRepository;
import com.kosshitikhin.footballcity.team.dto.TeamDto;
import com.kosshitikhin.footballcity.team.dto.TeamRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final LeagueRepository leagueRepository;

    public TeamService(TeamRepository teamRepository, LeagueRepository leagueRepository) {
        this.teamRepository = teamRepository;
        this.leagueRepository = leagueRepository;
    }

    public TeamDto getOneTeamFromLeague(Long leagueId, Long teamId) {
        Team team = teamRepository.findByLeagueIdAndId(leagueId, teamId).orElseThrow(NotFoundException::team);
        return new TeamDto(team);
    }

    public List<TeamDto> getAllTeamsFromLeague(Long leagueId) {
        return teamRepository.findAllByLeagueId(leagueId)
                .stream()
                .map(TeamDto::new)
                .collect(Collectors.toList());
    }

    public TeamDto addTeam(Long leagueId, TeamRequest request) {
        League league = leagueRepository.findById(leagueId).orElseThrow(NotFoundException::league);
        Team team = new Team(request.getName());
        team.setLeague(league);
        return new TeamDto(teamRepository.save(team));
    }

    public TeamDto updateTeam(Long leagueId, Long teamId, TeamRequest request) {
        Team team = teamRepository.findByLeagueIdAndId(leagueId, teamId).orElseThrow(NotFoundException::team);
        team.setName(request.getName());
        return new TeamDto(teamRepository.save(team));
    }

    @Transactional
    public void deleteTeam(Long leagueId, Long teamId) {
        Team team = teamRepository.findByLeagueIdAndId(leagueId, teamId).orElseThrow(NotFoundException::team);
        teamRepository.delete(team);
    }
}
