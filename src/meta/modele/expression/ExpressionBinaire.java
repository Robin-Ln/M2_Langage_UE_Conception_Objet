package meta.modele.expression;

/**
 * Class qui permet la représentation d'expression avec deux opérandes
 * 
 * @author Robin LOUARN
 *
 */
public abstract class ExpressionBinaire extends Expression {

	/*
	 * Attributs
	 */

	private Expression operandeGauche;

	private Expression operandeDroite;

	private String idOperandeGauche;

	private String idOperandeDroite;

	/*
	 * Constructeurs
	 */
	public ExpressionBinaire() {
		super();
	}
	
	public ExpressionBinaire(Expression operandeGauche, Expression operandeDroite) {
		super();
		this.setOperandeGauche(operandeGauche);
		this.setOperandeDroite(operandeDroite);
	}

	/*
	 * Accesseurs
	 */

	

	public Expression getOperandeGauche() {
		return operandeGauche;
	}

	public void setOperandeGauche(Expression operandeGauche) {
		this.operandeGauche = operandeGauche;
	}

	public Expression getOperandeDroite() {
		return operandeDroite;
	}

	public void setOperandeDroite(Expression operandeDroite) {
		this.operandeDroite = operandeDroite;
	}

	public String getIdOperandeGauche() {
		return idOperandeGauche;
	}

	public void setIdOperandeGauche(String idOperandeGauche) {
		this.idOperandeGauche = idOperandeGauche;
	}

	public String getIdOperandeDroite() {
		return idOperandeDroite;
	}

	public void setIdOperandeDroite(String idOperandeDroite) {
		this.idOperandeDroite = idOperandeDroite;
	}

}
