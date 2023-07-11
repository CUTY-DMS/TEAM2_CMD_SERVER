package com.example.cmdproject_team2.domain.user.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String password;

    @NotNull
    private String userId;

    private String userEmail;

    @Enumerated(EnumType.STRING)
    @Column
    private Authority authority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id",nullable = false)
    private Division division;


    @Builder
    public User(String userId, String password, String userEmail,Authority authority) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.password = password;
        this.authority = authority;
    }
}
