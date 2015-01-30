package org.eclipse.emf.doc2model.doc2model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.doc2model.doc2model.Action;
import org.eclipse.emf.doc2model.doc2model.Activity;
import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;
import org.eclipse.emf.doc2model.doc2model.ObjectContainer;
import org.eclipse.emf.doc2model.doc2model.ParameterObject;

import org.eclipse.emf.doc2model.doc2model.Value;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.ActivityImpl#getOwnedObjects <em>Owned Objects</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.ActivityImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.ActivityImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityImpl extends ActionImpl implements Activity {
	/**
	 * The cached value of the '{@link #getOwnedObjects() <em>Owned Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> ownedObjects;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterObject> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Doc2modelPackage.Literals.ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getOwnedObjects() {
		if (ownedObjects == null) {
			ownedObjects = new EObjectContainmentEList<Value>(Value.class, this, Doc2modelPackage.ACTIVITY__OWNED_OBJECTS);
		}
		return ownedObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<Action>(Action.class, this, Doc2modelPackage.ACTIVITY__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterObject> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<ParameterObject>(ParameterObject.class, this, Doc2modelPackage.ACTIVITY__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Doc2modelPackage.ACTIVITY__OWNED_OBJECTS:
				return ((InternalEList<?>)getOwnedObjects()).basicRemove(otherEnd, msgs);
			case Doc2modelPackage.ACTIVITY__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
			case Doc2modelPackage.ACTIVITY__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case Doc2modelPackage.ACTIVITY__OWNED_OBJECTS:
				return getOwnedObjects();
			case Doc2modelPackage.ACTIVITY__ACTIONS:
				return getActions();
			case Doc2modelPackage.ACTIVITY__PARAMETERS:
				return getParameters();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Doc2modelPackage.ACTIVITY__OWNED_OBJECTS:
				getOwnedObjects().clear();
				getOwnedObjects().addAll((Collection<? extends Value>)newValue);
				return;
			case Doc2modelPackage.ACTIVITY__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
				return;
			case Doc2modelPackage.ACTIVITY__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends ParameterObject>)newValue);
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
			case Doc2modelPackage.ACTIVITY__OWNED_OBJECTS:
				getOwnedObjects().clear();
				return;
			case Doc2modelPackage.ACTIVITY__ACTIONS:
				getActions().clear();
				return;
			case Doc2modelPackage.ACTIVITY__PARAMETERS:
				getParameters().clear();
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
			case Doc2modelPackage.ACTIVITY__OWNED_OBJECTS:
				return ownedObjects != null && !ownedObjects.isEmpty();
			case Doc2modelPackage.ACTIVITY__ACTIONS:
				return actions != null && !actions.isEmpty();
			case Doc2modelPackage.ACTIVITY__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ObjectContainer.class) {
			switch (derivedFeatureID) {
				case Doc2modelPackage.ACTIVITY__OWNED_OBJECTS: return Doc2modelPackage.OBJECT_CONTAINER__OWNED_OBJECTS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ObjectContainer.class) {
			switch (baseFeatureID) {
				case Doc2modelPackage.OBJECT_CONTAINER__OWNED_OBJECTS: return Doc2modelPackage.ACTIVITY__OWNED_OBJECTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ActivityImpl
