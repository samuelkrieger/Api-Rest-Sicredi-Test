package br.com.compasso.api.error;

public class PautaNotFoundException extends NotFoundException {
    public PautaNotFoundException(Long id) {
    	super(String.format("Pauta not found by id=%s", id));
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}
