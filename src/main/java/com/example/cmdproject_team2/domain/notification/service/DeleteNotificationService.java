package com.example.cmdproject_team2.domain.notification.service;

import com.example.cmdproject_team2.domain.notification.domain.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class DeleteNotificationService {

    private final NotificationRepository notificationRepository;

    public void deleteNotification(Long notificationId) {

        notificationRepository.deleteById(notificationId);
    }
}
