package meta.modele.instructions;

import exceptions.PropagationExeption;
import meta.modele.expression.Expression;
import meta.modele.expression.Reference;
import visiteur.Visiteur;

public class Affectation extends Instruction {

	/*
	 * Attributs
	 */
	Reference reference;
	Expression expression;

	/*
	 * Constructeur
	 */
	public Affectation() {
		super();
	}

	/*
	 * Methodes
	 */
	@Override
	public void accept(Visiteur visiteur) throws PropagationExeption {
		visiteur.visite(this);
	}

	@Override
	public String toString() {
		return "Affectation [varriableReference=" + reference + ", expression=" + expression + "]";
	}

	/*
	 * Accesseurs
	 */
	public Reference getReference() {
		return reference;
	}

	public void setVarriableReference(Reference reference) {
		this.reference = reference;
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

}
