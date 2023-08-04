package com.example.cmdproject_team2.domain.user.presentation.dto.response;

import com.example.cmdproject_team2.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudentList {

    private String userName;

    private Long grader;

    private Long schoolClass;

    private Long number;

    public static StudentList of(User user) {
        return StudentList.builder()
                .userName(user.getUsername())
                .grader(user.getGrader())
                .schoolClass(user.getSchoolClass())
                .number(user.getNumber())
                .build();
    }
}
