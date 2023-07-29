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

    private String username;

    private Long grader;

    private Long schoolClass;

    private Long number;

    private String club;

    private MajorType majorType;

    private Date birth;
}
