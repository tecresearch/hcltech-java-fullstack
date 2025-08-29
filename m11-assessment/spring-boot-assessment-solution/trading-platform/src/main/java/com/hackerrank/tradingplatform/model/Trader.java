package com.hackerrank.tradingplatform.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
public class Trader implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private Double balance;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Trader() {
    }

    public Trader(String name, String email, Double balance) {
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    //before saving
    @PrePersist
    public void saveCreationTimestamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //this.createdAt = timestamp;
        this.createdAt = Timestamp.from(Instant.now());
        this.updatedAt = timestamp;
    }

    @PreUpdate
    public void saveUpdateTimestamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //this.createdAt = timestamp;
        //this.createdAt = Timestamp.from(Instant.now());
        this.updatedAt = timestamp;
    }
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
