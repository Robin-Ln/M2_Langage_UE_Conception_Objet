package tests;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import exceptions.PropagationExeption;
import meta.modele.instructions.Instruction;
import modele.instruction.visiteurs.impl.VisiteurInstructionString;
import modele.xml.reader.InstructionDomReader;
import xml.XmlErrorHandler;

class TestInstructionDomReader {

	@Test
	void test() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);

		DocumentBuilder builder = factory.newDocumentBuilder();
		XmlErrorHandler xmlErrorHandler = new XmlErrorHandler();
		builder.setErrorHandler(xmlErrorHandler);

		File xml = new File("XMLs/Instructions.xml");

		Document document = builder.parse(xml);
		

		if (xmlErrorHandler.isValide()) {
			InstructionDomReader instructionDomReader = new InstructionDomReader(document);
			instructionDomReader.interpreter();
			LinkedList<Instruction> instructions = instructionDomReader.getInstructions();

			VisiteurInstructionString visiteurInstructionString = new VisiteurInstructionString();

			for (Instruction instruction : instructions) {
				try {
					instruction.accept(visiteurInstructionString);
					System.out.println(visiteurInstructionString.getResultat());
					for (Exception exception : instruction.getExceptions()) {
						System.out.println("\\-> " + exception);
					}
				} catch (PropagationExeption e) {
					e.printStackTrace();
				}
			}
		} else {
			for (SAXParseException saxParseException : xmlErrorHandler.getSAXParseExceptions()) {
				System.out.println("Line : "+saxParseException.getLineNumber()+""
						+ ", colonne : "+saxParseException.getColumnNumber()+""
						+ " -----> "
						+ saxParseException.getMessage());
			}
		}
	}

}
