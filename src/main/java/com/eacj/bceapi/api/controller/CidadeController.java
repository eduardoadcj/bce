
package com.eacj.bceapi.api.controller;

import com.eacj.bceapi.api.model.CidadeModel;
import com.eacj.bceapi.domain.model.Cidade;
import com.eacj.bceapi.domain.repository.CidadeRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    @GetMapping
    public List<CidadeModel> listar() {
        return toCollectionModel(cidadeRepository.findAll());
    }
    
    @GetMapping("/{uf}")
    public ResponseEntity<List<CidadeModel>> listar(@PathVariable String uf){
        
        if(uf.length() != 2)
            return ResponseEntity.badRequest().build();
        
        uf = uf.toUpperCase();
        
        List<Cidade> list = cidadeRepository.findByEstadoUf(uf);
        
        if(list.isEmpty())
            return ResponseEntity.notFound().build();
        
        return ResponseEntity.ok(toCollectionModel(list));
        
    }
    
    private CidadeModel toModel(Cidade cidade){
        return modelMapper.map(cidade, CidadeModel.class);
    }
    
    private List<CidadeModel> toCollectionModel(List<Cidade> cidades){
        return cidades.stream()
                .map(cidade -> toModel(cidade))
                .collect(Collectors.toList());
    }
    
}
