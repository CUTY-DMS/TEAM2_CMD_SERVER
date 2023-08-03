package com.example.cmdproject_team2.domain.user.service.studentService;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.facade.UserFacade;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.StudentUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateStudentInfoService {

    private final UserFacade userFacade;

    public void updateStudentInfo(StudentUpdateRequest request) {

        User user = userFacade.currentUser();

        user.updateStudentInfo(request.getUsername(), request.getGrader(), request.getSchoolClass(), request.getNumber(), request.getMajorType(),
                request.getClub(), request.getBirth());

    }

}
