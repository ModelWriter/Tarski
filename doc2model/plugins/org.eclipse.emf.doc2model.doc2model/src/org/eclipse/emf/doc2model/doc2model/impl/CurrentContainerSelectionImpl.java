head	1.1;
access;
symbols;
locks; strict;
comment	@# @;


1.1
date	2010.03.02.22.19.51;	author tfaure;	state Exp;
branches;
next	;
commitid	66574b8d8ee24567;


desc
@@


1.1
log
@first commit for doc2model api
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
package org.eclipse.emf.doc2model.doc2model.impl;

import org.eclipse.emf.doc2model.doc2model.CurrentContainerSelection;
import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Current Container Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @@generated
 */
public class CurrentContainerSelectionImpl extends ElementSelectionImpl implements CurrentContainerSelection {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	protected CurrentContainerSelectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	protected EClass eStaticClass() {
		return Doc2modelPackage.Literals.CURRENT_CONTAINER_SELECTION;
	}

	@@Override
	public EObject getElement() {
		return null;
	}
	
	

} //CurrentContainerSelectionImpl
@
