package com.sistemablue.sistemablue.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DataNascimentoValidator {

    private DataNascimentoValidator() {
        throw new IllegalStateException("Classe utilitária, não deve ser instanciada.");
    }

    public static boolean isDataNascimentoValida(final String dataNascimento) {

        if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
            log.error("Data de Nascimento vazia ou nula: {}", dataNascimento);
            return false;
        }

        final var dataSemTracos = dataNascimento.replace("-", "");

        final var sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            final var date = sdf.parse(dataSemTracos);
            if (date.after(new Date())) {
                log.error("Data de Nascimento no futuro: {}", dataNascimento);
                return false;
            }
        } catch (ParseException e) {
            log.error("Formato de Data de Nascimento inválido: {}", dataNascimento);
            return false;
        }

        log.info("Data de Nascimento validada com sucesso: {}", dataNascimento);
        return true;
    }

}
