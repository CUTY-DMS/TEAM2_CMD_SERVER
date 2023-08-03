package com.example.cmdproject_team2.domain.user.service.commonService;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.UserIdResponse;
import com.example.cmdproject_team2.global.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class FindUserIdService {

    private final UserRepository userRepository;

    public UserIdResponse findUserId(String userEmail) {

        User user = userRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return new UserIdResponse(user.getUserId());

    }
}
