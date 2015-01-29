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
package org.eclipse.emf.doc2model.documents;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Documents extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.emf.doc2model.documents"; //$NON-NLS-1$

	// The shared instance
	private static Documents plugin;

	/**
	 * The constructor
	 */
	public Documents() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @@see
	 * org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @@see
	 * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @@return the shared instance
	 */
	public static Documents getDefault() {
		return plugin;
	}

}
@
