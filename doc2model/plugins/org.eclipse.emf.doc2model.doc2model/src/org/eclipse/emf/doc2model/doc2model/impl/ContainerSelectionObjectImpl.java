package org.eclipse.emf.doc2model.doc2model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.doc2model.doc2model.ContainerSelectionObject;
import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;
import org.eclipse.emf.doc2model.doc2model.ElementSelection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container Selection Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.ContainerSelectionObjectImpl#getSelection <em>Selection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContainerSelectionObjectImpl extends ValueImpl implements ContainerSelectionObject {
	/**
	 * The cached value of the '{@link #getSelection() <em>Selection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelection()
	 * @generated
	 * @ordered
	 */
	protected ElementSelection selection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerSelectionObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Doc2modelPackage.Literals.CONTAINER_SELECTION_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementSelection getSelection() {
		return selection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSelection(ElementSelection newSelection, NotificationChain msgs) {
		ElementSelection oldSelection = selection;
		selection = newSelection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Doc2modelPackage.CONTAINER_SELECTION_OBJECT__SELECTION, oldSelection, newSelection);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelection(ElementSelection newSelection) {
		if (newSelection != selection) {
			NotificationChain msgs = null;
			if (selection != null)
				msgs = ((InternalEObject)selection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Doc2modelPackage.CONTAINER_SELECTION_OBJECT__SELECTION, null, msgs);
			if (newSelection != null)
				msgs = ((InternalEObject)newSelection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Doc2modelPackage.CONTAINER_SELECTION_OBJECT__SELECTION, null, msgs);
			msgs = basicSetSelection(newSelection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.CONTAINER_SELECTION_OBJECT__SELECTION, newSelection, newSelection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Doc2modelPackage.CONTAINER_SELECTION_OBJECT__SELECTION:
				return basicSetSelection(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Doc2modelPackage.CONTAINER_SELECTION_OBJECT__SELECTION:
				return getSelection();
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
			case Doc2modelPackage.CONTAINER_SELECTION_OBJECT__SELECTION:
				setSelection((ElementSelection)newValue);
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
			case Doc2modelPackage.CONTAINER_SELECTION_OBJECT__SELECTION:
				setSelection((ElementSelection)null);
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
			case Doc2modelPackage.CONTAINER_SELECTION_OBJECT__SELECTION:
				return selection != null;
		}
		return super.eIsSet(featureID);
	}

} //ContainerSelectionObjectImpl
