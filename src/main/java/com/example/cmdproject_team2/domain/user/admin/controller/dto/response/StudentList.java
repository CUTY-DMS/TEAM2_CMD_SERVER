package com.example.cmdproject_team2.domain.user.admin.controller.dto.response;

import com.example.cmdproject_team2.domain.user.admin.entity.Admin;
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

    public static StudentList of(Admin user) {
        return StudentList.builder()
                .id(user.getId())
                .userName(user.getUsername())
                .grader(user.getGrader())
                .schoolClass(user.getSchoolClass())
                .number(user.getNumber())
                .build();
    }
}
