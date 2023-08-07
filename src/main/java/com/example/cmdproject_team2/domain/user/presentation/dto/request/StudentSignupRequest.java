package com.example.cmdproject_team2.domain.user.presentation.dto.request;

import com.example.cmdproject_team2.domain.user.enums.MajorType;
import com.example.cmdproject_team2.domain.user.enums.UserType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

    @NotNull
    private String club;

    @NotNull
    private Long year;

    @NotNull
    private Long month;

    @NotNull
    private Long day;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MajorType majorType;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
