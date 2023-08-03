package com.example.cmdproject_team2.domain.user.service.adminService;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.facade.UserFacade;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.AdminDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class GetAdminDetailsService {

    private final UserFacade userFacade;

    public AdminDetailsResponse getAdminDetails() {

        User user = userFacade.currentUser();

        return new AdminDetailsResponse(user);

    }

}
