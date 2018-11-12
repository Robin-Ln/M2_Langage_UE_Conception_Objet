package meta.modele.expression.verification;

import exceptions.OperationImpossible;
import meta.modele.expression.BooleanExpression;
import meta.modele.expression.DoubleExpression;
import meta.modele.expression.ExpressionUnaire;
import meta.modele.expression.IntegerExpression;
import meta.modele.expression.StringExpression;

public interface VerifierAdditionExpression {
	/*
	 * Methodes
	 */

	ExpressionUnaire verifierAdditionAvec(ExpressionUnaire expressionUnaire) throws OperationImpossible;

	ExpressionUnaire verifierAdditionAvecInteger(StringExpression stringExpression) throws OperationImpossible;

	ExpressionUnaire verifierAdditionAvecInteger(IntegerExpression integerExpression) throws OperationImpossible;

	ExpressionUnaire verifierAdditionAvecInteger(DoubleExpression doubleExpression) throws OperationImpossible;
	
	ExpressionUnaire verifierAdditionAvecInteger(BooleanExpression booleanExpression) throws OperationImpossible;

	ExpressionUnaire verifierAdditionAvecString(StringExpression stringExpression) throws OperationImpossible;

	ExpressionUnaire verifierAdditionAvecString(IntegerExpression integerExpression) throws OperationImpossible;

	ExpressionUnaire verifierAdditionAvecString(DoubleExpression doubleExpression) throws OperationImpossible;
	
	ExpressionUnaire verifierAdditionAvecString(BooleanExpression booleanExpression) throws OperationImpossible;

	ExpressionUnaire verifierAdditionAvecDouble(StringExpression stringExpression) throws OperationImpossible;

	ExpressionUnaire verifierAdditionAvecDouble(IntegerExpression integerExpression) throws OperationImpossible;

	ExpressionUnaire verifierAdditionAvecDouble(DoubleExpression doubleExpression) throws OperationImpossible;

	ExpressionUnaire verifierAdditionAvecDouble(BooleanExpression booleanExpression) throws OperationImpossible;

	ExpressionUnaire verifierAdditionAvecBoolean(StringExpression stringExpression) throws OperationImpossible;

	ExpressionUnaire verifierAdditionAvecBoolean(IntegerExpression integerExpression) throws OperationImpossible;

	ExpressionUnaire verifierAdditionAvecBoolean(DoubleExpression doubleExpression) throws OperationImpossible;
	
	ExpressionUnaire verifierAdditionAvecBoolean(BooleanExpression doubleExpression) throws OperationImpossible;


}
