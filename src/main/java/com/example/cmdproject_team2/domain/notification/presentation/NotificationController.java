package com.example.cmdproject_team2.domain.notification.presentation;

import com.example.cmdproject_team2.domain.notification.presentation.dto.request.NotificationRequest;
import com.example.cmdproject_team2.domain.notification.presentation.dto.response.NotificationDetailsResponse;
import com.example.cmdproject_team2.domain.notification.presentation.dto.response.NotificationListResponse;
import com.example.cmdproject_team2.domain.notification.service.adminService.DeleteNotificationService;
import com.example.cmdproject_team2.domain.notification.service.adminService.ModifyNotificationService;
import com.example.cmdproject_team2.domain.notification.service.adminService.WriteNotificationService;
import com.example.cmdproject_team2.domain.notification.service.publicService.GetNotificationDetailsService;
import com.example.cmdproject_team2.domain.notification.service.publicService.GetNotificationListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
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
    @GetMapping
    public NotificationDetailsResponse getNotificationDetails(@RequestBody NotificationRequest request) {
        return getNotificationDetailsService.getNotificationDetails(request);
    }
    @GetMapping("/list")
    public NotificationListResponse getNotificationList() {
        return getNotificationListService.getNotificationList();
    }


    //ADMIN
    @PostMapping
    public void writeNotification(@RequestBody NotificationRequest request) {
        writeNotificationService.writeNotification(request);
    }
    @PatchMapping("/{notificationId}")
    public void modifyNotification(@PathVariable long notificationId, @RequestBody NotificationRequest request) {
        modifyNotificationService.modifyNotification(notificationId, request);
    }
    @DeleteMapping("/{notificationId}")
    public void deleteNotification(@PathVariable long notificationId) {
        deleteNotificationService.deleteNotification(notificationId);
    }
}
