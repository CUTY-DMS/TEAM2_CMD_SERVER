package com.example.cmdproject_team2.domain.auth.presentation;

import com.example.cmdproject_team2.domain.auth.presentation.dto.request.CheckPasswordRequest;
import com.example.cmdproject_team2.domain.auth.presentation.dto.request.ReIssueRequest;
import com.example.cmdproject_team2.domain.auth.presentation.dto.response.TokenResponse;
import com.example.cmdproject_team2.domain.auth.service.CheckPasswordService;
import com.example.cmdproject_team2.domain.auth.service.DuplicateUserIdService;
import com.example.cmdproject_team2.domain.auth.service.LogoutService;
import com.example.cmdproject_team2.domain.auth.service.TokenReissueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final TokenReissueService tokenReissueService;
    private final DuplicateUserIdService duplicateUserIdService;
    private final CheckPasswordService checkPasswordService;
    private final LogoutService logoutService;

    @PostMapping("/reissue")
    public TokenResponse reissue(@RequestBody ReIssueRequest request) {
        return tokenReissueService.reissue(request.getRefreshToken());
    }

    @RequestMapping(value = "/userId", method = RequestMethod.HEAD)
    public void duplicateUserIdExist(@NotBlank @RequestParam(name = "userId") String userId) {
        duplicateUserIdService.execute(userId);
    }

    @PostMapping("/checkPassword")
    public void checkPassword(@RequestBody @Valid CheckPasswordRequest request) {
        checkPasswordService.execute(request);
    }

    @DeleteMapping("/logout")
    public void logout() {
        logoutService.logout();
    }

}
