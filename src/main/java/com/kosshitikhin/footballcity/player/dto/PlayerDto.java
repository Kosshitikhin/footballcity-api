package com.kosshitikhin.footballcity.player.dto;

import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.player.Player;
import com.kosshitikhin.footballcity.team.Team;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
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
        this.age = player.getAge();
    }

    public PlayerDto(Player player, Team team, League league) {
        this.playerId = player.getId();
        this.teamId = player.getTeam().getId();
        this.leagueId = player.getLeague().getId();
        this.firstName = player.getFirstName();
        this.surname = player.getSurname();
        this.patronymic = player.getPatronymic();
        this.age = player.getAge();
    }
}
