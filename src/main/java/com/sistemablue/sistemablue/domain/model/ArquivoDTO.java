package com.sistemablue.sistemablue.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArquivoDTO {

    private String nomeExame;
    private String valorReferenciaMinimo;
    private String valorReferenciaMaximo;
    private String unidade;

}
