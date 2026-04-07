package com.bpi.training.module10.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponse {
    private final int status;
    private final String title;
    private final String message;
    private final String path;

    public ApiResponse(int status, String title, String message, String path) {
        this.status = status;
        this.title = title;
        this.message = message;
        this.path = path;
    }

    public static ResponseEntity<ApiResponse> success(
            String title, String message, String path) {
        return ResponseEntity.ok(
                ApiResponse.of(
                        HttpStatus.OK.value(),
                        title,
                        message,
                        path));
    }

    public static ApiResponse of(int status, String title, String message, String path) {
        return new ApiResponse(status, title, message, path);
    }

    public int getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

}
