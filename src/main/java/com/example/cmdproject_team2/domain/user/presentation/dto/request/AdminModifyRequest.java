package com.example.cmdproject_team2.domain.user.presentation.dto.request;

import com.example.cmdproject_team2.domain.user.enums.MajorType;
import com.example.cmdproject_team2.domain.user.enums.SubjectType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdminModifyRequest {

    private String username;

    private Long grader;

    private Long schoolClass;

    private SubjectType subjectType;
}
