package com.example.cmdproject_team2.domain.notification.service.publicService;

import com.example.cmdproject_team2.domain.notification.domain.NotificationRepository;
import com.example.cmdproject_team2.domain.notification.presentation.dto.response.NotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class GetNotificationListService {

    private final NotificationRepository notificationRepository;

    public List<NotificationResponse> getNotificationList() {

        return notificationRepository.findAll()
                .stream()
                .map(NotificationResponse::new)
                .collect(Collectors.toList());

    }

}
