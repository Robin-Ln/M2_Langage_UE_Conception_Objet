package exceptions;

import meta.modele.expression.Expression;

public class OperationImpossible extends Exception {

	/*
	 * Attributs
	 */

	private static final long serialVersionUID = 7514424174720807609L;
	Expression operandeGauche;
	Expression operandeDroite;

	/*
	 * Constructeur
	 */
	public OperationImpossible(Expression operandeGauche, Expression operandeDroite) {
		super();
		this.operandeGauche = operandeGauche;
		this.operandeDroite = operandeDroite;
	}

	@Override
	public String toString() {
		return "OperationImpossible [operandeGauche=" + operandeGauche + ", operandeDroite=" + operandeDroite + "]";
	}

}
