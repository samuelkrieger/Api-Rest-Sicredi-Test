package br.com.compasso.api.service;

import java.util.List;

import br.com.compasso.api.model.request.PautaRequest;
import br.com.compasso.api.model.response.PautaResponse;
import br.com.compasso.api.persistence.domain.Pauta;

public interface PautaService {
	
	PautaResponse criarNovaPauta(PautaRequest request);

	Pauta get(Long id);
	
	List<Pauta> getAll();
	
 

	
	
	
	 	
	 



;
}
