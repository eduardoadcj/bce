
package com.eacj.bceapi.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstadoModel {
    
    private Long id;
    private String nome;
    private String uf;
    
    private List<CidadeEstadoModel> cidades;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<CidadeEstadoModel> getCidades() {
        return cidades;
    }

    public void setCidades(List<CidadeEstadoModel> cidades) {
        this.cidades = cidades;
    }
    
}
