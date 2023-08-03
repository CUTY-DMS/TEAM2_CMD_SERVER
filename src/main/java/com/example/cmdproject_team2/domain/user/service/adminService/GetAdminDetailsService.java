package com.example.cmdproject_team2.domain.user.service.adminService;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.AdminDetailsResponse;
import com.example.cmdproject_team2.global.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
@Transactional
public class GetAdminDetailsService {

    private final UserRepository userRepository;

    public AdminDetailsResponse getAdminDetails(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        return new AdminDetailsResponse(user);
    }

}
