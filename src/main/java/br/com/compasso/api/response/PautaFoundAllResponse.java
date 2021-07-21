package br.com.compasso.api.response;

import org.springframework.http.HttpStatus;

import br.com.compasso.api.persistence.entity.PautaEntity;

public class PautaFoundAllResponse extends Response<PautaEntity> {

	public PautaFoundAllResponse( PautaEntity result) {
		super("pautas-encontradas", "", HttpStatus.OK, result);
	}

}
