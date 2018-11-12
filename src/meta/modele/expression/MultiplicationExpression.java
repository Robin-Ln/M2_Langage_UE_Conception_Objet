package meta.modele.expression;

import exceptions.PropagationExeption;
import visiteur.Visiteur;

public class MultiplicationExpression extends ExpressionBinaire {

	/*
	 * Constructeurs
	 */
	public MultiplicationExpression() {
		super();
	}

	public MultiplicationExpression(Expression operandeGauche, Expression operandeDroite) {
		super(operandeGauche, operandeDroite);
	}

	/*
	 * Méthodes
	 */

	@Override
	public String toString() {
		return "MultiplicationExpression [" + "Id()=" + getId() + "]";
	}

	@Override
	public void accept(Visiteur visiteur) throws PropagationExeption {
		visiteur.visite(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (!(obj instanceof AdditionExpression)) {
			return false;
		}

		System.out.println("equale mulr bad");
		
		MultiplicationExpression multiplicationExpression = (MultiplicationExpression) obj;

		if (this.getOperandeGauche().equals(multiplicationExpression.getOperandeGauche())
				&& this.getOperandeDroite().equals(multiplicationExpression.getOperandeDroite())) {
			return true;
		}

		return false;
	}

}
