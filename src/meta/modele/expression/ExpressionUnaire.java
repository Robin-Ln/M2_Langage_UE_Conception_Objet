package meta.modele.expression;

import meta.modele.expression.verification.VerifierAdditionExpression;
import meta.modele.expression.verification.VerifierInferieurExpression;
import meta.modele.expression.verification.VerifierMultiplicationExpression;

/**
 * Class qui permet la représentation d'expression avec une opérande
 * 
 * @author Robin LOUARN
 *
 */
public abstract class ExpressionUnaire extends Expression
		implements VerifierAdditionExpression, VerifierMultiplicationExpression, VerifierInferieurExpression {

	/*
	 * Constructeurs
	 */

	/**
	 * Constructeur sans paramètre
	 */
	public ExpressionUnaire() {
		super();
	}

}
