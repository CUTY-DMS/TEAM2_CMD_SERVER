package com.example.cmdproject_team2.domain.user.presentation.dto.response;

import com.example.cmdproject_team2.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class StudentDetailsResponse {

    private String username;

    private Long grader;

    private Long schoolClass;

    private Long number;

    private String major;

    private String club;

    private Date birth;

    public StudentDetailsResponse(User user){
        username = user.getUsername();
        grader = user.getGrader();
        schoolClass = user.getSchoolClass();
        number = user.getNumber();
        major = user.getMajor();
        club = user.getClub();
        birth = user.getBirth();
    }
}
