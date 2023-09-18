package com.sistemablue.sistemablue.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Usuario")
public class Usuario {

    private String id;
    private String nomeDeUsuario;
    private String email;
    private String senha;
    private String nomeCompleto;
    private String genero;
    private String dataDeNascimento;
    private String urlFotoPerfil;
    private String biografia;
    private String numeroDeTelefone;
    private String endereco;
    private String[] linksRedesSociais;
    private boolean emailVerificado;
    private boolean autenticacaoDuasEtapasHabilitada;
    private String idiomaPreferido;
    private String dataRegistro;
    private NivelAcesso papel;
    private ConfiguracoesNotificacao configuracoesNotificacao;
    private PreferenciasPrivacidade preferenciasPrivacidade;
    private HistoricoLogin[] historicoLogin;
    private RegistroAtividades[] registroAtividades;

}
