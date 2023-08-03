package com.example.cmdproject_team2.domain.notification.service.adminService;

import com.example.cmdproject_team2.domain.notification.domain.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
@Transactional
public class DeleteNotificationService {

    private final NotificationRepository notificationRepository;

    public void deleteNotification(Long notificationId) {

        notificationRepository.deleteById(notificationId);
    }
}
