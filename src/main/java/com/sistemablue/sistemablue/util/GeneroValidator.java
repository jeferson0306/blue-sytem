package com.sistemablue.sistemablue.util;

import lombok.extern.slf4j.Slf4j;
import java.util.HashSet;

@Slf4j
public class GeneroValidator {

    private GeneroValidator() {
        throw new IllegalStateException("Classe utilitária, não deve ser instanciada.");
    }

    public static boolean isGenero(final String genero) {

        if (genero == null || genero.trim().isEmpty()) {
            log.error("Gênero vazio ou nulo {}", genero);
            return false;
        }

        final var generosValidos = new HashSet<>();
        generosValidos.add("MASCULINO");
        generosValidos.add("FEMININO");

        final var generoUpperCase = genero.toUpperCase();

        if (!generosValidos.contains(generoUpperCase)) {
            log.error("Gênero inválido {}", genero);
            return false;
        }

        log.info("Gênero validado com sucesso {}", genero);
        return true;
    }
}
