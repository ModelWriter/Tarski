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
package org.eclipse.emf.doc2model.documents.opendocument.ods;

import java.io.File;
import java.util.Map;

import org.eclipse.emf.doc2model.documents.DocumentFactory;
import org.eclipse.emf.doc2model.documents.IDocument;

/**
 * A factory for creating ODS objects.
 */
public class ODSFactory implements DocumentFactory {

	/**
	 * Instantiates a new oDS factory.
	 */
	public ODSFactory() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @@see
	 * org.topcased.document.parser.documents.DocumentFactory#loadDocument(java
	 * .io.File)
	 */
	public IDocument loadDocument(String documentFile) {
		return loadDocument(documentFile, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @@see
	 * org.topcased.document.parser.documents.DocumentFactory#loadDocument(java
	 * .io.File, java.util.Map)
	 */
	public IDocument loadDocument(String documentFile,
			Map<String, Object> configuration) {
		return new ODSDocument(new File(documentFile), configuration);
	}

	public boolean handles(String uriPath) {
		return uriPath != null && uriPath.toLowerCase().endsWith("ods");
	}

}
@
