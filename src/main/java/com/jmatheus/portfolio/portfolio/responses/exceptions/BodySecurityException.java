package com.jmatheus.portfolio.portfolio.responses.exceptions;

import jakarta.servlet.http.HttpServletResponse;

public class BodySecurityException extends RuntimeException{
    public static String create(HttpServletResponse response, String message){
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        return "{\"message\": \"" + message + "\"}";
    }
}
