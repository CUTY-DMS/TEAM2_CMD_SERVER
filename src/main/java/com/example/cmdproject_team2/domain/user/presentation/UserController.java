package com.example.cmdproject_team2.domain.user.presentation;

import com.example.cmdproject_team2.domain.user.presentation.dto.request.AdminLoginRequest;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.AdminModifyRequest;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.AdminSignupRequest;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.AdminDetailsResponse;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.StudentDetailsResponse;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.StudentListResponse;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.TokenResponse;
import com.example.cmdproject_team2.domain.user.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final SignupAdminService signupAdminService;
    private final LoginAdminService loginAdminService;
    private final GetAdminDetailsService getAdminDetailsService;
    private final GetStudentDetailsService getStudentDetailsService;
    private final GetStudentListService getStudentListService;
    private final ModifyAdminInfoService modifyAdminInfoService;

    @PostMapping("/admin/signup")
    public void signup(@RequestBody AdminSignupRequest request) {
        signupAdminService.signup(request);
    }

    @PostMapping("/admin/login")
    public TokenResponse login(@RequestBody AdminLoginRequest request) {
        return loginAdminService.login(request);
    }

    @GetMapping("/admin/getAdminDetails")
    public AdminDetailsResponse getAdminDetails(@PathVariable long userId) {
        return getAdminDetailsService.getAdminDetails(userId);
    }

    @GetMapping("/admin/getStudentDetails")
    public StudentDetailsResponse getStudentDetails() {
        return getStudentDetailsService.getStudentDetails();
    }

    @GetMapping("/admin/getStudentList")
    public StudentListResponse getStudentList(){
        return getStudentListService.getStudentList();
    }

    @PatchMapping
    public void modifyAdminInfo(@PathVariable long userId, @RequestBody AdminModifyRequest request){
        modifyAdminInfoService.modifyAdminInfo(userId, request);
    }
}
