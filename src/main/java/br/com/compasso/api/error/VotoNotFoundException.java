package br.com.compasso.api.error;

public class VotoNotFoundException extends NotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VotoNotFoundException(Long id) {
    	super(String.format("Voto not found by id=%s", id));
	}

}
