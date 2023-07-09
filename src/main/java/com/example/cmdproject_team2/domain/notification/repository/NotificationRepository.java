package com.example.cmdproject_team2.domain.notification.repository;

import com.example.cmdproject_team2.domain.notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
   // Optional<Notification> findByNotificationId(Long notificationId)
}
