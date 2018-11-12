package exceptions;

import meta.modele.expression.Expression;

public class NotACondition extends Exception {

	/*
	 * Attributs
	 */

	private static final long serialVersionUID = 7514424174720807609L;
	Expression expression;

	/*
	 * Constructeur
	 */
	public NotACondition(Expression expression) {
		super();
		this.expression = expression;
	}

	@Override
	public String toString() {
		return "NotACondition [expression=" + expression + "]";
	}

}
