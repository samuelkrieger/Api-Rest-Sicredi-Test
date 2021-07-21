package br.com.compasso.api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.api.persistence.domain.PautaEntity;
import br.com.compasso.api.persistence.domain.SessaoEntity;

public interface SessaoRepository extends JpaRepository<SessaoEntity, Long>{
	SessaoEntity  findByPauta (PautaEntity  pauta );
	
	
}
