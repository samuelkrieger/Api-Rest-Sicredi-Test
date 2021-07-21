package br.com.compasso.api.response;

import org.springframework.http.HttpStatus;

public class PautaNotFoundResponse extends Response<Void>{

	public PautaNotFoundResponse(String message) {
		super("pauta-nao-encontrada", message, HttpStatus.NOT_FOUND, null);
	}

}
