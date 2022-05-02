package com.kosshitikhin.footballcity.coach.dto;

import com.kosshitikhin.footballcity.coach.Coach;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.team.Team;

import java.time.LocalDate;
import java.time.Period;

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

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
