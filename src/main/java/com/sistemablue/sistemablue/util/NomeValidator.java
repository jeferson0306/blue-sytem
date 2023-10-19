package com.sistemablue.sistemablue.util;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

@Slf4j
public class NomeValidator {

    private NomeValidator() {
        throw new IllegalStateException("Classe utilitária, não deve ser instanciada.");
    }

    public static boolean isNomeValido(final String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            log.error("Nome vazio ou nulo {}", nome);
            return false;
        }

        final var minCaracteres = 3;
        final var maxCaracteres = 100;

        final var nomeSemValidacao = nome.trim();

        if (nomeSemValidacao.length() < minCaracteres || nomeSemValidacao.length() > maxCaracteres) {
            log.warn("Nome com quantidade de caracteres inválida: {}", nomeSemValidacao);
            return false;
        }

        final var nomeEmUppercase = nomeSemValidacao.toUpperCase();

        final var regex = "^[A-Z][A-Z\\s]*$";

        log.info("Nome em validado com sucesso: {}", nomeEmUppercase);

        return Pattern.matches(regex, nomeEmUppercase);
    }
}
