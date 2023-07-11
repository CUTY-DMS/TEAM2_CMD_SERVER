package com.example.cmdproject_team2.global.exception.notification;

import com.example.cmdproject_team2.global.error.exception.BusinessException;
import com.example.cmdproject_team2.global.error.exception.ErrorCode;

public class NotificationNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new NotificationNotFoundException();

    public NotificationNotFoundException() {
        super(ErrorCode.NOTIFICATION_NOT_FOUND);
    }
}
