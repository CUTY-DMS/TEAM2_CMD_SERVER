package com.example.cmdproject_team2.domain.auth.service;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.facade.UserFacade;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.CheckPasswordRequest;
import com.example.cmdproject_team2.global.exception.user.PasswordMismatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CheckPasswordService {

    private final PasswordEncoder passwordEncoder;
    private final UserFacade userFacade;

    public void execute(CheckPasswordRequest request) {
        User user = userFacade.currentUser();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }
    }
}
