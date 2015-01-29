head	1.1;
access;
symbols;
locks; strict;
comment	@# @;


1.1
date	2010.03.02.22.32.38;	author tfaure;	state Exp;
branches;
next	;
commitid	77de4b8d92034567;


desc
@@


1.1
log
@first commit for doc2model api : openxml
handles xlsx and docx document
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
package org.eclipse.emf.doc2model.documents.openxml.xlsx;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.doc2model.documents.AbstractZipDocument;
import org.eclipse.emf.doc2model.documents.constants.ConfigurationConstants;
import org.eclipse.emf.doc2model.documents.constants.PropertyConstants;
import org.eclipse.emf.doc2model.documents.openxml.helper.OfficeHelper;
import org.eclipse.emf.doc2model.documents.openxml.helper.XLSXHelper;
import org.eclipse.emf.doc2model.documents.xml.XMLParser;
import org.w3c.dom.Node;

/**
 * The Class XLSXDocument.
 */
public class XLSXDocument extends AbstractZipDocument {

	private String[] strings = null;

	public XLSXDocument(File documentFile) {
		this(documentFile, null);
	}

	public XLSXDocument(File documentFile, Map<String, Object> configuration) {
		super(documentFile, configuration);
		initStrings();

	}

	/**
	 * Fill the array of shared strings to get them later
	 */
	private void initStrings() {
		XMLParser parser = new XMLParser(getUnzipper().getFile(
				XLSXHelper.SHARED_STRING_FILE));
		Node item = parser.getCurrentNode().getAttributes().getNamedItem(
				XLSXHelper.ATTRIBUTE_COUNT);
		if (item == null) {
			return;
		}
		int nb = Integer.valueOf(item.getTextContent());
		strings = new String[nb];
		int i = 0;
		do {
			if ("t".equals(parser.getCurrentNode().getNodeName())) {
				strings[i] = parser.getCurrentNode().getTextContent();
				i++;
			}
		} while (parser.next());

	}

	@@Override
	protected Collection<XMLParser> getXmlParsers(String idForDocument) {
		Collection<XMLParser> parsers = new LinkedList<XMLParser>();
		if (ConfigurationConstants.CONTENT.equals(idForDocument)) {
			XMLParser workbook = new XMLParser(getUnzipper().getFile(
					XLSXHelper.CONTENTS_FILE_NAME), idForDocument);
			do {
				if ("sheet".equals(workbook.getCurrentNode().getNodeName())) {
					Node item = workbook.getCurrentNode().getAttributes()
							.getNamedItem(XLSXHelper.SHEET_ID);
					if (item != null) {
						OfficeHelper.fillCollection(getUnzipper(), parsers,
								XLSXHelper.RELATIONSHIPS_SHEETS, idForDocument,
								XLSXHelper.DOCUMENT_RELS_FILE_NAME, item
										.getTextContent());
					}
				}
			} while (workbook.next());
		}
		return parsers;
	}

	public String getStyle() {
		return "";
	}

	public String getText() {
		String result = "";
		Node currentNode = getXMLParser().getCurrentNode();
		if (XLSXHelper.CELL.equals(currentNode.getNodeName())) {
			Node item = currentNode.getAttributes().getNamedItem(
					XLSXHelper.CELL_TYPE);
			for (int i = 0; i < currentNode.getChildNodes().getLength(); i++) {
				if (XLSXHelper.CELL_VALUE.equals(currentNode.getChildNodes()
						.item(i).getNodeName())) {
					String value = currentNode.getChildNodes().item(i)
							.getTextContent();
					if (item != null
							&& XLSXHelper.CELL_VALUE_SHARED_STRING.equals(item
									.getTextContent())) {
						try {
							int index = Integer.valueOf(value);
							if (index < strings.length) {
								result = strings[index];
							}
						} catch (NumberFormatException e) {
							// DO NOTHING
						}
					} else {
						result = value;
					}
					break;
				}
			}
		}
		return result;
	}

	public String getTextCorrespondingToCurrentStyle() {
		return null;
	}

	@@Override
	public int getColumnNumber() {
		// we init to -1 to not be matched if there is a problem
		int column = -1;
		Node currentNode = getXMLParser().getCurrentNode();
		if (XLSXHelper.CELL.equals(currentNode.getNodeName())) {
			Node item = currentNode.getAttributes().getNamedItem("r");
			if (item != null) {
				String[] columnArray = item.getTextContent().split("\\d");
				if (columnArray.length > 0) {
					String columnString = columnArray[0];
					column = getColumnNumber(columnString);
				}
			}
		}
		return column;
	}

	private int getColumnNumber(String columnString) {
		if (columnString == null || columnString.length() == 0) {
			return -1;
		}
		int finalValue = 0;
		int j = 0;
		for (int i = columnString.length() - 1; i >= 0; i--) {
			finalValue += getColumnNumber(columnString.charAt(i))
					* Math.pow(26, j);
			j++;
		}
		return finalValue - 1;
	}

	/**
	 * Return the column number for a character A ==> 1
	 * 
	 * @@param charAt
	 * @@return
	 */
	private int getColumnNumber(char charAt) {
		return charAt - 'A' + 1;
	}

	public Object get(String property) {
		if (PropertyConstants.ROW.equals(property)) {
			return getRowNumber();
		} else if (PropertyConstants.COLUMN.equals(property)) {
			return getColumnNumber();
		} else if (PropertyConstants.TEXT.equals(property)) {
			return getText();
		} else {
			return super.get(property);
		}
	}

	private int getRowNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

}
@
