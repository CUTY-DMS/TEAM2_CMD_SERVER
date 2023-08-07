package com.example.cmdproject_team2.domain.user.presentation.dto.request;

import com.example.cmdproject_team2.domain.user.enums.MajorType;
import com.fasterxml.jackson.databind.node.LongNode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudentUpdateRequest {

    @NotNull
    private String username;

    @NotNull
    private Long grader;

    @NotNull
    private Long schoolClass;

    @NotNull
    private Long number;

    @NotNull
    private MajorType majorType;

    @NotNull
    private String club;

    @NotNull
    private Date birth;

}
