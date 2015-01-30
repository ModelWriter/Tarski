package org.eclipse.emf.doc2model.documents;

import org.eclipse.emf.doc2model.documents.xml.XMLParser;

public interface IXMLDocument extends IDocument {
	/**
	 * Return the XML Parser object containing all xml information if your
	 * document doesn't contain XML Parser please use
	 * {@link XMLParser.NullXMLParser}
	 * 
	 * @return the XML Parser
	 */
	XMLParser getXMLParser();
}
