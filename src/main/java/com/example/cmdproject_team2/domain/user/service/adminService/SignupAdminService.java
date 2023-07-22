package com.example.cmdproject_team2.domain.user.service.adminService;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.user.enums.UserType;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.AdminSignupRequest;
import com.example.cmdproject_team2.global.exception.user.NotAdminException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class SignupAdminService {

    private final UserRepository userRepository;

    public void signupAdmin(AdminSignupRequest request) {

        User user = User.builder()
                .userId(request.getUserId())
                .password(request.getPassword())
                .username(request.getUsername())
                .userEmail(request.getUser_email())
                .grader(request.getGrader())
                .schoolClass(request.getSchoolClass())
                .number(request.getNumber())
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
