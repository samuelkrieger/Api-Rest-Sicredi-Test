package br.com.compasso.api.service;

import java.util.List;

import br.com.compasso.api.model.PautaRequest;
import br.com.compasso.api.persistence.entity.PautaEntity;

public interface PautaService {
	
	PautaRequest criarNovaPauta(PautaEntity entity);

	PautaEntity get(Long id);
	
	List<PautaEntity> getAll();
	
 

	
	
	
	 	
	 



;
}
