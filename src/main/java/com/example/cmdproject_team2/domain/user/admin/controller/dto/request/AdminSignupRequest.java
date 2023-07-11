package com.example.cmdproject_team2.domain.user.admin.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdminSignupRequest {

    private String userId;

    private String username;

    private String password;

    private Long grader;

    private Long schoolClass;

    @Value("${key.secretKey}")
    private String secretKey;
}
