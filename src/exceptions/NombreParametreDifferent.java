package exceptions;

public class NombreParametreDifferent extends Exception {

	private String nomProcedure;

	/*
	 * Attributs  
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Constructeurs
	 */
	public NombreParametreDifferent(String nomProcedure) {
		this.nomProcedure = nomProcedure;
	}

	
	
	/*
	 * Methodes
	 */
	@Override
	public String toString() {
		return "NombreParametreDifferent [nomProcedure=" + nomProcedure + "]";
	}
}
