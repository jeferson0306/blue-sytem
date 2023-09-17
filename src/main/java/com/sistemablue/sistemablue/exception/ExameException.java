package com.sistemablue.sistemablue.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExameException extends RuntimeException {

    private HttpStatus httpStatus;

    public ExameException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
