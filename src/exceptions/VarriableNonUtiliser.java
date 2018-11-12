package exceptions;

import meta.modele.expression.Reference;

public class VarriableNonUtiliser extends Exception{

	/*
	 * Attributs
	 */
	private static final long serialVersionUID = 1L;
	private Reference Reference;

	
	/*
	 * Constructeurs
	 */
	public VarriableNonUtiliser(Reference Reference) {
		this.Reference = Reference;
	}

	/*
	 * Methodes
	 */
	@Override
	public String toString() {
		return "VarriableNonUtiliser [Reference=" + Reference + "]";
	}

}
