package com.example.cmdproject_team2.domain.notification.service;

import com.example.cmdproject_team2.domain.notification.domain.Notification;
import com.example.cmdproject_team2.domain.notification.domain.NotificationRepository;
import com.example.cmdproject_team2.domain.notification.presentation.dto.request.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class WriteNotificationService {

    private final NotificationRepository notificationRepository;

    public void writeNotification(NotificationRequest request) {

        notificationRepository.save(
                Notification.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build());
    }
}
