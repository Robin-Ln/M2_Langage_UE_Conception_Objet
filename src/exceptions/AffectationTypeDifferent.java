package exceptions;

import meta.modele.expression.ExpressionUnaire;

public class AffectationTypeDifferent extends Exception{

	/*
	 * Attributs
	 */
	private static final long serialVersionUID = 821318648434205285L;
	
	Class<? extends ExpressionUnaire> typeSymbole;
	Class<? extends ExpressionUnaire> typeExpressionUnaire;
	
	
	/*
	 * Constructeur
	 */
	public AffectationTypeDifferent(Class<? extends ExpressionUnaire> typeSymbole,
			Class<? extends ExpressionUnaire> typeExpressionUnaire) {
		super();
		this.typeSymbole = typeSymbole;
		this.typeExpressionUnaire = typeExpressionUnaire;
	}


	@Override
	public String toString() {
		return "AffectationTypeDifferent [typeSymbole=" 
				+ typeSymbole.getSimpleName() 
				+ ", typeExpressionUnaire=" 
				+ typeExpressionUnaire.getSimpleName()
				+ "]";
	}
}
