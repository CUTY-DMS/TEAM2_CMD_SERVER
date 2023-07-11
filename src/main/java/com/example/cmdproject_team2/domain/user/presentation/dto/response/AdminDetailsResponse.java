package com.example.cmdproject_team2.domain.user.presentation.dto.response;

import com.example.cmdproject_team2.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AdminDetailsResponse {

    private String username;

    private Long grader;

    private Long schoolClass;

    public AdminDetailsResponse(User user){
        username = user.getUsername();
        grader = user.getGrader();
        schoolClass = user.getSchoolClass();
    }
}
