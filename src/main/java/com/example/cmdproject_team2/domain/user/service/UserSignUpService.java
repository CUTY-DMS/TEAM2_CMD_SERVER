package com.example.cmdproject_team2.domain.user.service;

import com.example.cmdproject_team2.domain.user.entity.Authority;
import com.example.cmdproject_team2.domain.user.entity.User;
import com.example.cmdproject_team2.domain.user.entity.UserRepository;
import com.example.cmdproject_team2.domain.user.facade.UserFacade;
import com.example.cmdproject_team2.domain.user.model.request.UserSignUpRequest;
import com.example.cmdproject_team2.global.security.jwt.JwtProperties;
import com.example.cmdproject_team2.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final UserFacade facade;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProperties jwtProperties;
    private final JwtTokenProvider jwtTokenProvider;

    public void signUp(UserSignUpRequest request) {
        User user = userRepository.save(User.builder()
                .userId(request.getUserId())
                .password(passwordEncoder.encode(request.getPassword()))
                .authority(Authority.USER)
                .build());
    }
}
