
package com.eacj.bceapi.domain.repository;

import com.eacj.bceapi.domain.model.Estado;
import com.eacj.bceapi.domain.model.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long>{

    
}
