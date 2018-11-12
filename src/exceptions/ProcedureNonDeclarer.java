package exceptions;

public class ProcedureNonDeclarer extends Exception {

	private String nomProcedure;

	/*
	 * Attributs  
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Constructeurs
	 */
	public ProcedureNonDeclarer(String nomProcedure) {
		this.nomProcedure = nomProcedure;
	}

	
	
	/*
	 * Methodes
	 */
	@Override
	public String toString() {
		return "ProcedureNonDeclarer [nomProcedure=" + nomProcedure + "]";
	}
}
