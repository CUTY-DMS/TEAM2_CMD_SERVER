package com.example.cmdproject_team2.domain.user.domain;

import com.example.cmdproject_team2.domain.user.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    private String major;

    private String club;

    private Date birth;

    @Value("${key.secretKey}")
    private String secretKey;

    @Enumerated(EnumType.STRING)
    private UserType type;

    public void modifyAdminInfo(String username, Long grader, Long schoolClass) {
        this.username = username;
        this.grader = grader;
        this.schoolClass = schoolClass;
    }

    public void updateStudentInfo(String username, Long grader, Long schoolClass, Long number, String major,
                                  String club,Date birth) {
        this.username = username;
        this.grader = grader;
        this.schoolClass = schoolClass;
        this.number = number;
        this.major = major;
        this.club = club;
        this.birth = birth;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}

