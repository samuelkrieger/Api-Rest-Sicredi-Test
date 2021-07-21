package br.com.compasso.api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.api.persistence.entity.PautaEntity;
import br.com.compasso.api.persistence.entity.SessaoEntity;

public interface SessaoRepository extends JpaRepository<SessaoEntity, Long>{
	SessaoEntity  findByPauta(PautaEntity  pauta );
	
	
	
}
