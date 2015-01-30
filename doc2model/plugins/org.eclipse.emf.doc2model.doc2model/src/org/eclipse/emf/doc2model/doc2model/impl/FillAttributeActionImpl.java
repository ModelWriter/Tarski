package org.eclipse.emf.doc2model.doc2model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;
import org.eclipse.emf.doc2model.doc2model.FillAttributeAction;

import org.eclipse.emf.doc2model.doc2model.Value;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fill Attribute Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.FillAttributeActionImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.FillAttributeActionImpl#getEobjectContainingAttribute <em>Eobject Containing Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FillAttributeActionImpl extends ActionWithInParameterImpl implements FillAttributeAction {
	/**
	 * The default value of the '{@link #getAttribute() <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected String attribute = ATTRIBUTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEobjectContainingAttribute() <em>Eobject Containing Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEobjectContainingAttribute()
	 * @generated
	 * @ordered
	 */
	protected Value eobjectContainingAttribute;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FillAttributeActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Doc2modelPackage.Literals.FILL_ATTRIBUTE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(String newAttribute) {
		String oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.FILL_ATTRIBUTE_ACTION__ATTRIBUTE, oldAttribute, attribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value getEobjectContainingAttribute() {
		if (eobjectContainingAttribute != null && eobjectContainingAttribute.eIsProxy()) {
			InternalEObject oldEobjectContainingAttribute = (InternalEObject)eobjectContainingAttribute;
			eobjectContainingAttribute = (Value)eResolveProxy(oldEobjectContainingAttribute);
			if (eobjectContainingAttribute != oldEobjectContainingAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Doc2modelPackage.FILL_ATTRIBUTE_ACTION__EOBJECT_CONTAINING_ATTRIBUTE, oldEobjectContainingAttribute, eobjectContainingAttribute));
			}
		}
		return eobjectContainingAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value basicGetEobjectContainingAttribute() {
		return eobjectContainingAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEobjectContainingAttribute(Value newEobjectContainingAttribute) {
		Value oldEobjectContainingAttribute = eobjectContainingAttribute;
		eobjectContainingAttribute = newEobjectContainingAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.FILL_ATTRIBUTE_ACTION__EOBJECT_CONTAINING_ATTRIBUTE, oldEobjectContainingAttribute, eobjectContainingAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Doc2modelPackage.FILL_ATTRIBUTE_ACTION__ATTRIBUTE:
				return getAttribute();
			case Doc2modelPackage.FILL_ATTRIBUTE_ACTION__EOBJECT_CONTAINING_ATTRIBUTE:
				if (resolve) return getEobjectContainingAttribute();
				return basicGetEobjectContainingAttribute();
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
			case Doc2modelPackage.FILL_ATTRIBUTE_ACTION__ATTRIBUTE:
				setAttribute((String)newValue);
				return;
			case Doc2modelPackage.FILL_ATTRIBUTE_ACTION__EOBJECT_CONTAINING_ATTRIBUTE:
				setEobjectContainingAttribute((Value)newValue);
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
			case Doc2modelPackage.FILL_ATTRIBUTE_ACTION__ATTRIBUTE:
				setAttribute(ATTRIBUTE_EDEFAULT);
				return;
			case Doc2modelPackage.FILL_ATTRIBUTE_ACTION__EOBJECT_CONTAINING_ATTRIBUTE:
				setEobjectContainingAttribute((Value)null);
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
			case Doc2modelPackage.FILL_ATTRIBUTE_ACTION__ATTRIBUTE:
				return ATTRIBUTE_EDEFAULT == null ? attribute != null : !ATTRIBUTE_EDEFAULT.equals(attribute);
			case Doc2modelPackage.FILL_ATTRIBUTE_ACTION__EOBJECT_CONTAINING_ATTRIBUTE:
				return eobjectContainingAttribute != null;
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
		result.append(" (attribute: ");
		result.append(attribute);
		result.append(')');
		return result.toString();
	}

} //FillAttributeActionImpl
