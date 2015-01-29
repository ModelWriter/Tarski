head	1.1;
access;
symbols;
locks; strict;
comment	@# @;


1.1
date	2010.03.02.22.28.07;	author tfaure;	state Exp;
branches;
next	;
commitid	6e914b8d90e34567;


desc
@@


1.1
log
@first commit for doc2model api edit
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
package org.eclipse.emf.doc2model.doc2model.provider;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.provider.EcoreEditPlugin;

/**
 * This is the central singleton for the Doc2model edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @@generated
 */
public final class Doc2modelEditPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public static final Doc2modelEditPlugin INSTANCE = new Doc2modelEditPlugin();

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public Doc2modelEditPlugin() {
		super
		  (new ResourceLocator [] {
		     EcoreEditPlugin.INSTANCE,
		   });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the singleton instance.
	 * @@generated
	 */
	@@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the singleton instance.
	 * @@generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public static class Implementation extends EclipsePlugin {
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}

}
@
