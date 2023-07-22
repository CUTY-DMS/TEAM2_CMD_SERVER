package com.example.cmdproject_team2.domain.user.presentation.dto.request;

import com.example.cmdproject_team2.domain.user.enums.MajorType;
import com.example.cmdproject_team2.domain.user.enums.UserType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdminSignupRequest {

    @NotNull
    private String userId;

    @NotNull
    private String user_email;

    @NotNull
    @Pattern(regexp="(?=.*\\d)(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}", message = "비밀번호는 특수기호 숫가 포함 8-20자여야 합니다")
    private String password;

    @NotNull
    private String username;

    @NotNull
    private Long grader;

    @NotNull
    private Long schoolClass;

    @NotNull
    private Long number;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MajorType majorType;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @NotNull
    @Value("${key.secretKey}")
    private String secretKey;
}
