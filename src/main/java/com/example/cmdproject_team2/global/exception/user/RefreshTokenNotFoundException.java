package com.example.cmdproject_team2.global.exception.user;

import com.example.cmdproject_team2.global.error.exception.BusinessException;
import com.example.cmdproject_team2.global.error.exception.ErrorCode;

public class RefreshTokenNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new RefreshTokenNotFoundException();

    public RefreshTokenNotFoundException() {
        super(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }

}
