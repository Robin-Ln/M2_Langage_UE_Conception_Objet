package meta.modele.expression;

import exceptions.OperationImpossible;
import exceptions.PropagationExeption;
import visiteur.Visiteur;

public class BooleanExpression extends ExpressionUnaire {

	/*
	 * Attributs
	 */

	private Boolean valeur;

	/*
	 * Constructeur
	 */
	public BooleanExpression() {
		super();
	}

	public BooleanExpression(Boolean valeur) {
		super();
		this.valeur = valeur;
	}

	/*
	 * Méthodes
	 */

	@Override
	public String toString() {
		return "BooleanExpression [" + "Id()=" + getId() + ", valeur=" + valeur + "]";
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

		if (!(obj instanceof BooleanExpression)) {
			return false;
		}

		BooleanExpression integerExpression = (BooleanExpression) obj;

		if (this.getValeur().equals(integerExpression.getValeur())) {
			return true;
		}

		return false;
	}

	/*
	 * Accesseurs
	 */

	public Boolean getValeur() {
		return valeur;
	}

	public void setValeur(Boolean valeur) {
		this.valeur = valeur;
	}

	/*
	 * Méthodes VerifierAdditionExpression
	 */

	@Override
	public ExpressionUnaire verifierAdditionAvec(ExpressionUnaire expressionUnaire) throws OperationImpossible {
		return expressionUnaire.verifierAdditionAvecBoolean(this);
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecInteger(StringExpression stringExpression) throws OperationImpossible {
		throw new OperationImpossible(stringExpression, this);
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecInteger(IntegerExpression integerExpression) throws OperationImpossible {
		throw new OperationImpossible(integerExpression, this);
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecInteger(DoubleExpression doubleExpression) throws OperationImpossible {
		throw new OperationImpossible(doubleExpression, this);
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecString(StringExpression stringExpression) throws OperationImpossible {
		throw new OperationImpossible(stringExpression, this);
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecString(IntegerExpression integerExpression) throws OperationImpossible {
		throw new OperationImpossible(integerExpression, this);
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecString(DoubleExpression doubleExpression) throws OperationImpossible {
		throw new OperationImpossible(doubleExpression, this);
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecDouble(StringExpression stringExpression) throws OperationImpossible {
		throw new OperationImpossible(stringExpression, this);

	}

	@Override
	public ExpressionUnaire verifierAdditionAvecDouble(IntegerExpression integerExpression) throws OperationImpossible {
		throw new OperationImpossible(integerExpression, this);
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecDouble(DoubleExpression doubleExpression) throws OperationImpossible {
		throw new OperationImpossible(doubleExpression, this);
	}
	
	@Override
	public ExpressionUnaire verifierAdditionAvecInteger(BooleanExpression booleanExpression)
			throws OperationImpossible {
		throw new OperationImpossible(booleanExpression, this);
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecString(BooleanExpression booleanExpression) throws OperationImpossible {
		throw new OperationImpossible(booleanExpression, this);
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecDouble(BooleanExpression booleanExpression) throws OperationImpossible {
		throw new OperationImpossible(booleanExpression, this);

	}

	@Override
	public ExpressionUnaire verifierAdditionAvecBoolean(StringExpression stringExpression) throws OperationImpossible {
		throw new OperationImpossible(stringExpression, this);
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecBoolean(IntegerExpression integerExpression)
			throws OperationImpossible {
		throw new OperationImpossible(integerExpression, this);
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecBoolean(DoubleExpression doubleExpression) throws OperationImpossible {
		throw new OperationImpossible(doubleExpression, this);
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecBoolean(BooleanExpression doubleExpression) throws OperationImpossible {
		throw new OperationImpossible(doubleExpression, this);
	}

	/*
	 * Méthodes VerifierMultiplicationExpression
	 */

	@Override
	public ExpressionUnaire verifierMultiplicationAvec(ExpressionUnaire expressionUnaire) throws OperationImpossible {
		return expressionUnaire.verifierMultiplicationAvecBoolean(this);
	}

	@Override
	public ExpressionUnaire verifierMultiplicationAvecInteger(StringExpression stringExpression)
			throws OperationImpossible {
		throw new OperationImpossible(stringExpression, this);
	}

	@Override
	public ExpressionUnaire verifierMultiplicationAvecInteger(IntegerExpression integerExpression)
			throws OperationImpossible {
		throw new OperationImpossible(integerExpression, this);
	}

	@Override
	public ExpressionUnaire verifierMultiplicationAvecInteger(DoubleExpression doubleExpression)
			throws OperationImpossible {
		throw new OperationImpossible(doubleExpression, this);
	}

	@Override
	public ExpressionUnaire verifierMultiplicationAvecString(StringExpression stringExpression)
			throws OperationImpossible {
		throw new OperationImpossible(stringExpression, this);
	}

	@Override
	public ExpressionUnaire verifierMultiplicationAvecString(IntegerExpression integerExpression)
			throws OperationImpossible {
		throw new OperationImpossible(integerExpression, this);
	}

	@Override
	public ExpressionUnaire verifierMultiplicationAvecString(DoubleExpression doubleExpression)
			throws OperationImpossible {
		throw new OperationImpossible(doubleExpression, this);
	}

	@Override
	public ExpressionUnaire verifierMultiplicationAvecDouble(StringExpression stringExpression)
			throws OperationImpossible {
		throw new OperationImpossible(stringExpression, this);
	}

	@Override
	public ExpressionUnaire verifierMultiplicationAvecDouble(IntegerExpression integerExpression)
			throws OperationImpossible {
		throw new OperationImpossible(integerExpression, this);
	}

	@Override
	public ExpressionUnaire verifierMultiplicationAvecDouble(DoubleExpression doubleExpression)
			throws OperationImpossible {
		throw new OperationImpossible(doubleExpression, this);
	}

	@Override
	public ExpressionUnaire verifierMultiplicationAvecInteger(BooleanExpression booleanExpression)
			throws OperationImpossible {
		throw new OperationImpossible(booleanExpression, this);

	}

	@Override
	public ExpressionUnaire verifierMultiplicationAvecString(BooleanExpression booleanExpression)
			throws OperationImpossible {
		throw new OperationImpossible(booleanExpression, this);
	}

	@Override
	public ExpressionUnaire verifierMultiplicationAvecDouble(BooleanExpression booleanExpression)
			throws OperationImpossible {
		throw new OperationImpossible(booleanExpression, this);
	}

	@Override
	public ExpressionUnaire verifierMultiplicationAvecBoolean(StringExpression stringExpression)
			throws OperationImpossible {
		throw new OperationImpossible(stringExpression, this);
	}

	@Override
	public ExpressionUnaire verifierMultiplicationAvecBoolean(IntegerExpression integerExpression)
			throws OperationImpossible {
		throw new OperationImpossible(integerExpression, this);
	}

	@Override
	public ExpressionUnaire verifierMultiplicationAvecBoolean(DoubleExpression doubleExpression)
			throws OperationImpossible {
		throw new OperationImpossible(doubleExpression, this);
	}

	@Override
	public ExpressionUnaire verifierMultiplicationAvecBoolean(BooleanExpression doubleExpression)
			throws OperationImpossible {
		throw new OperationImpossible(doubleExpression, this);
	}

	/*
	 * Méthodes VerifierInferieurExpression
	 */

	@Override
	public ExpressionUnaire verifierInferieurAvec(ExpressionUnaire expressionUnaire) throws OperationImpossible {
		return expressionUnaire.verifierInferieurAvecString(this);
	}

	@Override
	public ExpressionUnaire verifierInferieurAvecInteger(StringExpression stringExpression) throws OperationImpossible {
		throw new OperationImpossible(stringExpression, this);
	}

	@Override
	public ExpressionUnaire verifierInferieurAvecInteger(IntegerExpression integerExpression)
			throws OperationImpossible {
		throw new OperationImpossible(integerExpression, this);
	}

	@Override
	public ExpressionUnaire verifierInferieurAvecInteger(DoubleExpression doubleExpression) throws OperationImpossible {
		throw new OperationImpossible(doubleExpression, this);
	}

	@Override
	public ExpressionUnaire verifierInferieurAvecInteger(BooleanExpression booleanExpression)
			throws OperationImpossible {
		throw new OperationImpossible(booleanExpression, this);
	}

	@Override
	public ExpressionUnaire verifierInferieurAvecString(StringExpression stringExpression) throws OperationImpossible {
		throw new OperationImpossible(stringExpression, this);
	}

	@Override
	public ExpressionUnaire verifierInferieurAvecString(IntegerExpression integerExpression)
			throws OperationImpossible {
		throw new OperationImpossible(integerExpression, this);
	}

	@Override
	public ExpressionUnaire verifierInferieurAvecString(DoubleExpression doubleExpression) throws OperationImpossible {
		throw new OperationImpossible(doubleExpression, this);
	}

	@Override
	public ExpressionUnaire verifierInferieurAvecString(BooleanExpression booleanExpression)
			throws OperationImpossible {
		throw new OperationImpossible(booleanExpression, this);
	}

	@Override
	public ExpressionUnaire verifierInferieurAvecDouble(StringExpression stringExpression) throws OperationImpossible {
		throw new OperationImpossible(stringExpression, this);
	}

	@Override
	public ExpressionUnaire verifierInferieurAvecDouble(IntegerExpression integerExpression)
			throws OperationImpossible {
		throw new OperationImpossible(integerExpression, this);
	}

	@Override
	public ExpressionUnaire verifierInferieurAvecDouble(DoubleExpression doubleExpression) throws OperationImpossible {
		throw new OperationImpossible(doubleExpression, this);
	}

	@Override
	public ExpressionUnaire verifierInferieurAvecDouble(BooleanExpression booleanExpression)
			throws OperationImpossible {
		throw new OperationImpossible(booleanExpression, this);
	}

	@Override
	public ExpressionUnaire verifierInferieurAvecBoolean(StringExpression stringExpression) throws OperationImpossible {
		throw new OperationImpossible(stringExpression, this);
	}

	@Override
	public ExpressionUnaire verifierInferieurAvecBoolean(IntegerExpression integerExpression)
			throws OperationImpossible {
		throw new OperationImpossible(integerExpression, this);
	}

	@Override
	public ExpressionUnaire verifierInferieurAvecBoolean(DoubleExpression doubleExpression) throws OperationImpossible {
		throw new OperationImpossible(doubleExpression, this);
	}

	@Override
	public ExpressionUnaire verifierInferieurAvecBoolean(BooleanExpression booleanExpression)
			throws OperationImpossible {
		throw new OperationImpossible(booleanExpression, this);
	}
	
}
