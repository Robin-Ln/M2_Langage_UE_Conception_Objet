package mains;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import exceptions.PropagationExeption;
import meta.modele.programme.Programme;
import visiteur.VisiteurAfficher;
import visiteur.VisiteurCalculer;
import visiteur.VisiteurCreerProgramme;
import visiteur.VisiteurVerifier;
import xml.XmlErrorHandler;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);

		DocumentBuilder builder = factory.newDocumentBuilder();
		XmlErrorHandler xmlErrorHandler = new XmlErrorHandler();
		builder.setErrorHandler(xmlErrorHandler);

		File xml = new File("XMLs/ProgrammeValide.xml");

		Document document = builder.parse(xml);

		/*
		 * DTD ok
		 */
		if (xmlErrorHandler.isValide()) {

			VisiteurCreerProgramme visiteurCreerProgramme = new VisiteurCreerProgramme(document);
			visiteurCreerProgramme.lire();
			Programme programme = visiteurCreerProgramme.getProgramme();

			VisiteurAfficher visiteurAfficher = new VisiteurAfficher();
			try {
				programme.accept(visiteurAfficher);
			} catch (PropagationExeption e) {
			}
			System.out.println(visiteurAfficher.getResultat());

			VisiteurVerifier visiteurVerifier = new VisiteurVerifier();
			try {
				programme.accept(visiteurVerifier);
			} catch (PropagationExeption e) {
			}
			if (!visiteurVerifier.isValide()) {
				for (Exception exception : visiteurVerifier.getExceptions()) {
					System.out.println(exception);
				}
			}

			if (visiteurVerifier.isValide()) {
				VisiteurCalculer visiteurCalculer = new VisiteurCalculer();
				try {
					programme.accept(visiteurCalculer);
				} catch (PropagationExeption e) {
				}
				if (!visiteurCalculer.isValide()) {
					for (Exception exception : visiteurCalculer.getExceptions()) {
						System.out.println(exception);
					}
				}
			}

		} else {
			for (SAXParseException saxParseException : xmlErrorHandler.getSAXParseExceptions()) {
				System.out.println("Line : " + saxParseException.getLineNumber() + "" + ", colonne : "
						+ saxParseException.getColumnNumber() + "" + " -----> " + saxParseException.getMessage());
			}
		}
	}
}
