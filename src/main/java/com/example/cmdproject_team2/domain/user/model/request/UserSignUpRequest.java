package com.example.cmdproject_team2.domain.user.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {

    @NotNull
    private String userId;

    @NotNull
    private String password;
}
