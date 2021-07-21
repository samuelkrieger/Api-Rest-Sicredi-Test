package br.com.compasso.api.response;

import org.springframework.http.HttpStatus;

public class SessaoNotFoundResponse extends Response<Void>{

	public SessaoNotFoundResponse(String message) {
		super("pessao-nao-encontrada", message, HttpStatus.NOT_FOUND, null);
	}

}
