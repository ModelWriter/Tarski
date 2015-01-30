package org.eclipse.emf.doc2model.doc2model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;
import org.eclipse.emf.doc2model.doc2model.ElementSelection;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.ElementSelectionImpl#getEReferenceOwning <em>EReference Owning</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ElementSelectionImpl extends EObjectImpl implements ElementSelection {
	/**
	 * The default value of the '{@link #getEReferenceOwning() <em>EReference Owning</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReferenceOwning()
	 * @generated
	 * @ordered
	 */
	protected static final String EREFERENCE_OWNING_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getEReferenceOwning() <em>EReference Owning</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReferenceOwning()
	 * @generated
	 * @ordered
	 */
	protected String eReferenceOwning = EREFERENCE_OWNING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementSelectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Doc2modelPackage.Literals.ELEMENT_SELECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEReferenceOwning() {
		return eReferenceOwning;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEReferenceOwning(String newEReferenceOwning) {
		String oldEReferenceOwning = eReferenceOwning;
		eReferenceOwning = newEReferenceOwning;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.ELEMENT_SELECTION__EREFERENCE_OWNING, oldEReferenceOwning, eReferenceOwning));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getElement() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Doc2modelPackage.ELEMENT_SELECTION__EREFERENCE_OWNING:
				return getEReferenceOwning();
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
			case Doc2modelPackage.ELEMENT_SELECTION__EREFERENCE_OWNING:
				setEReferenceOwning((String)newValue);
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
			case Doc2modelPackage.ELEMENT_SELECTION__EREFERENCE_OWNING:
				setEReferenceOwning(EREFERENCE_OWNING_EDEFAULT);
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
			case Doc2modelPackage.ELEMENT_SELECTION__EREFERENCE_OWNING:
				return EREFERENCE_OWNING_EDEFAULT == null ? eReferenceOwning != null : !EREFERENCE_OWNING_EDEFAULT.equals(eReferenceOwning);
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
		result.append(" (eReferenceOwning: ");
		result.append(eReferenceOwning);
		result.append(')');
		return result.toString();
	}

} //ElementSelectionImpl
