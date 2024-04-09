package com.jmatheus.portfolio.portfolio.responses.exceptions;

public class BadRequest extends RuntimeException{
    public BadRequest(String message){
        super(message);
    }
}
