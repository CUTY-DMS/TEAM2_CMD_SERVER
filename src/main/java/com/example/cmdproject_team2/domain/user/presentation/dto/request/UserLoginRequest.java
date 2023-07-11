package com.example.cmdproject_team2.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Transactional
public class UserLoginRequest {

    @NotNull
    private String userId;

    @NotNull
    private String password;

}
