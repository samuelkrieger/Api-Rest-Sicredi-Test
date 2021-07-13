package br.com.compasso.api.service;

import java.time.LocalDateTime;
import java.util.Optional;

import br.com.compasso.api.model.request.PautaRequest;
import br.com.compasso.api.model.response.SessaoResponse;

public interface SessaoService {

	SessaoResponse criarNovaSessao(PautaRequest request,LocalDateTime fechamento); 
	
	Optional<SessaoResponse> getSessaoId(Long id);
}
