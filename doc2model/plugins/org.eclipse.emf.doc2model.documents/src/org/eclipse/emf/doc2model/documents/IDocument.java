head	1.1;
access;
symbols;
locks; strict;
comment	@# @;


1.1
date	2010.03.02.22.30.42;	author tfaure;	state Exp;
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
package org.eclipse.emf.doc2model.documents;

import java.io.File;

/**
 * The Interface Document.
 * 
 * @@author tristan.faure@@atosorigin.com
 */
public interface IDocument {
	/**
	 * Next.
	 * 
	 * @@return false if there is no next
	 */
	boolean next();

	/**
	 * Gets the value corresponding to the property
	 * 
	 * @@param property
	 *            the property
	 * 
	 * @@return the string
	 */
	Object get(String property);

	void call(String operation);

	/**
	 * Get the input file document
	 * 
	 * @@return the file
	 */
	File getDocumentFile();

}@
