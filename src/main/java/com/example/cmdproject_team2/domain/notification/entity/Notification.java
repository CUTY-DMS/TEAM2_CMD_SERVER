package com.example.cmdproject_team2.domain.notification.entity;

import com.example.cmdproject_team2.domain.user.admin.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Admin user;

    private String title;

    private String content;

    public void modifyTitleAndContent(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
