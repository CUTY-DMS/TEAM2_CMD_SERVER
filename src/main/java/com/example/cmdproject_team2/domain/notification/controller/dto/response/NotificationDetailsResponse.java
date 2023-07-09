package com.example.cmdproject_team2.domain.notification.controller.dto.response;

import com.example.cmdproject_team2.domain.notification.entity.Notification;
import com.example.cmdproject_team2.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class NotificationDetailsResponse {

    private String title;

    private String content;

    public NotificationDetailsResponse(Notification notification){
        title = notification.getTitle();
        content = notification.getContent();
    }
}
