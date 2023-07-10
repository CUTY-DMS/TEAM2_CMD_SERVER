package com.example.cmdproject_team2.domain.user.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum UserType {

    STUDENT("학생"),
    ADMIN("교사"),

    ;

    private final String name;

}
