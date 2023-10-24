package com.sistemablue.sistemablue.model.exame;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValorReferencia {

    private String nomeExame;
    private double valorReferenciaMinimo;
    private double valorReferenciaMaximo;
    private String unidade;

}

