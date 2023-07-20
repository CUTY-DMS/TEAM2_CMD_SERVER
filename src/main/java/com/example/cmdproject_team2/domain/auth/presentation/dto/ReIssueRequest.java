package com.example.cmdproject_team2.domain.auth.presentation.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReIssueRequest {

    private String refreshToken;
}
