head	1.2;
access;
symbols;
locks; strict;
comment	@# @;


1.2
date	2010.07.26.14.24.39;	author tfaure;	state Exp;
branches;
next	1.1;
commitid	3f8d44c4d9aa64567;

1.1
date	2010.03.02.22.32.37;	author tfaure;	state Exp;
branches;
next	;
commitid	77de4b8d92034567;


desc
@@


1.2
log
@NEW - bug 320747: Provide recognition by regular expression
https://bugs.eclipse.org/bugs/show_bug.cgi?id=320747

add regular expression.
The syntax in uri is
regex:myRegex(zoneGrouped)

or if you want to bufferize the document (be careful no performance test have been done)
regex:myRegex(zoneGrouped)#global
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
package org.eclipse.emf.doc2model.documents.openxml.docx;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.doc2model.documents.AbstractZipDocument;
import org.eclipse.emf.doc2model.documents.constants.ConfigurationConstants;
import org.eclipse.emf.doc2model.documents.constants.PropertyConstants;
import org.eclipse.emf.doc2model.documents.helper.XMLHelper;
import org.eclipse.emf.doc2model.documents.openxml.helper.DOCXHelper;
import org.eclipse.emf.doc2model.documents.openxml.helper.OfficeHelper;
import org.eclipse.emf.doc2model.documents.xml.XMLParser;
import org.w3c.dom.Node;

/**
 * The Class DocxDocument.
 * 
 * @@author tristan.faure@@atosorigin.com
 */
public class DocxDocument extends AbstractZipDocument {

	/**
	 * The style xml file
	 */
	private XMLParser style = null;

	/**
	 * Default constructor.
	 * 
	 * @@param document
	 *            the document
	 */
	public DocxDocument(File document) {
		this(document, null);
	}

	public DocxDocument(File documentFile, Map<String, Object> configuration) {
		super(documentFile, configuration);
		File xmlContentFile = getUnzipper().getFile(
				DOCXHelper.CONTENTS_FILE_NAME);
		style = new XMLParser(getUnzipper().getFile(DOCXHelper.STYLE_FILE_NAME));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @@see org.topcased.doc2model.documents.Document#getStyle()
	 */
	public String getStyle() {
		Node n = getXMLParser().getCurrentNode();
		if (DOCXHelper.WORD_STYLE_PARAGRAPH_W.equals(n.getNodeName())) {
			return getStyleCorrespondingToCurrentText();
		}
		// String tagValue =
		// XMLHelper.getTagValueWithoutNamespace(getXMLParser()
		// .getCurrentNode());
		// if (DOCXHelper.WORD_STYLE.equals(tagValue)) {
		// if (DOCXHelper.getNodeForStyleNode(getXMLParser().getCurrentNode())
		// != null) {
		// if (DOCXHelper.isNotAModification(DOCXHelper
		// .getNodeForStyleNode(getXMLParser().getCurrentNode()))) {
		// String styleName = getXMLParser().getCurrentNode()
		// .getAttributes().getNamedItem(
		// DOCXHelper.WORD_STYLE_ATTRIBUTE)
		// .getNodeValue();
		// // check if the style is not defined in styles
		// return DOCXHelper.getStringStyleForStyleNodeInStyleFile(
		// styleName, style);
		// }
		// }
		// }
		return null;
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
			return DOCXHelper.getTextNodeForStyleNode(getXMLParser()
					.getCurrentNode());
		}
		return result;
	}

	public String getStyleCorrespondingToCurrentText() {
		String result = null;
		Node sibling = getXMLParser().getCurrentNode().getNextSibling();
		Node tmp = getXMLParser().getCurrentNode();
		while (tmp != sibling) {
			String tagValue = XMLHelper.getTagValueWithoutNamespace(tmp);
			if (DOCXHelper.WORD_STYLE.equals(tagValue)) {
				if (DOCXHelper.getNodeForStyleNode(tmp) != null) {
					if (DOCXHelper.isNotAModification(DOCXHelper
							.getNodeForStyleNode(tmp))) {
						String styleName = tmp.getAttributes().getNamedItem(
								DOCXHelper.WORD_STYLE_ATTRIBUTE).getNodeValue();
						// check if the style is not defined in styles
						return DOCXHelper
								.getStringStyleForStyleNodeInStyleFile(
										styleName, style);
					}
				}
			}
			tmp = XMLHelper.next(tmp);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @@see org.topcased.doc2model.documents.Document#getText()
	 */
	public String getText() {
		StringBuffer result = new StringBuffer("");
		Node n = getXMLParser().getCurrentNode();
		if (DOCXHelper.WORD_STYLE_PARAGRAPH_W.equals(n.getNodeName())) {
			Node tmp = XMLHelper.next(n);
			while (tmp != null
					&& !DOCXHelper.WORD_STYLE_PARAGRAPH_W.equals(tmp
							.getNodeName())) {
				if (DOCXHelper.WORD_STYLE_TEXT_W.equals(tmp.getNodeName())) {
					result.append(tmp.getTextContent());
				}
				tmp = XMLHelper.next(tmp);
			}
		}
		return result.toString();
		// return getXmlParser().getCurrentNode().getNodeValue();

	}

	public Collection<XMLParser> getXmlParsers(String idForDocument) {
		Collection<XMLParser> parsers = new LinkedList<XMLParser>();
		if (ConfigurationConstants.CONTENT.equals(idForDocument)) {
			XMLParser p = new XMLParser(getUnzipper().getFile(
					DOCXHelper.CONTENTS_FILE_NAME), idForDocument);
			parsers.add(p);
		} else if (ConfigurationConstants.FOOTER.equals(idForDocument)) {
			OfficeHelper.fillCollection(getUnzipper(), parsers,
					DOCXHelper.RELATIONSHIPS_FOOTER, idForDocument,
					DOCXHelper.DOCUMENT_RELS_FILE_NAME);
		} else if (ConfigurationConstants.HEADER.equals(idForDocument)) {
			OfficeHelper.fillCollection(getUnzipper(), parsers,
					DOCXHelper.RELATIONSHIPS_HEADER, idForDocument,
					DOCXHelper.DOCUMENT_RELS_FILE_NAME);
		}
		return parsers;
	}

	@@Override
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


1.1
log
@first commit for doc2model api : openxml
handles xlsx and docx document
@
text
@d177 1
a177 1
		}
@

