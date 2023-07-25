package com.example.cmdproject_team2.domain.auth.presentation;

import com.example.cmdproject_team2.domain.auth.presentation.dto.ReIssueRequest;
import com.example.cmdproject_team2.domain.auth.service.TokenReissueService;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final TokenReissueService tokenReissueService;

    @PostMapping("/reissue")
    public TokenResponse reissue(@RequestBody ReIssueRequest request) {
        return tokenReissueService.reissue(request.getRefreshToken());
    }
}
