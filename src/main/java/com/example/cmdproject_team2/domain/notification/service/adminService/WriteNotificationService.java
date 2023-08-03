package com.example.cmdproject_team2.domain.notification.service.adminService;

import com.example.cmdproject_team2.domain.notification.domain.Notification;
import com.example.cmdproject_team2.domain.notification.domain.NotificationRepository;
import com.example.cmdproject_team2.domain.notification.presentation.dto.request.NotificationRequest;
import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class WriteNotificationService {

    private final NotificationRepository notificationRepository;
    private final UserFacade userFacade;

    public void writeNotification(NotificationRequest request) {

        User user = userFacade.currentUser();

        notificationRepository.save(
                Notification.builder()
                        .user(user)
                        .title(request.getTitle())
                        .content(request.getContent())
                        .expiredAt(request.getExpiredAt())
                        .build());

    }

}
