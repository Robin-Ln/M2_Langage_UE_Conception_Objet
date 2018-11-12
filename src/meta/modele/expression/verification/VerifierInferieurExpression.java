package meta.modele.expression.verification;

import exceptions.OperationImpossible;
import meta.modele.expression.BooleanExpression;
import meta.modele.expression.DoubleExpression;
import meta.modele.expression.ExpressionUnaire;
import meta.modele.expression.IntegerExpression;
import meta.modele.expression.StringExpression;

public interface VerifierInferieurExpression {
	/*
	 * Methodes
	 */

	ExpressionUnaire verifierInferieurAvec(ExpressionUnaire expressionUnaire) throws OperationImpossible;

	ExpressionUnaire verifierInferieurAvecInteger(StringExpression stringExpression) throws OperationImpossible;

	ExpressionUnaire verifierInferieurAvecInteger(IntegerExpression integerExpression) throws OperationImpossible;

	ExpressionUnaire verifierInferieurAvecInteger(DoubleExpression doubleExpression) throws OperationImpossible;
	
	ExpressionUnaire verifierInferieurAvecInteger(BooleanExpression booleanExpression) throws OperationImpossible;

	ExpressionUnaire verifierInferieurAvecString(StringExpression stringExpression) throws OperationImpossible;

	ExpressionUnaire verifierInferieurAvecString(IntegerExpression integerExpression) throws OperationImpossible;

	ExpressionUnaire verifierInferieurAvecString(DoubleExpression doubleExpression) throws OperationImpossible;
	
	ExpressionUnaire verifierInferieurAvecString(BooleanExpression booleanExpression) throws OperationImpossible;

	ExpressionUnaire verifierInferieurAvecDouble(StringExpression stringExpression) throws OperationImpossible;

	ExpressionUnaire verifierInferieurAvecDouble(IntegerExpression integerExpression) throws OperationImpossible;

	ExpressionUnaire verifierInferieurAvecDouble(DoubleExpression doubleExpression) throws OperationImpossible;

	ExpressionUnaire verifierInferieurAvecDouble(BooleanExpression booleanExpression) throws OperationImpossible;

	ExpressionUnaire verifierInferieurAvecBoolean(StringExpression stringExpression) throws OperationImpossible;

	ExpressionUnaire verifierInferieurAvecBoolean(IntegerExpression integerExpression) throws OperationImpossible;

	ExpressionUnaire verifierInferieurAvecBoolean(DoubleExpression doubleExpression) throws OperationImpossible;
	
	ExpressionUnaire verifierInferieurAvecBoolean(BooleanExpression booleanExpression) throws OperationImpossible;

}
