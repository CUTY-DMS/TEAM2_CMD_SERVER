package com.example.cmdproject_team2.domain.user.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserType {

    STUDENT("학생"),
    ADMIN("교사"),

    ;

    private final String name;

}
