package br.com.compasso.api.error;

public class SessaoNotFoundException extends NotFoundException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SessaoNotFoundException(Long id) {
    	super(String.format("Session not found by id=%s", id));
	}
}
