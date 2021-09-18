package com.kosshitikhin.footballcity.coach.dto;

import com.kosshitikhin.footballcity.coach.Coach;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.team.Team;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.Period;

@Slf4j
@Getter
@Setter
public class CoachDto {

    private Long coachId;

    private Long teamId;

    private Long leagueId;

    private String firstName;

    private String surname;

    private String patronymic;

    private int age;

    public CoachDto(Coach coach) {
        this.coachId = coach.getId();
        this.teamId = coach.getTeam().getId();
        this.leagueId = coach.getLeague().getId();
        this.firstName = coach.getFirstName();
        this.surname = coach.getSurname();
        this.patronymic = coach.getPatronymic();
        this.age = calculateAge(coach.getBirthday());
    }

    public CoachDto(Coach coach, League league, Team team) {
        this.coachId = coach.getId();
        this.teamId = team.getId();
        this.teamId = league.getId();
        this.firstName = coach.getFirstName();
        this.surname = coach.getSurname();
        this.patronymic = coach.getPatronymic();
        this.age = calculateAge(coach.getBirthday());
    }

    private int calculateAge(LocalDate birthday) {
        if (birthday != null) {
            return Period.between(birthday, LocalDate.now()).getYears();
        }
        return 0;
    }
}
