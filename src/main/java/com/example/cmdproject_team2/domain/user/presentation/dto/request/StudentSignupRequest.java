package com.example.cmdproject_team2.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudentSignupRequest {

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

    @NotNull
    private Long schoolClass;

    @NotNull
    private Long number;

    @NotNull
    private String major;

    @NotNull
    private String club;

    @NotNull
    private Date birth;
}
