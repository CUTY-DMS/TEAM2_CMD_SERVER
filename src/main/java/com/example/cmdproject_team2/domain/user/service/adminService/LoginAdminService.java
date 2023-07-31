package com.example.cmdproject_team2.domain.user.service.adminService;

import com.example.cmdproject_team2.domain.auth.presentation.dto.response.TokenResponse;
import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.AdminLoginRequest;
import com.example.cmdproject_team2.global.exception.user.PasswordMismatchException;
import com.example.cmdproject_team2.global.exception.user.UserNotFoundException;
import com.example.cmdproject_team2.global.security.jwt.JwtProperties;
import com.example.cmdproject_team2.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service
@RequiredArgsConstructor
public class LoginAdminService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final JwtProperties jwtProperties;

    public TokenResponse loginAdmin(AdminLoginRequest request) {

        Date now = new Date();

        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return TokenResponse.builder()
                .refreshToken(jwtTokenProvider.createRefreshToken(user.getUsername()))
                .accessToken(jwtTokenProvider.createAccessToken(user.getUsername()))
                .accessExpiredAt(new Date(now.getTime() + jwtProperties.getAccessExpiration()))
                .refreshExpiredAt(new Date(now.getTime() + jwtProperties.getRefreshExpiration()))
                .build();
    }

}
