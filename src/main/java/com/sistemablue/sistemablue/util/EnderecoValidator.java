package com.sistemablue.sistemablue.util;

import com.sistemablue.sistemablue.model.entities.Endereco;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnderecoValidator {

    private EnderecoValidator() {
        throw new IllegalStateException("Classe utilitária, não deve ser instanciada.");
    }

    public static boolean isEnderecoValido(final Endereco endereco) {

        if (endereco == null) {
            log.warn("Endereço nulo.");
            return false;
        }

        if (endereco.getLogradouro() == null || endereco.getLogradouro().trim().isEmpty()) {
            log.warn("Logradouro vazio ou nulo.");
            return false;
        }

        if (endereco.getBairro() == null || endereco.getBairro().trim().isEmpty()) {
            log.warn("Bairro vazio ou nulo.");
            return false;
        }

        if (endereco.getCidade() == null || endereco.getCidade().trim().isEmpty()) {
            log.warn("Cidade vazia ou nula.");
            return false;
        }

        if (endereco.getEstado() == null || endereco.getEstado().trim().isEmpty()) {
            log.warn("Estado vazio ou nulo.");
            return false;
        }

        if (endereco.getCep() == null || endereco.getCep().trim().isEmpty()) {
            log.warn("CEP vazio ou nulo.");
            return false;
        }

        if (!isCepValido(endereco.getCep())) {
            log.warn("Formato de CEP inválido: {}", endereco.getCep());
            return false;
        }

        log.info("Endereço validado com sucesso.");
        return true;
    }

    private static boolean isCepValido(final String cep) {
        return cep.matches("\\d{8}");
    }
}
