package com.hcl.entity.dto;

import com.hcl.entity.Product;

public class ProductDto {
    private String name;
    private double price;
    public ProductDto(){}
    public ProductDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }



}
