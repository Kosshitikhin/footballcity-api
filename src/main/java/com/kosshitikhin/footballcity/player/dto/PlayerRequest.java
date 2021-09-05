package com.kosshitikhin.footballcity.player.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;

@Slf4j
@Setter
@Getter
public class PlayerRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String surname;

    @NotNull
    private String patronymic;

    @NotNull
    private int age;

}
