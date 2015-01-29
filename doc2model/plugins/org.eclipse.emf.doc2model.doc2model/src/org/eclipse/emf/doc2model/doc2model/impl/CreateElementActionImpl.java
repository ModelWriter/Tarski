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
package org.eclipse.emf.doc2model.doc2model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.doc2model.doc2model.ActionResultObject;
import org.eclipse.emf.doc2model.doc2model.ContainerSelectionObject;
import org.eclipse.emf.doc2model.doc2model.CreateElementAction;
import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;

import org.eclipse.emf.doc2model.doc2model.EPackageReference;
import org.eclipse.emf.doc2model.doc2model.Value;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Element Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.impl.CreateElementActionImpl#getEClassName <em>EClass Name</em>}</li>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.impl.CreateElementActionImpl#getEpackage <em>Epackage</em>}</li>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.impl.CreateElementActionImpl#getNewElement <em>New Element</em>}</li>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.impl.CreateElementActionImpl#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @@generated
 */
public class CreateElementActionImpl extends ActionImpl implements CreateElementAction {
	/**
	 * The default value of the '{@@link #getEClassName() <em>EClass Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see #getEClassName()
	 * @@generated
	 * @@ordered
	 */
	protected static final String ECLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@@link #getEClassName() <em>EClass Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see #getEClassName()
	 * @@generated
	 * @@ordered
	 */
	protected String eClassName = ECLASS_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@@link #getEpackage() <em>Epackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see #getEpackage()
	 * @@generated
	 * @@ordered
	 */
	protected EPackageReference epackage;

	/**
	 * The cached value of the '{@@link #getNewElement() <em>New Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see #getNewElement()
	 * @@generated
	 * @@ordered
	 */
	protected ActionResultObject newElement;

	/**
	 * The cached value of the '{@@link #getContainer() <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see #getContainer()
	 * @@generated
	 * @@ordered
	 */
	protected Value container;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	protected CreateElementActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	protected EClass eStaticClass() {
		return Doc2modelPackage.Literals.CREATE_ELEMENT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public String getEClassName() {
		return eClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public void setEClassName(String newEClassName) {
		String oldEClassName = eClassName;
		eClassName = newEClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.CREATE_ELEMENT_ACTION__ECLASS_NAME, oldEClassName, eClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EPackageReference getEpackage() {
		if (epackage != null && epackage.eIsProxy()) {
			InternalEObject oldEpackage = (InternalEObject)epackage;
			epackage = (EPackageReference)eResolveProxy(oldEpackage);
			if (epackage != oldEpackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Doc2modelPackage.CREATE_ELEMENT_ACTION__EPACKAGE, oldEpackage, epackage));
			}
		}
		return epackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EPackageReference basicGetEpackage() {
		return epackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public void setEpackage(EPackageReference newEpackage) {
		EPackageReference oldEpackage = epackage;
		epackage = newEpackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.CREATE_ELEMENT_ACTION__EPACKAGE, oldEpackage, epackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public ActionResultObject getNewElement() {
		if (newElement != null && newElement.eIsProxy()) {
			InternalEObject oldNewElement = (InternalEObject)newElement;
			newElement = (ActionResultObject)eResolveProxy(oldNewElement);
			if (newElement != oldNewElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Doc2modelPackage.CREATE_ELEMENT_ACTION__NEW_ELEMENT, oldNewElement, newElement));
			}
		}
		return newElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public ActionResultObject basicGetNewElement() {
		return newElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public void setNewElement(ActionResultObject newNewElement) {
		ActionResultObject oldNewElement = newElement;
		newElement = newNewElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.CREATE_ELEMENT_ACTION__NEW_ELEMENT, oldNewElement, newElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public Value getContainer() {
		if (container != null && container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject)container;
			container = (Value)eResolveProxy(oldContainer);
			if (container != oldContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Doc2modelPackage.CREATE_ELEMENT_ACTION__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public Value basicGetContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public void setContainer(Value newContainer) {
		Value oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.CREATE_ELEMENT_ACTION__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Doc2modelPackage.CREATE_ELEMENT_ACTION__ECLASS_NAME:
				return getEClassName();
			case Doc2modelPackage.CREATE_ELEMENT_ACTION__EPACKAGE:
				if (resolve) return getEpackage();
				return basicGetEpackage();
			case Doc2modelPackage.CREATE_ELEMENT_ACTION__NEW_ELEMENT:
				if (resolve) return getNewElement();
				return basicGetNewElement();
			case Doc2modelPackage.CREATE_ELEMENT_ACTION__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
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
			case Doc2modelPackage.CREATE_ELEMENT_ACTION__ECLASS_NAME:
				setEClassName((String)newValue);
				return;
			case Doc2modelPackage.CREATE_ELEMENT_ACTION__EPACKAGE:
				setEpackage((EPackageReference)newValue);
				return;
			case Doc2modelPackage.CREATE_ELEMENT_ACTION__NEW_ELEMENT:
				setNewElement((ActionResultObject)newValue);
				return;
			case Doc2modelPackage.CREATE_ELEMENT_ACTION__CONTAINER:
				setContainer((Value)newValue);
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
			case Doc2modelPackage.CREATE_ELEMENT_ACTION__ECLASS_NAME:
				setEClassName(ECLASS_NAME_EDEFAULT);
				return;
			case Doc2modelPackage.CREATE_ELEMENT_ACTION__EPACKAGE:
				setEpackage((EPackageReference)null);
				return;
			case Doc2modelPackage.CREATE_ELEMENT_ACTION__NEW_ELEMENT:
				setNewElement((ActionResultObject)null);
				return;
			case Doc2modelPackage.CREATE_ELEMENT_ACTION__CONTAINER:
				setContainer((Value)null);
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
			case Doc2modelPackage.CREATE_ELEMENT_ACTION__ECLASS_NAME:
				return ECLASS_NAME_EDEFAULT == null ? eClassName != null : !ECLASS_NAME_EDEFAULT.equals(eClassName);
			case Doc2modelPackage.CREATE_ELEMENT_ACTION__EPACKAGE:
				return epackage != null;
			case Doc2modelPackage.CREATE_ELEMENT_ACTION__NEW_ELEMENT:
				return newElement != null;
			case Doc2modelPackage.CREATE_ELEMENT_ACTION__CONTAINER:
				return container != null;
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
		result.append(" (eClassName: ");
		result.append(eClassName);
		result.append(')');
		return result.toString();
	}

} //CreateElementActionImpl
@
