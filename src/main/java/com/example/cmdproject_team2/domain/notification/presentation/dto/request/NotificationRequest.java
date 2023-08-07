package com.example.cmdproject_team2.domain.notification.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NotificationRequest {

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private LocalDateTime expiredAt;

}
