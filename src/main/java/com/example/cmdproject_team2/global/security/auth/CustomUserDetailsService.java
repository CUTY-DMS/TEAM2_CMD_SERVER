package com.example.cmdproject_team2.global.security.auth;

import com.example.cmdproject_team2.domain.user.admin.entity.Admin;
import com.example.cmdproject_team2.domain.user.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final AdminRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        Admin user = userRepository.findByUserId(username)
                .orElseThrow();

        return new CustomUserDetails(user.getUsername());
    }
}
