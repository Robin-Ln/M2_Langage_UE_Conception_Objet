package meta.modele.instructions;

import java.util.ArrayList;
import java.util.List;

import exceptions.PropagationExeption;
import meta.modele.expression.Expression;
import visiteur.Visiteur;

public class ProcedureCall extends Instruction {
	
	/*
	 * Attributs
	 */
	private String nom;
	private List<Expression> expressions;
	
	
	/*
	 * Constructeurs
	 */
	public ProcedureCall() {
		super();
		this.expressions = new ArrayList<>();
	}
	
	public ProcedureCall(String nom, List<Expression> expressions) {
		super();
		this.nom = nom;
		this.expressions = expressions;
	}
	
	/*
	 * Methodes
	 */
	@Override
	public void accept(Visiteur visiteur) throws PropagationExeption {
		visiteur.visite(this);
	}
	
	
	/*
	 * Accesseurs
	 */
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Expression> getExpressions() {
		return expressions;
	}

	public void setExpressions(List<Expression> expressions) {
		this.expressions = expressions;
	}

}
