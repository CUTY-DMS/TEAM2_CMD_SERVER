package com.example.cmdproject_team2.domain.user.admin.service.facade;

import com.example.cmdproject_team2.domain.user.admin.entity.Admin;
import com.example.cmdproject_team2.domain.user.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final AdminRepository userRepository;

    public Admin currentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username)
                .orElseThrow();
    }
}
