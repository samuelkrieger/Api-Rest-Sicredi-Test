package br.com.compasso.api.service;

import java.util.Optional;

import br.com.compasso.api.model.SessaoRequest;
import br.com.compasso.api.persistence.entity.PautaEntity;
import br.com.compasso.api.persistence.entity.SessaoEntity;

public interface SessaoService {

	SessaoRequest criarNovaSessao(PautaEntity entity); 
	
	Optional<SessaoEntity> getSessaoId(Long id);
}
