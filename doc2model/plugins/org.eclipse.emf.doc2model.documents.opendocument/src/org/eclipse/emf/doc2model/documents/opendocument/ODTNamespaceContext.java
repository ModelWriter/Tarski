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
package org.eclipse.emf.doc2model.documents.opendocument;

import java.util.Iterator;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;

/**
 * The Class ODTNamespaceContext.
 * 
 * @@author tristan.faure@@atosorigin.com
 */
public class ODTNamespaceContext implements NamespaceContext {

	/*
	 * (non-Javadoc)
	 * 
	 * @@see
	 * javax.xml.namespace.NamespaceContext#getNamespaceURI(java.lang.String)
	 */
	public String getNamespaceURI(String prefix) {

		if (prefix == null) {
			throw new NullPointerException("Null prefix");
		} else if ("style".equals(prefix)) {
			return "urn:oasis:names:tc:opendocument:xmlns:style:1.0";
		} else if ("xml".equals(prefix)) {
			return XMLConstants.XML_NS_URI;
		} else if ("text".equals(prefix)) {
			return "urn:oasis:names:tc:opendocument:xmlns:text:1.0";
		}

		return XMLConstants.NULL_NS_URI;

	}

	// This method isn't necessary for XPath processing.
	/*
	 * (non-Javadoc)
	 * 
	 * @@see javax.xml.namespace.NamespaceContext#getPrefix(java.lang.String)
	 */
	public String getPrefix(String uri) {

		throw new UnsupportedOperationException();

	}

	// This method isn't necessary for XPath processing either.
	/*
	 * (non-Javadoc)
	 * 
	 * @@see javax.xml.namespace.NamespaceContext#getPrefixes(java.lang.String)
	 */
	public Iterator getPrefixes(String uri) {

		throw new UnsupportedOperationException();

	}

}
@
