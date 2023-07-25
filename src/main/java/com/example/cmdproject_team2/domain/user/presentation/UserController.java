package com.example.cmdproject_team2.domain.user.presentation;

import com.example.cmdproject_team2.domain.auth.service.*;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.*;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.*;
import com.example.cmdproject_team2.domain.user.service.adminService.*;
import com.example.cmdproject_team2.domain.user.service.commonService.*;
import com.example.cmdproject_team2.domain.user.service.studentService.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@RestController
@RequiredArgsConstructor
public class UserController {

    //PUBLIC
    private final GetStudentDetailsService getStudentDetailsService;
    private final GetStudentListService getStudentListService;
    private final DuplicateUserIdService duplicateUserIdService;
    private final CheckPasswordService checkPasswordService;
    private final FindUserIdService findUserIdService;
    private final UpdatePasswordService updatePasswordService;
    private final LogoutService logoutService;


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

    @RequestMapping(value = "/userId", method = RequestMethod.HEAD)
    public void duplicateUserIdExist(@NotNull @RequestParam(name = "userId") String userId) {
        duplicateUserIdService.execute(userId);
    }

    @PostMapping("/checkPassword")
    public void checkPassword(@RequestBody @Valid CheckPasswordRequest request) {
        checkPasswordService.execute(request);
    }

    @GetMapping("/findUserId")
    public UserIdResponse findUserId(@PathVariable("userEmail") String userEmail) {
        return findUserIdService.findUserId(userEmail);
    }

    @PatchMapping("/updatePassword")
    public void updatePassword(@RequestBody @Valid UpdatePasswordRequest request) {
        updatePasswordService.updatePassword(request);
    }

    @DeleteMapping("/logout")
    public void logout() {
        logoutService.logout();
    }


    //STUDENT
    @PostMapping("/signup/student")
    public void userSignup(@RequestBody StudentSignupRequest request) {
        studentSignUpService.signUp(request);
    }
    @PostMapping("/login/student")
    public TokenResponse userLogin(@RequestBody @Valid StudentLoginRequest request) {
        return studentLoginService.loginUser(request);
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
        modifyAdminInfoService.modifyAdminInfo(userId, request);
    }
}
