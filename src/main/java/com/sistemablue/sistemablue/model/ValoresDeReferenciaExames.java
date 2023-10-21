package com.sistemablue.sistemablue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValoresDeReferenciaExames {

    private String exame;
    private String valorMinimo;
    private String valorMaximo;
    private String unidadeReferencia;

}
