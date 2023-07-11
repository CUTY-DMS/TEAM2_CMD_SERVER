package com.example.cmdproject_team2.domain.user.admin.controller;

import com.example.cmdproject_team2.domain.user.admin.controller.dto.request.AdminSignupRequest;
import com.example.cmdproject_team2.domain.user.admin.controller.dto.response.AdminDetailsResponse;
import com.example.cmdproject_team2.domain.user.admin.controller.dto.response.StudentDetailsResponse;
import com.example.cmdproject_team2.domain.user.admin.controller.dto.response.TokenResponse;
import com.example.cmdproject_team2.domain.user.admin.controller.dto.request.AdminLoginRequest;
import com.example.cmdproject_team2.domain.user.admin.controller.dto.request.AdminModifyRequest;
import com.example.cmdproject_team2.domain.user.admin.controller.dto.response.StudentListResponse;
import com.example.cmdproject_team2.domain.user.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/signup")
    public void signup(@RequestBody AdminSignupRequest request) {
        adminService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody AdminLoginRequest request) {
        return adminService.login(request);
    }

    @GetMapping("/admin/{userId}")
    public AdminDetailsResponse getAdminDetails(@PathVariable String userId) {
        return adminService.getAdminDetails(userId);
    }

    @GetMapping("/admin/getStudentDetails")
    public StudentDetailsResponse getStudentDetails() {
        return adminService.getStudentDetails();
    }

    @GetMapping("/admin/getStudentList")
    public StudentListResponse getStudentList(){
        return adminService.getStudentList();
    }

    @PatchMapping("/admin{userId}")
    public void modifyAdminInfo(@PathVariable long userId, @RequestBody AdminModifyRequest request){
        adminService.modifyAdminInfo(userId, request);
    }
}
