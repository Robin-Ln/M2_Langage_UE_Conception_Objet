package meta.modele.procedure;

import java.util.List;

import meta.modele.expression.Expression;
import visiteur.VisiteurCalculer;

public abstract class Procedure {

	/*
	 * Attributs
	 */
	private String nom;
	private Integer nbArgument;

	/*
	 * Construteurs
	 */
	public Procedure() {
		super();
	}

	public Procedure(String nom) {
		super();
		this.nom = nom;
	}

	/*
	 * méthodes
	 */

	public abstract void traitement(List<Expression> expressions, VisiteurCalculer visiteurCalculer);

	/*
	 * accesseurs
	 */

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNbArgument() {
		return nbArgument;
	}

	public void setNbArgument(Integer nbArgument) {
		this.nbArgument = nbArgument;
	}

}
