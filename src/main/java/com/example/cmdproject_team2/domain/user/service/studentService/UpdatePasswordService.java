package com.example.cmdproject_team2.domain.user.service.studentService;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.user.facade.UserFacade;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.UpdatePasswordRequest;
import com.example.cmdproject_team2.global.exception.user.PasswordMismatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdatePasswordService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void updatePassword(UpdatePasswordRequest request) {
        User user = userFacade.currentUser();

        if(user.getPassword().equals(user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        user.updatePassword(request.getNewPassword());
        userRepository.save(user);
    }
}