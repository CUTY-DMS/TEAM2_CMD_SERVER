package com.example.cmdproject_team2.domain.user.facade;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.global.exception.user.EmailMatchedException;
import com.example.cmdproject_team2.global.exception.user.UserExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User currentUser() {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUserId(userId)
                .orElseThrow();
    }

    public void checkUserExist(String userId) {
        if (userRepository.findByUserId(userId).isPresent()) {
            throw UserExistsException.EXCEPTION;
        }
    }

    public void checkUserEmail(String userEmail) {
        if (userRepository.findByUserEmail(userEmail).isPresent()) {
            throw EmailMatchedException.EXCEPTION;
        }
    }
}
