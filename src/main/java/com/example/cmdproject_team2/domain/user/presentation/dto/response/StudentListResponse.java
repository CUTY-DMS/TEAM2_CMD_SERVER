package com.example.cmdproject_team2.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public class StudentListResponse implements Serializable {

    private List<StudentList> currentStudent;
}
