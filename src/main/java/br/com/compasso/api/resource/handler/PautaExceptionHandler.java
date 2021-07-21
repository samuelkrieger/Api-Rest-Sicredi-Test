package br.com.compasso.api.resource.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.compasso.api.error.BadPautaException;
import br.com.compasso.api.error.PautaNotFoundException;
import br.com.compasso.api.response.PautaErrorResponse;
import br.com.compasso.api.response.PautaNotFoundResponse;

@RestControllerAdvice
public class PautaExceptionHandler {
	
	@ExceptionHandler(BadPautaException.class)
	public ResponseEntity<PautaErrorResponse> handleBadRequest(BadPautaException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PautaErrorResponse(ex.getMessage()));
	}

	@ExceptionHandler(PautaNotFoundException.class)
	public ResponseEntity<PautaNotFoundResponse> handleNotFound(PautaNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PautaNotFoundResponse (ex.getMessage()));
	}

}
