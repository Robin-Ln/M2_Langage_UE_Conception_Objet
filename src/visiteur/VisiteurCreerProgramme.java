package visiteur;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import exceptions.PropagationExeption;
import exceptions.VarriableNonDeclarer;
import meta.modele.block.Block;
import meta.modele.declaration.Declaration;
import meta.modele.element.ElementProgramme;
import meta.modele.expression.AdditionExpression;
import meta.modele.expression.BooleanExpression;
import meta.modele.expression.DoubleExpression;
import meta.modele.expression.Expression;
import meta.modele.expression.InferieurExpression;
import meta.modele.expression.IntegerExpression;
import meta.modele.expression.MultiplicationExpression;
import meta.modele.expression.Reference;
import meta.modele.expression.StringExpression;
import meta.modele.expression.UnResolveSymbole;
import meta.modele.expression.VarriableReference;
import meta.modele.instructions.Affectation;
import meta.modele.instructions.IfInstruction;
import meta.modele.instructions.ProcedureCall;
import meta.modele.instructions.WhileInstruction;
import meta.modele.programme.Programme;

public class VisiteurCreerProgramme implements Visiteur {

	/*
	 * Attribut
	 */

	Document document;
	Programme programme;

	/*
	 * Constructeur
	 */
	public VisiteurCreerProgramme(Document document) {
		super();
		this.document = document;
		programme = new Programme();
	}

	/*
	 * Methodes Implémentés
	 */

	@Override
	public void visite(IntegerExpression integerExpression) {
	}

	@Override
	public void visite(DoubleExpression doubleExpression) {
	}

	@Override
	public void visite(StringExpression stringExpression) {
	}

	@Override
	public void visite(VarriableReference varriableReference) {
	}

	@Override
	public void visite(UnResolveSymbole unResolveSymbole) {
	}

	@Override
	public void visite(BooleanExpression booleanExpression) throws PropagationExeption {
	}

	@Override
	public void visite(AdditionExpression additionExpression) throws PropagationExeption {
		Element elementOperandeGauche = this.document.getElementById(additionExpression.getIdOperandeGauche());
		Expression operandeGauche = this.getExpression(elementOperandeGauche);
		operandeGauche.setElementProgrammeParent(additionExpression);
		additionExpression.setOperandeGauche(operandeGauche);
		operandeGauche.accept(this);

		Element elementOperandeDroite = this.document.getElementById(additionExpression.getIdOperandeDroite());
		Expression operandeDroite = this.getExpression(elementOperandeDroite);
		operandeDroite.setElementProgrammeParent(additionExpression);
		additionExpression.setOperandeDroite(operandeDroite);
		operandeDroite.accept(this);
	}

	@Override
	public void visite(MultiplicationExpression multiplicationExpression) throws PropagationExeption {
		Element elementOperandeGauche = this.document.getElementById(multiplicationExpression.getIdOperandeGauche());
		Expression operandeGauche = this.getExpression(elementOperandeGauche);
		operandeGauche.setElementProgrammeParent(multiplicationExpression);
		multiplicationExpression.setOperandeGauche(operandeGauche);
		operandeGauche.accept(this);

		Element elementOperandeDroite = this.document.getElementById(multiplicationExpression.getIdOperandeDroite());
		Expression operandeDroite = this.getExpression(elementOperandeDroite);
		operandeDroite.setElementProgrammeParent(multiplicationExpression);
		multiplicationExpression.setOperandeDroite(operandeDroite);
		operandeDroite.accept(this);
	}

	@Override
	public void visite(InferieurExpression inferieurExpression) throws PropagationExeption {
		Element elementOperandeGauche = this.document.getElementById(inferieurExpression.getIdOperandeGauche());
		Expression operandeGauche = this.getExpression(elementOperandeGauche);
		operandeGauche.setElementProgrammeParent(inferieurExpression);
		inferieurExpression.setOperandeGauche(operandeGauche);
		operandeGauche.accept(this);

		Element elementOperandeDroite = this.document.getElementById(inferieurExpression.getIdOperandeDroite());
		Expression operandeDroite = this.getExpression(elementOperandeDroite);
		operandeDroite.setElementProgrammeParent(inferieurExpression);
		inferieurExpression.setOperandeDroite(operandeDroite);
		operandeDroite.accept(this);
	}

	@Override
	public void visite(Declaration declaration) throws PropagationExeption {
	}

	@Override
	public void visite(Affectation affectation) throws PropagationExeption {
	}

	@Override
	public void visite(ProcedureCall procedureCall) {
	}

	@Override
	public void visite(IfInstruction ifInstruction) throws PropagationExeption {
		Element elementExpression = this.document.getElementById(ifInstruction.getIdExpressionCondition());
		ifInstruction.setExpressionCondition(this.getExpression(elementExpression));
		
		Block blockTrue = new Block();
		blockTrue.setIdBlock(ifInstruction.getIdBlockTrue());
		blockTrue.setElementProgrammeParent(ifInstruction);
		blockTrue.accept(this);
		ifInstruction.setBlockTrue(blockTrue);
		
		if(ifInstruction.getIdBlockFalse() != null) {
			Block blockFalse = new Block();
			blockFalse.setIdBlock(ifInstruction.getIdBlockFalse());
			blockFalse.setElementProgrammeParent(ifInstruction);
			blockFalse.accept(this);
			ifInstruction.setBlockFalse(blockFalse);
		}
	}

	@Override
	public void visite(Block block) throws PropagationExeption {
		Element elementBlock = this.document.getElementById(block.getIdBlock());
		this.lire(elementBlock, block);
	}

	@Override
	public void visite(Programme programme) throws PropagationExeption {
		for (ElementProgramme elementProgramme : programme.getElements()) {
			elementProgramme.setElementProgrammeParent(programme);
			this.programme.getElements().add(elementProgramme);
		}
	}
	
	@Override
	public void visite(WhileInstruction whileInstruction) throws PropagationExeption {
		Element elementExpression = this.document.getElementById(whileInstruction.getIdExpressionCondition());
		whileInstruction.setExpressionCondition(this.getExpression(elementExpression));
		
		Block block = new Block();
		block.setIdBlock(whileInstruction.getIdBlock());
		block.setElementProgrammeParent(whileInstruction);
		block.accept(this);
		whileInstruction.setBlock(block);
		
	}

	/*
	 * -------------------
	 */

	public Expression getExpression(Element elementExpression) {
		switch (elementExpression.getNodeName()) {
		case "StringExpression":

			String stringValue = elementExpression.getAttribute("valeur");
			StringExpression stringExpression = new StringExpression(stringValue);
			stringExpression.setId(elementExpression.getAttribute("id"));
			return stringExpression;

		case "BooleanExpression":

			Boolean booleanValue = Boolean.parseBoolean(elementExpression.getAttribute("valeur"));
			BooleanExpression booleanExpression = new BooleanExpression(booleanValue);
			booleanExpression.setId(elementExpression.getAttribute("id"));
			return booleanExpression;

		case "IntegerExpression":

			Integer integerValue = Integer.parseInt(elementExpression.getAttribute("valeur"));
			IntegerExpression integerExpression = new IntegerExpression(programme, integerValue);
			integerExpression.setId(elementExpression.getAttribute("id"));
			return integerExpression;

		case "DoubleExpression":

			Double doubleValue = Double.parseDouble(elementExpression.getAttribute("valeur"));
			DoubleExpression doubleExpression = new DoubleExpression(doubleValue);
			doubleExpression.setId(elementExpression.getAttribute("id"));
			return doubleExpression;

		case "UnResolveSymbole":

			String nomSymboleAffectation = elementExpression.getAttribute("nomSymbole");
			Reference reference = new UnResolveSymbole(nomSymboleAffectation);
			try {
				Declaration declarationAffectation = programme.resolvedVariable(nomSymboleAffectation);
				reference = declarationAffectation.getVarriableReference();
			} catch (VarriableNonDeclarer e) {
			}
			return reference;

		case "MultiplicationExpression":
			try {
				MultiplicationExpression multiplicationExpression = new MultiplicationExpression();
				multiplicationExpression.setId(elementExpression.getAttribute("id"));
				multiplicationExpression.setIdOperandeGauche(elementExpression.getAttribute("idOperandeGauche"));
				multiplicationExpression.setIdOperandeDroite(elementExpression.getAttribute("idOperandeDroite"));
				multiplicationExpression.accept(this);
				return multiplicationExpression;
			} catch (PropagationExeption e) {
			}
			break;

		case "AdditionExpression":
			try {
				AdditionExpression additionExpression = new AdditionExpression();
				additionExpression.setId(elementExpression.getAttribute("id"));
				additionExpression.setIdOperandeGauche(elementExpression.getAttribute("idOperandeGauche"));
				additionExpression.setIdOperandeDroite(elementExpression.getAttribute("idOperandeDroite"));
				additionExpression.accept(this);
				return additionExpression;
			} catch (PropagationExeption e) {
			}

			break;

		case "InferieurExpression":
			try {
				InferieurExpression inferieurExpression = new InferieurExpression();
				inferieurExpression.setId(elementExpression.getAttribute("id"));
				inferieurExpression.setIdOperandeGauche(elementExpression.getAttribute("idOperandeGauche"));
				inferieurExpression.setIdOperandeDroite(elementExpression.getAttribute("idOperandeDroite"));
				inferieurExpression.accept(this);
				return inferieurExpression;
			} catch (PropagationExeption e) {
			}

			break;
		default:
			System.out.println("Ce expression n'est pas traiter : " + elementExpression.getNodeName());
			break;
		}
		return null;
	}

	/*
	 * -------------------------------
	 */
	public void lire() {
		Element elementRoot = this.document.getDocumentElement();
		this.lire(elementRoot, programme);
	}

	private void lire(Element elementRoot, Programme programme) {
		NodeList nodeList = elementRoot.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nodeExpression = nodeList.item(i);
			if (nodeExpression.getNodeType() == Node.ELEMENT_NODE) {

				Element elementExpression = (Element) nodeExpression;

				switch (elementExpression.getNodeName()) {
				case "Declaration":
					Declaration declaration = new Declaration();

					VarriableReference varriableReferenceDeclaration = new VarriableReference();
					varriableReferenceDeclaration.setNom(elementExpression.getAttribute("nomSymbole"));
					varriableReferenceDeclaration.setElementProgrammeParent(declaration);

					declaration.setVarriableReference(varriableReferenceDeclaration);
					declaration.setElementProgrammeParent(programme);

					programme.getDeclarations().add(declaration);
					break;

				case "Affectation":

					Affectation affectation = new Affectation();

					String nomSymboleAffectation = elementExpression.getAttribute("nomSymbole");
					Reference reference = new UnResolveSymbole(nomSymboleAffectation);
					try {
						Declaration declarationAffectation = programme.resolvedVariable(nomSymboleAffectation);
						reference = declarationAffectation.getVarriableReference();
					} catch (VarriableNonDeclarer e) {
					}
					reference.setElementProgrammeParent(affectation);

					String idExpression = elementExpression.getAttribute("idExpression");
					Element elementAffectation = this.document.getElementById(idExpression);
					Expression expression = this.getExpression(elementAffectation);
					expression.setElementProgrammeParent(affectation);

					affectation.setVarriableReference(reference);
					affectation.setExpression(expression);
					affectation.setElementProgrammeParent(programme);

					programme.getElements().add(affectation);
					break;

				case "ProcedureCall":

					String nomProcedureCall = elementExpression.getAttribute("nomProcedure");
					String idArguments = elementExpression.getAttribute("idExpressions");
					List<Expression> expressions = new ArrayList<>();
					for (String idArgument : idArguments.split(" ")) {
						Element elementArgument = this.document.getElementById(idArgument);
						Expression expressionArgument = this.getExpression(elementArgument);
						expressionArgument.setElementProgrammeParent(programme);
						expressions.add(expressionArgument);
					}

					ProcedureCall procedureCall = new ProcedureCall(nomProcedureCall, expressions);
					procedureCall.setElementProgrammeParent(programme);
					programme.getElements().add(procedureCall);
					break;

				case "If":
					try {
						IfInstruction ifInstruction = new IfInstruction();
						ifInstruction.setIdExpressionCondition(elementExpression.getAttribute("idExpression"));
						ifInstruction.setIdBlockTrue(elementExpression.getAttribute("idBlockTrue"));
						ifInstruction.setIdBlockFalse(elementExpression.getAttribute("idBlockFalse"));
						ifInstruction.setElementProgrammeParent(programme);
						ifInstruction.accept(this);
						programme.getElements().add(ifInstruction);
					} catch (PropagationExeption e) {
					}
					break;
				
				case "While":
					try {
						WhileInstruction whileInstruction = new WhileInstruction();
						whileInstruction.setIdExpressionCondition(elementExpression.getAttribute("idExpression"));
						whileInstruction.setIdBlock(elementExpression.getAttribute("idBlock"));
						whileInstruction.setElementProgrammeParent(programme);
						whileInstruction.accept(this);
						programme.getElements().add(whileInstruction);
					} catch (PropagationExeption e) {
					}
					break;
				default:
					break;
				}
			}
		}
	}

	/*
	 * Accesseurs
	 */

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

}
