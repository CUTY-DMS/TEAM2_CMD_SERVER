package com.example.cmdproject_team2.domain.user.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum SubjectType {

    KOREAN("국어"),
    MATH("수학"),
    ENGLISH("영어"),
    SOCIAL("사회"),
    SCIENCE("과학"),
    HISTORY("역사"),
    ATHLETIC("체육"),
    MUSIC("음악"),
    ART("미술")

    ;


    private final String name;
}
