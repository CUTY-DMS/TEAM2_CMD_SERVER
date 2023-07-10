package com.example.cmdproject_team2.domain.user.service;

import com.example.cmdproject_team2.domain.user.controller.dto.request.AdminLoginRequest;
import com.example.cmdproject_team2.domain.user.controller.dto.request.AdminSignupRequest;
import com.example.cmdproject_team2.domain.user.controller.dto.response.StudentDetailsResponse;
import com.example.cmdproject_team2.domain.user.controller.dto.response.StudentList;
import com.example.cmdproject_team2.domain.user.controller.dto.response.StudentListResponse;
import com.example.cmdproject_team2.domain.user.controller.dto.response.TokenResponse;
import com.example.cmdproject_team2.domain.user.entity.User;
import com.example.cmdproject_team2.domain.user.entity.UserType;
import com.example.cmdproject_team2.domain.user.repository.UserRepository;
import com.example.cmdproject_team2.domain.user.service.exception.user.NotAdminException;
import com.example.cmdproject_team2.domain.user.service.exception.user.PasswordMismatchException;
import com.example.cmdproject_team2.domain.user.service.exception.user.UserNotFoundException;
import com.example.cmdproject_team2.domain.user.service.facade.UserFacade;
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

    public StudentListResponse getStudentList() {
        List<User> user = userRepository.findAllByType(UserType.STUDENT);

        List<StudentList> studentList = user.stream().map(StudentList::of)
                .toList();

        return new StudentListResponse(studentList);
    }

    public StudentDetailsResponse getStudentDetails() {

        User currentUser = userFacade.currentUser();

        return new StudentDetailsResponse(currentUser);
    }

}
