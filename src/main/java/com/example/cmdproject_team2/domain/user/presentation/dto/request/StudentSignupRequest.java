package com.example.cmdproject_team2.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudentSignupRequest {

    @NotNull
    private String userId;

    @NotNull
    @Pattern(regexp="(?=.*\\d)(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}", message = "비밀번호는 특수기호 숫가 포함 8-20자여야 합니다")
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
}
