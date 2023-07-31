package com.example.cmdproject_team2.domain.user.service.adminService;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.user.facade.UserFacade;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.AdminModifyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class ModifyAdminInfoService {

    private final UserFacade userFacade;

    public void modifyAdminInfo(AdminModifyRequest request) {
        User user = userFacade.currentUser();

        user.modifyAdminInfo(request.getUsername(), request.getGrader(), request.getSchoolClass(), request.getSubjectType());
    }

}
