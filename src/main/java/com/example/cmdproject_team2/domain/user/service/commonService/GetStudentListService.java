package com.example.cmdproject_team2.domain.user.service.commonService;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.user.enums.UserType;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.StudentList;
import com.example.cmdproject_team2.domain.user.presentation.dto.response.StudentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class GetStudentListService {

    private final UserRepository userRepository;

    public StudentListResponse getStudentList() {

        List<User> user = userRepository.findAllByType(UserType.STUDENT);

        List<StudentList> studentList = user.stream().map(StudentList::of)
                .toList();

        return new StudentListResponse(studentList);

    }
}
