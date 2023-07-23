package com.example.cmdproject_team2.domain.notification.presentation;

import com.example.cmdproject_team2.domain.notification.presentation.dto.request.NotificationRequest;
import com.example.cmdproject_team2.domain.notification.presentation.dto.response.NotificationResponse;
import com.example.cmdproject_team2.domain.notification.service.adminService.DeleteNotificationService;
import com.example.cmdproject_team2.domain.notification.service.adminService.ModifyNotificationService;
import com.example.cmdproject_team2.domain.notification.service.adminService.WriteNotificationService;
import com.example.cmdproject_team2.domain.notification.service.publicService.GetNotificationDetailsService;
import com.example.cmdproject_team2.domain.notification.service.publicService.GetNotificationListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    //PUBLIC
    private final GetNotificationDetailsService getNotificationDetailsService;
    private final GetNotificationListService getNotificationListService;


    //ADMIN
    private final WriteNotificationService writeNotificationService;
    private final ModifyNotificationService modifyNotificationService;
    private final DeleteNotificationService deleteNotificationService;


    //PUBLIC
    @GetMapping("/notification/{notificationId}")
    public NotificationResponse getNotificationDetails(@PathVariable long notificationId) {
        return getNotificationDetailsService.getNotificationDetails(notificationId);
    }
    @GetMapping("/notification/list")
    public List<NotificationResponse> getNotificationList() {
        return getNotificationListService.getNotificationList();
    }


    //ADMIN
    @PostMapping("/admin/notification")
    public void writeNotification(@RequestBody NotificationRequest request) {
        writeNotificationService.writeNotification(request);
    }
    @PatchMapping("/admin/notification/{notificationId}")
    public void modifyNotification(@PathVariable long notificationId, @RequestBody NotificationRequest request) {
        modifyNotificationService.modifyNotification(notificationId, request);
    }
    @DeleteMapping("/admin/notification/{notificationId}")
    public void deleteNotification(@PathVariable long notificationId) {
        deleteNotificationService.deleteNotification(notificationId);
    }
}
