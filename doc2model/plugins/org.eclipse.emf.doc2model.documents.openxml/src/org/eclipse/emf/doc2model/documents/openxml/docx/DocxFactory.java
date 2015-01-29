head	1.1;
access;
symbols;
locks; strict;
comment	@# @;


1.1
date	2010.03.02.22.32.37;	author tfaure;	state Exp;
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
package org.eclipse.emf.doc2model.documents.openxml.docx;

import java.io.File;
import java.util.Map;

import org.eclipse.emf.doc2model.documents.DocumentFactory;
import org.eclipse.emf.doc2model.documents.IDocument;

/**
 * The Class DocxFactory.
 * 
 * @@author tristan.faure@@atosorigin.com
 */
public class DocxFactory implements DocumentFactory {
	/** The instance. */
	private static DocxFactory instance = new DocxFactory();

	/**
	 * Default constructor.
	 */
	public DocxFactory() {
	}

	/**
	 * Method for implemented interface : architecture.DocumentFactory
	 * 
	 * @@return the instance
	 * 
	 * @@see architecture.DocumentFactory#getInstance
	 */
	public static DocumentFactory getInstance() {
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @@see
	 * org.topcased.doc2model.documents.DocumentFactory#loadDocument(java.io
	 * .File)
	 */
	public IDocument loadDocument(String file) {
		return loadDocument(file, null);
	}

	public IDocument loadDocument(String documentFile,
			Map<String, Object> configuration) {
		DocxDocument document = new DocxDocument(new File(documentFile),
				configuration);
		return document;
	}

	public boolean handles(String uriPath) {
		return uriPath != null && uriPath.toLowerCase().endsWith("docx");
	}

}
@
