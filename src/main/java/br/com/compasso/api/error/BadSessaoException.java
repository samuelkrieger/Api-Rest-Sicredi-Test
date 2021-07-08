package br.com.compasso.api.error;

public class BadSessaoException extends BadRequestException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadSessaoException(String message) {
		 super(String.format("invalid Session for name=%s", message));
	}

}
