package com.example.cmdproject_team2.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    //user
    USER_NOT_FOUND(404, "User not found"),
    PASSWORD_MISMATCH(404, "Password mismatch"),
    NOT_ADMIN(404, "Not admin"),

    //notification
    NOTIFICATION_NOT_FOUND(404, "Notification not found");

    private final int statusCode;
    private final String message;
}
