package com.example.cmdproject_team2.domain.user.service;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.user.facade.UserFacade;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.StudentDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class GetStudentDetailsService {

    private final UserFacade userFacade;

    public StudentDetailsResponse getStudentDetails() {

        User currentUser = userFacade.currentUser();

        return new StudentDetailsResponse(currentUser);
    }
}
