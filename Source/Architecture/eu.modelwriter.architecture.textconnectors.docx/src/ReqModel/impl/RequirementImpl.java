/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    A. Furkan Tanriverdi (UNIT) - initial API and implementation
 *******************************************************************************/
/**
 */
package ReqModel.impl;

import ReqModel.Priority;
import ReqModel.ReqModelPackage;
import ReqModel.Requirement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ReqModel.impl.RequirementImpl#getId <em>Id</em>}</li>
 *   <li>{@link ReqModel.impl.RequirementImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link ReqModel.impl.RequirementImpl#getRefine <em>Refine</em>}</li>
 *   <li>{@link ReqModel.impl.RequirementImpl#getDependencyTo <em>Dependency To</em>}</li>
 *   <li>{@link ReqModel.impl.RequirementImpl#getPriorityType <em>Priority Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementImpl extends DefinitionImpl implements Requirement {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRefine() <em>Refine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefine()
	 * @generated
	 * @ordered
	 */
	protected Requirement refine;

	/**
	 * The cached value of the '{@link #getDependencyTo() <em>Dependency To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencyTo()
	 * @generated
	 * @ordered
	 */
	protected Requirement dependencyTo;

	/**
	 * The default value of the '{@link #getPriorityType() <em>Priority Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriorityType()
	 * @generated
	 * @ordered
	 */
	protected static final Priority PRIORITY_TYPE_EDEFAULT = Priority.MANDATORY;

	/**
	 * The cached value of the '{@link #getPriorityType() <em>Priority Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriorityType()
	 * @generated
	 * @ordered
	 */
	protected Priority priorityType = PRIORITY_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReqModelPackage.Literals.REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReqModelPackage.REQUIREMENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReqModelPackage.REQUIREMENT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement getRefine() {
		if (refine != null && refine.eIsProxy()) {
			InternalEObject oldRefine = (InternalEObject)refine;
			refine = (Requirement)eResolveProxy(oldRefine);
			if (refine != oldRefine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqModelPackage.REQUIREMENT__REFINE, oldRefine, refine));
			}
		}
		return refine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement basicGetRefine() {
		return refine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefine(Requirement newRefine) {
		Requirement oldRefine = refine;
		refine = newRefine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReqModelPackage.REQUIREMENT__REFINE, oldRefine, refine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement getDependencyTo() {
		if (dependencyTo != null && dependencyTo.eIsProxy()) {
			InternalEObject oldDependencyTo = (InternalEObject)dependencyTo;
			dependencyTo = (Requirement)eResolveProxy(oldDependencyTo);
			if (dependencyTo != oldDependencyTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqModelPackage.REQUIREMENT__DEPENDENCY_TO, oldDependencyTo, dependencyTo));
			}
		}
		return dependencyTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement basicGetDependencyTo() {
		return dependencyTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependencyTo(Requirement newDependencyTo) {
		Requirement oldDependencyTo = dependencyTo;
		dependencyTo = newDependencyTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReqModelPackage.REQUIREMENT__DEPENDENCY_TO, oldDependencyTo, dependencyTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Priority getPriorityType() {
		return priorityType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriorityType(Priority newPriorityType) {
		Priority oldPriorityType = priorityType;
		priorityType = newPriorityType == null ? PRIORITY_TYPE_EDEFAULT : newPriorityType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReqModelPackage.REQUIREMENT__PRIORITY_TYPE, oldPriorityType, priorityType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ReqModelPackage.REQUIREMENT__ID:
				return getId();
			case ReqModelPackage.REQUIREMENT__DESCRIPTION:
				return getDescription();
			case ReqModelPackage.REQUIREMENT__REFINE:
				if (resolve) return getRefine();
				return basicGetRefine();
			case ReqModelPackage.REQUIREMENT__DEPENDENCY_TO:
				if (resolve) return getDependencyTo();
				return basicGetDependencyTo();
			case ReqModelPackage.REQUIREMENT__PRIORITY_TYPE:
				return getPriorityType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ReqModelPackage.REQUIREMENT__ID:
				setId((String)newValue);
				return;
			case ReqModelPackage.REQUIREMENT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ReqModelPackage.REQUIREMENT__REFINE:
				setRefine((Requirement)newValue);
				return;
			case ReqModelPackage.REQUIREMENT__DEPENDENCY_TO:
				setDependencyTo((Requirement)newValue);
				return;
			case ReqModelPackage.REQUIREMENT__PRIORITY_TYPE:
				setPriorityType((Priority)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ReqModelPackage.REQUIREMENT__ID:
				setId(ID_EDEFAULT);
				return;
			case ReqModelPackage.REQUIREMENT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ReqModelPackage.REQUIREMENT__REFINE:
				setRefine((Requirement)null);
				return;
			case ReqModelPackage.REQUIREMENT__DEPENDENCY_TO:
				setDependencyTo((Requirement)null);
				return;
			case ReqModelPackage.REQUIREMENT__PRIORITY_TYPE:
				setPriorityType(PRIORITY_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ReqModelPackage.REQUIREMENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ReqModelPackage.REQUIREMENT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ReqModelPackage.REQUIREMENT__REFINE:
				return refine != null;
			case ReqModelPackage.REQUIREMENT__DEPENDENCY_TO:
				return dependencyTo != null;
			case ReqModelPackage.REQUIREMENT__PRIORITY_TYPE:
				return priorityType != PRIORITY_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (Id: ");
		result.append(id);
		result.append(", Description: ");
		result.append(description);
		result.append(", PriorityType: ");
		result.append(priorityType);
		result.append(')');
		return result.toString();
	}

} //RequirementImpl
