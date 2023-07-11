package com.example.cmdproject_team2.domain.notification.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class NotificationDetailsResponse {

    private String title;

    private String content;

    private LocalDateTime expiredAt;
}
