package com.example.cmdproject_team2.global.exception.user;

import com.example.cmdproject_team2.global.error.exception.BusinessException;
import com.example.cmdproject_team2.global.error.exception.ErrorCode;

import javax.validation.constraints.Email;

public class EmailMatchedException extends BusinessException {

    public static final BusinessException EXCEPTION = new EmailMatchedException();

    private EmailMatchedException() {
        super(ErrorCode.EMAIL_MATCHED);
    }
}

