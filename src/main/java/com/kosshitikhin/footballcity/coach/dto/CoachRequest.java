package com.kosshitikhin.footballcity.coach.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Slf4j
@Setter
@Getter
public class CoachRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String surname;

    @NotNull
    private String patronymic;

    @NotNull
    private LocalDate birthday;

}
