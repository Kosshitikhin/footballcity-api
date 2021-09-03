package com.kosshitikhin.footballcity.coach;

import com.kosshitikhin.footballcity.coach.dto.CoachDto;
import com.kosshitikhin.footballcity.coach.dto.CoachRequest;
import com.kosshitikhin.footballcity.common.rest.NotFoundException;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.league.LeagueRepository;
import com.kosshitikhin.footballcity.team.Team;
import com.kosshitikhin.footballcity.team.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class CoachService {

    private final CoachRepository coachRepository;
    private final LeagueRepository leagueRepository;
    private final TeamRepository teamRepository;

    public CoachService(CoachRepository coachRepository, LeagueRepository leagueRepository, TeamRepository teamRepository) {
        this.coachRepository = coachRepository;
        this.leagueRepository = leagueRepository;
        this.teamRepository = teamRepository;
    }

    public CoachDto getCoach(Long leagueId, Long teamId, Long coachId) {
        Coach coach = coachRepository.getByLeagueIdAndTeamIdAndId(leagueId, teamId, coachId).orElseThrow(NotFoundException::coach);
        return new CoachDto(coach);
    }

    public CoachDto addCoach(Long leagueId, Long teamId, CoachRequest request) {
        League league = leagueRepository.findById(leagueId).orElseThrow(NotFoundException::league);
        Team team = teamRepository.findById(teamId).orElseThrow(NotFoundException::team);
        String firstName = request.getFirstName();
        String surname = request.getSurname();
        String patronymic = request.getPatronymic();
        int age = request.getAge();
        Coach coach = new Coach(firstName, surname, patronymic, age, team, league);
        return new CoachDto(coachRepository.save(coach));
    }

    public CoachDto updateCoach(Long leagueId, Long teamId, Long coachId, CoachRequest request) {
        Coach coach = coachRepository.getByLeagueIdAndTeamIdAndId(leagueId, teamId, coachId).orElseThrow(NotFoundException::coach);
        coach.setFirstName(request.getFirstName());
        coach.setSurname(request.getSurname());
        coach.setPatronymic(request.getPatronymic());
        coach.setAge(request.getAge());

        return new CoachDto(coachRepository.save(coach));
    }

    public void deleteCoach(Long leagueId, Long teamId, Long coachId) {
        Coach coach = coachRepository.getByLeagueIdAndTeamIdAndId(leagueId, teamId, coachId).orElseThrow(NotFoundException::coach);
        coachRepository.delete(coach);
    }
}
