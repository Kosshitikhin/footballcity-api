package com.kosshitikhin.footballcity.coach;

import com.kosshitikhin.footballcity.coach.dto.CoachDto;
import com.kosshitikhin.footballcity.coach.dto.CoachRequest;
import com.kosshitikhin.footballcity.coach.dto.CoachUpdateRequest;
import com.kosshitikhin.footballcity.common.rest.exception.NotFoundException;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.league.LeagueRepository;
import com.kosshitikhin.footballcity.team.Team;
import com.kosshitikhin.footballcity.team.TeamRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

    public CoachDto getCoach(Long coachId) {
        Coach coach = coachRepository.findById(coachId).orElseThrow(NotFoundException::coach);
        return new CoachDto(coach);
    }

    public CoachDto addCoach(Long leagueId, Long teamId, CoachRequest request) {
        League league = leagueRepository.findById(leagueId).orElseThrow(NotFoundException::league);
        Team team = teamRepository.findById(teamId).orElseThrow(NotFoundException::team);
        String firstName = request.getFirstName();
        String surname = request.getSurname();
        String patronymic = request.getPatronymic();
        LocalDate birthday = request.getBirthday();
        Coach coach = new Coach(firstName, surname, patronymic, birthday, team, league);
        return new CoachDto(coachRepository.save(coach));
    }

    public CoachDto updateCoach(Long coachId, CoachUpdateRequest request) {
        Coach coach = coachRepository.findById(coachId).orElseThrow(NotFoundException::coach);

        if (request.getFirstName() != null) {
            coach.setFirstName(request.getFirstName());
        }
        if (request.getSurname() != null) {
            coach.setSurname(request.getSurname());
        }
        if (request.getPatronymic() != null) {
            coach.setPatronymic(request.getPatronymic());
        }
        if (request.getBirthday() != null) {
            coach.setBirthday(request.getBirthday());
        }

        return new CoachDto(coachRepository.save(coach));
    }

    public void deleteCoach(Long coachId) {
        Coach coach = coachRepository.findById(coachId).orElseThrow(NotFoundException::coach);
        coachRepository.delete(coach);
    }
}
