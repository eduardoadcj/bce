
package com.eacj.bceapi.api.controller;

import com.eacj.bceapi.api.model.CidadeEstadoModel;
import com.eacj.bceapi.api.model.EstadoModel;
import com.eacj.bceapi.domain.model.Cidade;
import com.eacj.bceapi.domain.model.Estado;
import com.eacj.bceapi.domain.repository.CidadeRepository;
import com.eacj.bceapi.domain.repository.EstadoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/estados")
public class EstadoController {
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    @GetMapping
    public List<EstadoModel> listar(){
        return toCollectionModel(estadoRepository.findAll());
    }
    
    @GetMapping("/cidades")
    public List<EstadoModel> listarCidades(){
        
        List<EstadoModel> list = toCollectionModel(estadoRepository.findAll());
        
        for(EstadoModel e : list){
            List<Cidade> cidades = cidadeRepository.findByEstadoUf(e.getUf());
            List<CidadeEstadoModel> cidadesEstado = new ArrayList<>();
            for(Cidade c : cidades)
                cidadesEstado.add(new CidadeEstadoModel(c.getId(), c.getNome()));
            e.setCidades(cidadesEstado);
        }
        
        return list;
        
    }
    
    private EstadoModel toModel(Estado estado){
        return modelMapper.map(estado, EstadoModel.class);
    }
    
    private List<EstadoModel> toCollectionModel(List<Estado> estados){
        return estados.stream()
                .map(estado -> toModel(estado))
                .collect(Collectors.toList());
    }
    
}
