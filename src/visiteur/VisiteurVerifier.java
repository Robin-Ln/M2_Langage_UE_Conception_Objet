package visiteur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.NomVarriableEnDouble;
import exceptions.NombreParametreDifferent;
import exceptions.ProcedureNonDeclarer;
import exceptions.PropagationExeption;
import exceptions.VarriableNonDeclarer;
import exceptions.VarriableNonUtiliser;
import meta.modele.block.Block;
import meta.modele.declaration.Declaration;
import meta.modele.element.ElementProgramme;
import meta.modele.expression.AdditionExpression;
import meta.modele.expression.BooleanExpression;
import meta.modele.expression.DoubleExpression;
import meta.modele.expression.Expression;
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
import meta.modele.procedure.Procedure;
import meta.modele.programme.Programme;

public class VisiteurVerifier implements Visiteur {

	/*
	 * Attributs
	 */

	private Map<Reference, Expression> affectation;
	private List<Exception> exceptions;
	private List<VarriableReference> varriableReferences;

	/*
	 * Constucteurs
	 */
	public VisiteurVerifier() {
		this.exceptions = new ArrayList<>();
		this.affectation = new HashMap<>();
		this.varriableReferences = new ArrayList<>();
	}

	/*
	 * Methodes Implémentés
	 */

	@Override
	public void visite(AdditionExpression additionExpression) throws PropagationExeption {
		additionExpression.getOperandeGauche().accept(this);
		additionExpression.getOperandeDroite().accept(this);
	}

	@Override
	public void visite(MultiplicationExpression multiplicationExpression) throws PropagationExeption {
		multiplicationExpression.getOperandeGauche().accept(this);
		multiplicationExpression.getOperandeDroite().accept(this);
	}

	@Override
	public void visite(InferieurExpression inferieurExpression) throws PropagationExeption {
		inferieurExpression.getOperandeGauche().accept(this);
		inferieurExpression.getOperandeDroite().accept(this);
	}

	@Override
	public void visite(IntegerExpression integerExpression) {
	}

	@Override
	public void visite(DoubleExpression doubleExpression) {
	}

	@Override
	public void visite(StringExpression stringExpression) {
	}

	@Override
	public void visite(BooleanExpression booleanExpression) {
	}

	@Override
	public void visite(VarriableReference varriableReference) throws PropagationExeption {
	}

	@Override
	public void visite(UnResolveSymbole unResolveSymbole) throws PropagationExeption {
		Exception exception = new VarriableNonDeclarer(unResolveSymbole.getNom());
		this.exceptions.add(exception);
		throw new PropagationExeption(exception);
	}

	@Override
	public void visite(Affectation affectation) throws PropagationExeption {

		/*
		 * récupérer le symbole dans la table des symboles
		 */
		try {
			affectation.getReference().accept(this);
		} catch (PropagationExeption exeption) {
			throw exeption;
		}

		try {
			affectation.getExpression().accept(this);
		} catch (PropagationExeption exeption) {
			throw exeption;
		}

		this.affectation.put(affectation.getReference(), affectation.getExpression());
	}

	@Override
	public void visite(Declaration declaration) throws PropagationExeption {
		/*
		 * Est ce que le symbole existe deja
		 */
		VarriableReference varriableReference = declaration.getVarriableReference();
		if (this.varriableReferences.contains(varriableReference)) {
			Exception exception = new NomVarriableEnDouble(declaration.getVarriableReference().getNom());
			this.exceptions.add(exception);
			throw new PropagationExeption(exception);
		}

		this.varriableReferences.add(varriableReference);
		this.affectation.put(declaration.getVarriableReference(), null);

	}

	@Override
	public void visite(ProcedureCall procedureCall) throws PropagationExeption {
		try {
			String nomProcedure = procedureCall.getNom();
			Procedure procedure = procedureCall.resolvedProcedure(nomProcedure);
			if (procedureCall.getExpressions().size() != procedure.getNbArgument()) {
				Exception exception = new NombreParametreDifferent(nomProcedure);
				this.exceptions.add(exception);
				throw new PropagationExeption(exception);
			}
		} catch (ProcedureNonDeclarer exception) {
			this.exceptions.add(exception);
			throw new PropagationExeption(exception);
		}
	}

	@Override
	public void visite(Programme programme) {
		for (ElementProgramme elementProgramme : programme.getDeclarations()) {
			try {
				elementProgramme.accept(this);
			} catch (PropagationExeption e) {
			}
		}

		for (ElementProgramme elementProgramme : programme.getElements()) {
			try {
				elementProgramme.accept(this);
			} catch (PropagationExeption e) {
			}
		}

		/*
		 * Varriable utiliser ?
		 */
		for (Declaration declaration : programme.getDeclarations()) {
			Reference reference = declaration.getVarriableReference();
			if (this.affectation.get(reference) == null) {
				this.exceptions.add(new VarriableNonUtiliser(reference));
			}
		}
	}

	@Override
	public void visite(IfInstruction ifInstruction) throws PropagationExeption {
		try {
			ifInstruction.getExpressionCondition().accept(this);
		} catch (PropagationExeption exception) {
			throw new PropagationExeption(exception);
		}

		try {
			ifInstruction.getBlockTrue().accept(this);
		} catch (PropagationExeption exception) {
			throw new PropagationExeption(exception);
		}

		try {
			ifInstruction.getBlockFalse().accept(this);
		} catch (PropagationExeption exception) {
			throw new PropagationExeption(exception);
		}

	}

	@Override
	public void visite(Block block) throws PropagationExeption {
		this.visite((Programme) block);
	}

	/*
	 * Accesseurs
	 */

	public List<Exception> getExceptions() {
		return exceptions;
	}

	public Boolean isValide() {
		return this.exceptions.isEmpty();
	}

}
