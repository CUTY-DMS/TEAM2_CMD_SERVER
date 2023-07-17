package com.example.cmdproject_team2.domain.user.service.publicService;

import com.example.cmdproject_team2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CheckUserIdService {

    private final UserFacade userFacade;

    public void execute(String userId) {
        userFacade.checkUserExist(userId);
    }
}
