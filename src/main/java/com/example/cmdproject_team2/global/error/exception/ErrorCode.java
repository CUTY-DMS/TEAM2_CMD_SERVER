package com.example.cmdproject_team2.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // jwt
    EXPIRED_TOKEN(401 , "Expired token"),
    INVALID_TOKEN(401, "Invalid token"),
    REFRESH_TOKEN_NOT_FOUND(403,"RefreshToken not found"),


    //user
    USER_EXISTS(403, "User exists"),
    USER_NOT_FOUND(404, "User not found"),
    PASSWORD_MISMATCH(404, "Password mismatch"),
    NOT_ADMIN(403, "Not admin"),
    EMAIL_MATCHED(409,"email matched"),

    //notification
    NOTIFICATION_NOT_FOUND(404, "Notification not found"),

    // general
    BAD_REQUEST(400, "Bad request"),
    INTERNAL_SERVER_ERROR(500, "Internal server error");

    private final int statusCode;
    private final String message;
}
