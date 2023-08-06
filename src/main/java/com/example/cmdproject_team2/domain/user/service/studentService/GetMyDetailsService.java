package com.example.cmdproject_team2.domain.user.service.studentService;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.facade.UserFacade;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.StudentDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class GetMyDetailsService {

    private final UserFacade userFacade;
    public StudentDetailsResponse getMyDetails() {

        User user = userFacade.currentUser();

        return new StudentDetailsResponse(user);
    }
}
