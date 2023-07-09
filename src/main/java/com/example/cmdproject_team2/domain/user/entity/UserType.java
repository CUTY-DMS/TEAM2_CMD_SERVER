package com.example.cmdproject_team2.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
@Getter
@AllArgsConstructor
public enum UserType {

    STUDENT("학생"),
    ADMIN("교사"),

    ;

    private final String name;

}
