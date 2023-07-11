package com.example.cmdproject_team2.global.exception.token;

import com.example.cmdproject_team2.global.error.exception.BusinessException;
import com.example.cmdproject_team2.global.error.exception.ErrorCode;

public class InvalidTokenException extends BusinessException {
    public static final BusinessException EXCEPTION = new InvalidTokenException();
    public InvalidTokenException(){
        super(ErrorCode.INVALID_TOKEN);
    }
}
