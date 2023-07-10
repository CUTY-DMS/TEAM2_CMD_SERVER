package com.example.cmdproject_team2.domain.user.entity;

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

    @Value("${key.secretKey}")
    private String secretKey;

    @Enumerated(EnumType.STRING)
    private UserType type;

    public void modifyAdminInfo(String username, Long grader, Long schoolClass) {
        this.username = username;
        this.grader = grader;
        this.schoolClass = schoolClass;
    }
}
