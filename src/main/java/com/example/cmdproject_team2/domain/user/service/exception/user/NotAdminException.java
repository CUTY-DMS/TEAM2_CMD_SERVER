package com.example.cmdproject_team2.domain.user.service.exception.user;

import com.example.cmdproject_team2.global.error.exception.BusinessException;
import com.example.cmdproject_team2.global.error.exception.ErrorCode;

public class NotAdminException extends BusinessException {

    public static final BusinessException EXCEPTION = new  NotAdminException();

    public NotAdminException() {
        super(ErrorCode.NOT_ADMIN);
    }
}
