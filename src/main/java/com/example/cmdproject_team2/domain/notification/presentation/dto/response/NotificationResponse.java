package com.example.cmdproject_team2.domain.notification.presentation.dto.response;

import com.example.cmdproject_team2.domain.notification.domain.Notification;
import com.example.cmdproject_team2.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class NotificationResponse {

    private String title;

    private String content;

    private LocalDateTime expiredAt;

    public NotificationResponse(Notification notification){
        title = notification.getTitle();
        content = notification.getContent();
        expiredAt = notification.getExpiredAt();
    }
}
