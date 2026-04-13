package com.muthu.task_scheduler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>>
    handleException(Exception e) {

        // Ignore swagger errors
        if (e.getMessage() != null &&
                e.getMessage().contains(
                        "swagger")) {
            return null;
        }

        Map<String, Object> error =
                new HashMap<>();
        error.put("timestamp",
                LocalDateTime.now());
        error.put("message",
                e.getMessage());
        error.put("status",
                HttpStatus.INTERNAL_SERVER_ERROR
                        .value());

        return ResponseEntity
                .status(HttpStatus
                        .INTERNAL_SERVER_ERROR)
                .body(error);
    }
}