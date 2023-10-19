package com.sistemablue.sistemablue.util;

import lombok.extern.slf4j.Slf4j;
import java.util.regex.Pattern;

@Slf4j
public class RgValidator {

    private RgValidator() {
        throw new IllegalStateException("Classe utilitária, não deve ser instanciada.");
    }

    public static boolean isRgValido(final String rg) {

        if (rg == null || rg.trim().isEmpty()) {
            log.error("RG vazio ou nulo: {}", rg);
            return false;
        }

        final var numeroRg = rg.replaceAll("[^0-9]", "");

        if (!isValidFormat(numeroRg)) {
            log.error("Formato de RG inválido: {}", rg);
            return false;
        }

        log.info("RG validado com sucesso: {}", rg);
        return true;
    }

    private static boolean isValidFormat(final String numeroRg) {
        return numeroRg.length() == 8 || numeroRg.length() == 9;
    }
}
