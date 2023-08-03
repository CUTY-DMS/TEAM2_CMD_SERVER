package com.example.cmdproject_team2.domain.auth.service;

import com.example.cmdproject_team2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DuplicateUserIdService {

    private final UserFacade userFacade;

    public void execute(String userId) {
        userFacade.checkUserExist(userId);
    }

}
