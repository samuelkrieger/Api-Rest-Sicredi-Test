package br.com.compasso.api.error;

public abstract class BadRequestException  extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadRequestException(final String message) {
        super(message);
    }
}
