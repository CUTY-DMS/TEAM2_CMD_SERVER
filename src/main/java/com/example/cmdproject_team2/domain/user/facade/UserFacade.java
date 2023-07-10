package com.example.cmdproject_team2.domain.user.facade;

import com.example.cmdproject_team2.domain.user.entity.User;
import com.example.cmdproject_team2.domain.user.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByUserId(userId);
    }
}
