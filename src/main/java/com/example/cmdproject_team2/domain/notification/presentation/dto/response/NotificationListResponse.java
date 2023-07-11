package com.example.cmdproject_team2.domain.notification.presentation.dto.response;

import lombok.Builder;

import java.io.Serializable;
import java.util.List;

@Builder
public class NotificationListResponse implements Serializable {

    private List<NotificationList> currentNotification;
}
