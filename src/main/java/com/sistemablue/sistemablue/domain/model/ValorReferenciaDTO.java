package com.sistemablue.sistemablue.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValorReferenciaDTO {

    private String nomeExame;
    private double valorReferenciaMinimo;
    private double valorReferenciaMaximo;
    private String unidade;

}

