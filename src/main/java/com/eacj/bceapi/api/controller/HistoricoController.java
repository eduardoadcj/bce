
package com.eacj.bceapi.api.controller;

import com.eacj.bceapi.api.model.HistoricoModel;
import com.eacj.bceapi.domain.model.Historico;
import com.eacj.bceapi.domain.repository.HistoricoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historico")
public class HistoricoController {
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private HistoricoRepository historicoRepository;
    
    @GetMapping
    public List<HistoricoModel> get(){
        return toCollectionModel(historicoRepository.findAll());
    }
    
    private HistoricoModel toModel(Historico historico){
        return modelMapper.map(historico, HistoricoModel.class);
    }
    
    private List<HistoricoModel> toCollectionModel(List<Historico> historicos){
        return historicos.stream()
                .map(historico -> toModel(historico))
                .collect(Collectors.toList());
    }
    
}
