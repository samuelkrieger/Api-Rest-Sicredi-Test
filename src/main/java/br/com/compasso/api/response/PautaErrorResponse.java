package br.com.compasso.api.response;

import org.springframework.http.HttpStatus;

public class PautaErrorResponse extends Response<Void> {

	public PautaErrorResponse(String message) {
        super("pauta-error", message, HttpStatus.BAD_REQUEST, null);
	}

}
