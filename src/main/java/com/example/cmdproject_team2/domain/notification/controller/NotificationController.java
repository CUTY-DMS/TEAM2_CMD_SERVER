package com.example.cmdproject_team2.domain.notification.controller;

import com.example.cmdproject_team2.domain.notification.controller.dto.request.NotificationRequest;
import com.example.cmdproject_team2.domain.notification.controller.dto.response.NotificationDetailsResponse;
import com.example.cmdproject_team2.domain.notification.controller.dto.response.NotificationListResponse;
import com.example.cmdproject_team2.domain.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void writeNotification(@RequestBody NotificationRequest request) {
        notificationService.writeNotification(request);
    }

    @GetMapping
    public NotificationDetailsResponse getNotificationDetails(@RequestBody NotificationRequest request) {
        return notificationService.getNotificationDetails(request);
    }

    @GetMapping("/list")
    public NotificationListResponse getNotificationList() {
        return notificationService.getNotificationList();
    }

    @PatchMapping("/{notificationId}")
    public void modifyNotification(@PathVariable long notificationId, @RequestBody NotificationRequest request) {
        notificationService.modifyNotification(notificationId, request);
    }

    @DeleteMapping("/{notificationId}")
    public void deleteNotification(@PathVariable long notificationId) {
        notificationService.deleteNotification(notificationId);
    }
}
