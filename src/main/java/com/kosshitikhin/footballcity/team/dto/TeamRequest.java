package com.kosshitikhin.footballcity.team.dto;

import javax.validation.constraints.NotNull;

public class TeamRequest {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
