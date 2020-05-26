
package com.eacj.bceapi.api.controller;

import com.eacj.bceapi.domain.model.Cidade;
import com.eacj.bceapi.domain.repository.CidadeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;
    
    @GetMapping
    public List<Cidade> listar() {
        return cidadeRepository.findAll();
    }
    
    @GetMapping("/{uf}")
    public ResponseEntity<List<Cidade>> listar(@PathVariable String uf){
        
        if(uf.length() != 2)
            return ResponseEntity.badRequest().build();
        
        uf = uf.toUpperCase();
        
        List<Cidade> list = cidadeRepository.findByEstadoUf(uf);
        
        if(list.isEmpty())
            return ResponseEntity.notFound().build();
        
        return ResponseEntity.ok(list);
        
    }
    
}
