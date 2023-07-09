package com.example.cmdproject_team2.domain.notification.controller;

import com.example.cmdproject_team2.domain.notification.controller.dto.request.WriteNotificationRequest;
import com.example.cmdproject_team2.domain.notification.controller.dto.response.NotificationDetailsResponse;
import com.example.cmdproject_team2.domain.notification.entity.Notification;
import com.example.cmdproject_team2.domain.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;
    @PostMapping
    public void writeNotification(@RequestBody WriteNotificationRequest request) {
        notificationService.writeNotification(request);
    }

   // @GetMapping
   //     return notificationService.getNotificationDetails(notificationId);
    //}

    @PatchMapping("/{notificationId}")
    public void modifyNotification(@PathVariable long notificationId, @RequestBody WriteNotificationRequest request) {
        notificationService.modifyNotification(notificationId, request);
    }

    @DeleteMapping("/{notificationId}")
    public void deleteNotification(@PathVariable long notificationId) {
        notificationService.deleteNotification(notificationId);
    }
}
