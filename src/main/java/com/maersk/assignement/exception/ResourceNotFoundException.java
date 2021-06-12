package com.maersk.assignement.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
public class ResourceNotFoundException extends RuntimeException{
    private HttpStatus code;
    private String message;

    public ResourceNotFoundException(String message, HttpStatus code) {
        this.code = code;
        this.message = message;
    }
}

