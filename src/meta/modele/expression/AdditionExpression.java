package meta.modele.expression;

import exceptions.PropagationExeption;
import visiteur.Visiteur;

/**
 * Class qui represente une Addition
 * 
 * @author Robin LOUARN
 *
 */
public class AdditionExpression extends ExpressionBinaire {

	/*
	 * Constructeur
	 */
	public AdditionExpression() {
		super();
	}

	public AdditionExpression(Expression operandeGauche, Expression operandeDroite) {
		super(operandeGauche, operandeDroite);
	}

	/*
	 * Methodes
	 */

	@Override
	public String toString() {
		return "AdditionExpression [ " + "Id=" + getId() + "]";
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

		AdditionExpression additionExpression = (AdditionExpression) obj;

		if (this.getOperandeGauche().equals(additionExpression.getOperandeGauche())
				&& this.getOperandeDroite().equals(additionExpression.getOperandeDroite())) {
			return true;
		}

		return false;
	}

}
