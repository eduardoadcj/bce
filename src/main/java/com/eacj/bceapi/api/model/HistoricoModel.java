package com.eacj.bceapi.api.model;

import java.time.OffsetDateTime;


public class HistoricoModel {
    
    private Long id;
    private OffsetDateTime ultimaAtualizacao;
    private String fonte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(OffsetDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }
    
}
