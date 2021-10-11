package com.kosshitikhin.footballcity.goals;

import com.kosshitikhin.footballcity.common.dbo.StatisticsEntity;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.match.Match;
import com.kosshitikhin.footballcity.player.Player;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Goal extends StatisticsEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private League league;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Match match;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Player player;

    public Goal() {
    }

    public Goal(String firstName, String surname, int minute) {
        this.firstName = firstName;
        this.surname = surname;
        this.minute = minute;
    }

    public Goal(String firstName, String surname, int minute, Match match, Player player) {
        this.firstName = firstName;
        this.surname = surname;
        this.minute = minute;
        this.match = match;
        this.player = player;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goal)) return false;
        Goal goal = (Goal) o;
        return Objects.equals(match, goal.getMatch()) &&
                Objects.equals(player, goal.getPlayer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(match, player);
    }
}