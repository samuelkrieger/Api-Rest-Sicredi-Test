package br.com.compasso.api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.api.persistence.domain.PautaEntity;

public interface PautaRepository extends JpaRepository<PautaEntity, Long>{

}
