package com.example.cmdproject_team2.domain.user.service.commonService;

import com.example.cmdproject_team2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CheckUserIdService {

    private final UserFacade userFacade;

    public void execute(String userId) {
        userFacade.checkUserExist(userId);
    }
}
