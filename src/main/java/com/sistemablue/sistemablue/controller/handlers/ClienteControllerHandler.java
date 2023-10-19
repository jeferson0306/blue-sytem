package com.sistemablue.sistemablue.controller.handlers;

import com.sistemablue.sistemablue.exception.ClienteException;
import com.sistemablue.sistemablue.exception.ExameException;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Getter
@ControllerAdvice
public class ClienteControllerHandler {

    @ExceptionHandler(ClienteException.class)
    public ResponseEntity<String> handleClienteException(final ClienteException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getHttpStatus());
    }

    @ExceptionHandler(ExameException.class)
    public ResponseEntity<String> handleExameException(final ExameException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException() {
        return new ResponseEntity<>("Erro interno do servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
