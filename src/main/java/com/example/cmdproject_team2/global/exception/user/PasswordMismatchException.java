package com.example.cmdproject_team2.global.exception.user;

import com.example.cmdproject_team2.global.error.exception.BusinessException;
import com.example.cmdproject_team2.global.error.exception.ErrorCode;

public class PasswordMismatchException extends BusinessException {

    public static final BusinessException EXCEPTION = new PasswordMismatchException();

    public PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }

}
