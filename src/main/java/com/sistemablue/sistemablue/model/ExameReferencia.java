package com.sistemablue.sistemablue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExameReferencia {

    private String nomeExame;
    private double valorReferenciaMinimo;
    private double valorReferenciaMaximo;
    private String unidade;

}

