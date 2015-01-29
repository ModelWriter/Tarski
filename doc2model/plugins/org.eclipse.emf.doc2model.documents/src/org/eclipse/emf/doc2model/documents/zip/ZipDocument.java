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
package org.eclipse.emf.doc2model.documents.zip;

import java.io.File;

import org.eclipse.emf.doc2model.documents.IDocument;

/**
 * The Interface ZipDocument.
 */
public interface ZipDocument extends IDocument {

	/**
	 * 
	 * @@param locationToZip
	 */
	File getUnzipLocationDocumentFile();

	void zipToLocation(String locationToZip);
}
@
