package com.example.cmdproject_team2.domain.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum UserType {

    USER("학생"),
    ADMIN("교사"),

    ;

    private final String name;

}
