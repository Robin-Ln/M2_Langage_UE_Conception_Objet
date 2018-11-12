package meta.modele.expression;

public abstract class Reference extends Expression{
	
	/*
	 * Attributs
	 */

	private String nom;

	/*
	 * Constructeur
	 */
	public Reference() {
		super();
	}

	public Reference(String nom) {
		super();
		this.nom = nom;
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

}
