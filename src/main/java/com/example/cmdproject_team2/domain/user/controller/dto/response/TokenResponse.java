package com.example.cmdproject_team2.domain.user.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TokenResponse {

    private String accessToken;

    private LocalDateTime expiredAt;
}
