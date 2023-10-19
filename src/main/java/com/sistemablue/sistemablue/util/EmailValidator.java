package com.sistemablue.sistemablue.util;

import lombok.extern.slf4j.Slf4j;
import java.text.Normalizer;
import java.util.regex.Pattern;

@Slf4j
public class EmailValidator {

    private EmailValidator() {
        throw new IllegalStateException("Classe utilitária, não deve ser instanciada.");
    }

    public static boolean isEmailValido(final String email) {

        if (email == null || email.trim().isEmpty()) {
            log.error("E-mail vazio ou nulo: {}", email);
            return false;
        }

        final var emailNormalizado = normalizarEmail(email);

        final var regex = "^[A-Z0-9+_.-]+@(.+)$";

        if (!Pattern.matches(regex, emailNormalizado)) {
            log.error("E-mail inválido: {}", email);
            return false;
        }

        log.info("E-mail validado com sucesso: {}", email);
        return true;
    }

    private static String normalizarEmail(final String email) {
        return Normalizer.normalize(email, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .toUpperCase();
    }
}
