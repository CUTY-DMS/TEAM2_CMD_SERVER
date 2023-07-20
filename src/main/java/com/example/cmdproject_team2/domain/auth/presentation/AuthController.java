package com.example.cmdproject_team2.domain.auth.presentation;

import com.example.cmdproject_team2.domain.auth.service.AuthService;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/reissue")
    public TokenResponse reissue(@RequestHeader String refreshToken) {
        return authService.reissue(refreshToken);
    }
}
