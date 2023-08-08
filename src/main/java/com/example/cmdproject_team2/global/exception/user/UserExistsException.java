package com.example.cmdproject_team2.global.exception.user;

import com.example.cmdproject_team2.global.error.exception.BusinessException;
import com.example.cmdproject_team2.global.error.exception.ErrorCode;

public class UserExistsException extends BusinessException {

    public static final BusinessException EXCEPTION = new UserExistsException();

    private UserExistsException() {
        super(ErrorCode.USER_EXISTS);
    }

}
