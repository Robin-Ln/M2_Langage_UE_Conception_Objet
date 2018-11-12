package meta.modele.procedure;

import java.util.List;

import exceptions.PropagationExeption;
import meta.modele.expression.Expression;
import meta.modele.expression.ExpressionUnaire;
import visiteur.VisiteurAfficher;
import visiteur.VisiteurCalculer;

public class Print extends Procedure {

	public Print() {
		this.setNom("print");
		this.setNbArgument(1);
	}

	@Override
	public void traitement(List<Expression> expressions, VisiteurCalculer visiteurCalculer) {
		for (Expression expression : expressions) {
			try {
				expression.accept(visiteurCalculer);
				ExpressionUnaire expressionUnaire =visiteurCalculer.getPile().pop();
				VisiteurAfficher visiteurAfficher = new VisiteurAfficher();
				expressionUnaire.accept(visiteurAfficher);
				System.out.println(visiteurAfficher.getResultat());
			} catch (PropagationExeption e) {
			}
		}
	}

}
