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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regex Text Transformer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.RegexTextTransformer#getPatternForGroupingAndRegex <em>Pattern For Grouping And Regex</em>}</li>
 * </ul>
 * </p>
 *
 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getRegexTextTransformer()
 * @@model
 * @@generated
 */
public interface RegexTextTransformer extends TransformHandledText {
	/**
	 * Returns the value of the '<em><b>Pattern For Grouping And Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern For Grouping And Regex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @@return the value of the '<em>Pattern For Grouping And Regex</em>' attribute.
	 * @@see #setPatternForGroupingAndRegex(String)
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getRegexTextTransformer_PatternForGroupingAndRegex()
	 * @@model
	 * @@generated
	 */
	String getPatternForGroupingAndRegex();

	/**
	 * Sets the value of the '{@@link org.eclipse.emf.doc2model.doc2model.RegexTextTransformer#getPatternForGroupingAndRegex <em>Pattern For Grouping And Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@param value the new value of the '<em>Pattern For Grouping And Regex</em>' attribute.
	 * @@see #getPatternForGroupingAndRegex()
	 * @@generated
	 */
	void setPatternForGroupingAndRegex(String value);

} // RegexTextTransformer
@
