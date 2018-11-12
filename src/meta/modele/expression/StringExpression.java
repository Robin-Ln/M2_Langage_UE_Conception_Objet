package meta.modele.expression;

import exceptions.OperationImpossible;
import exceptions.PropagationExeption;
import visiteur.Visiteur;

public class StringExpression extends ExpressionUnaire {

	/*
	 * Attributs
	 */

	private String valeur;

	/*
	 * Constructeur
	 */
	public StringExpression() {
		super();
	}

	public StringExpression(String valeur) {
		super();
		this.valeur = valeur;
	}

	/*
	 * Méthodes
	 */

	@Override
	public String toString() {
		return "StringExpression [" + "Id()=" + getId() + ", valeur=" + valeur + "]";
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

		if (!(obj instanceof StringExpression)) {
			return false;
		}

		StringExpression integerExpression = (StringExpression) obj;

		if (this.getValeur().equals(integerExpression.getValeur())) {
			return true;
		}

		return false;
	}

	/*
	 * Accesseurs
	 */

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	/*
	 * Méthodes VerifierAdditionExpression
	 */

	@Override
	public ExpressionUnaire verifierAdditionAvec(ExpressionUnaire expressionUnaire) throws OperationImpossible {
		return expressionUnaire.verifierAdditionAvecString(this);
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecInteger(StringExpression stringExpression) {
		StringExpression resultat = new StringExpression();
		resultat.setValeur(stringExpression.getValeur() + this.getValeur());
		return resultat;
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecInteger(IntegerExpression integerExpression) {
		StringExpression resultat = new StringExpression();
		resultat.setValeur(integerExpression.getValeur() + this.getValeur());
		return resultat;
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecInteger(DoubleExpression doubleExpression) throws OperationImpossible {
		throw new OperationImpossible(doubleExpression, this);
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecString(StringExpression stringExpression) {
		StringExpression resultat = new StringExpression();
		resultat.setValeur(stringExpression.getValeur() + this.getValeur());
		return resultat;
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecString(IntegerExpression integerExpression) {
		StringExpression resultat = new StringExpression();
		resultat.setValeur(integerExpression.getValeur() + this.getValeur());
		return resultat;
	}

	@Override
	public ExpressionUnaire verifierAdditionAvecString(DoubleExpression doubleExpression) {
		StringExpression resultat = new StringExpression(doubleExpression.getValeur() + this.getValeur());
		resultat.setValeur(doubleExpression.getValeur() + this.getValeur());
		return resultat;
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
	public ExpressionUnaire verifierAdditionAvecDouble(DoubleExpression doubleExpression) {
		StringExpression resultat = new StringExpression();
		resultat.setValeur(doubleExpression.getValeur() + this.getValeur());
		return resultat;
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
		return expressionUnaire.verifierMultiplicationAvecString(this);
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
	public ExpressionUnaire verifierInferieurAvecBoolean(BooleanExpression doubleExpression)
			throws OperationImpossible {
		throw new OperationImpossible(doubleExpression, this);
	}
	
}
