package com.hcl.controller.dto;

import com.hcl.entity.dto.ProductDto;


import java.time.LocalDateTime;

import java.util.HashMap;

import java.util.Map;

public class SavedProductResponse {

        private String httpStatus;
       private int response;
       private String  message;
  private LocalDateTime timestamp;
  private ProductDto productDto;

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }
}
