package com.muthu.task_scheduler.exception;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;

    public ApiResponse(
            boolean success,
            String message,
            T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // Success response
    public static <T> ApiResponse<T>
    success(T data, String message) {
        return new ApiResponse<>(
                true, message, data);
    }

    // Error response
    public static <T> ApiResponse<T>
    error(String message) {
        return new ApiResponse<>(
                false, message, null);
    }
}