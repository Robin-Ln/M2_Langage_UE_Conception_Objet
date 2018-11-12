package meta.modele.element;

import exceptions.ProcedureNonDeclarer;
import exceptions.VarriableNonDeclarer;
import meta.modele.declaration.Declaration;
import meta.modele.procedure.Procedure;
import visiteur.Visitable;

public abstract class ElementProgramme implements Visitable {

	/*
	 * Attributs
	 */

	private ElementProgramme elementProgrammeParent;

	/*
	 * Constructeurs
	 */

	public ElementProgramme() {
		super();
	}

	/*
	 * Methodes
	 */

	
	public Declaration resolvedVariable(String nom) throws VarriableNonDeclarer {

		if (this.getElementProgrammeParent() != null) {
			return this.getElementProgrammeParent().resolvedVariable(nom);
		}

		throw new VarriableNonDeclarer(nom);
	}

	
	public Procedure resolvedProcedure(String nom) throws ProcedureNonDeclarer {

		if (this.getElementProgrammeParent() != null) {
			return this.getElementProgrammeParent().resolvedProcedure(nom);
		}

		throw new ProcedureNonDeclarer(nom);
	}

	/*
	 * Accesseurs
	 */

	public ElementProgramme getElementProgrammeParent() {
		return elementProgrammeParent;
	}

	public void setElementProgrammeParent(ElementProgramme elementProgrammeParent) {
		this.elementProgrammeParent = elementProgrammeParent;
	}

}
