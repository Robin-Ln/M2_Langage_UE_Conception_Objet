package visiteur;

import exceptions.PropagationExeption;
import meta.modele.block.Block;
import meta.modele.declaration.Declaration;
import meta.modele.element.ElementProgramme;
import meta.modele.expression.AdditionExpression;
import meta.modele.expression.BooleanExpression;
import meta.modele.expression.DoubleExpression;
import meta.modele.expression.InferieurExpression;
import meta.modele.expression.IntegerExpression;
import meta.modele.expression.MultiplicationExpression;
import meta.modele.expression.StringExpression;
import meta.modele.expression.UnResolveSymbole;
import meta.modele.expression.VarriableReference;
import meta.modele.instructions.Affectation;
import meta.modele.instructions.IfInstruction;
import meta.modele.instructions.ProcedureCall;
import meta.modele.programme.Programme;

public class VisiteurAfficher implements Visiteur {

	/*
	 * Attributs
	 */

	String resultat;
	Integer tabultation;

	/*
	 * Constucteurs
	 */

	public VisiteurAfficher() {
		this.resultat = new String();
		this.tabultation = 0;
	}

	/*
	 * Methodes Implémentés
	 */

	@Override
	public void visite(IntegerExpression integerExpression) {
		this.resultat += integerExpression.getValeur();
	}

	@Override
	public void visite(DoubleExpression doubleExpression) {
		this.resultat += doubleExpression.getValeur();
	}

	@Override
	public void visite(AdditionExpression additionExpression) throws PropagationExeption {

		this.resultat += "(";
		additionExpression.getOperandeGauche().accept(this);
		this.resultat += "+";
		additionExpression.getOperandeDroite().accept(this);
		this.resultat += ")";
	}

	@Override
	public void visite(MultiplicationExpression multiplicationExpression) throws PropagationExeption {
		this.resultat += "(";
		multiplicationExpression.getOperandeGauche().accept(this);
		this.resultat += "*";
		multiplicationExpression.getOperandeDroite().accept(this);
		this.resultat += ")";
	}

	@Override
	public void visite(InferieurExpression inferieurExpression) throws PropagationExeption {
		this.resultat += "(";
		inferieurExpression.getOperandeGauche().accept(this);
		this.resultat += "<";
		inferieurExpression.getOperandeDroite().accept(this);
		this.resultat += ")";
	}

	@Override
	public void visite(StringExpression stringExpression) {
		this.resultat += "\"";
		this.resultat += stringExpression.getValeur();
		this.resultat += "\"";
	}

	@Override
	public void visite(BooleanExpression booleanExpression) throws PropagationExeption {
		this.resultat += booleanExpression.getValeur();
	}

	@Override
	public void visite(VarriableReference varriableReference) {
		this.resultat += varriableReference.getNom();
	}

	@Override
	public void visite(UnResolveSymbole unResolveSymbole) {
		this.resultat += unResolveSymbole.getNom();
	}

	@Override
	public void visite(Declaration declaration) {
		try {
			this.resultat += "var ";
			declaration.getVarriableReference().accept(this);
			this.resultat += ";\n";
		} catch (PropagationExeption e) {
		}
	}

	@Override
	public void visite(Affectation affectation) {
		try {
			affectation.getReference().accept(this);
			this.resultat += " = ";
			affectation.getExpression().accept(this);
			this.resultat += ";\n";
		} catch (PropagationExeption e) {
		}
	}

	@Override
	public void visite(Programme programme) {
		for (Declaration declaration : programme.getDeclarations()) {
			try {
				this.afficherTabulation();
				declaration.accept(this);
			} catch (PropagationExeption e) {
			}
		}

		for (ElementProgramme elementProgramme : programme.getElements()) {
			try {
				this.afficherTabulation();
				elementProgramme.accept(this);
			} catch (PropagationExeption e) {
			}
		}
	}

	@Override
	public void visite(ProcedureCall procedureCall) {
		this.resultat += procedureCall.getNom();
		this.resultat += "(";
		for (int i = 0; i < procedureCall.getExpressions().size(); i++) {
			try {
				procedureCall.getExpressions().get(i).accept(this);
			} catch (PropagationExeption e) {
			}
			if (i != (procedureCall.getExpressions().size() - 1)) {
				this.resultat += ", ";
			}
		}
		this.resultat += ");\n";
	}

	@Override
	public void visite(IfInstruction ifInstruction) throws PropagationExeption {
		this.resultat += "if (";
		ifInstruction.getExpressionCondition().accept(this);
		this.resultat += " )";
		ifInstruction.getBlockTrue().accept(this);
		if (ifInstruction.getBlockFalse() != null) {
			this.resultat += "else";
			ifInstruction.getBlockFalse().accept(this);
		}
		this.resultat += "\n";
	}

	@Override
	public void visite(Block block) throws PropagationExeption {
		this.tabultation++;
		this.resultat += "{\n";
		this.visite((Programme) block);
		this.tabultation--;
		this.resultat += "}";

	}

	private void afficherTabulation() {
		for (int i = 0; i < this.tabultation; i++) {
			this.resultat += "   ";
		}
	}

	/*
	 * Accesseurs
	 */

	public String getResultat() {
		String res = this.resultat;
		this.resultat = "";
		return res;
	}

}
