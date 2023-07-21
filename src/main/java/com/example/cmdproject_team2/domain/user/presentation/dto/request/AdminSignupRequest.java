package com.example.cmdproject_team2.domain.user.presentation.dto.request;

import com.example.cmdproject_team2.domain.user.enums.UserType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdminSignupRequest {

    private String userId;

    private String user_email;

    private String password;

    private String username;

    private Long grader;

    private Long schoolClass;

    private Long number;

    @Enumerated(EnumType.STRING)
    private UserType ADMIN;

    @Value("${key.secretKey}")
    private String secretKey;
}
