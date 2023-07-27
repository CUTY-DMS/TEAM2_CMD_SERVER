package com.example.cmdproject_team2.domain.auth.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CheckPasswordRequest {

    @NotNull
    private String password;
}
