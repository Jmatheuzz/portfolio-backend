package com.jmatheus.portfolio.portfolio.responses.exceptions;

public class Unauthorized extends RuntimeException{
    public Unauthorized(String message){
        super(message);
    }
}
