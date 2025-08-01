package com.example.model;

import java.time.LocalDateTime;

public class ApiResponse {
    private String message;
    private String status;
    private String author;
    private String version;
    private String timestamp;

    // Constructor
    public ApiResponse(String message, String status, String author, String version) {
        this.message = message;
        this.status = status;
        this.author = author;
        this.version = version;
        this.timestamp = LocalDateTime.now().toString();
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
