package meta.modele.programme;

import java.util.ArrayList;
import java.util.List;

import exceptions.ProcedureNonDeclarer;
import exceptions.PropagationExeption;
import exceptions.VarriableNonDeclarer;
import meta.modele.declaration.Declaration;
import meta.modele.element.ElementProgramme;
import meta.modele.procedure.Print;
import meta.modele.procedure.Procedure;
import visiteur.Visiteur;

public class Programme extends ElementProgramme {

	/*
	 * Attributs
	 */

	private List<ElementProgramme> elements;
	private List<Declaration> declarations;
	private List<Procedure> procedures;
//	private List<Fonction> Fonctions;

	/*
	 * Constructeur
	 */

	public Programme() {
		super();
		this.elements = new ArrayList<>();
		this.declarations = new ArrayList<>();
		this.procedures = new ArrayList<>();
		this.procedures.add(new Print());

		// ajout de primitive
		this.procedures.add(new Print());
	}

	/*
	 * Métodes
	 */

	@Override
	public void accept(Visiteur visiteur) throws PropagationExeption {
		visiteur.visite(this);
	}

	@Override
	public Declaration resolvedVariable(String nom) throws VarriableNonDeclarer {
		for (Declaration declaration : this.declarations) {
			if (declaration.getVarriableReference().getNom().equals(nom)) {
				return declaration;
			}
		}

		if (this.getElementProgrammeParent() != null) {
			return this.getElementProgrammeParent().resolvedVariable(nom);
		}

		throw new VarriableNonDeclarer(nom);
	}

	@Override
	public Procedure resolvedProcedure(String nom) throws ProcedureNonDeclarer {

		for (Procedure procedure : this.procedures) {
			if (procedure.getNom().equals(nom)) {
				return procedure;
			}
		}

		if (this.getElementProgrammeParent() != null) {
			return this.getElementProgrammeParent().resolvedProcedure(nom);
		}

		throw new ProcedureNonDeclarer(nom);
	}

	/*
	 * Accesserus
	 */

	public List<Declaration> getDeclarations() {
		return declarations;
	}

	public void setDeclarations(List<Declaration> declarations) {
		this.declarations = declarations;
	}

	public List<ElementProgramme> getElements() {
		return elements;
	}

	public void setElements(List<ElementProgramme> elements) {
		this.elements = elements;
	}

	public List<Procedure> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<Procedure> procedures) {
		this.procedures = procedures;
	}

}
