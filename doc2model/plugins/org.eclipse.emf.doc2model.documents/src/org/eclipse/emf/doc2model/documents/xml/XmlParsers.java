package org.eclipse.emf.doc2model.documents.xml;

import java.util.Collection;
import java.util.LinkedList;

/**
 * The Class XmlParsers.
 */
public class XmlParsers {

	private LinkedList<XMLParser> parsers = new LinkedList<XMLParser>();
	private XMLParser pointer = null;
	private int index;

	public XmlParsers(Collection<XMLParser> xmlParsers) {
		addAll(xmlParsers);
		pointer = parsers.get(0);
		index = 0;
	}

	public void addAll(Collection<XMLParser> xmlParser) {
		parsers.addAll(xmlParser);
	}

	public void add(XMLParser xmlParser) {
		parsers.add(xmlParser);
	}

	public XMLParser getCurrent() {
		return pointer;
	}

	public boolean next() {
		boolean result = pointer.next();
		if (!result) {
			result = nextXMLParser();
		}
		return result;
	}

	private boolean nextXMLParser() {
		index++;
		boolean result = false;
		if (index < parsers.size()) {
			pointer = parsers.get(index);
			if (pointer.getCurrentNode() == null) {
				result = next();
			} else {
				result = true;
			}
		}
		return result;
	}

	public boolean jumpToNextFile() {
		return nextXMLParser();
	}

	public void jumpToStart() {
		// reinitialize xmlparsers to the beginning
		for (XMLParser p : parsers) {
			p.setCurrentNode(p.getDocument().getFirstChild());
		}
		// set to first
		index = 0;
		pointer = parsers.get(index);
	}

}
