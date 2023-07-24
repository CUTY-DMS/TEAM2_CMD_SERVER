package com.example.cmdproject_team2.domain.notification.service.publicService;

import com.example.cmdproject_team2.domain.notification.domain.Notification;
import com.example.cmdproject_team2.domain.notification.domain.NotificationRepository;
import com.example.cmdproject_team2.domain.notification.presentation.dto.response.NotificationResponse;
import com.example.cmdproject_team2.global.exception.notification.NotificationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class GetNotificationDetailsService {

    private final NotificationRepository notificationRepository;

    public NotificationResponse getNotificationDetails(Long notificationId) {

        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(()-> NotificationNotFoundException.EXCEPTION);

        return new NotificationResponse(notification);
    }
}
