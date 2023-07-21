package com.example.cmdproject_team2.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdminLoginRequest {

    @NotNull
    private String userId;

    @NotNull
    private String username;

    @NotNull
    private String password;
}
