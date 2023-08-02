package com.example.cmdproject_team2.domain.user.presentation.dto.response;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.schedule.enums.SubjectType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Builder
@AllArgsConstructor
public class AdminDetailsResponse {

    private String username;

    private Long grader;

    private Long schoolClass;

    @Enumerated(EnumType.STRING)
    private SubjectType subjectType;

    public AdminDetailsResponse(User user){
        username = user.getUsername();
        grader = user.getGrader();
        schoolClass = user.getSchoolClass();
        subjectType = user.getSubjectType();
    }
}
