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
import com.example.cmdproject_team2.domain.user.service.commonService.*;
import com.example.cmdproject_team2.domain.user.service.studentService.GetMyDetailsService;
import com.example.cmdproject_team2.domain.user.service.studentService.StudentLoginService;
import com.example.cmdproject_team2.domain.user.service.studentService.StudentSignUpService;
import com.example.cmdproject_team2.domain.user.service.studentService.UpdateStudentInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    //COMMON
    private final GetStudentListService getStudentListService;
    private final FindUserIdService findUserIdService;
    private final UpdatePasswordService updatePasswordService;
    private final PasswordResetService passwordResetService;
    private final GetStudentDetailsService getStudentDetailsService;

    //STUDENT
    private final StudentSignUpService studentSignUpService;
    private final StudentLoginService studentLoginService;
    private final UpdateStudentInfoService updateStudentInfoService;
    private final GetMyDetailsService getMyDetailsService;

    //ADMIN
    private final SignupAdminService signupAdminService;
    private final LoginAdminService loginAdminService;
    private final GetAdminDetailsService getAdminDetailsService;
    private final ModifyAdminInfoService modifyAdminInfoService;

    //PUBLIC
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

    @PostMapping("/findPassword")
    public ResponseEntity<String> findPassword(@RequestBody String userEmail) {
        try {
            passwordResetService.resetPasswordAndSendEmail(userEmail);
            return ResponseEntity.ok("임시 비밀번호가 이메일로 발송되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("student/{userId}")
    public StudentDetailsResponse getStudentDetails(@PathVariable String userId) {

        return getStudentDetailsService.getStudentDetails(userId);
    }

    //STUDENT
    @PostMapping("/signup/student")
    public void userSignup(@RequestBody @Valid StudentSignupRequest request) {
        studentSignUpService.signUp(request);
    }

    @PostMapping("/login/student")
    public TokenResponse userLogin(@RequestBody @Valid StudentLoginRequest request) {
        return studentLoginService.login(request);
    }

    @PatchMapping("/student")
    public void updateStudentInfo(@RequestBody @Valid StudentUpdateRequest request){
        updateStudentInfoService.updateStudentInfo(request);
    }

    @GetMapping("/student")
    public StudentDetailsResponse getMyDetails() {
        return getMyDetailsService.getMyDetails();
    }

    //ADMIN
    @PostMapping("/signup/admin")
    public void signupAdmin(@RequestBody @Valid AdminSignupRequest request) {
        signupAdminService.signupAdmin(request);
    }

    @PostMapping("/login/admin")
    public TokenResponse loginAdmin(@RequestBody @Valid AdminLoginRequest request) {
        return loginAdminService.loginAdmin(request);
    }

    @GetMapping("/admin")
    public AdminDetailsResponse getAdminDetails() {
        return getAdminDetailsService.getAdminDetails();
    }

    @PatchMapping("/admin")
    public void modifyAdminInfo(@RequestBody @Valid AdminModifyRequest request){
        modifyAdminInfoService.modifyAdminInfo(request);
    }

}