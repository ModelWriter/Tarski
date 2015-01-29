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

import org.eclipse.emf.doc2model.doc2model.ActionWithOutParameter;
import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;
import org.eclipse.emf.doc2model.doc2model.Value;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action With Out Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.impl.ActionWithOutParameterImpl#getOut <em>Out</em>}</li>
 * </ul>
 * </p>
 *
 * @@generated
 */
public abstract class ActionWithOutParameterImpl extends EObjectImpl implements ActionWithOutParameter {
	/**
	 * The cached value of the '{@@link #getOut() <em>Out</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see #getOut()
	 * @@generated
	 * @@ordered
	 */
	protected Value out;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	protected ActionWithOutParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	protected EClass eStaticClass() {
		return Doc2modelPackage.Literals.ACTION_WITH_OUT_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public Value getOut() {
		if (out != null && out.eIsProxy()) {
			InternalEObject oldOut = (InternalEObject)out;
			out = (Value)eResolveProxy(oldOut);
			if (out != oldOut) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Doc2modelPackage.ACTION_WITH_OUT_PARAMETER__OUT, oldOut, out));
			}
		}
		return out;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public Value basicGetOut() {
		return out;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public void setOut(Value newOut) {
		Value oldOut = out;
		out = newOut;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.ACTION_WITH_OUT_PARAMETER__OUT, oldOut, out));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Doc2modelPackage.ACTION_WITH_OUT_PARAMETER__OUT:
				if (resolve) return getOut();
				return basicGetOut();
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
			case Doc2modelPackage.ACTION_WITH_OUT_PARAMETER__OUT:
				setOut((Value)newValue);
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
			case Doc2modelPackage.ACTION_WITH_OUT_PARAMETER__OUT:
				setOut((Value)null);
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
			case Doc2modelPackage.ACTION_WITH_OUT_PARAMETER__OUT:
				return out != null;
		}
		return super.eIsSet(featureID);
	}

} //ActionWithOutParameterImpl
@
