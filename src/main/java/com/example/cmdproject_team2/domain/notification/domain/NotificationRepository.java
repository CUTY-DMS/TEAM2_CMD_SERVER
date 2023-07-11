package com.example.cmdproject_team2.domain.notification.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Optional<Notification> findByExpiredAt(LocalDateTime expiredAt);
}
