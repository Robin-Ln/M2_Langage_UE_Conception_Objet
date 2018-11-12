package meta.modele.instructions;

import exceptions.PropagationExeption;
import meta.modele.block.Block;
import meta.modele.expression.Expression;
import visiteur.Visiteur;

public class WhileInstruction extends Instruction {

	/*
	 * Attributs
	 */

	private String idExpressionCondition;
	private String idBlock;

	private Expression expressionCondition;
	private Block block;

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

	public String getIdBlock() {
		return idBlock;
	}

	public void setIdBlock(String idBlock) {
		this.idBlock = idBlock;
	}

	public Expression getExpressionCondition() {
		return expressionCondition;
	}

	public void setExpressionCondition(Expression expressionCondition) {
		this.expressionCondition = expressionCondition;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

}
