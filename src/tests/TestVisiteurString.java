package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import exceptions.PropagationExeption;
import meta.modele.expression.AdditionExpression;
import meta.modele.expression.Expression;
import meta.modele.expression.IntegerExpression;
import meta.modele.expression.MultiplicationExpression;
import modele.expression.visiteurs.impl.VisiteurExpressionInterpreteur;
import modele.expression.visiteurs.impl.VisiteurExpressionString;

class TestVisiteurString {

	@Test
	void test1() throws PropagationExeption {
		IntegerExpression integerExpression = new IntegerExpression();
		integerExpression.setValeur(5);
		VisiteurExpressionString visiteurExpressionString = new VisiteurExpressionString();
		integerExpression.accept(visiteurExpressionString);
		assertTrue(visiteurExpressionString.getResultat().equals("5"));
		
		
		VisiteurExpressionInterpreteur visiteurExpressionInterpreteur = new VisiteurExpressionInterpreteur();
		integerExpression.accept(visiteurExpressionInterpreteur);
		Expression expression = visiteurExpressionInterpreteur.getExpressionResultat();
		assertTrue(integerExpression.equals(expression));
	}
	
	@Test
	void test2() throws PropagationExeption {
		
		AdditionExpression additionExpression = new AdditionExpression();
		
		IntegerExpression integerExpression1 = new IntegerExpression();
		integerExpression1.setValeur(5);
		
		IntegerExpression integerExpression2 = new IntegerExpression();
		integerExpression2.setValeur(6);
		
		additionExpression.setOperandeGauche(integerExpression1);
		additionExpression.setOperandeDroite(integerExpression2);
		
		
		VisiteurExpressionString visiteurExpressionString = new VisiteurExpressionString();
		additionExpression.accept(visiteurExpressionString);
		assertTrue(visiteurExpressionString.getResultat().equals("(5+6)"));
		
		
		IntegerExpression integerExpression = new IntegerExpression();
		integerExpression.setValeur(11);
		VisiteurExpressionInterpreteur visiteurExpressionInterpreteur = new VisiteurExpressionInterpreteur();
		integerExpression.accept(visiteurExpressionInterpreteur);
		Expression expression = visiteurExpressionInterpreteur.getExpressionResultat();
		assertTrue(integerExpression.equals(expression));
	}
	
	@Test
	void test3() throws PropagationExeption {
		
		AdditionExpression additionExpression = new AdditionExpression();
		
		IntegerExpression integerExpression1 = new IntegerExpression();
		integerExpression1.setValeur(5);
		
		IntegerExpression integerExpression2 = new IntegerExpression();
		integerExpression2.setValeur(6);
		
		additionExpression.setOperandeGauche(integerExpression1);
		additionExpression.setOperandeDroite(integerExpression2);
		
		MultiplicationExpression multiplicationExpression = new MultiplicationExpression();
		multiplicationExpression.setOperandeGauche(additionExpression);
		multiplicationExpression.setOperandeDroite(additionExpression);
		
		
		
		VisiteurExpressionString visiteurExpressionString = new VisiteurExpressionString();
		multiplicationExpression.accept(visiteurExpressionString);
		assertTrue(visiteurExpressionString.getResultat().equals("((5+6)*(5+6))"));
		
		
		IntegerExpression integerExpression = new IntegerExpression();
		integerExpression.setValeur(121);
		VisiteurExpressionInterpreteur visiteurExpressionInterpreteur = new VisiteurExpressionInterpreteur();
		integerExpression.accept(visiteurExpressionInterpreteur);
		Expression expression = visiteurExpressionInterpreteur.getExpressionResultat();
		assertTrue(integerExpression.equals(expression));
	}


}
