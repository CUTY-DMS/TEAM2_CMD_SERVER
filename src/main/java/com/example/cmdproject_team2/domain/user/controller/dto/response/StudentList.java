package com.example.cmdproject_team2.domain.user.controller.dto.response;

import com.example.cmdproject_team2.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudentList {

    private Long id;

    private String userName;

    private Long grader;

    private Long schoolClass;

    private Long number;

    public static StudentList of(User user) {
        return StudentList.builder()
                .id(user.getId())
                .userName(user.getUsername())
                .grader(user.getGrader())
                .schoolClass(user.getSchoolClass())
                .number(user.getNumber())
                .build();
    }
}
