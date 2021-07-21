package br.com.compasso.api.response;

import org.springframework.http.HttpStatus;

import br.com.compasso.api.persistence.entity.PautaEntity;

public class SessaoCreatedResponse  extends Response<PautaEntity>{

	public SessaoCreatedResponse(String pauta, PautaEntity result) {
		super("sessao-criada", "", HttpStatus.CREATED, result);
	}

}
