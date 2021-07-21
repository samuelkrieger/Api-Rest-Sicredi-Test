package br.com.compasso.api.response;

import org.springframework.http.HttpStatus;

import br.com.compasso.api.persistence.domain.VotoEntity;

public class VotoCreatedResponse extends Response<VotoEntity> {

	public VotoCreatedResponse() {
		super("voto-concluido", "", HttpStatus.CREATED, null);;
		
	}

}
