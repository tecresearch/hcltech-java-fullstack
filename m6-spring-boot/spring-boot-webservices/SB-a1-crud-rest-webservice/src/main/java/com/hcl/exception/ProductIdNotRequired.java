package com.hcl.exception;

public class ProductIdNotRequired extends RuntimeException{
    public ProductIdNotRequired(String message){
        super(message);
    }
}
