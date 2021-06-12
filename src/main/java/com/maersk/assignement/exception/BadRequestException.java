package com.maersk.assignement.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BadRequestException extends RuntimeException{
    private HttpStatus code;
    private String message;

    public BadRequestException(String message, HttpStatus code) {
        this.code = code;
        this.message = message;
    }
}

