package com.kosshitikhin.footballcity.league;

import com.kosshitikhin.footballcity.coach.Coach;
import com.kosshitikhin.footballcity.common.dbo.IdEntity;
import com.kosshitikhin.footballcity.team.Team;

import javax.persistence.*;
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
    private Set<Coach> coach;

    @OneToMany(mappedBy = "league", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Team> teams;

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

    public Set<Coach> getCoach() {
        return coach;
    }

    public void setCoach(Set<Coach> coach) {
        this.coach = coach;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

}
