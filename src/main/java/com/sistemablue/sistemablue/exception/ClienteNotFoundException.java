package com.sistemablue.sistemablue.exception;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException (String cpf) {
        super("Cliente não encontrado para o CPF: " + cpf);
    }

}
