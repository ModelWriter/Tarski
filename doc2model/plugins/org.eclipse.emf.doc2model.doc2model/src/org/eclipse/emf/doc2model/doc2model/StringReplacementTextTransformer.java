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
 * A representation of the model object '<em><b>String Replacement Text Transformer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.StringReplacementTextTransformer#getStringReplacement <em>String Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getStringReplacementTextTransformer()
 * @@model
 * @@generated
 */
public interface StringReplacementTextTransformer extends TransformHandledText {
	/**
	 * Returns the value of the '<em><b>String Replacement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Replacement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @@return the value of the '<em>String Replacement</em>' attribute.
	 * @@see #setStringReplacement(String)
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getStringReplacementTextTransformer_StringReplacement()
	 * @@model
	 * @@generated
	 */
	String getStringReplacement();

	/**
	 * Sets the value of the '{@@link org.eclipse.emf.doc2model.doc2model.StringReplacementTextTransformer#getStringReplacement <em>String Replacement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@param value the new value of the '<em>String Replacement</em>' attribute.
	 * @@see #getStringReplacement()
	 * @@generated
	 */
	void setStringReplacement(String value);

} // StringReplacementTextTransformer
@
