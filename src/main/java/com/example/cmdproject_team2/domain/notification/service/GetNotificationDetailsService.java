package com.example.cmdproject_team2.domain.notification.service;

import com.example.cmdproject_team2.domain.notification.presentation.dto.request.NotificationRequest;
import com.example.cmdproject_team2.domain.notification.presentation.dto.response.NotificationDetailsResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class GetNotificationDetailsService {

    public NotificationDetailsResponse getNotificationDetails(NotificationRequest request) {

        return new NotificationDetailsResponse(request.getTitle(), request.getContent());
    }
}
