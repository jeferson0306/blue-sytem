package com.sistemablue.sistemablue.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NomeInvalidoException extends RuntimeException {

    private final HttpStatus httpStatus;

    public NomeInvalidoException(final String message, final HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
