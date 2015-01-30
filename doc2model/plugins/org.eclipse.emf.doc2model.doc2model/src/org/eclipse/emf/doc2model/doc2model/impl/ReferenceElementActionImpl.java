package org.eclipse.emf.doc2model.doc2model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;
import org.eclipse.emf.doc2model.doc2model.ReferenceElementAction;

import org.eclipse.emf.doc2model.doc2model.Value;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Element Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.ReferenceElementActionImpl#getToAssign <em>To Assign</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceElementActionImpl extends ReferenceActionImpl implements ReferenceElementAction {
	/**
	 * The cached value of the '{@link #getToAssign() <em>To Assign</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToAssign()
	 * @generated
	 * @ordered
	 */
	protected Value toAssign;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceElementActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Doc2modelPackage.Literals.REFERENCE_ELEMENT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value getToAssign() {
		if (toAssign != null && toAssign.eIsProxy()) {
			InternalEObject oldToAssign = (InternalEObject)toAssign;
			toAssign = (Value)eResolveProxy(oldToAssign);
			if (toAssign != oldToAssign) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Doc2modelPackage.REFERENCE_ELEMENT_ACTION__TO_ASSIGN, oldToAssign, toAssign));
			}
		}
		return toAssign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value basicGetToAssign() {
		return toAssign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToAssign(Value newToAssign) {
		Value oldToAssign = toAssign;
		toAssign = newToAssign;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.REFERENCE_ELEMENT_ACTION__TO_ASSIGN, oldToAssign, toAssign));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Doc2modelPackage.REFERENCE_ELEMENT_ACTION__TO_ASSIGN:
				if (resolve) return getToAssign();
				return basicGetToAssign();
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
			case Doc2modelPackage.REFERENCE_ELEMENT_ACTION__TO_ASSIGN:
				setToAssign((Value)newValue);
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
			case Doc2modelPackage.REFERENCE_ELEMENT_ACTION__TO_ASSIGN:
				setToAssign((Value)null);
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
			case Doc2modelPackage.REFERENCE_ELEMENT_ACTION__TO_ASSIGN:
				return toAssign != null;
		}
		return super.eIsSet(featureID);
	}

} //ReferenceElementActionImpl
