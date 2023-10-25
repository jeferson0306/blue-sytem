package com.sistemablue.sistemablue.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExameException extends RuntimeException {

    private final HttpStatus httpStatus;

    public ExameException(final String message, final HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
