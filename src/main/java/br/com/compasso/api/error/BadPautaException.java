package br.com.compasso.api.error;

public class BadPautaException extends BadRequestException{

	public BadPautaException(String message) {
		 super(String.format("invalid Pauta for name=%s", message));
	}

	private static final long serialVersionUID = 1L;

	
	}