package exceptions;

import meta.modele.expression.VarriableReference;

public class VarriableNonInitialiser extends Exception {


	/*
	 * Attributs
	 */
	private static final long serialVersionUID = 1L;
	private VarriableReference varriableReference;

	
	/*
	 * Constructeurs
	 */
	public VarriableNonInitialiser(VarriableReference varriableReference) {
		this.varriableReference = varriableReference;
	}

	/*
	 * Methodes
	 */
	@Override
	public String toString() {
		return "VarriableNonInitialiser [varriableReference=" + varriableReference + "]";
	}

}
