package com.example.cmdproject_team2.domain.notification.presentation.dto.response;

import com.example.cmdproject_team2.domain.notification.domain.Notification;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class NotificationList {

    private String title;

    private String content;

    private LocalDateTime expiredAt;

    public static NotificationList of(Notification notification) {
        return NotificationList.builder()
                .title(notification.getTitle())
                .content(notification.getContent())
                .expiredAt(notification.getExpiredAt())
                .build();
    }
}
