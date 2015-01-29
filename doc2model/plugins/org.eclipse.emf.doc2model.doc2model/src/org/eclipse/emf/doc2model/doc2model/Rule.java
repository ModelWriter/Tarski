head	1.1;
access;
symbols;
locks; strict;
comment	@# @;


1.1
date	2010.03.02.22.19.49;	author tfaure;	state Exp;
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
package org.eclipse.emf.doc2model.doc2model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.Rule#getMatch <em>Match</em>}</li>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.Rule#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getRule()
 * @@model
 * @@generated
 */
public interface Rule extends EObject {
	/**
	 * Returns the value of the '<em><b>Match</b></em>' reference.
	 * It is bidirectional and its opposite is '{@@link org.eclipse.emf.doc2model.doc2model.Match#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Match</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @@return the value of the '<em>Match</em>' reference.
	 * @@see #setMatch(Match)
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getRule_Match()
	 * @@see org.eclipse.emf.doc2model.doc2model.Match#getRule
	 * @@model opposite="rule"
	 * @@generated
	 */
	Match getMatch();

	/**
	 * Sets the value of the '{@@link org.eclipse.emf.doc2model.doc2model.Rule#getMatch <em>Match</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@param value the new value of the '<em>Match</em>' reference.
	 * @@see #getMatch()
	 * @@generated
	 */
	void setMatch(Match value);

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' reference list.
	 * The list contents are of type {@@link org.eclipse.emf.doc2model.doc2model.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @@return the value of the '<em>Actions</em>' reference list.
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getRule_Actions()
	 * @@model
	 * @@generated
	 */
	EList<Action> getActions();

} // Rule
@
