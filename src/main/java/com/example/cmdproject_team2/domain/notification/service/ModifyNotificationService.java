package com.example.cmdproject_team2.domain.notification.service;

import com.example.cmdproject_team2.domain.notification.domain.Notification;
import com.example.cmdproject_team2.domain.notification.domain.NotificationRepository;
import com.example.cmdproject_team2.domain.notification.presentation.dto.request.NotificationRequest;
import com.example.cmdproject_team2.global.exception.notification.NotificationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class ModifyNotificationService {

    private final NotificationRepository notificationRepository;

    public void modifyNotification(Long notificationId, NotificationRequest request) {

        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(()-> NotificationNotFoundException.EXCEPTION);

        notification.modifyTitleAndContent(request.getTitle(), request.getContent());
        notificationRepository.save(notification);
    }
}
