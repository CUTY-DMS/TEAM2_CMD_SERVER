package com.example.cmdproject_team2.domain.user.service.studentService;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.user.facade.UserFacade;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.StudentSignupRequest;
import com.example.cmdproject_team2.global.security.jwt.JwtProperties;
import com.example.cmdproject_team2.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class StudentSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void userSignUp(StudentSignupRequest request) {
        User user = User.builder()
                .userId(request.getUserId())
                .password(passwordEncoder.encode(request.getPassword()))
                .userEmail(request.getUserEmail())
                .grader(request.getGrader())
                .number(request.getNumber())
                .schoolClass(request.getSchoolClass())
                .birth(request.getBirth())
                .club(request.getClub())
                .major(request.getMajor())
                .build();

        userRepository.save(user);
    }
}
