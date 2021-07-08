package br.com.compasso.api.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.compasso.api.model.request.PautaRequest;
import br.com.compasso.api.model.response.PautaResponse;
import br.com.compasso.api.model.response.SessaoResponse;
import br.com.compasso.api.persistence.domain.OpcaoVoto;
import br.com.compasso.api.persistence.domain.Pauta;
import br.com.compasso.api.persistence.domain.Sessao;
import br.com.compasso.api.persistence.domain.Voto;

public interface PautaService {
	
	PautaResponse criarNovaPauta(PautaRequest request);

	Optional<Pauta> get(Long id);
	
	Page<PautaResponse> getAll(Pageable pageable);
	
    SessaoResponse criarNovaSessao(PautaRequest request,LocalDateTime fechamento); 
    
    Sessao getSessao(Optional<Pauta> pauta);
    
    Voto  votar(Long id, OpcaoVoto opcao);
    
    Optional<Sessao> getSessaoId(Long id);

	Page<Voto> getVotos(Pageable pageable);
	
	String resultado();


	
	
	
	 	
	 



;
}
