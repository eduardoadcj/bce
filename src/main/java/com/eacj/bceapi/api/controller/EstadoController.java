
package com.eacj.bceapi.api.controller;

import com.eacj.bceapi.domain.model.Cidade;
import com.eacj.bceapi.domain.model.CidadeEstado;
import com.eacj.bceapi.domain.model.Estado;
import com.eacj.bceapi.domain.repository.CidadeRepository;
import com.eacj.bceapi.domain.repository.EstadoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    @GetMapping
    public List<Estado> listar(){
        return estadoRepository.findAll();
    }
    
    @GetMapping("/cidades")
    public List<Estado> listarCidades(){
        
        List<Estado> list = estadoRepository.findAll();
        
        for(Estado e : list){
            List<Cidade> cidades = cidadeRepository.findByEstadoUf(e.getUf());
            List<CidadeEstado> cidadesEstado = new ArrayList<>();
            for(Cidade c : cidades)
                cidadesEstado.add(new CidadeEstado(c.getId(), c.getNome()));
            e.setCidades(cidadesEstado);
        }
        
        return list;
        
    }
    
}
