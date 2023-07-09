package com.example.cmdproject_team2.domain.user.controller;

import com.example.cmdproject_team2.domain.user.controller.dto.request.AdminLoginRequest;
import com.example.cmdproject_team2.domain.user.controller.dto.request.AdminSignupRequest;
import com.example.cmdproject_team2.domain.user.controller.dto.response.StudentDetailsResponse;
import com.example.cmdproject_team2.domain.user.controller.dto.response.StudentListResponse;
import com.example.cmdproject_team2.domain.user.controller.dto.response.TokenResponse;
import com.example.cmdproject_team2.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/admin/Signup")
    public void signup(@RequestBody AdminSignupRequest request) {
        userService.signup(request);
    }

    @PostMapping("/admin/login")
    public TokenResponse login(@RequestBody AdminLoginRequest request) {
        return userService.login(request);
    }

    @GetMapping
    public StudentDetailsResponse getStudentDetails() {
        return userService.getStudentDetails();
    }

    @GetMapping("/admin/getStudentList")
    public StudentListResponse getStudentList(){
        return userService.getStudentList();
    }
}
