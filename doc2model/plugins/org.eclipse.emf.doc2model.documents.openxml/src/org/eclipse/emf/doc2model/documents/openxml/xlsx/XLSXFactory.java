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
import java.util.Map;

import org.eclipse.emf.doc2model.documents.DocumentFactory;
import org.eclipse.emf.doc2model.documents.IDocument;

/**
 * A factory for creating XLSX objects.
 */
public class XLSXFactory implements DocumentFactory {

	public XLSXFactory() {
	}

	public IDocument loadDocument(String documentFile) {
		return loadDocument(documentFile, null);
	}

	public IDocument loadDocument(String documentFile,
			Map<String, Object> configuration) {
		return new XLSXDocument(new File(documentFile), configuration);
	}

	public boolean handles(String uriPath) {
		return uriPath != null && uriPath.toLowerCase().endsWith("xlsx");
	}

}
@
