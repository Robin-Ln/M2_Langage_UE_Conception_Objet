package exceptions;

public class VarriableNonDeclarer extends Exception {

	private String nomSymbole;

	/*
	 * Attributs  
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Constructeurs
	 */
	public VarriableNonDeclarer(String nomSymbole) {
		this.nomSymbole = nomSymbole;
	}

	
	
	/*
	 * Methodes
	 */
	@Override
	public String toString() {
		return "VarriableNonDeclarer [nomSymbole=" + nomSymbole + "]";
	}
}
