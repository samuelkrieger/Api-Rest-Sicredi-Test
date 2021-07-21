package br.com.compasso.api.response;

import org.springframework.http.HttpStatus;

import br.com.compasso.api.persistence.domain.PautaEntity;

public class PautaCreatedResponse extends Response<PautaEntity> {

	public PautaCreatedResponse( PautaEntity result) {
		super("pauta-criada", "", HttpStatus.CREATED, result);
	}
	
	

}
