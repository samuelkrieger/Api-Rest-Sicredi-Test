package br.com.compasso.api.response;

import org.springframework.http.HttpStatus;

import br.com.compasso.api.persistence.entity.SessaoEntity;

public class SessaoFoundResponse extends Response<SessaoEntity> {

	public SessaoFoundResponse() {
		super("sessoes-encontradas", "", HttpStatus.OK, null);
	
	}

}
