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

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class Logger {
	public static Logger INSTANCE = new Logger();

	private Logger() {
	}

	protected ILog getLogger() {
		return Documents.getDefault().getLog();
	}

	public void log(final Exception e) {
		log(e, IStatus.WARNING);
	}

	/**
	 * Log.
	 * 
	 * @@param e
	 *            the exception
	 * @@param severity
	 *            the severity
	 */
	public void log(Exception e, int severity) {
		IStatus status = new Status(severity, Documents.PLUGIN_ID, e
				.getMessage(), e);
		getLogger().log(status);
	}
}
@
