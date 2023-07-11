package com.example.cmdproject_team2.domain.user.repository.vo;

import lombok.Getter;

@Getter
public class UserListVo {

    private final String userId;
    private final Integer schoolClass;
    private final Integer number;
    private final Integer grader;

    public UserListVo(String userId, Integer schoolClass, Integer number, Integer grader) {
        this.userId = userId;
        this.schoolClass = schoolClass;
        this.number = number;
        this.grader = grader;
    }

}
