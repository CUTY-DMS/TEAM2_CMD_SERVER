package com.example.cmdproject_team2.domain.auth.service;

import com.example.cmdproject_team2.domain.user.presentation.dto.response.TokenResponse;
import com.example.cmdproject_team2.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TokenReissueService {

    private final JwtTokenProvider jwtTokenProvider;
    @Transactional
    public TokenResponse reissue(String token) {
        return jwtTokenProvider.reissue(token);
    }
}
