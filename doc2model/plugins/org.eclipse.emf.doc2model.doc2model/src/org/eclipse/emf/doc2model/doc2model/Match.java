head	1.1;
access;
symbols;
locks; strict;
comment	@# @;


1.1
date	2010.03.02.22.19.50;	author tfaure;	state Exp;
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
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Match</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.Match#getUri <em>Uri</em>}</li>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.Match#getHigherThan <em>Higher Than</em>}</li>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.Match#getLowerThan <em>Lower Than</em>}</li>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.Match#getRule <em>Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getMatch()
 * @@model
 * @@generated
 */
public interface Match extends ObjectContainer {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute list.
	 * The list contents are of type {@@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * uri to define match kind
	 * for example if a plugin references the regex scheme it will able to recgnize a uri of this kind :
	 * regex:/REQ-(\s.*)
	 * <!-- end-model-doc -->
	 * @@return the value of the '<em>Uri</em>' attribute list.
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getMatch_Uri()
	 * @@model
	 * @@generated
	 */
	EList<String> getUri();

	/**
	 * Returns the value of the '<em><b>Higher Than</b></em>' reference list.
	 * The list contents are of type {@@link org.eclipse.emf.doc2model.doc2model.Match}.
	 * It is bidirectional and its opposite is '{@@link org.eclipse.emf.doc2model.doc2model.Match#getLowerThan <em>Lower Than</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Higher Than</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @@return the value of the '<em>Higher Than</em>' reference list.
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getMatch_HigherThan()
	 * @@see org.eclipse.emf.doc2model.doc2model.Match#getLowerThan
	 * @@model opposite="lowerThan"
	 * @@generated
	 */
	EList<Match> getHigherThan();

	/**
	 * Returns the value of the '<em><b>Lower Than</b></em>' reference list.
	 * The list contents are of type {@@link org.eclipse.emf.doc2model.doc2model.Match}.
	 * It is bidirectional and its opposite is '{@@link org.eclipse.emf.doc2model.doc2model.Match#getHigherThan <em>Higher Than</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Than</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @@return the value of the '<em>Lower Than</em>' reference list.
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getMatch_LowerThan()
	 * @@see org.eclipse.emf.doc2model.doc2model.Match#getHigherThan
	 * @@model opposite="higherThan"
	 * @@generated
	 */
	EList<Match> getLowerThan();

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' reference.
	 * It is bidirectional and its opposite is '{@@link org.eclipse.emf.doc2model.doc2model.Rule#getMatch <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @@return the value of the '<em>Rule</em>' reference.
	 * @@see #setRule(Rule)
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getMatch_Rule()
	 * @@see org.eclipse.emf.doc2model.doc2model.Rule#getMatch
	 * @@model opposite="match"
	 * @@generated
	 */
	Rule getRule();

	/**
	 * Sets the value of the '{@@link org.eclipse.emf.doc2model.doc2model.Match#getRule <em>Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@param value the new value of the '<em>Rule</em>' reference.
	 * @@see #getRule()
	 * @@generated
	 */
	void setRule(Rule value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@model kind="operation" dataType="org.eclipse.emf.doc2model.doc2model.URI"
	 * @@generated
	 */
	EList<URI> getURI();

} // Match
@
