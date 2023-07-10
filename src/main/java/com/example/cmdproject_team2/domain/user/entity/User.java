package com.example.cmdproject_team2.domain.user.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String password;

    @NotNull
    private String userId;

    private String userEmail;

    private Long grader;

    private Long schoolClass;

    private Long number;

    @Enumerated(EnumType.STRING)
    @Column
    private Authority authority;
}
