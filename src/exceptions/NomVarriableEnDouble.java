package exceptions;

public class NomVarriableEnDouble extends Exception{

	private String nomSymbole;

	/*
	 * Attributs  
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Constructeurs
	 */
	public NomVarriableEnDouble(String nomSymbole) {
		this.nomSymbole = nomSymbole;
	}

	
	
	/*
	 * Methodes
	 */
	@Override
	public String toString() {
		return "NomVarriableEnDouble [nomSymbole=" + nomSymbole + "]";
	}

}
