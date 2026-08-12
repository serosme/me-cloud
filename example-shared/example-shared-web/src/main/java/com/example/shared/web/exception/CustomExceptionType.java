package com.example.shared.web.exception;

import org.springframework.http.HttpStatus;

public interface CustomExceptionType {
    HttpStatus getStatus();

    String getDetail();
}
