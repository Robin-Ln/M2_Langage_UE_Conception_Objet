package meta.modele.expression;

import exceptions.PropagationExeption;
import visiteur.Visiteur;

public class UnResolveSymbole extends Reference {

	/*
	 * Constructeur
	 */
	public UnResolveSymbole() {
		super();
	}

	public UnResolveSymbole(String nom) {
		super(nom);
	}

	/*
	 * Methodes
	 */

	@Override
	public void accept(Visiteur visiteur) throws PropagationExeption {
		visiteur.visite(this);
	}

	@Override
	public String toString() {
		return "UnResolveSymbole [" + "Id()=" + getId() + ", nom=" + this.getNom() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("UnResolveSymbole equals");
		return false;
	}

}
