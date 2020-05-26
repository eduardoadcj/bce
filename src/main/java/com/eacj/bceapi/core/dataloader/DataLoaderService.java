package com.eacj.bceapi.core.dataloader;

import com.eacj.bceapi.domain.model.Cidade;
import com.eacj.bceapi.domain.model.Estado;
import com.eacj.bceapi.domain.model.Historico;
import com.eacj.bceapi.domain.repository.CidadeRepository;
import com.eacj.bceapi.domain.repository.EstadoRepository;
import com.eacj.bceapi.domain.repository.HistoricoRepository;
import com.eacj.bceapi.util.tools.BasicDateOperator;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataLoaderService {

    @Autowired
    private HistoricoRepository historicoRepository;
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    public void start(){
        
        List<Historico> hist = historicoRepository.findAll();
        if(hist.isEmpty()){
            loadData();
        }else{
            
            Historico h = hist.get(hist.size()-1);
            Date ultimaAt = Date.from(h.getUltimaAtualizacao().toInstant()); 
            
            if(BasicDateOperator.getDaysBetween(ultimaAt, new Date()) > 365)
                updateDate();
            
        }
        
    }
    
    private void updateDate(){

    }
    
    private void loadData() {
        
        System.out.println("Iniciando carregamento de dados...");
        
        RestTemplate rt = new RestTemplate();
        String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";

        ResponseEntity<EstadoTemp[]> resp = rt.getForEntity(url, EstadoTemp[].class);
        
        for(EstadoTemp et : Arrays.asList(resp.getBody())){

            Estado e = new Estado();
            e.setNome(et.getNome());
            e.setUf(et.getSigla());
            
            estadoRepository.save(e);
            
            url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/"+e.getUf()+"/municipios";
            ResponseEntity<Municipios[]> resp2 = rt.getForEntity(url, Municipios[].class);
            
            for(Municipios m : Arrays.asList(resp2.getBody())){
                
                Cidade c = new Cidade();
                c.setEstado(e);
                c.setNome(m.getNome());
                
                cidadeRepository.save(c);
                
            }
            
        }
        
        salvarHistorico();
        
        System.out.println("Dados carregados com sucesso!");
            
    }
    
    private void salvarHistorico(){
        Historico h = new Historico();
        h.setUltimaAtualizacao(OffsetDateTime.now());
        h.setFonte("servicodados.ibge.gov.br");
        historicoRepository.save(h);
    }

}
