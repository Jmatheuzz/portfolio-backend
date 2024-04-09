package com.jmatheus.portfolio.portfolio.config;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.jmatheus.portfolio.portfolio.responses.ResponseError;
import com.jmatheus.portfolio.portfolio.responses.exceptions.BadRequest;
import com.jmatheus.portfolio.portfolio.responses.exceptions.Forbidden;
import com.jmatheus.portfolio.portfolio.responses.exceptions.Unauthorized;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({BadRequest.class})
    public ResponseEntity<ResponseError> handleBadRequestException(
            BadRequest ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseError(ex.getMessage()));
    }

    @ExceptionHandler({Forbidden.class})
    public ResponseEntity<ResponseError> handleBForbiddenException(
            Forbidden ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ResponseError(ex.getMessage()));
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ResponseError> handleBForbiddenAccessDeniedException(
            AccessDeniedException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ResponseError(ex.getMessage()));
    }

    @ExceptionHandler({Unauthorized.class})
    public ResponseEntity<ResponseError> handleUnauthorizedException(
            Unauthorized ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseError(ex.getMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseError>  handleDataAccessException(DataIntegrityViolationException ex) {
        if (ex.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseError(ex.getMessage())); // Status 409 Conflict
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseError(ex.getMessage()));
        }
    }

    @ExceptionHandler(JWTCreationException.class)
    public ResponseEntity<ResponseError>  handleJWTCreationException(
            JWTCreationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseError(ex.getMessage()));
    }


    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<ResponseError> handleJWTCreationException(
            JWTVerificationException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseError(ex.getMessage()));
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ResponseError> handleRuntimeException(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseError("Server Error"));
    }

}
