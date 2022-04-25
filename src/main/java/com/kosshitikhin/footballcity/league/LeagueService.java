package com.kosshitikhin.footballcity.league;

import com.kosshitikhin.footballcity.common.rest.NotFoundException;
import com.kosshitikhin.footballcity.league.dto.CreateLeagueRequest;
import com.kosshitikhin.footballcity.league.dto.LeagueDto;
import com.kosshitikhin.footballcity.league.dto.UpdateLeagueRequest;
import com.kosshitikhin.footballcity.team.Team;
import com.kosshitikhin.footballcity.team.TeamRepository;
import com.kosshitikhin.footballcity.team.dto.TeamDto;
import com.kosshitikhin.footballcity.team.dto.TeamRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;
    private final TeamRepository teamRepository;

    public LeagueService(LeagueRepository leagueRepository, TeamRepository teamRepository) {
        this.leagueRepository = leagueRepository;
        this.teamRepository = teamRepository;
    }

    public LeagueDto getOneLeague(Long leagueId) {
        League league = leagueRepository.findById(leagueId).orElseThrow(NotFoundException::league);
        return new LeagueDto(league);
    }

    public List<LeagueDto> getAllLeagues() {
        return leagueRepository.findAll()
                .stream()
                .map(LeagueDto::new)
                .collect(Collectors.toList());
    }

    //todo add access rights
    public LeagueDto createLeague(CreateLeagueRequest request) {
        League league = new League(request.getName(), request.getStartYear(), request.getEndYear());
        return new LeagueDto(leagueRepository.save(league));
    }

    //todo add access rights
    public TeamDto addTeam(Long leagueId, TeamRequest request) {
        League league = leagueRepository.findById(leagueId).orElseThrow(NotFoundException::league);
        Team team = new Team(request.getName());
        team.setLeague(league);
        return new TeamDto(teamRepository.save(team));
    }

    //todo add access rights
    public LeagueDto updateLeague(Long leagueId, UpdateLeagueRequest request) {
        League league = leagueRepository.findById(leagueId).orElseThrow(NotFoundException::league);

        if (request.getName() != null) {
            league.setName(request.getName());
        }
        if (request.getStartYear() != null) {
            league.setStartYear(request.getStartYear());
        }
        if (request.getEndYear() != null) {
            league.setEndYear(request.getEndYear());
        }

        return new LeagueDto(leagueRepository.save(league));
    }

    //todo add access rights
    @Transactional
    public void deleteLeague(Long leagueId) {
        leagueRepository.deleteById(leagueId);
    }
}
