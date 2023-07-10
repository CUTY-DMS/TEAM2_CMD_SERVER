package com.example.cmdproject_team2.domain.notification.service;

import com.example.cmdproject_team2.domain.notification.controller.dto.request.NotificationRequest;
import com.example.cmdproject_team2.domain.notification.controller.dto.response.NotificationDetailsResponse;
import com.example.cmdproject_team2.domain.notification.controller.dto.response.NotificationList;
import com.example.cmdproject_team2.domain.notification.controller.dto.response.NotificationListResponse;
import com.example.cmdproject_team2.domain.notification.entity.Notification;
import com.example.cmdproject_team2.domain.notification.repository.NotificationRepository;
import com.example.cmdproject_team2.domain.notification.service.exception.notification.NotificationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void writeNotification(NotificationRequest request) {

        notificationRepository.save(
                Notification.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build());
    }

    public NotificationDetailsResponse getNotificationDetails(NotificationRequest request) {

        return new NotificationDetailsResponse(request.getTitle(), request.getContent());
    }

    public NotificationListResponse getNotificationList() {

        return NotificationListResponse.builder()
                .currentNotification(notificationRepository.findAll()
                        .stream()
                        .map(NotificationList::of)
                        .toList())
                .build();
    }

    public void modifyNotification(Long notificationId, NotificationRequest request) {

        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(()-> NotificationNotFoundException.EXCEPTION);

        notification.modifyTitleAndContent(request.getTitle(), request.getContent());
        notificationRepository.save(notification);
    }

    public void deleteNotification(Long notificationId) {

        notificationRepository.deleteById(notificationId);
    }
}
