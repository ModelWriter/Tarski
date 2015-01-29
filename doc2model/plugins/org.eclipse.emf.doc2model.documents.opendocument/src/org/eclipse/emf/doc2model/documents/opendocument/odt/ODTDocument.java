head	1.1;
access;
symbols;
locks; strict;
comment	@# @;


1.1
date	2010.03.02.22.31.38;	author tfaure;	state Exp;
branches;
next	;
commitid	763b4b8d91c74567;


desc
@@


1.1
log
@first commit for doc2model api : opendocument
implementation of IDocument for odt and ods
@
text
@/**
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 * 
 *     
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@@atosorigin.com - Initial API and implementation
 */
package org.eclipse.emf.doc2model.documents.opendocument.odt;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.doc2model.documents.AbstractZipDocument;
import org.eclipse.emf.doc2model.documents.constants.ConfigurationConstants;
import org.eclipse.emf.doc2model.documents.constants.PropertyConstants;
import org.eclipse.emf.doc2model.documents.helper.XMLHelper;
import org.eclipse.emf.doc2model.documents.opendocument.ODTNamespaceContext;
import org.eclipse.emf.doc2model.documents.xml.XMLParser;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * The Class ODTDocument.
 * 
 * @@author tristan.faure@@atosorigin.com
 */
public class ODTDocument extends AbstractZipDocument {
	private static final String ODT_TEXT = "text:";

	/** The Constant ODT_STYLE_H. */
	private static final String ODT_STYLE_H = "h";

	/** The Constant ODT_STYLE_P. */
	private static final String ODT_STYLE_P = "p";

	/** The body node name. */
	private static final String ODT_P_TEXT = ODT_TEXT + ODT_STYLE_P;

	/** The Header node name */
	private static final String ODT_H_TEXT = ODT_TEXT + ODT_STYLE_H;

	/** The contents file name. */
	private static String contentsFileName = "content.xml";

	/** The styles. */
	private static String styles = "styles.xml";

	/** The Constant ODT_STYLE_ATTRIBUTE. */
	private static final String ODT_STYLE_ATTRIBUTE = "text:style-name";

	/** The Constant ODT_STYLE_ATTRIBUTE_PARENT_NAME. */
	private static final String ODT_STYLE_ATTRIBUTE_PARENT_NAME = "style:parent-style-name";

	/** The Constant ODT_STYLE_ATTRIBUTE_DISPLAY_NAME. */
	private static final String ODT_STYLE_ATTRIBUTE_DISPLAY_NAME = "style:display-name";

	/** The Constant ODT_STYLE_ATTRIBUTE_NAME. */
	// private static final String ODT_STYLE_ATTRIBUTE_NAME =
	// "style:style-name";
	/** The Constant ODT_STYLE_ATTRIBUTE_NAME_2. */
	private static final String ODT_STYLE_ATTRIBUTE_NAME_2 = "style:name";

	private static final String ODT_STYLE_HEADER = "style:header";

	private static final String ODT_STYLE_FOOTER = "style:footer";

	private static final String ODT_STYLE_MASTER_STYLE = "office:master-styles";

	/** The Constant XPATH_STYLE_NAME. */
	// private static final String XPATH_STYLE_NAME =
	// "//style:style[@@style:name='%s']";
	/** The Constant XPATH_STYLE_GENERIC. */
	private static final String XPATH_STYLE_GENERIC = "//style:style";

	/** The xml styles parser. */
	private XMLParser xmlStylesParser = null;

	/**
	 * Default constructor.
	 * 
	 * @@param document
	 *            the document
	 */
	public ODTDocument(File document) {
		this(document, null);
	}

	public ODTDocument(File documentFile, Map<String, Object> configuration) {
		super(documentFile, configuration);
	}

	/**
	 * Get the applicated style for the current Node in OO case.
	 * 
	 * @@return the style
	 * 
	 * @@see org.topcased.document.parser.documents.AbstractDocument#getStyle()
	 */
	public String getStyle() {
		// the current Node name
		String nodeName = getXMLParser().getCurrentNode().getNodeName();
		// the current node tag name <a:b ...> <== b
		String tagValue = nodeName.substring(nodeName.indexOf(":") + 1,
				nodeName.length());
		// string to return
		String result = null;
		// we check only when the tag is a header or a paragraph
		if (ODT_STYLE_H.equals(tagValue) || ODT_STYLE_P.equals(tagValue)) {
			Node nAttribute = getXMLParser().getCurrentNode().getAttributes()
					.getNamedItem(ODT_STYLE_ATTRIBUTE);
			if (nAttribute != null) {
				String value = nAttribute.getNodeValue();
				File xmlStyles = getUnzipper().getFile(styles);
				if (xmlStylesParser == null) {
					xmlStylesParser = new XMLParser(xmlStyles);
				}
				// String exp = String.format(XPATH_STYLE_NAME, value);
				// // get the node in styles.xml to check if it is referenced
				// Node n = xmlStylesParser.evaluateXPathExpression(exp, new
				// ODTNamespaceContext());
				Node n = getXMLParser().evaluateXPathExpression(
						XPATH_STYLE_GENERIC, ODT_STYLE_ATTRIBUTE_NAME_2, value,
						new ODTNamespaceContext());
				// Node n =
				// xmlStylesParser.evaluateXPathExpression(XPATH_STYLE_GENERIC,
				// ODT_STYLE_ATTRIBUTE_NAME_2,
				// value, new ODTNamespaceContext());
				if (n != null) {
					// get the display name
					NamedNodeMap map = n.getAttributes();
					if (exists(map, ODT_STYLE_ATTRIBUTE_DISPLAY_NAME)) {
						result = n.getAttributes().getNamedItem(
								ODT_STYLE_ATTRIBUTE_DISPLAY_NAME)
								.getNodeValue();
					} else {
						// we get the parent name
						if (exists(map, ODT_STYLE_ATTRIBUTE_PARENT_NAME)) {
							result = n.getAttributes().getNamedItem(
									ODT_STYLE_ATTRIBUTE_PARENT_NAME)
									.getNodeValue();
							String tmp = checkStyleInDocumentXML(result);
							if (tmp != null) {
								result = tmp;
							}
						} else {
							result = null;
						}
					}
				}
				if (n == null || result == null) {
					result = checkStyleInDocumentXML(value);
				}
			}
		}
		return result;

	}

	/**
	 * Exists. Check if there is an attribute named name in the map
	 * 
	 * @@param map
	 *            the map
	 * @@param name
	 *            the name
	 * 
	 * @@return true, if successful
	 */
	private boolean exists(NamedNodeMap map, String name) {
		boolean result = false;
		for (int i = 0; i < map.getLength(); i++) {
			if (name.equals(map.item(i).getNodeName())) {

				return true;
			}
		}
		return result;
	}

	/**
	 * Check the style.
	 * 
	 * @@param value
	 *            the value
	 * 
	 * @@return the string
	 */
	private String checkStyleInDocumentXML(String value) {
		String result = null;
		// String expressionStyleNotFound = String.format(XPATH_STYLE_NAME,
		// value);
		// Node n2 = xmlParser.evaluateXPathExpression(expressionStyleNotFound,
		// new ODTNamespaceContext());
		Node n2 = xmlStylesParser.evaluateXPathExpression(XPATH_STYLE_GENERIC,
				ODT_STYLE_ATTRIBUTE_NAME_2, value, new ODTNamespaceContext());
		// Node n2 = getXmlParser().evaluateXPathExpression(XPATH_STYLE_GENERIC,
		// ODT_STYLE_ATTRIBUTE_NAME_2, value, new
		// ODTNamespaceContext());
		if (n2 != null) {
			// get the parent name
			Node namedItem = n2.getAttributes().getNamedItem(
					ODT_STYLE_ATTRIBUTE_PARENT_NAME);
			Node nTmp = n2.getAttributes().getNamedItem(
					ODT_STYLE_ATTRIBUTE_DISPLAY_NAME);
			if (namedItem != null && nTmp == null) {
				String parent = namedItem.getNodeValue();
				if (parent != null) {
					// String exp2 = String.format(XPATH_STYLE_NAME, parent);
					// Node n3 = xmlStylesParser.evaluateXPathExpression(exp2,
					// new ODTNamespaceContext());
					Node n3 = xmlStylesParser.evaluateXPathExpression(
							XPATH_STYLE_GENERIC, ODT_STYLE_ATTRIBUTE_NAME_2,
							parent, new ODTNamespaceContext());
					if (n3 != null) {
						result = getDisplayName(n3);
					}
				} else {
					// get the name
					result = getName(n2);
				}
			} else if (nTmp != null) {
				result = nTmp.getNodeValue();
			}
		}
		return result;

	}

	/**
	 * Gets the name.
	 * 
	 * @@param n
	 *            the n
	 * 
	 * @@return the name
	 */
	private String getName(Node n) {
		String result = null;
		for (int i = 0; i < n.getAttributes().getLength(); i++) {
			Node tmp = n.getAttributes().item(i);
			if (ODT_STYLE_ATTRIBUTE_NAME_2.equals(tmp.getNodeName())) {
				result = tmp.getNodeValue();
			}
		}
		return result;
	}

	/**
	 * Gets the display name.
	 * 
	 * @@param n
	 *            the n
	 * 
	 * @@return the display name
	 */
	private String getDisplayName(Node n) {
		String result = null;
		for (int i = 0; i < n.getAttributes().getLength(); i++) {
			Node tmp = n.getAttributes().item(i);
			if (ODT_STYLE_ATTRIBUTE_DISPLAY_NAME.equals(tmp.getNodeName())) {
				result = tmp.getNodeValue();
			}
		}
		if (result == null) {
			result = getName(n);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @@see
	 * org.topcased.doc2model.documents.Document#getTextCorrespondingToCurrentStyle
	 * ()
	 */
	public String getTextCorrespondingToCurrentStyle() {
		String result = null;
		if (getStyle() != null) {
			return getText();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @@see org.topcased.doc2model.documents.Document#getText()
	 */
	public String getText() {
		// check if the tag is not contained in a comment if you search the
		// corresponding tag browse inside the current node
		if ((ODT_P_TEXT.equals(getXMLParser().getCurrentNode().getNodeName()) || ODT_H_TEXT
				.equals(getXMLParser().getCurrentNode().getNodeName()))
				&& !XMLHelper.containsInHierarchy(getXMLParser()
						.getCurrentNode(), "office:annotation")) {
			switch (getXMLParser().getCurrentNode().getNodeType()) {
			case Node.ELEMENT_NODE:
				return getXMLParser().getCurrentNode().getTextContent();
			case Node.TEXT_NODE:
				return getXMLParser().getCurrentNode().getNodeValue();
			default:
				return getXMLParser().getCurrentNode().getNodeValue();
			}

		} else {
			return "";
		}
	}

	/**
	 * Fill the collection corresponding to odt style including in master styles
	 * 
	 * @@param parsers
	 *            the collection to fill
	 * @@param odtStyle
	 *            the style to search
	 * @@param idForDocument
	 */
	private void fillCollection(Collection<XMLParser> parsers, String odtStyle,
			String config) {
		XMLParser parser = new XMLParser(getUnzipper().getFile(styles));
		// set the parser to the good position
		boolean result = false;
		do {
			result = parser.next();
			Node sibling = XMLHelper.getSibling(parser.getCurrentNode());
			if (ODT_STYLE_MASTER_STYLE.equals(parser.getCurrentNode()
					.getNodeName())) {
				do {
					result = parser.next();
					if (result
							&& odtStyle.equals(parser.getCurrentNode()
									.getNodeName())) {
						XMLParser tmp = new XMLParser(getUnzipper().getFile(
								styles), config);
						tmp.setCurrentNode(parser.getCurrentNode());
						tmp.setEndNode(XMLHelper.getSibling(parser
								.getCurrentNode()));
						parsers.add(tmp);
					}
				} while (result && parser.getCurrentNode() != sibling);
			}
		} while (result);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @@see
	 * org.topcased.document.parser.documents.Document#getXmlParsers(org.topcased
	 * .document.parser.documents.Document.CONFIGURATION)
	 */
	public Collection<XMLParser> getXmlParsers(String idForDocument) {
		Collection<XMLParser> parsers = new LinkedList<XMLParser>();
		if (ConfigurationConstants.CONTENT.equals(idForDocument)) {
			XMLParser parser = new XMLParser(getUnzipper().getFile(
					contentsFileName), idForDocument);
			parsers.add(parser);
		} else if (ConfigurationConstants.FOOTER.equals(idForDocument)) {
			fillCollection(parsers, ODT_STYLE_FOOTER, idForDocument);
		} else if (ConfigurationConstants.HEADER.equals(idForDocument)) {
			fillCollection(parsers, ODT_STYLE_HEADER, idForDocument);
		}
		return parsers;
	}

	public Object get(String property) {
		if (PropertyConstants.TEXT.equals(property)) {
			return getText();
		} else if (PropertyConstants.STYLE.equals(property)) {
			return getStyle();
		}
		return super.get(property);
	}

}
@
