package com.sistemablue.sistemablue.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DataValidator {

    private DataValidator() {
        throw new IllegalStateException("Classe utilitária, não deve ser instanciada.");
    }

    public static boolean isData(final String data) {

        if (data == null || data.trim().isEmpty()) {
            log.error("Data vazia ou nula: {}", data);
            return false;
        }

        final var dataSemTracos = data.replace("-", "");

        final var sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);

        try {
            final var date = sdf.parse(dataSemTracos);
            if (date.after(new Date())) {
                log.error("Data no futuro: {}", data);
                return false;
            }
        } catch (ParseException e) {
            log.error("Formato de Data inválido: {}", data);
            return false;
        }

        log.info("Data validada com sucesso: {}", data);
        return true;
    }

}
