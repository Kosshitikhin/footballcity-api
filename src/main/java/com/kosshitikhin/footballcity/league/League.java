package com.kosshitikhin.footballcity.league;

import com.kosshitikhin.footballcity.common.dbo.IdEntity;
import com.kosshitikhin.footballcity.match.Match;
import com.kosshitikhin.footballcity.team.Team;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class League extends IdEntity {

    @Column(nullable = false)
    private String name;

    @Column (name = "start_year", nullable = false)
    private String startYear;

    @Column(name = "end_year")
    private String endYear;

    @OneToMany(mappedBy = "league", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Team> teams;

    @OneToMany(mappedBy = "league", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Match> matches;

    public League() {

    }

    public League(String name, String startYear, String endYear) {
        this.name = name;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof League)) return false;
        if (!super.equals(o)) return false;
        League league = (League) o;
        return Objects.equals(name, league.getName()) &&
                Objects.equals(startYear, league.getStartYear()) &&
                Objects.equals(endYear, league.getEndYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, startYear, endYear);
    }
}
