package com.example.shared.web.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {
    private final HttpStatus status;
    private final String detail;

    public CustomException(CustomExceptionType exceptionType) {
        this.status = exceptionType.getStatus();
        this.detail = exceptionType.getDetail();
    }
}
