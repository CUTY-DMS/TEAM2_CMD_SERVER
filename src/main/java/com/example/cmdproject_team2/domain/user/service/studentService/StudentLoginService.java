package com.example.cmdproject_team2.domain.user.service.studentService;

import com.example.cmdproject_team2.domain.auth.presentation.dto.response.TokenResponse;
import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.StudentLoginRequest;
import com.example.cmdproject_team2.global.exception.user.PasswordMismatchException;
import com.example.cmdproject_team2.global.exception.user.UserNotFoundException;
import com.example.cmdproject_team2.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentLoginService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse login(StudentLoginRequest request) {

        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return jwtTokenProvider.createToken(request.getUserId());
    }

}


