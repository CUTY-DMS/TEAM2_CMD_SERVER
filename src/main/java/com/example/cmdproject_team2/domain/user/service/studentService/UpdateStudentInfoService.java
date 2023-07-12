package com.example.cmdproject_team2.domain.user.service.studentService;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.StudentUpdateRequest;
import com.example.cmdproject_team2.global.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateStudentInfoService {

    private final UserRepository userRepository;

    @Transactional
    public void updateStudentInfo(Long userId, StudentUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        user.updateStudentInfo(request.getUsername(), request.getGrader(), request.getSchoolClass(), request.getNumber(), request.getMajor(), request.getClub(), request.getBirth());

        userRepository.save(user);

    }


}
