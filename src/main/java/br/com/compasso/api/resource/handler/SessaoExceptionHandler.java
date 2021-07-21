package br.com.compasso.api.resource.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.compasso.api.error.BadSessaoException;
import br.com.compasso.api.error.PautaNotFoundException;
import br.com.compasso.api.response.SessaoErrorResponse;
import br.com.compasso.api.response.SessaoNotFoundResponse;

@RestControllerAdvice
public class SessaoExceptionHandler {
	
	@ExceptionHandler(BadSessaoException.class)
	public ResponseEntity<SessaoErrorResponse> handleBadRequest(BadSessaoException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SessaoErrorResponse(ex.getMessage()));
	}

	@ExceptionHandler(PautaNotFoundException.class)
	public ResponseEntity<SessaoNotFoundResponse> handleNotFound(PautaNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new SessaoNotFoundResponse(ex.getMessage()));
	}

}
