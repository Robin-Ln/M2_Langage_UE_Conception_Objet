package meta.modele.expression;

import meta.modele.element.ElementProgramme;

/**
 * Classe qui décrit une expression
 * 
 * @author Robin LOUARN
 *
 */
public abstract class Expression extends ElementProgramme {

	/*
	 * Attributs
	 */

	private String id;

	/*
	 * Constructeur
	 */

	public Expression() {
		super();
	}

	/*
	 * Accesseurs
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
