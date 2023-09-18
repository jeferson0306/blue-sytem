package com.sistemablue.sistemablue.util;

import org.springframework.stereotype.Component;

@Component
public class Utils {

    public static boolean isValidCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            char c = cpf.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
            digits[i] = Character.getNumericValue(c);
        }

        int sum1 = 0;
        int sum2 = 0;
        int mod1, mod2;

        for (int i = 0; i < 9; i++) {
            sum1 += digits[i] * (10 - i);
            sum2 += digits[i] * (11 - i);
        }

        mod1 = (sum1 % 11) < 2 ? 0 : 11 - (sum1 % 11);
        if (digits[9] != mod1) {
            return false;
        }

        sum2 += mod1 * 2;
        mod2 = (sum2 % 11) < 2 ? 0 : 11 - (sum2 % 11);
        return digits[10] == mod2;
    }

}
