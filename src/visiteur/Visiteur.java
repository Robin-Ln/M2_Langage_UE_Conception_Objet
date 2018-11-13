package visiteur;

import exceptions.PropagationExeption;
import meta.modele.block.Block;
import meta.modele.declaration.Declaration;
import meta.modele.expression.AdditionExpression;
import meta.modele.expression.BooleanExpression;
import meta.modele.expression.DoubleExpression;
import meta.modele.expression.InferieurExpression;
import meta.modele.expression.IntegerExpression;
import meta.modele.expression.MultiplicationExpression;
import meta.modele.expression.StringExpression;
import meta.modele.expression.UnResolveSymbole;
import meta.modele.expression.VarriableReference;
import meta.modele.instructions.Affectation;
import meta.modele.instructions.IfInstruction;
import meta.modele.instructions.ProcedureCall;
import meta.modele.instructions.WhileInstruction;
import meta.modele.programme.Programme;

/**
 * Interface qui permet de visiter tous les types d'expressions
 * 
 * @author Robin LOUARN
 *
 */
public interface Visiteur {

	public void visite(IntegerExpression integerExpression) throws PropagationExeption;

	public void visite(DoubleExpression doubleExpression) throws PropagationExeption;

	public void visite(StringExpression stringExpression) throws PropagationExeption;

	public void visite(AdditionExpression plusExpression) throws PropagationExeption;

	public void visite(MultiplicationExpression multiplicationExpression) throws PropagationExeption;

	public void visite(VarriableReference varriableReference) throws PropagationExeption;

	public void visite(UnResolveSymbole unResolveSymbole) throws PropagationExeption;

	public void visite(Declaration declaration) throws PropagationExeption;

	public void visite(Affectation affectation) throws PropagationExeption;

	public void visite(Programme programme) throws PropagationExeption;

	public void visite(BooleanExpression booleanExpression) throws PropagationExeption;

	public void visite(InferieurExpression inferieurExpression) throws PropagationExeption;

	public void visite(ProcedureCall procedureCall) throws PropagationExeption;

	public void visite(IfInstruction ifInstruction) throws PropagationExeption;

	public void visite(Block block) throws PropagationExeption;

	public void visite(WhileInstruction whileInstruction) throws PropagationExeption;

}
