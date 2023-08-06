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

    private Long id;

    private String title;

    private LocalDateTime expiredAt;

    public NotificationResponse(Notification notification){
        id= notification.getId();
        title = notification.getTitle();
        expiredAt = notification.getExpiredAt();
    }
}
