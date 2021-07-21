package br.com.compasso.api.response;

import org.springframework.http.HttpStatus;

public class SessaoErrorResponse extends Response<Void> {

	public SessaoErrorResponse(String message) {
        super("pessao-error", message, HttpStatus.BAD_REQUEST, null);
	}

}
