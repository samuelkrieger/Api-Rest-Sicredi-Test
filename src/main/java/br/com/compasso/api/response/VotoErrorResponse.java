package br.com.compasso.api.response;

import org.springframework.http.HttpStatus;

public class VotoErrorResponse extends Response<Void>  {

	public VotoErrorResponse(String message) {
        super("voto-error", message, HttpStatus.BAD_REQUEST, null);
	}

}
