package com.example.shared.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ProblemDetail> handleCustomException(CustomException e) {
        log.error(e.getDetail(), e);
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(e.getStatus(), e.getDetail())).build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.of(ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR)).build();
    }
}
