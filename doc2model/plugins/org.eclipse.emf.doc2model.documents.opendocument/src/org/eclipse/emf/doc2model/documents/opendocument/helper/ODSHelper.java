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
package org.eclipse.emf.doc2model.documents.opendocument.helper;

/**
 * The Class ODSHelper.
 */
public final class ODSHelper {
	public static final String CONTENTS_FILE_NAME = "content.xml";
	public static final String CELL = "table:table-cell";
	public static final String PARA = "text:p";
	public static final String ROW = "table:table-row";
	public static final String COL_REPEAT = "table:number-columns-repeated";

	private ODSHelper() {
	}

}
@
