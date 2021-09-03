package com.kosshitikhin.footballcity.team.dto;

import javax.validation.constraints.NotEmpty;

public class TeamRequest {

    @NotEmpty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
