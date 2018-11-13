package tests;
/*

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.PropagationExeption;
import meta.modele.declaration.Declaration;
import meta.modele.expression.AdditionExpression;
import meta.modele.expression.DoubleExpression;
import meta.modele.expression.Expression;
import meta.modele.expression.IntegerExpression;
import meta.modele.expression.MultiplicationExpression;
import meta.modele.expression.StringExpression;
import meta.modele.expression.UnResolveSymbole;
import meta.modele.instructions.Affectation;
import modele.expression.visiteurs.impl.VisiteurExpressionInterpreteur;
import modele.symbole.Symbole;
*/

class TestInterpreteur {
	/*

	private StringExpression stringExpression;
	private IntegerExpression integerExpression;
	private DoubleExpression doubleExpression;

	private UnResolveSymbole unResolveSymbole;

	private Symbole integerSymbole;
	private Symbole doubleSymbole;

	private AdditionExpression additionExpression;
	private MultiplicationExpression multiplicationExpression;

	private VisiteurExpressionInterpreteur visiteurExpressionInterpreteur;

	@BeforeEach
	void init() {
		this.stringExpression = new StringExpression("string");
		this.integerExpression = new IntegerExpression(2);
		this.doubleExpression = new DoubleExpression(2.0);

		this.unResolveSymbole = new UnResolveSymbole("x");

		this.integerSymbole = new Symbole("integerSymbole", IntegerExpression.class);
		this.doubleSymbole = new Symbole("doubleSymbole", DoubleExpression.class);

		this.visiteurExpressionInterpreteur = new VisiteurExpressionInterpreteur();

		this.additionExpression = null;
		this.multiplicationExpression = null;
	}

	/*
	 * Addition test
	 */
/*
	@Test
	void additionIntegerInteger() {
		this.additionExpression = new AdditionExpression(this.integerExpression, this.integerExpression);

		try {
			this.additionExpression.accept(this.visiteurExpressionInterpreteur);
			Expression expression = this.visiteurExpressionInterpreteur.getExpressionResultat();
			Expression expressionResult = new IntegerExpression(4);
			assertTrue(expression.equals(expressionResult));
		} catch (PropagationExeption e) {
			assertTrue(false);
		}
	}

	@Test
	void additionIntegerDouble() {
		this.additionExpression = new AdditionExpression(this.integerExpression, this.doubleExpression);

		try {
			this.additionExpression.accept(this.visiteurExpressionInterpreteur);
			Expression expression = this.visiteurExpressionInterpreteur.getExpressionResultat();
			Expression expressionResult = new DoubleExpression(4.0);
			assertTrue(expression.equals(expressionResult));
		} catch (PropagationExeption e) {
			assertTrue(false);
		}
	}

	@Test
	void additionIntegerString() {
		this.additionExpression = new AdditionExpression(this.integerExpression, this.stringExpression);

		try {
			this.additionExpression.accept(this.visiteurExpressionInterpreteur);
			Expression expression = this.visiteurExpressionInterpreteur.getExpressionResultat();
			Expression expressionResult = new StringExpression("2string");
			assertTrue(expression.equals(expressionResult));
		} catch (PropagationExeption e) {
			assertTrue(false);
		}
	}

	@Test
	void additionDoubleInteger() {
		this.additionExpression = new AdditionExpression(this.doubleExpression, this.integerExpression);

		try {
			this.additionExpression.accept(this.visiteurExpressionInterpreteur);
			Expression expression = this.visiteurExpressionInterpreteur.getExpressionResultat();
			Expression expressionResult = new DoubleExpression(4.0);
			assertTrue(expression.equals(expressionResult));
		} catch (PropagationExeption e) {
			assertTrue(false);
		}
	}

	@Test
	void additionDoubleDouble() {
		this.additionExpression = new AdditionExpression(this.doubleExpression, this.doubleExpression);

		try {
			this.additionExpression.accept(this.visiteurExpressionInterpreteur);
			Expression expression = this.visiteurExpressionInterpreteur.getExpressionResultat();
			Expression expressionResult = new DoubleExpression(4.0);
			assertTrue(expression.equals(expressionResult));
		} catch (PropagationExeption e) {
			assertTrue(false);
		}
	}

	@Test
	void additionDoubleString() {
		this.additionExpression = new AdditionExpression(this.doubleExpression, this.stringExpression);

		try {
			this.additionExpression.accept(this.visiteurExpressionInterpreteur);
			Expression expression = this.visiteurExpressionInterpreteur.getExpressionResultat();
			Expression expressionResult = new StringExpression("2.0string");
			assertTrue(expression.equals(expressionResult));
		} catch (PropagationExeption e) {
			assertTrue(false);
		}
	}

	@Test
	void additionStringInteger() {
		this.additionExpression = new AdditionExpression(this.stringExpression, this.integerExpression);

		try {
			this.additionExpression.accept(this.visiteurExpressionInterpreteur);
			Expression expression = this.visiteurExpressionInterpreteur.getExpressionResultat();
			Expression expressionResult = new StringExpression("string2");
			assertTrue(expression.equals(expressionResult));
		} catch (PropagationExeption e) {
			assertTrue(false);
		}
	}

	@Test
	void additionStringDouble() {
		this.additionExpression = new AdditionExpression(this.stringExpression, this.doubleExpression);

		try {
			this.additionExpression.accept(this.visiteurExpressionInterpreteur);
			Expression expression = this.visiteurExpressionInterpreteur.getExpressionResultat();
			Expression expressionResult = new StringExpression("string2.0");
			assertTrue(expression.equals(expressionResult));
		} catch (PropagationExeption e) {
			assertTrue(false);
		}
	}

	@Test
	void additionStringString() {
		this.additionExpression = new AdditionExpression(this.stringExpression, this.stringExpression);

		try {
			this.additionExpression.accept(this.visiteurExpressionInterpreteur);
			Expression expression = this.visiteurExpressionInterpreteur.getExpressionResultat();
			Expression expressionResult = new StringExpression("stringstring");
			assertTrue(expression.equals(expressionResult));
		} catch (PropagationExeption e) {
			assertTrue(false);
		}
	}

	/*
	 * Multiplication test
	 */
/*
	@Test
	void multiplicationIntegerInteger() {
		this.multiplicationExpression = new MultiplicationExpression(this.integerExpression, this.integerExpression);

		try {
			this.multiplicationExpression.accept(this.visiteurExpressionInterpreteur);
			Expression expression = this.visiteurExpressionInterpreteur.getExpressionResultat();
			Expression expressionResult = new IntegerExpression(4);
			assertTrue(expression.equals(expressionResult));
		} catch (PropagationExeption e) {
			assertTrue(false);
		}
	}

	@Test
	void multiplicationIntegerDouble() {
		this.multiplicationExpression = new MultiplicationExpression(this.integerExpression, this.doubleExpression);

		try {
			this.multiplicationExpression.accept(this.visiteurExpressionInterpreteur);
			Expression expression = this.visiteurExpressionInterpreteur.getExpressionResultat();
			Expression expressionResult = new DoubleExpression(4.0);
			assertTrue(expression.equals(expressionResult));
		} catch (PropagationExeption e) {
			assertTrue(false);
		}
	}

	@Test
	void multiplicationIntegerString() {
		this.multiplicationExpression = new MultiplicationExpression(this.integerExpression, this.stringExpression);

		try {
			this.multiplicationExpression.accept(this.visiteurExpressionInterpreteur);
			assertTrue(false);
		} catch (PropagationExeption e) {
			assertTrue(true);
		}
	}

	@Test
	void multiplicationDoubleInteger() {
		this.multiplicationExpression = new MultiplicationExpression(this.doubleExpression, this.integerExpression);

		try {
			this.multiplicationExpression.accept(this.visiteurExpressionInterpreteur);
			Expression expression = this.visiteurExpressionInterpreteur.getExpressionResultat();
			Expression expressionResult = new DoubleExpression(4.0);
			assertTrue(expression.equals(expressionResult));
		} catch (PropagationExeption e) {
			assertTrue(false);
		}
	}

	@Test
	void multiplicationDoubleDouble() {
		this.multiplicationExpression = new MultiplicationExpression(this.doubleExpression, this.doubleExpression);

		try {
			this.multiplicationExpression.accept(this.visiteurExpressionInterpreteur);
			Expression expression = this.visiteurExpressionInterpreteur.getExpressionResultat();
			Expression expressionResult = new DoubleExpression(4.0);
			assertTrue(expression.equals(expressionResult));
		} catch (PropagationExeption e) {
			assertTrue(false);
		}
	}

	@Test
	void multiplicationDoubleString() {
		this.multiplicationExpression = new MultiplicationExpression(this.doubleExpression, this.stringExpression);

		try {
			this.multiplicationExpression.accept(this.visiteurExpressionInterpreteur);
			assertTrue(false);
		} catch (PropagationExeption e) {
			assertTrue(true);
		}
	}

	@Test
	void multiplicationStringInteger() {
		this.multiplicationExpression = new MultiplicationExpression(this.stringExpression, this.integerExpression);

		try {
			this.multiplicationExpression.accept(this.visiteurExpressionInterpreteur);
			assertTrue(false);
		} catch (PropagationExeption e) {
			assertTrue(true);
		}
	}

	@Test
	void multiplicationStringDouble() {
		this.multiplicationExpression = new MultiplicationExpression(this.stringExpression, this.doubleExpression);

		try {
			this.multiplicationExpression.accept(this.visiteurExpressionInterpreteur);
			assertTrue(false);
		} catch (PropagationExeption e) {
			assertTrue(true);
		}
	}

	@Test
	void multiplicationStringString() {
		this.multiplicationExpression = new MultiplicationExpression(this.stringExpression, this.stringExpression);

		try {
			this.multiplicationExpression.accept(this.visiteurExpressionInterpreteur);
			assertTrue(false);
		} catch (PropagationExeption e) {
			assertTrue(true);
		}
	}

	/*
	 * tester Exeptions
	 */
/*
	@Test
	void affectationIntegerIntger() {
		Declaration declaration = this.visiteurExpressionInterpreteur.ajouterSymbole(integerSymbole);
		if (!declaration.getExceptions().isEmpty()) {
			assertTrue(false);
		}
		Affectation affectation = this.visiteurExpressionInterpreteur.ajouterAffectation("integerSymbole",
				this.integerExpression);
		if (!affectation.getExceptions().isEmpty()) {
			assertTrue(false);
		}
		assertTrue(true);
	}

	@Test
	void varriableNonDeclarer() {
		Affectation affectation = this.visiteurExpressionInterpreteur.ajouterAffectation("integerSymbole",
				this.integerExpression);
		if (affectation.getExceptions().isEmpty()) {
			assertTrue(false);
		}
		assertTrue(true);

	}

	@Test
	void varriableNonDeclarer2() {
		try {
			this.visiteurExpressionInterpreteur.ajouterSymbole(doubleSymbole);
			this.multiplicationExpression = new MultiplicationExpression(this.stringExpression, this.unResolveSymbole);
			this.multiplicationExpression.accept(this.visiteurExpressionInterpreteur);
			assertTrue(false);
		} catch (PropagationExeption e) {
			assertTrue(e.toString()
					.equals("PropagationExeption [" + "exception=VarriableNonDeclarer [" + "nomSymbole=x" + "]" + "]"));
		}
	}

	@Test
	void varriableNonInitialiser() {
		try {
			this.visiteurExpressionInterpreteur.ajouterSymbole(doubleSymbole);
			this.multiplicationExpression = new MultiplicationExpression(this.stringExpression,
					new UnResolveSymbole("doubleSymbole"));
			this.multiplicationExpression.accept(this.visiteurExpressionInterpreteur);
			assertTrue(false);
		} catch (PropagationExeption e) {
			System.out.println(e);
			assertTrue(true);
		}
	}
	*/
}
