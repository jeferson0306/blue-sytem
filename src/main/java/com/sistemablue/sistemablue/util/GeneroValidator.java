package com.sistemablue.sistemablue.util;

import lombok.extern.slf4j.Slf4j;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class GeneroValidator {

    private GeneroValidator() {
        throw new IllegalStateException("Classe utilitária, não deve ser instanciada.");
    }

    public static boolean isGeneroValido(final String genero) {

        if (genero == null || genero.trim().isEmpty()) {
            log.error("Gênero vazio ou nulo: {}", genero);
            return false;
        }

        final var generosValidos = new HashSet<>();
        generosValidos.add("masculino");
        generosValidos.add("feminino");

        final var generoLowerCase = genero.toLowerCase();

        if (!generosValidos.contains(generoLowerCase)) {
            log.error("Gênero inválido: {}", genero);
            return false;
        }

        log.info("Gênero validado com sucesso: {}", genero);
        return true;
    }
}
