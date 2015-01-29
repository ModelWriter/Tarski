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
@
