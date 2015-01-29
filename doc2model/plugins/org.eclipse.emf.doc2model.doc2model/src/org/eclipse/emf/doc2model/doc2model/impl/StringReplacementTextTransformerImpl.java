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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;
import org.eclipse.emf.doc2model.doc2model.StringReplacementTextTransformer;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Replacement Text Transformer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.impl.StringReplacementTextTransformerImpl#getStringReplacement <em>String Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @@generated
 */
public class StringReplacementTextTransformerImpl extends TransformHandledTextImpl implements StringReplacementTextTransformer {
	/**
	 * The default value of the '{@@link #getStringReplacement() <em>String Replacement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see #getStringReplacement()
	 * @@generated
	 * @@ordered
	 */
	protected static final String STRING_REPLACEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@@link #getStringReplacement() <em>String Replacement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see #getStringReplacement()
	 * @@generated
	 * @@ordered
	 */
	protected String stringReplacement = STRING_REPLACEMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	protected StringReplacementTextTransformerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	protected EClass eStaticClass() {
		return Doc2modelPackage.Literals.STRING_REPLACEMENT_TEXT_TRANSFORMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public String getStringReplacement() {
		return stringReplacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public void setStringReplacement(String newStringReplacement) {
		String oldStringReplacement = stringReplacement;
		stringReplacement = newStringReplacement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.STRING_REPLACEMENT_TEXT_TRANSFORMER__STRING_REPLACEMENT, oldStringReplacement, stringReplacement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Doc2modelPackage.STRING_REPLACEMENT_TEXT_TRANSFORMER__STRING_REPLACEMENT:
				return getStringReplacement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Doc2modelPackage.STRING_REPLACEMENT_TEXT_TRANSFORMER__STRING_REPLACEMENT:
				setStringReplacement((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Doc2modelPackage.STRING_REPLACEMENT_TEXT_TRANSFORMER__STRING_REPLACEMENT:
				setStringReplacement(STRING_REPLACEMENT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Doc2modelPackage.STRING_REPLACEMENT_TEXT_TRANSFORMER__STRING_REPLACEMENT:
				return STRING_REPLACEMENT_EDEFAULT == null ? stringReplacement != null : !STRING_REPLACEMENT_EDEFAULT.equals(stringReplacement);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (stringReplacement: ");
		result.append(stringReplacement);
		result.append(')');
		return result.toString();
	}

} //StringReplacementTextTransformerImpl
@
