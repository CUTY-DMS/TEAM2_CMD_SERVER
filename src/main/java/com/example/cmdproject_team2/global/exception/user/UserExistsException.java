package com.example.cmdproject_team2.global.exception.user;

import com.example.cmdproject_team2.global.error.exception.ErrorCode;

public class UserExistsException extends RuntimeException{

    public static final RuntimeException EXCEPTION = new UserExistsException();

    private UserExistsException() {
        super(ErrorCode.User_EXISTS);
    }
}
