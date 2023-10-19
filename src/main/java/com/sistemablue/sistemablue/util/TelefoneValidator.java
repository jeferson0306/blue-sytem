package com.sistemablue.sistemablue.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelefoneValidator {

    private TelefoneValidator() {
        throw new IllegalStateException("Classe utilitária, não deve ser instanciada.");
    }

    public static boolean isTelefoneValido(final String telefone) {

        if (telefone == null || telefone.trim().isEmpty()) {
            log.error("Telefone vazio ou nulo: {}", telefone);
            return false;
        }

        final var numeroTelefone = telefone.replaceAll("[^0-9]", "");

        if (!isValidFormat(numeroTelefone)) {
            log.error("Formato de telefone inválido: {}", telefone);
            return false;
        }

        if (!isCelular(numeroTelefone) && !isComercial(numeroTelefone)) {
            log.warn("Tipo de telefone desconhecido: {}", telefone);
            return false;
        }

        log.info("Telefone validado com sucesso: {}", telefone);
        return true;
    }

    private static boolean isValidFormat(final String numeroTelefone) {
        return numeroTelefone.length() == 10 || numeroTelefone.length() == 11 || numeroTelefone.length() == 14;
    }

    private static boolean isCelular(final String numeroTelefone) {
        return numeroTelefone.length() == 11 || numeroTelefone.length() == 14;
    }

    private static boolean isComercial(final String numeroTelefone) {
        return numeroTelefone.length() == 10;
    }
}
