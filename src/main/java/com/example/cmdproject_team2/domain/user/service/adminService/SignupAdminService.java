package com.example.cmdproject_team2.domain.user.service.adminService;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
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

    public void signup(AdminSignupRequest request) {

        User user = User.builder()
                .userId(request.getUserId())
                .password(request.getPassword())
                .build();

        if(!request.getSecretKey().equals(user.getSecretKey())) {
            throw NotAdminException.EXCEPTION;
        }

        userRepository.save(user);
    }
}
