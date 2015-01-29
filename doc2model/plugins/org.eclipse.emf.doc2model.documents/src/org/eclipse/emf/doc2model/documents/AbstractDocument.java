head	1.2;
access;
symbols;
locks; strict;
comment	@# @;


1.2
date	2010.07.26.14.24.34;	author tfaure;	state Exp;
branches;
next	1.1;
commitid	3f87d4c4d9aa24567;

1.1
date	2010.03.02.22.30.42;	author tfaure;	state Exp;
branches;
next	;
commitid	73794b8d918e4567;


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
package org.eclipse.emf.doc2model.documents;

import java.io.File;
import java.util.Map;

import org.eclipse.emf.doc2model.documents.constants.PropertyConstants;

/**
 * Abstract Document.
 * 
 * @@author tristan.faure@@atosorigin.com
 */
public abstract class AbstractDocument implements IMultiFileDocument,
		IXMLDocument {

	private File file;

	/**
	 * Instantiates a new abstract document.
	 * 
	 * @@param document
	 *            the document
	 */
	public AbstractDocument(File pFile) {
		this(pFile, null);
	}

	public AbstractDocument(File documentFile, Map<String, Object> configuration) {
		this.file = documentFile;
	}

	/**
	 * @@see org.eclipse.emf.doc2model.documents.IDocument.documents.Document#getDocumentFile()
	 */
	public File getDocumentFile() {
		return file;
	}

	/**
	 * @@see org.eclipse.emf.doc2model.documents.IDocument.documents.Document#getColumnNumber()
	 */
	public int getColumnNumber() {
		return 0;
	}

	public Object get(String property) {
		if (PropertyConstants.DOCUMENT_NAME.equals(property)) {
			return file.getName();
		}
		return null;
	}
}
@


1.1
log
@first commit for doc2model api : documents
this plugin contains interface for IDocument and some utils classes to handle xmls, zip documents
@
text
@d21 1
a21 1
 * Abstract Document unzip OO and word.
a63 1

@

