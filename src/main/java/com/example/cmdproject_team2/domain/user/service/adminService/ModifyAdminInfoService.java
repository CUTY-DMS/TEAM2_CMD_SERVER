package com.example.cmdproject_team2.domain.user.service.adminService;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.AdminModifyRequest;
import com.example.cmdproject_team2.global.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class ModifyAdminInfoService {

    private final UserRepository userRepository;

    public void modifyAdminInfo(Long userId, AdminModifyRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        user.modifyAdminInfo(request.getUsername(), request.getGrader(), request.getSchoolClass());
        userRepository.save(user);
    }
}
