package com.example.cmdproject_team2.domain.user.presentation;

import com.example.cmdproject_team2.domain.user.presentation.dto.request.*;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.*;
import com.example.cmdproject_team2.domain.user.service.adminService.*;
import com.example.cmdproject_team2.domain.user.service.studentService.GetDetailsService;
import com.example.cmdproject_team2.domain.user.service.studentService.StudentLoginService;
import com.example.cmdproject_team2.domain.user.service.studentService.StudentSignUpService;
import com.example.cmdproject_team2.domain.user.service.studentService.UpdateStudentInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class UserController {

    //STUDENT 여기다가 짜
    private final StudentSignUpService studentSignUpService;
    private final StudentLoginService studentLoginService;
    private final GetDetailsService getDetailsService;
    private final UpdateStudentInfoService updateStudentInfoService;



    //ADMIN
    private final SignupAdminService signupAdminService;
    private final LoginAdminService loginAdminService;
    private final GetAdminDetailsService getAdminDetailsService;
    private final GetStudentDetailsService getStudentDetailsService;
    private final GetStudentListService getStudentListService;
    private final ModifyAdminInfoService modifyAdminInfoService;

    //STUDENT 여기다가 짜
    @PostMapping("/signup/student")
    public void signupUser(@RequestBody @Valid StudentSignupRequest request) {
        studentSignUpService.userSignUp(request);
    }

    @PostMapping("/login/student")
    public TokenResponse userLogin(@RequestBody @Valid StudentLoginRequest request) {
        return studentLoginService.loginUser(request);
    }

    @GetMapping("/student/{userId}")
    public DetailsResponse getDetails(@PathVariable long userId) {
        return getDetailsService.getDetails(userId);
    }

    @PatchMapping("/admin/{userId}")
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

    @GetMapping("/admin/getStudentDetails")
    public StudentDetailsResponse getStudentDetails() {
        return getStudentDetailsService.getStudentDetails();
    }

    @GetMapping("/admin/getStudentList")
    public StudentListResponse getStudentList(){
        return getStudentListService.getStudentList();
    }

    @PatchMapping("/admin/{userId}")
    public void modifyAdminInfo(@PathVariable long userId, @RequestBody AdminModifyRequest request){
        modifyAdminInfoService.modifyAdminInfo(userId, request);
    }
}
