package com.example.cmdproject_team2.domain.notification.presentation.dto.response;

import com.example.cmdproject_team2.domain.notification.domain.Notification;
import lombok.Builder;

@Builder
public class NotificationList {

    private String title;

    private String content;

    public static NotificationList of(Notification notification) {
        return NotificationList.builder()
                .title(notification.getTitle())
                .content(notification.getContent())
                .build();
    }
}