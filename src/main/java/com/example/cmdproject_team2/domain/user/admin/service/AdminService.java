package com.example.cmdproject_team2.domain.user.admin.service;

import com.example.cmdproject_team2.domain.user.UserType;
import com.example.cmdproject_team2.domain.user.admin.controller.dto.request.AdminLoginRequest;
import com.example.cmdproject_team2.domain.user.admin.controller.dto.request.AdminModifyRequest;
import com.example.cmdproject_team2.domain.user.admin.controller.dto.request.AdminSignupRequest;
import com.example.cmdproject_team2.domain.user.admin.controller.dto.response.*;
import com.example.cmdproject_team2.domain.user.admin.entity.Admin;
import com.example.cmdproject_team2.domain.user.admin.repository.AdminRepository;
import com.example.cmdproject_team2.domain.user.admin.service.exception.user.NotAdminException;
import com.example.cmdproject_team2.domain.user.admin.service.exception.user.PasswordMismatchException;
import com.example.cmdproject_team2.domain.user.admin.service.exception.user.UserNotFoundException;
import com.example.cmdproject_team2.domain.user.admin.service.facade.AdminFacade;
import com.example.cmdproject_team2.global.security.jwt.JwtProperties;
import com.example.cmdproject_team2.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final JwtProperties jwtProperties;

    private final AdminFacade adminFacade;

    public void signup(AdminSignupRequest request) {

        Admin user = Admin.builder()
                .userId(request.getUserId())
                .password(request.getPassword())
                .secretKey(request.getSecretKey())
                .build();

        if(!request.getSecretKey().equals(user.getSecretKey())) {
            throw NotAdminException.EXCEPTION;
        }

        adminRepository.save(user);
    }

    public TokenResponse login(AdminLoginRequest request) {

        Admin admin = adminRepository.findByUserId(request.getUserId())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        if(!request.getPassword().equals(admin.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createToken(admin.getUserId()))
                .expiredAt(java.time.LocalDateTime.now()
                        .plusSeconds(jwtProperties.getAccessExpiration()))
                .build();
    }

    public AdminDetailsResponse getAdminDetails(String userId) {

        Admin admin = adminRepository.findByUserId(userId)
                .orElseThrow(()->UserNotFoundException.EXCEPTION);

        return new AdminDetailsResponse(admin);
    }

    public StudentListResponse getStudentList() {
        List<Admin> admins = adminRepository.findAllByType(UserType.STUDENT);

        List<StudentList> studentList = admins.stream().map(StudentList::of)
                .toList();

        return new StudentListResponse(studentList);
    }

    public StudentDetailsResponse getStudentDetails() {

        Admin currentUser = adminFacade.currentUser();

        return new StudentDetailsResponse(currentUser);
    }

    public void modifyAdminInfo(Long userId, AdminModifyRequest request) {
        Admin admin = adminRepository.findById(userId)
                .orElseThrow(()->UserNotFoundException.EXCEPTION);

        admin.modifyAdminInfo(request.getUsername(), request.getGrader(), request.getSchoolClass());
        adminRepository.save(admin);
    }

}
