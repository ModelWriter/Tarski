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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.ParameterObject#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getParameterObject()
 * @@model
 * @@generated
 */
public interface ParameterObject extends Value {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@@link org.eclipse.emf.doc2model.doc2model.ParameterKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @@return the value of the '<em>Kind</em>' attribute.
	 * @@see org.eclipse.emf.doc2model.doc2model.ParameterKind
	 * @@see #setKind(ParameterKind)
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getParameterObject_Kind()
	 * @@model
	 * @@generated
	 */
	ParameterKind getKind();

	/**
	 * Sets the value of the '{@@link org.eclipse.emf.doc2model.doc2model.ParameterObject#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@param value the new value of the '<em>Kind</em>' attribute.
	 * @@see org.eclipse.emf.doc2model.doc2model.ParameterKind
	 * @@see #getKind()
	 * @@generated
	 */
	void setKind(ParameterKind value);

} // ParameterObject
@
