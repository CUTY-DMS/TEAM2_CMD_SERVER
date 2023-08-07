package com.example.cmdproject_team2.domain.user.presentation.dto.request;

import com.example.cmdproject_team2.domain.user.enums.SubjectType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdminModifyRequest {

    @NotNull
    private String username;

    @NotNull
    private Long grader;

    @NotNull
    private Long schoolClass;

    @NotNull
    private SubjectType subjectType;
}
