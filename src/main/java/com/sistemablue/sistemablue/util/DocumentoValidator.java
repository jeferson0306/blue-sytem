package com.sistemablue.sistemablue.util;

import lombok.extern.slf4j.Slf4j;

import java.util.InputMismatchException;

@Slf4j
public class DocumentoValidator {

    private DocumentoValidator() {
        throw new IllegalStateException("Classe utilitária, não deve ser instanciada.");
    }

    public static boolean isCpf(final String documento) {

        if (documento == null || documento.isEmpty() || documento.trim().isEmpty() || documento.equals("0")) {
            log.error("CPF vazio ou nulo {}", documento);
            return false;
        }

        final var cpf = documento.replaceAll("\\D", "");

        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") || cpf.length() != 11) {
            log.error("CPF inválido: {}", cpf);
            return false;
        }

        char dig10;
        char dig11;
        int sm;
        int i;
        int r;
        int num;
        int peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = cpf.charAt(i) - '0';
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if (r == 10 || r == 11) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + '0');
            }

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = cpf.charAt(i) - '0';
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if (r == 10 || r == 11) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + '0');
            }

            log.info("CPF válido: {}", cpf);

            return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));

        } catch (InputMismatchException erro) {
            return false;
        }
    }

    public static boolean isRgValido(final String rg) {

        if (rg == null || rg.isEmpty()) {
            log.error("Documento rg é vazio ou nulo {}", rg);
            return false;
        }

        final var numeroRg = rg.replaceAll("\\D", "");

        if (!isDocumentoRgValido(numeroRg)) {
            log.error("Formato do documento rg {} é inválido", rg);
            return false;
        }

        log.info("Documento rg {} validado com sucesso", rg);
        return true;
    }

    private static boolean isDocumentoRgValido(final String numeroRg) {
        return numeroRg.length() == 8 || numeroRg.length() == 9;
    }
}
