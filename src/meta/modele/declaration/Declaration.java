package meta.modele.declaration;

import exceptions.PropagationExeption;
import meta.modele.element.ElementProgramme;
import meta.modele.expression.VarriableReference;
import visiteur.Visiteur;

public class Declaration extends ElementProgramme {

	/*
	 * Attributs
	 */

	VarriableReference varriableReference;

	/*
	 * Constructeur
	 */
	public Declaration() {
		super();
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
		return "Declaration []";
	}

	/*
	 * Accesseurs
	 */
	public VarriableReference getVarriableReference() {
		return varriableReference;
	}

	public void setVarriableReference(VarriableReference varriableReference) {
		this.varriableReference = varriableReference;
	}

}
