package com.example.cmdproject_team2.domain.user.service;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.user.enums.UserType;
import com.example.cmdproject_team2.domain.user.facade.UserFacade;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.AdminLoginRequest;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.AdminModifyRequest;
import com.example.cmdproject_team2.domain.user.presentation.dto.request.AdminSignupRequest;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.*;
import com.example.cmdproject_team2.global.exception.user.NotAdminException;
import com.example.cmdproject_team2.global.exception.user.PasswordMismatchException;
import com.example.cmdproject_team2.global.exception.user.UserNotFoundException;
import com.example.cmdproject_team2.global.security.jwt.JwtProperties;
import com.example.cmdproject_team2.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final JwtProperties jwtProperties;

    private final UserFacade userFacade;

    public void signup(AdminSignupRequest request) {

        User user = User.builder()
                .userId(request.getUserId())
                .password(request.getPassword())
                .build();

        if(!request.getSecretKey().equals(user.getSecretKey())) {
            throw NotAdminException.EXCEPTION;
        }

        userRepository.save(user);
    }

    public TokenResponse login(AdminLoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        if(!request.getPassword().equals(user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createToken(user.getUsername()))
                .expiredAt(java.time.LocalDateTime.now()
                        .plusSeconds(jwtProperties.getAccessExpiration()))
                .build();
    }

    public AdminDetailsResponse getAdminDetails(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(()->UserNotFoundException.EXCEPTION);

        return new AdminDetailsResponse(user);
    }

    public StudentListResponse getStudentList() {
        List<User> user = userRepository.findAllByType(UserType.USER);

        List<StudentList> studentList = user.stream().map(StudentList::of)
                .toList();

        return new StudentListResponse(studentList);
    }

    public StudentDetailsResponse getStudentDetails() {

        User currentUser = userFacade.currentUser();

        return new StudentDetailsResponse(currentUser);
    }

    public void modifyAdminInfo(Long userId, AdminModifyRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->UserNotFoundException.EXCEPTION);

        user.modifyAdminInfo(request.getUsername(), request.getGrader(), request.getSchoolClass());
        userRepository.save(user);
    }

}
