package com.example.cmdproject_team2.domain.user.admin.controller;

import com.example.cmdproject_team2.domain.user.admin.controller.dto.request.AdminSignupRequest;
import com.example.cmdproject_team2.domain.user.admin.controller.dto.response.AdminDetailsResponse;
import com.example.cmdproject_team2.domain.user.admin.controller.dto.response.StudentDetailsResponse;
import com.example.cmdproject_team2.domain.user.admin.controller.dto.response.TokenResponse;
import com.example.cmdproject_team2.domain.user.admin.controller.dto.request.AdminLoginRequest;
import com.example.cmdproject_team2.domain.user.admin.controller.dto.request.AdminModifyRequest;
import com.example.cmdproject_team2.domain.user.admin.controller.dto.response.StudentListResponse;
import com.example.cmdproject_team2.domain.user.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/admin/getAdminDetails")
    public AdminDetailsResponse getAdminDetails(@PathVariable long userId) {
        return userService.getAdminDetails(userId);
    }

    @GetMapping("/admin/getStudentDetails")
    public StudentDetailsResponse getStudentDetails() {
        return userService.getStudentDetails();
    }

    @GetMapping("/admin/getStudentList")
    public StudentListResponse getStudentList(){
        return userService.getStudentList();
    }

    @PatchMapping
    public void modifyAdminInfo(@PathVariable long userId, @RequestBody AdminModifyRequest request){
        userService.modifyAdminInfo(userId, request);
    }
}
