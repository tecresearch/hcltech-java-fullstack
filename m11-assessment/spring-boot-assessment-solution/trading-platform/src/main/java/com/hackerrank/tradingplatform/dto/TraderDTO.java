package com.hackerrank.tradingplatform.dto;

import com.hackerrank.tradingplatform.model.Trader;

import java.sql.Timestamp;

public class TraderDTO {
    private final Long id;
    private final String name;
    private final String email;
    private final Double balance;

    private final Timestamp createdAt;
    private final Timestamp updatedAt;

    public TraderDTO(Trader trader) {
        this.id = trader.getId();
        this.name = trader.getName();
        this.email = trader.getEmail();
        this.balance = trader.getBalance();
        this.createdAt = trader.getCreatedAt();
        this.updatedAt = trader.getUpdatedAt();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public Double getBalance() {
        return this.balance;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }
}
