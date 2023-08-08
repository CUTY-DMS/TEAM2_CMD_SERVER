package com.example.cmdproject_team2.global.exception.user;

public class NotAuthenticatedException extends RuntimeException{
    public NotAuthenticatedException(String message) {
        super(message);
    }
}
