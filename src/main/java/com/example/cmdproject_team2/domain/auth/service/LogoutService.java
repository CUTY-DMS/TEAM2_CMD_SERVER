package com.example.cmdproject_team2.domain.auth.service;

import com.example.cmdproject_team2.domain.auth.domain.RefreshToken;
import com.example.cmdproject_team2.domain.auth.domain.RefreshTokenRepository;
import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.facade.UserFacade;
import com.example.cmdproject_team2.global.exception.user.RefreshTokenNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class LogoutService {

    private final UserFacade userFacade;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void logout() {
        User user = userFacade.currentUser();

        RefreshToken refreshToken = refreshTokenRepository.findById(user.getUserId())
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        refreshTokenRepository.delete(refreshToken);
    }
}
