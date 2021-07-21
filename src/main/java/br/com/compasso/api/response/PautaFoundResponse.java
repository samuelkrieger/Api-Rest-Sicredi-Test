package br.com.compasso.api.response;

import org.springframework.http.HttpStatus;

import br.com.compasso.api.persistence.entity.PautaEntity;

public class PautaFoundResponse extends Response<PautaEntity>{

	public PautaFoundResponse( PautaEntity result) {
		super("pauta-encontrada", "", HttpStatus.OK, result);
	}

}
