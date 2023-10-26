package com.sistemablue.sistemablue.domain.model;

import com.sistemablue.sistemablue.domain.entities.Medico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaMedicaDTO {

    private String tipoAtendimento;
    private Medico medico;
    private String cid;
    private String observacoes;
    private Date dataConsulta;

}
