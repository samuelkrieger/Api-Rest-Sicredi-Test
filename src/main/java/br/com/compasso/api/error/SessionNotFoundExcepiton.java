package br.com.compasso.api.error;

public class SessionNotFoundExcepiton extends NotFoundException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SessionNotFoundExcepiton(Long id) {
    	super(String.format("Session not found by id=%s", id));
	}
}
