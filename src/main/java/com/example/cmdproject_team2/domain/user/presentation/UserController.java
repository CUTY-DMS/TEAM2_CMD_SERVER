package com.example.cmdproject_team2.domain.user.presentation;

import com.example.cmdproject_team2.domain.auth.presentation.dto.response.TokenResponse;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.*;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.AdminDetailsResponse;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.StudentDetailsResponse;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.StudentListResponse;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.UserIdResponse;
import com.example.cmdproject_team2.domain.user.service.adminService.GetAdminDetailsService;
import com.example.cmdproject_team2.domain.user.service.adminService.LoginAdminService;
import com.example.cmdproject_team2.domain.user.service.adminService.ModifyAdminInfoService;
import com.example.cmdproject_team2.domain.user.service.adminService.SignupAdminService;
import com.example.cmdproject_team2.domain.user.service.commonService.FindUserIdService;
import com.example.cmdproject_team2.domain.user.service.commonService.GetStudentDetailsService;
import com.example.cmdproject_team2.domain.user.service.commonService.GetStudentListService;
import com.example.cmdproject_team2.domain.user.service.commonService.UpdatePasswordService;
import com.example.cmdproject_team2.domain.user.service.studentService.StudentLoginService;
import com.example.cmdproject_team2.domain.user.service.studentService.StudentSignUpService;
import com.example.cmdproject_team2.domain.user.service.studentService.UpdateStudentInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class UserController {

    //PUBLIC
    private final GetStudentDetailsService getStudentDetailsService;
    private final GetStudentListService getStudentListService;
    private final FindUserIdService findUserIdService;
    private final UpdatePasswordService updatePasswordService;

    //STUDENT
    private final StudentSignUpService studentSignUpService;
    private final StudentLoginService studentLoginService;
    private final UpdateStudentInfoService updateStudentInfoService;

    //ADMIN
    private final SignupAdminService signupAdminService;
    private final LoginAdminService loginAdminService;
    private final GetAdminDetailsService getAdminDetailsService;
    private final ModifyAdminInfoService modifyAdminInfoService;

    //PUBLIC
    @GetMapping("/getStudentDetails")
    public StudentDetailsResponse getStudentDetails() {
        return getStudentDetailsService.getStudentDetails();
    }

    @GetMapping("/getStudentList")
    public StudentListResponse getStudentList(){
        return getStudentListService.getStudentList();
    }

    @GetMapping("/users/{userEmail}")
    public UserIdResponse findUserId(@PathVariable("userEmail") String userEmail) {
        return findUserIdService.findUserId(userEmail);
    }

    @PatchMapping("/updatePassword")
    public void updatePassword(@RequestBody @Valid UpdatePasswordRequest request) {
        updatePasswordService.updatePassword(request);
    }

    //STUDENT
    @PostMapping("/signup/student")
    public void userSignup(@RequestBody StudentSignupRequest request) {
        studentSignUpService.signUp(request);
    }

    @PostMapping("/login/student")
    public TokenResponse userLogin(@RequestBody @Valid StudentLoginRequest request) {
        return studentLoginService.login(request);
    }

    @PatchMapping("/student/{userId}")
    public void updateStudentInfo(@PathVariable long userId, @RequestBody StudentUpdateRequest request){
        updateStudentInfoService.updateStudentInfo(userId, request);
    }

    //ADMIN
    @PostMapping("/signup/admin")
    public void signupAdmin(@RequestBody AdminSignupRequest request) {
        signupAdminService.signupAdmin(request);
    }

    @PostMapping("/login/admin")
    public TokenResponse loginAdmin(@RequestBody AdminLoginRequest request) {
        return loginAdminService.loginAdmin(request);
    }

    @GetMapping("/admin/{userId}")
    public AdminDetailsResponse getAdminDetails(@PathVariable long userId) {
        return getAdminDetailsService.getAdminDetails(userId);
    }

    @PatchMapping("/admin/{userId}")
    public void modifyAdminInfo(@PathVariable long userId, @RequestBody AdminModifyRequest request){
        modifyAdminInfoService.modifyAdminInfo(request);
    }

}
