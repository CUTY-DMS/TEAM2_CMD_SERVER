package com.example.cmdproject_team2.domain.notification.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NotificationRequest {

    private String title;

    private String content;

    private LocalDateTime expiredAt;
}
