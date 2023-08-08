package com.example.cmdproject_team2.domain.user.facade;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.global.exception.user.NotAuthenticatedException;
import com.example.cmdproject_team2.global.exception.user.UserExistsException;
import com.example.cmdproject_team2.global.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new NotAuthenticatedException("인증되지 않는 사용자입니다.");
        }

        String userId = authentication.getName();

        return userRepository.findByUserId(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void checkUserExist(String userId) {
        if (userRepository.findByUserId(userId).isPresent()) {
            throw UserExistsException.EXCEPTION;
        }
    }

}
