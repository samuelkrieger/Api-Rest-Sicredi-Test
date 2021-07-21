package br.com.compasso.api.service;

import java.util.List;

import br.com.compasso.api.persistence.domain.OpcaoVotoEntity;
import br.com.compasso.api.persistence.domain.VotoEntity;

public interface VotoService {
	  
    VotoEntity  votar(Long id, OpcaoVotoEntity opcao);

    List<VotoEntity> getAll();

	

}
