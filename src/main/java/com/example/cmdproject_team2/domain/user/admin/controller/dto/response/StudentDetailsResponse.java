package com.example.cmdproject_team2.domain.user.admin.controller.dto.response;

import com.example.cmdproject_team2.domain.user.admin.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class StudentDetailsResponse {

    private String username;

    private Long grader;

    private Long schoolClass;

    private Long number;

    public StudentDetailsResponse(Admin user){
        username = user.getUsername();
        grader = user.getGrader();
        schoolClass = user.getSchoolClass();
        number = user.getNumber();
    }
}
