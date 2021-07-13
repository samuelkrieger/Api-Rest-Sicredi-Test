package br.com.compasso.api.service;

import java.util.List;

import br.com.compasso.api.persistence.domain.OpcaoVoto;
import br.com.compasso.api.persistence.domain.Voto;

public interface VotoService {
	  
    Voto  votar(Long id, OpcaoVoto opcao);

    List<Voto> getAll();

	String resultado();


}
