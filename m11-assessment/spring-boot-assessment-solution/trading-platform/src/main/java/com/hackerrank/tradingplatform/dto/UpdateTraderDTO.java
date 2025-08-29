package com.hackerrank.tradingplatform.dto;

public class UpdateTraderDTO {
    private String name;
    private String email;

    public UpdateTraderDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
}
