package com.sistemablue.sistemablue.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ClienteException extends RuntimeException {

    private HttpStatus httpStatus;

    public ClienteException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
