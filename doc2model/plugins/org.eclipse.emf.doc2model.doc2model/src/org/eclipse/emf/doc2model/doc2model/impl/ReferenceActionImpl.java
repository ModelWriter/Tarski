package org.eclipse.emf.doc2model.doc2model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;
import org.eclipse.emf.doc2model.doc2model.ReferenceAction;

import org.eclipse.emf.doc2model.doc2model.Value;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.ReferenceActionImpl#getReferenceAttribute <em>Reference Attribute</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.ReferenceActionImpl#getCurrentElement <em>Current Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ReferenceActionImpl extends ActionImpl implements ReferenceAction {
	/**
	 * The default value of the '{@link #getReferenceAttribute() <em>Reference Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERENCE_ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReferenceAttribute() <em>Reference Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceAttribute()
	 * @generated
	 * @ordered
	 */
	protected String referenceAttribute = REFERENCE_ATTRIBUTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCurrentElement() <em>Current Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentElement()
	 * @generated
	 * @ordered
	 */
	protected Value currentElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Doc2modelPackage.Literals.REFERENCE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReferenceAttribute() {
		return referenceAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceAttribute(String newReferenceAttribute) {
		String oldReferenceAttribute = referenceAttribute;
		referenceAttribute = newReferenceAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.REFERENCE_ACTION__REFERENCE_ATTRIBUTE, oldReferenceAttribute, referenceAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value getCurrentElement() {
		if (currentElement != null && currentElement.eIsProxy()) {
			InternalEObject oldCurrentElement = (InternalEObject)currentElement;
			currentElement = (Value)eResolveProxy(oldCurrentElement);
			if (currentElement != oldCurrentElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Doc2modelPackage.REFERENCE_ACTION__CURRENT_ELEMENT, oldCurrentElement, currentElement));
			}
		}
		return currentElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value basicGetCurrentElement() {
		return currentElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentElement(Value newCurrentElement) {
		Value oldCurrentElement = currentElement;
		currentElement = newCurrentElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.REFERENCE_ACTION__CURRENT_ELEMENT, oldCurrentElement, currentElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Doc2modelPackage.REFERENCE_ACTION__REFERENCE_ATTRIBUTE:
				return getReferenceAttribute();
			case Doc2modelPackage.REFERENCE_ACTION__CURRENT_ELEMENT:
				if (resolve) return getCurrentElement();
				return basicGetCurrentElement();
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
			case Doc2modelPackage.REFERENCE_ACTION__REFERENCE_ATTRIBUTE:
				setReferenceAttribute((String)newValue);
				return;
			case Doc2modelPackage.REFERENCE_ACTION__CURRENT_ELEMENT:
				setCurrentElement((Value)newValue);
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
			case Doc2modelPackage.REFERENCE_ACTION__REFERENCE_ATTRIBUTE:
				setReferenceAttribute(REFERENCE_ATTRIBUTE_EDEFAULT);
				return;
			case Doc2modelPackage.REFERENCE_ACTION__CURRENT_ELEMENT:
				setCurrentElement((Value)null);
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
			case Doc2modelPackage.REFERENCE_ACTION__REFERENCE_ATTRIBUTE:
				return REFERENCE_ATTRIBUTE_EDEFAULT == null ? referenceAttribute != null : !REFERENCE_ATTRIBUTE_EDEFAULT.equals(referenceAttribute);
			case Doc2modelPackage.REFERENCE_ACTION__CURRENT_ELEMENT:
				return currentElement != null;
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
		result.append(" (referenceAttribute: ");
		result.append(referenceAttribute);
		result.append(')');
		return result.toString();
	}

} //ReferenceActionImpl
