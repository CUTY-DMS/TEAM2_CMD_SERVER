package com.example.cmdproject_team2.domain.user.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdminModifyRequest {

    private String username;

    private Long grader;

    private Long schoolClass;
}
