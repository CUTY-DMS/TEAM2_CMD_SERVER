package com.example.cmdproject_team2.domain.user.domain;

import com.example.cmdproject_team2.domain.user.enums.MajorType;
import com.example.cmdproject_team2.domain.user.enums.SubjectType;
import com.example.cmdproject_team2.domain.user.enums.UserType;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;

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

    private String club;

    private Long year;

    private Long month;

    private Long day;

    @Enumerated(EnumType.STRING)
    private MajorType majorType;

    @Enumerated(EnumType.STRING)
    private SubjectType subjectType;

    @Enumerated(EnumType.STRING)
    private UserType type;

    @Value("${key.secretKey}")
    private String secretKey;

    public void modifyAdminInfo(String username, Long grader, Long schoolClass, SubjectType subjectType) {
        this.username = username;
        this.grader = grader;
        this.schoolClass = schoolClass;
        this.subjectType = subjectType;
    }

    public void updateStudentInfo(String username, Long grader, Long schoolClass, Long number,
                                  MajorType majorType, String club, Long year, Long month, Long day) {
        this.username = username;
        this.grader = grader;
        this.schoolClass = schoolClass;
        this.number = number;
        this.majorType = majorType;
        this.club = club;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

