package com.example.cmdproject_team2.domain.notification.service;

import com.example.cmdproject_team2.domain.notification.controller.dto.request.WriteNotificationRequest;
import com.example.cmdproject_team2.domain.notification.controller.dto.response.NotificationDetailsResponse;
import com.example.cmdproject_team2.domain.notification.entity.Notification;
import com.example.cmdproject_team2.domain.notification.repository.NotificationRepository;
import com.example.cmdproject_team2.domain.user.entity.User;
import com.example.cmdproject_team2.domain.user.service.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    private final UserFacade userFacade;

    public void writeNotification(WriteNotificationRequest request) {

        notificationRepository.save(
                Notification.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build());
    }

  //  public NotificationDetailsResponse getNotificationDetails(Long notificationId) {

       // return notificationRepository.fin
   // }

    public void modifyNotification(Long notificationId, WriteNotificationRequest request) {

        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow();

        notification.modifyTitleAndContent(request.getTitle(), request.getContent());
        notificationRepository.save(notification);
    }

    public void deleteNotification(Long notificationId) {

        notificationRepository.deleteById(notificationId);
    }
}
