package com.example.cmdproject_team2.domain.user.service.studentService;

import com.example.cmdproject_team2.domain.auth.service.DuplicateUserIdService;
import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.user.enums.UserType;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.StudentSignupRequest;
import com.example.cmdproject_team2.global.exception.user.UserExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final DuplicateUserIdService duplicateUserIdService;

    public void signUp(StudentSignupRequest request) {

        String password = passwordEncoder.encode(request.getPassword());

        try {
            duplicateUserIdService.execute(request.getUserId());
        } catch (UserExistsException e) {
            throw new RuntimeException("중복된 아이디가 존재합니다.");
        }

        User user = User.builder()
                .userId(request.getUserId())
                .username(request.getUsername())
                .userEmail(request.getUserEmail())
                .password(password)
                .grader(request.getGrader())
                .number(request.getNumber())
                .schoolClass(request.getSchoolClass())
                .type(UserType.STUDENT)
                .majorType(request.getMajorType())
                .club(request.getClub())
                .birth(request.getBirth())
                .build();

        userRepository.save(user);

    }

}
