package com.eacj.bceapi.domain.repository;

import com.eacj.bceapi.domain.model.Cidade;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    List<Cidade> findByEstadoId(long id);
    List<Cidade> findByEstadoUf(String uf);
}
