package com.example.cmdproject_team2.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TokenResponse {

    private String accessToken;

    private String refreshToken;

    private LocalDateTime expiredAt;
}
