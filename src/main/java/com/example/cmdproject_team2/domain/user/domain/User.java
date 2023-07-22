package com.example.cmdproject_team2.domain.user.domain;

import com.example.cmdproject_team2.domain.user.enums.MajorType;
import com.example.cmdproject_team2.domain.user.enums.SubjectType;
import com.example.cmdproject_team2.domain.user.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String username;

    private String userEmail;

    private String password;

    private Long grader;

    private Long schoolClass;

    private Long number;

    @Enumerated(EnumType.STRING)
    private MajorType majorType;

    @Enumerated(EnumType.STRING)
    private SubjectType subjectType;

    @Enumerated(EnumType.STRING)
    private UserType type;

    @Value("${key.secretKey}")
    private String secretKey;

    public void modifyAdminInfo(String username, Long grader, Long schoolClass) {
        this.username = username;
        this.grader = grader;
        this.schoolClass = schoolClass;
    }

    public void updateStudentInfo(String username, Long grader, Long schoolClass, Long number) {
        this.username = username;
        this.grader = grader;
        this.schoolClass = schoolClass;
        this.number = number;

    }

    public void updatePassword(String password) {
        this.password = password;
    }
}

