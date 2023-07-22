package com.example.cmdproject_team2.domain.user.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MajorType {

    BACKEND("서버"),
    FRONTEND("클라이언트"),
    ANDROID("안드로이드"),
    IOS("ios"),
    AI("인공지능"),
    EMBEDDED("임베디드"),
    SECURITY("보안"),
    GAME("게임개발"),
    DESIGN("디자인"),

    ;

    private final String name;
}
