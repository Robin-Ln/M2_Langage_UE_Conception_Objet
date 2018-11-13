package visiteur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import exceptions.AffectationTypeDifferent;
import exceptions.NotACondition;
import exceptions.OperationImpossible;
import exceptions.ProcedureNonDeclarer;
import exceptions.PropagationExeption;
import exceptions.VarriableNonDeclarer;
import meta.modele.block.Block;
import meta.modele.declaration.Declaration;
import meta.modele.element.ElementProgramme;
import meta.modele.expression.AdditionExpression;
import meta.modele.expression.BooleanExpression;
import meta.modele.expression.DoubleExpression;
import meta.modele.expression.ExpressionUnaire;
import meta.modele.expression.InferieurExpression;
import meta.modele.expression.IntegerExpression;
import meta.modele.expression.MultiplicationExpression;
import meta.modele.expression.Reference;
import meta.modele.expression.StringExpression;
import meta.modele.expression.UnResolveSymbole;
import meta.modele.expression.VarriableReference;
import meta.modele.instructions.Affectation;
import meta.modele.instructions.IfInstruction;
import meta.modele.instructions.ProcedureCall;
import meta.modele.instructions.WhileInstruction;
import meta.modele.procedure.Procedure;
import meta.modele.programme.Programme;

public class VisiteurCalculer implements Visiteur {

	/*
	 * Attributs
	 */

	private Map<String, VarriableReference> varriableReferences;
	private Map<Reference, ExpressionUnaire> affectations;
	private List<Exception> exceptions;
	private Stack<ExpressionUnaire> pile;

	/*
	 * Constucteurs
	 */
	public VisiteurCalculer() {
		this.exceptions = new ArrayList<>();
		this.varriableReferences = new HashMap<>();
		this.affectations = new HashMap<>();
		this.pile = new Stack<>();
	}

	/*
	 * Methodes Implémentés
	 */

	@Override
	public void visite(AdditionExpression additionExpression) throws PropagationExeption {

		additionExpression.getOperandeGauche().accept(this);
		ExpressionUnaire expressionGauche = this.pile.pop();

		additionExpression.getOperandeDroite().accept(this);
		ExpressionUnaire expressionDroite = this.pile.pop();

		try {
			this.pile.push(expressionGauche.verifierAdditionAvec(expressionDroite));
		} catch (OperationImpossible exception) {
			throw new PropagationExeption(exception);
		}
	}

	@Override
	public void visite(MultiplicationExpression multiplicationExpression) throws PropagationExeption {

		multiplicationExpression.getOperandeGauche().accept(this);
		ExpressionUnaire expressionGauche = this.pile.pop();

		multiplicationExpression.getOperandeDroite().accept(this);
		ExpressionUnaire expressionDroite = this.pile.pop();

		try {
			this.pile.push(expressionGauche.verifierMultiplicationAvec(expressionDroite));
		} catch (OperationImpossible exception) {
			throw new PropagationExeption(exception);
		}
	}

	@Override
	public void visite(InferieurExpression inferieurExpression) throws PropagationExeption {
		inferieurExpression.getOperandeGauche().accept(this);
		ExpressionUnaire expressionGauche = this.pile.pop();

		inferieurExpression.getOperandeDroite().accept(this);
		ExpressionUnaire expressionDroite = this.pile.pop();

		try {
			this.pile.push(expressionGauche.verifierInferieurAvec(expressionDroite));
		} catch (OperationImpossible exception) {
			throw new PropagationExeption(exception);
		}
	}

	@Override
	public void visite(IntegerExpression integerExpression) {
		this.pile.push(integerExpression);
	}

	@Override
	public void visite(DoubleExpression doubleExpression) {
		this.pile.push(doubleExpression);
	}

	@Override
	public void visite(StringExpression stringExpression) {
		this.pile.push(stringExpression);
	}

	@Override
	public void visite(BooleanExpression booleanExpression) {
		this.pile.push(booleanExpression);
	}

	@Override
	public void visite(VarriableReference varriableReference) throws PropagationExeption {
		this.affectations.get(varriableReference).accept(this);
	}

	@Override
	public void visite(UnResolveSymbole unResolveSymbole) throws PropagationExeption {
		VarriableReference varriableReference = this.varriableReferences.get(unResolveSymbole.getNom());
		if (varriableReference == null) {
			Exception exception = new VarriableNonDeclarer(unResolveSymbole.getNom());
			this.exceptions.add(exception);
			throw new PropagationExeption(exception);
		}

		varriableReference.accept(this);
	}

	@Override
	public void visite(Affectation affectation) throws PropagationExeption {

		/*
		 * Interpréter l'expression
		 */
		try {
			affectation.getExpression().accept(this);
		} catch (PropagationExeption exception) {
			throw exception;
		}
		ExpressionUnaire expressionUnaire = this.pile.pop();

		/*
		 * associer le symbole à l'expression
		 */
		ExpressionUnaire oldExpressionUnaire = this.affectations.get(affectation.getReference());
		if (oldExpressionUnaire != null && !expressionUnaire.getClass().equals(oldExpressionUnaire.getClass())) {
			Exception exception = new AffectationTypeDifferent(expressionUnaire.getClass(),
					oldExpressionUnaire.getClass());
			this.exceptions.add(exception);
			throw new PropagationExeption(exception);
		}

		this.affectations.put(affectation.getReference(), expressionUnaire);
	}

	@Override
	public void visite(Declaration declaration) throws PropagationExeption {
		this.varriableReferences.put(declaration.getVarriableReference().getNom(), declaration.getVarriableReference());
	}

	@Override
	public void visite(ProcedureCall procedureCall) {
		try {
			Procedure procedure = procedureCall.resolvedProcedure(procedureCall.getNom());
			procedure.traitement(procedureCall.getExpressions(), this);
		} catch (ProcedureNonDeclarer e) {
		}

	}

	@Override
	public void visite(IfInstruction ifInstruction) throws PropagationExeption {
		try {
			ifInstruction.getExpressionCondition().accept(this);
		} catch (PropagationExeption exception) {
			throw new PropagationExeption(exception);
		}
		ExpressionUnaire expressionUnaire = this.pile.pop();
		if (!(expressionUnaire instanceof BooleanExpression)) {
			Exception exception = new NotACondition(expressionUnaire);
			this.exceptions.add(exception);
			throw new PropagationExeption(exception);
		}
		BooleanExpression booleanExpression = (BooleanExpression) expressionUnaire;

		try {
			if (booleanExpression.getValeur()) {
				ifInstruction.getBlockTrue().accept(this);
			} else {
				ifInstruction.getBlockFalse().accept(this);
			}
		} catch (PropagationExeption exception) {
			throw new PropagationExeption(exception);
		}

	}
	
	@Override
	public void visite(WhileInstruction whileInstruction) throws PropagationExeption {
		try {
			whileInstruction.getExpressionCondition().accept(this);
		} catch (PropagationExeption exception) {
			throw new PropagationExeption(exception);
		}
		ExpressionUnaire expressionUnaire = this.pile.pop();
		if (!(expressionUnaire instanceof BooleanExpression)) {
			Exception exception = new NotACondition(expressionUnaire);
			this.exceptions.add(exception);
			throw new PropagationExeption(exception);
		}
		BooleanExpression booleanExpression = (BooleanExpression) expressionUnaire;

		try {
			if (booleanExpression.getValeur()) {
				whileInstruction.getBlock().accept(this);
				whileInstruction.accept(this);
			}
		} catch (PropagationExeption exception) {
			throw new PropagationExeption(exception);
		}
	}

	@Override
	public void visite(Block block) throws PropagationExeption {
		this.visite((Programme) block);
	}

	@Override
	public void visite(Programme programme) throws PropagationExeption {
		for (ElementProgramme elementProgramme : programme.getElements()) {
			elementProgramme.accept(this);
		}
	}

	/*
	 * Accesseurs
	 */

	public Map<Reference, ExpressionUnaire> getAffectations() {
		return affectations;
	}

	public List<Exception> getExceptions() {
		return exceptions;
	}

	public Boolean isValide() {
		return this.exceptions.isEmpty();
	}

	public Stack<ExpressionUnaire> getPile() {
		return pile;
	}

	public Map<String, VarriableReference> getVarriableReferences() {
		return varriableReferences;
	}

	public void setVarriableReferences(Map<String, VarriableReference> varriableReferences) {
		this.varriableReferences = varriableReferences;
	}

	public void setAffectations(Map<Reference, ExpressionUnaire> affectations) {
		this.affectations = affectations;
	}

	public void setExceptions(List<Exception> exceptions) {
		this.exceptions = exceptions;
	}

	public void setPile(Stack<ExpressionUnaire> pile) {
		this.pile = pile;
	}

}
