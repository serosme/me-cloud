package com.example.platform.system.exception;

import com.example.shared.web.exception.CustomExceptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SystemException implements CustomExceptionType {
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "用户不存在");
    private final HttpStatus status;
    private final String detail;
}
