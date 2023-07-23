package com.example.cmdproject_team2.domain.user.presentation.dto.response;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.enums.MajorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class StudentDetailsResponse {

    private String username;

    private Long grader;

    private Long schoolClass;

    private Long number;

    @Enumerated(EnumType.STRING)
    private MajorType majorType;

    public StudentDetailsResponse(User user) {
        username = user.getUsername();
        grader = user.getGrader();
        schoolClass = user.getSchoolClass();
        number = user.getNumber();
        majorType = user.getMajorType();
    }
}
