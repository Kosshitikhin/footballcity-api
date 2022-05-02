package com.kosshitikhin.footballcity.player.dto;

import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.player.Player;
import com.kosshitikhin.footballcity.team.Team;

import java.time.LocalDate;
import java.time.Period;

public class PlayerDto {

    private Long playerId;
    private Long teamId;
    private Long leagueId;
    private String firstName;
    private String surname;
    private String patronymic;
    private int age;

    public PlayerDto(Player player) {
        this.playerId = player.getId();
        this.teamId = player.getTeam().getId();
        this.leagueId = player.getLeague().getId();
        this.firstName = player.getFirstName();
        this.surname = player.getSurname();
        this.patronymic = player.getPatronymic();
        this.age = calculateAge(player.getBirthday());
    }

    public PlayerDto(Player player, Team team, League league) {
        this.playerId = player.getId();
        this.teamId = player.getTeam().getId();
        this.leagueId = player.getLeague().getId();
        this.firstName = player.getFirstName();
        this.surname = player.getSurname();
        this.patronymic = player.getPatronymic();
        this.age = calculateAge(player.getBirthday());
    }

    private int calculateAge(LocalDate birthday) {
        if (birthday != null) {
            return Period.between(birthday, LocalDate.now()).getYears();
        }
        return 0;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
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
