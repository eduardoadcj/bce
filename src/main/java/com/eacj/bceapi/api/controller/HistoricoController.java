
package com.eacj.bceapi.api.controller;

import com.eacj.bceapi.domain.model.Historico;
import com.eacj.bceapi.domain.repository.HistoricoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historico")
public class HistoricoController {
    
    @Autowired
    private HistoricoRepository historicoRepository;
    
    @GetMapping
    public List<Historico> get(){
        return historicoRepository.findAll();
    }
    
}
