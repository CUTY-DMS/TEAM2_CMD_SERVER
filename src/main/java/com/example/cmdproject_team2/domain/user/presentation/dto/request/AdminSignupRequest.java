package com.example.cmdproject_team2.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdminSignupRequest {

    private String userId;

    private String password;

    @Value("${key.secretKey}")
    private String secretKey;
}
