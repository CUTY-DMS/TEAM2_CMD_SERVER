package com.example.cmdproject_team2.domain.user.service.adminService;

import com.example.cmdproject_team2.domain.auth.service.DuplicateUserIdService;
import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.user.enums.UserType;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.AdminSignupRequest;
import com.example.cmdproject_team2.global.exception.user.NotAdminException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SignupAdminService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final DuplicateUserIdService duplicateUserIdService;

    public void signupAdmin(AdminSignupRequest request) {

        String password = passwordEncoder.encode(request.getPassword());
        duplicateUserIdService.execute(request.getUserId());
        User user = User.builder()
                .userId(request.getUserId())
                .password(password)
                .username(request.getUsername())
                .userEmail(request.getUser_email())
                .grader(request.getGrader())
                .schoolClass(request.getSchoolClass())
                .subjectType(request.getSubjectType())
                .type(UserType.ADMIN)
                .secretKey(request.getSecretKey())
                .build();

        if(!request.getSecretKey().equals(user.getSecretKey())) {
            throw NotAdminException.EXCEPTION;
        }
        userRepository.save(user);

    }

}
