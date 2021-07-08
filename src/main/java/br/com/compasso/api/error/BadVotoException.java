package br.com.compasso.api.error;

public class BadVotoException extends BadRequestException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadVotoException(String message) {
		 super(String.format("invalid Voto for name=%s", message));
	}

}
