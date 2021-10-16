package com.kosshitikhin.footballcity.assists;

import com.kosshitikhin.footballcity.common.dbo.StatisticsEntity;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.match.Match;
import com.kosshitikhin.footballcity.player.Player;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Assist extends StatisticsEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private League league;

    @ManyToOne(fetch = FetchType.LAZY)
    private Match match;

    @ManyToOne(fetch = FetchType.LAZY)
    private Player player;

    public Assist() {
    }

    public Assist(String firstName, String surname, int minute) {
        this.firstName = firstName;
        this.surname = surname;
        this.minute = minute;
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
        if (!super.equals(o)) return false;
        Assist assist = (Assist) o;
        return Objects.equals(league, assist.getLeague()) &&
                Objects.equals(match, assist.getMatch()) &&
                Objects.equals(player, assist.getPlayer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), league, match, player);
    }
}
