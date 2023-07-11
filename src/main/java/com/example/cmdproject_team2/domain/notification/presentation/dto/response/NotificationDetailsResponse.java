package com.example.cmdproject_team2.domain.notification.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class NotificationDetailsResponse {

    private String title;

    private String content;
}
