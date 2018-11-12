package meta.modele.instructions;

import exceptions.PropagationExeption;
import meta.modele.block.Block;
import meta.modele.expression.Expression;
import visiteur.Visiteur;

public class If extends Instruction {

	/*
	 * Attributs
	 */

	private String idExpressionCondition;
	private String idBlockTrue;
	private String idBlockFalse;

	private Expression expressionCondition;
	private Block blockTrue;
	private Block blockFalse;

	/*
	 * Methodes
	 */

	@Override
	public void accept(Visiteur visiteur) throws PropagationExeption {
		visiteur.visite(this);
	}

	
	
	/*
	 * Accesseurs
	 */
	public String getIdExpressionCondition() {
		return idExpressionCondition;
	}

	public void setIdExpressionCondition(String idExpressionCondition) {
		this.idExpressionCondition = idExpressionCondition;
	}

	public String getIdBlockTrue() {
		return idBlockTrue;
	}

	public void setIdBlockTrue(String idBlockTrue) {
		this.idBlockTrue = idBlockTrue;
	}

	public String getIdBlockFalse() {
		return idBlockFalse;
	}

	public void setIdBlockFalse(String idBlockFalse) {
		this.idBlockFalse = idBlockFalse;
	}

	public Expression getExpressionCondition() {
		return expressionCondition;
	}

	public void setExpressionCondition(Expression expressionCondition) {
		this.expressionCondition = expressionCondition;
	}

	public Block getBlockTrue() {
		return blockTrue;
	}

	public void setBlockTrue(Block blockTrue) {
		this.blockTrue = blockTrue;
	}

	public Block getBlockFalse() {
		return blockFalse;
	}

	public void setBlockFalse(Block blockFalse) {
		this.blockFalse = blockFalse;
	}
	

}
