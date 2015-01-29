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
date	2010.03.02.22.30.41;	author tfaure;	state Exp;
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
package org.eclipse.emf.doc2model.documents.constants;

public interface PropertyConstants {
	public static final String DOCUMENT_NAME = "PROPERTY_CONSTANTS_DOCUMENT_NAME";
	public static final String TEXT = "PROPERTY_CONSTANTS_TEXT";
	public static final String COLUMN = "PROPERTY_CONSTANTS_COLUMN";
	public static final String ROW = "PROPERTY_CONSTANTS_ROW";
	public static final String STYLE = "PROPERTY_CONSTANTS_STYLE";
}
@


1.1
log
@first commit for doc2model api : documents
this plugin contains interface for IDocument and some utils classes to handle xmls, zip documents
@
text
@a16 1
	public static final String STYLE = "PROPERTY_CONSTANTS_STYLE";
d20 1
a20 1

@

