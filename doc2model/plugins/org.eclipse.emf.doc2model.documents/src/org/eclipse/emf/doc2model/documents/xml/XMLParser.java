head	1.1;
access;
symbols;
locks; strict;
comment	@# @;


1.1
date	2010.03.02.22.30.41;	author tfaure;	state Exp;
branches;
next	;
commitid	73794b8d918e4567;


desc
@@


1.1
log
@first commit for doc2model api : documents
this plugin contains interface for IDocument and some utils classes to handle xmls, zip documents
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
package org.eclipse.emf.doc2model.documents.xml;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.eclipse.emf.doc2model.documents.constants.ConfigurationConstants;
import org.eclipse.emf.doc2model.documents.helper.XMLHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * The Class XMLParser.
 * 
 * @@author tristan.faure@@atosorigin.com
 */
public class XMLParser {

	/** The xml. */
	private File xml;

	/** The document. */
	private org.w3c.dom.Document document;

	/** The current node. */
	private Node currentNode = null;

	/** The xpath. */
	private XPath xpath = null;

	/** The xpathes. */
	private HashMap<String, XPathExpression> xpathes = new HashMap<String, XPathExpression>();

	/** The xpathes nodes. containing the nodes lists for each xpath expression */
	private HashMap<String, NodeList> xpathesNodes = new HashMap<String, NodeList>();

	/** A node to indicate end of process */
	private Node nodeToEndParsing = null;

	/** the type of this xml parser */
	private String myConfiguration = null;

	/**
	 * Instantiates a new XML parser.
	 * 
	 * @@param f
	 *            the XML file
	 */
	public XMLParser(File f) {
		this(f, ConfigurationConstants.UNDEFINED);
	}

	public XMLParser(File f, String idForDocument) {
		try {
			xml = f;
			if (f != null) {
				myConfiguration = idForDocument;
				DocumentBuilderFactory fabrique = DocumentBuilderFactory
						.newInstance();
				fabrique.setNamespaceAware(true);
				// création d'un constructeur de documents
				DocumentBuilder constructeur = fabrique.newDocumentBuilder();
				// lecture du contenu d'un fichier XML avec DOM
				document = constructeur.parse(xml);
				currentNode = document.getFirstChild();
			}
		} catch (ParserConfigurationException pce) {
			throw new IllegalArgumentException(String.format(
					"File %s can't be parsed", f.getName()));
		} catch (SAXException se) {
			throw new IllegalArgumentException(String.format(
					"File %s can't be parsed", f.getName()));
		} catch (IOException ioe) {
			throw new IllegalArgumentException(String.format(
					"File %s can't be parsed", f.getName()));
		}

	}

	public String getKind() {
		return myConfiguration;
	}

	public void setEndNode(Node endNode) {
		nodeToEndParsing = endNode;
	}

	/**
	 * Gets the current node.
	 * 
	 * @@return the current node
	 */
	public Node getCurrentNode() {
		return currentNode;
	}

	/**
	 * Sets the current node.
	 * 
	 * @@param currentNode
	 *            the new current node
	 */
	public void setCurrentNode(Node currentNode) {
		this.currentNode = currentNode;
	}

	public org.w3c.dom.Document getDocument() {
		return document;
	}

	/**
	 * Next.
	 * 
	 * @@return true, if successful
	 */
	public boolean next() {
		currentNode = XMLHelper.next(currentNode);
		return (currentNode != null)
				&& !(nodeToEndParsing != null && currentNode == nodeToEndParsing);
	}

	/**
	 * evaluate a xpath expression.
	 * 
	 * @@param expression
	 *            the expression
	 * @@param context
	 *            the context
	 * 
	 * @@return the node
	 * 
	 * @@deprecated
	 */
	public Node evaluateXPathExpression(String expression,
			NamespaceContext context) {
		Node resultat = null;
		try {
			// creation du XPath
			if (xpath == null) {
				XPathFactory fabrique = XPathFactory.newInstance();
				xpath = fabrique.newXPath();
				xpath.setNamespaceContext(context);
			}
			// evaluation de l'expression XPath
			XPathExpression exp = null;
			if (!xpathes.containsKey(expression)) {
				exp = xpath.compile(expression);
				xpathes.put(expression, exp);
			} else {
				exp = xpathes.get(expression);
			}
			resultat = (Node) exp.evaluate(document, XPathConstants.NODE);
		} catch (XPathExpressionException xpee) {
			xpee.printStackTrace();
		}
		return resultat;
	}

	/**
	 * evaluate a xpath expression.
	 * 
	 * @@param expression
	 *            the expression
	 * @@param context
	 *            the context
	 * @@param attributeName
	 *            the attribute name
	 * @@param attributeValue
	 *            the attribute value
	 * 
	 * @@return the node
	 */
	public Node evaluateXPathExpression(String expression,
			String attributeName, String attributeValue,
			NamespaceContext context) {
		if (expression != null && attributeName != null
				&& attributeValue != null) {
			NodeList resultats = null;
			try {
				// creation du XPath
				if (xpath == null) {
					XPathFactory fabrique = XPathFactory.newInstance();
					xpath = fabrique.newXPath();
					xpath.setNamespaceContext(context);
				}
				// evaluation de l'expression XPath
				XPathExpression exp = null;
				if (!xpathesNodes.containsKey(expression)) {
					exp = xpath.compile(expression);
					resultats = (NodeList) exp.evaluate(document,
							XPathConstants.NODESET);
					xpathesNodes.put(expression, resultats);
				} else {
					resultats = xpathesNodes.get(expression);
				}
				return getResult(attributeName, attributeValue, resultats);
			} catch (XPathExpressionException xpee) {
				xpee.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * evaluate a xpath expression.
	 * 
	 * @@param expression
	 *            the expression
	 * @@param context
	 *            the context
	 * 
	 * @@return the node list which satisfy the xpath request
	 */
	public NodeList getNodesFromXPathExpression(String expression,
			NamespaceContext context) {
		if (expression != null) {
			NodeList results = null;
			try {
				if (xpath == null) {
					XPathFactory factory = XPathFactory.newInstance();
					xpath = factory.newXPath();
					xpath.setNamespaceContext(context);
				}
				XPathExpression exp = null;
				if (!xpathesNodes.containsKey(expression)) {
					exp = xpath.compile(expression);
					results = (NodeList) exp.evaluate(document,
							XPathConstants.NODESET);
					xpathesNodes.put(expression, results);
				} else {
					results = xpathesNodes.get(expression);
				}
				// return getResult(attributeName, attributeValue, resultats);
				return results;
			} catch (XPathExpressionException xpee) {
				xpee.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Gets the Node containing the attributes.
	 * 
	 * @@param attributeName
	 *            the attribute name
	 * @@param attributeValue
	 *            the attribute value
	 * @@param resultats
	 *            the resultats
	 * 
	 * @@return the result
	 */
	private Node getResult(String attributeName, String attributeValue,
			NodeList resultats) {
		for (int i = 0; i < resultats.getLength(); i++) {
			Node n = resultats.item(i);
			for (int j = 0; j < n.getAttributes().getLength(); j++) {
				Node nattribute = n.getAttributes().item(j);
				if (attributeName.equals(nattribute.getNodeName())) {
					if (attributeValue.equals(nattribute.getNodeValue())) {
						return n;
					}
				}
			}
		}
		return null;
	}

	public File getXmlFile() {
		return xml;
	}

	/**
	 * Clear all the caches
	 */
	public void init() {
		xpathes.clear();
		xpathesNodes.clear();
	}

	public static class NullXMLParser extends XMLParser {

		public NullXMLParser(File f) {
			super(f);
		}

		@@Override
		public Node evaluateXPathExpression(String expression,
				NamespaceContext context) {
			return null;
		}

		@@Override
		public Node evaluateXPathExpression(String expression,
				String attributeName, String attributeValue,
				NamespaceContext context) {
			return null;
		}

		@@Override
		public Node getCurrentNode() {
			return null;
		}

		@@Override
		public Document getDocument() {
			return null;
		}

		@@Override
		public String getKind() {
			return ConfigurationConstants.UNDEFINED;
		}

		@@Override
		public NodeList getNodesFromXPathExpression(String expression,
				NamespaceContext context) {
			return null;
		}

		@@Override
		public File getXmlFile() {
			return null;
		}

		@@Override
		public int hashCode() {
			return 0;
		}

		@@Override
		public void init() {
		}

		@@Override
		public boolean next() {
			return false;
		}

		@@Override
		public void setCurrentNode(Node currentNode) {
		}

		@@Override
		public void setEndNode(Node endNode) {
		}

		@@Override
		public String toString() {
			return "";
		}
	}
}@
