package com.hackerrank.tradingplatform.dto;

public class AddMoneyTraderDTO {
    private String email;
    private Double amount;

    public AddMoneyTraderDTO(String email, Double amount) {
        this.email = email;
        this.amount = amount;
    }

    public String getEmail() {
        return this.email;
    }

    public Double getAmount() {
        return this.amount;
    }
}
