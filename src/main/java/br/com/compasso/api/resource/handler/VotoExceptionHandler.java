package br.com.compasso.api.resource.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.compasso.api.error.BadVotoException;
import br.com.compasso.api.response.VotoErrorResponse;

public class VotoExceptionHandler {

	@ExceptionHandler(BadVotoException.class)
	public ResponseEntity<VotoErrorResponse> handleBadRequest(BadVotoException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new VotoErrorResponse(ex.getMessage()));
	}

	
}
