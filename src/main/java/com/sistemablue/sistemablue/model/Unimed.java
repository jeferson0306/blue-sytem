package com.sistemablue.sistemablue.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Unimed")
public class Unimed {

    private String codigo;
    private String tissTipoTabela;
    private String tissCodigo;
    private String descricao;
    private String valorProcedimento;
    private String valorHonorarioMedico;
    private String valorCustoOperacional;
    private String inc;
    private String numeroAuxiliares;
    private String porteAnestesico;
    private String filmeMetrosQuadrados;
    private String valorTaxaVideo;
    private String classificacao;
    private String baixoRisco;
    private String quantidade;
    private String documentacaoRacionalizacao;
    private Prazo prazo;

}
