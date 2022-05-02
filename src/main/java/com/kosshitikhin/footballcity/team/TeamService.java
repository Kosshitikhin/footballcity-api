package com.kosshitikhin.footballcity.team;

import com.kosshitikhin.footballcity.common.rest.exception.NotFoundException;
import com.kosshitikhin.footballcity.team.dto.TeamDto;
import com.kosshitikhin.footballcity.team.dto.UpdateTeamRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public TeamDto getTeam(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(NotFoundException::team);
        return new TeamDto(team);
    }

    public List<TeamDto> getAllTeamsFromLeague(Long leagueId) {
        return teamRepository.findAllByLeagueId(leagueId)
                .stream()
                .map(TeamDto::new)
                .collect(Collectors.toList());
    }

    //todo access rights
    public TeamDto updateTeam(Long teamId, UpdateTeamRequest request) {
        Team team = teamRepository.findById(teamId).orElseThrow(NotFoundException::team);

        if (request.getName() != null) {
            team.setName(request.getName());
        }

        return new TeamDto(teamRepository.save(team));
    }

    //todo access rights
    @Transactional
    public void deleteTeam(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(NotFoundException::team);
        teamRepository.delete(team);
    }
}
