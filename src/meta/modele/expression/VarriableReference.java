package meta.modele.expression;

import exceptions.PropagationExeption;
import exceptions.VarriableNonDeclarer;
import meta.modele.declaration.Declaration;
import visiteur.Visiteur;

public class VarriableReference extends Reference {

	/*
	 * Constructeur
	 */
	public VarriableReference() {
		super();
	}

	public VarriableReference(String nom) {
		super(nom);
	}

	/*
	 * Methodes
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (!(obj instanceof VarriableReference)) {
			return false;
		}

		VarriableReference varriableReference = (VarriableReference) obj;

		if (this.getNom().equals(varriableReference.getNom())) {
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return "Symbole [nom=" + getNom() + "]";
	}

	@Override
	public void accept(Visiteur visiteur) throws PropagationExeption {
		visiteur.visite(this);
	}

	public Declaration resolved() throws VarriableNonDeclarer {
		return this.getElementProgrammeParent().resolvedVariable(getNom());
	}

}
