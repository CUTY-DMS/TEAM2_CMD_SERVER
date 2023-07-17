package com.example.cmdproject_team2.domain.notification.service.publicService;

import com.example.cmdproject_team2.domain.notification.domain.NotificationRepository;
import com.example.cmdproject_team2.domain.notification.presentation.dto.response.NotificationList;
import com.example.cmdproject_team2.domain.notification.presentation.dto.response.NotificationListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class GetNotificationListService {

    private final NotificationRepository notificationRepository;

    public NotificationListResponse getNotificationList() {

        return NotificationListResponse.builder()
                .currentNotification(notificationRepository.findAll()
                        .stream()
                        .map(NotificationList::of)
                        .toList())
                .build();
    }
}
