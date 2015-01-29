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
package org.eclipse.emf.doc2model.documents.openxml.helper;

/**
 * The Class XLSXHelper.
 */
public final class XLSXHelper {
	/** The Constant CONTENTS_FILE_NAME. */
	public static final String CONTENTS_FILE_NAME = "workbook.xml";

	public static final String RELATIONSHIPS_SHEETS = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/worksheet";

	public static final String DOCUMENT_RELS_FILE_NAME = "workbook.xml.rels";

	public static final String CELL = "c";

	public static final String CELL_TYPE = "t";

	public static final String CELL_VALUE = "v";

	public static final String CELL_VALUE_SHARED_STRING = "s";

	public static final String SHEET_ID = "r:id";

	public static final String SHARED_STRING_FILE = "sharedStrings.xml";

	public static final String ATTRIBUTE_COUNT = "uniqueCount";

	public static final String RELATIONSHIPS_COMMENTS = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments";

	private XLSXHelper() {
		// do nothing
	}
}
@
