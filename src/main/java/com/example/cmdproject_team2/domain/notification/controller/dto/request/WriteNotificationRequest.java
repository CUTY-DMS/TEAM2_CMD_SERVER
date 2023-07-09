package com.example.cmdproject_team2.domain.notification.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WriteNotificationRequest {

    private String title;

    private String content;
}
