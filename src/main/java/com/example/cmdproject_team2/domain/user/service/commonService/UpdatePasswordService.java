package com.example.cmdproject_team2.domain.user.service.commonService;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.user.facade.UserFacade;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.UpdatePasswordRequest;
import com.example.cmdproject_team2.global.exception.user.PasswordMismatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
@Transactional
public class UpdatePasswordService {

    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    public void updatePassword(UpdatePasswordRequest request) {
        User user = userFacade.currentUser();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        user.updatePassword(passwordEncoder.encode(request.getNewPassword()));
    }
}
