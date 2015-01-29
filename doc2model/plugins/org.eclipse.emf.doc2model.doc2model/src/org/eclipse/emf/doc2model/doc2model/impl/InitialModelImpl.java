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
import org.eclipse.emf.doc2model.doc2model.InitialModel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Initial Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.impl.InitialModelImpl#isCopy <em>Copy</em>}</li>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.impl.InitialModelImpl#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @@generated
 */
public class InitialModelImpl extends EObjectImpl implements InitialModel {
	/**
	 * The default value of the '{@@link #isCopy() <em>Copy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see #isCopy()
	 * @@generated
	 * @@ordered
	 */
	protected static final boolean COPY_EDEFAULT = false;

	/**
	 * The cached value of the '{@@link #isCopy() <em>Copy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see #isCopy()
	 * @@generated
	 * @@ordered
	 */
	protected boolean copy = COPY_EDEFAULT;

	/**
	 * The cached value of the '{@@link #getReference() <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see #getReference()
	 * @@generated
	 * @@ordered
	 */
	protected EObject reference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	protected InitialModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	protected EClass eStaticClass() {
		return Doc2modelPackage.Literals.INITIAL_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public boolean isCopy() {
		return copy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public void setCopy(boolean newCopy) {
		boolean oldCopy = copy;
		copy = newCopy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.INITIAL_MODEL__COPY, oldCopy, copy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EObject getReference() {
		if (reference != null && reference.eIsProxy()) {
			InternalEObject oldReference = (InternalEObject)reference;
			reference = eResolveProxy(oldReference);
			if (reference != oldReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Doc2modelPackage.INITIAL_MODEL__REFERENCE, oldReference, reference));
			}
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EObject basicGetReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public void setReference(EObject newReference) {
		EObject oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.INITIAL_MODEL__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Doc2modelPackage.INITIAL_MODEL__COPY:
				return isCopy();
			case Doc2modelPackage.INITIAL_MODEL__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
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
			case Doc2modelPackage.INITIAL_MODEL__COPY:
				setCopy((Boolean)newValue);
				return;
			case Doc2modelPackage.INITIAL_MODEL__REFERENCE:
				setReference((EObject)newValue);
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
			case Doc2modelPackage.INITIAL_MODEL__COPY:
				setCopy(COPY_EDEFAULT);
				return;
			case Doc2modelPackage.INITIAL_MODEL__REFERENCE:
				setReference((EObject)null);
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
			case Doc2modelPackage.INITIAL_MODEL__COPY:
				return copy != COPY_EDEFAULT;
			case Doc2modelPackage.INITIAL_MODEL__REFERENCE:
				return reference != null;
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
		result.append(" (copy: ");
		result.append(copy);
		result.append(')');
		return result.toString();
	}

} //InitialModelImpl
@
