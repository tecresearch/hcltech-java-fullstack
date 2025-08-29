package com.hackerrank.validator.validation;

public class FieldValidationMessage {
    private String message;

    public FieldValidationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
