package com.example.cmdproject_team2.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class TokenResponse {

    private String accessToken;

    private String refreshToken;

    private Date accessExpiredAt;

    private Date refreshExpiredAt;
}
