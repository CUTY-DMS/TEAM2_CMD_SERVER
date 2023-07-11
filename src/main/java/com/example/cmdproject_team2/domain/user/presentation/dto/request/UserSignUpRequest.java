package com.example.cmdproject_team2.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSignUpRequest {

    @NotNull
    private String userId;

    @NotNull
    private String password;

    @NotNull
    @Length(min = 1, max = 10)
    private String username;

    @NotNull
    @Column(unique = true)
    private String userEmail;

    @NotNull
    private Long grader;

    private Long schoolClass;

    private Long number;
}
