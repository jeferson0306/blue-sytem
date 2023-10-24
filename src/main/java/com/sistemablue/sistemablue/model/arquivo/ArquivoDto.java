package com.sistemablue.sistemablue.model.arquivo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArquivoDto {

    private String nomeExame;
    private String valorReferenciaMinimo;
    private String valorReferenciaMaximo;
    private String unidade;

}
