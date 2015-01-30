package org.eclipse.emf.doc2model.doc2model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.doc2model.doc2model.Action;
import org.eclipse.emf.doc2model.doc2model.Configuration;
import org.eclipse.emf.doc2model.doc2model.Doc2Model;
import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;
import org.eclipse.emf.doc2model.doc2model.Match;
import org.eclipse.emf.doc2model.doc2model.Rule;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Doc2 Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.Doc2ModelImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.Doc2ModelImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.Doc2ModelImpl#getOwnedMatches <em>Owned Matches</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.Doc2ModelImpl#getOwnedActions <em>Owned Actions</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.Doc2ModelImpl#getInitialAction <em>Initial Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Doc2ModelImpl extends ObjectContainerImpl implements Doc2Model {
	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected Configuration configuration;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> rules;

	/**
	 * The cached value of the '{@link #getOwnedMatches() <em>Owned Matches</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMatches()
	 * @generated
	 * @ordered
	 */
	protected EList<Match> ownedMatches;

	/**
	 * The cached value of the '{@link #getOwnedActions() <em>Owned Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> ownedActions;

	/**
	 * The cached value of the '{@link #getInitialAction() <em>Initial Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialAction()
	 * @generated
	 * @ordered
	 */
	protected Action initialAction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Doc2ModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Doc2modelPackage.Literals.DOC2_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration getConfiguration() {
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfiguration(Configuration newConfiguration, NotificationChain msgs) {
		Configuration oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Doc2modelPackage.DOC2_MODEL__CONFIGURATION, oldConfiguration, newConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(Configuration newConfiguration) {
		if (newConfiguration != configuration) {
			NotificationChain msgs = null;
			if (configuration != null)
				msgs = ((InternalEObject)configuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Doc2modelPackage.DOC2_MODEL__CONFIGURATION, null, msgs);
			if (newConfiguration != null)
				msgs = ((InternalEObject)newConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Doc2modelPackage.DOC2_MODEL__CONFIGURATION, null, msgs);
			msgs = basicSetConfiguration(newConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.DOC2_MODEL__CONFIGURATION, newConfiguration, newConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<Rule>(Rule.class, this, Doc2modelPackage.DOC2_MODEL__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Match> getOwnedMatches() {
		if (ownedMatches == null) {
			ownedMatches = new EObjectContainmentEList<Match>(Match.class, this, Doc2modelPackage.DOC2_MODEL__OWNED_MATCHES);
		}
		return ownedMatches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getOwnedActions() {
		if (ownedActions == null) {
			ownedActions = new EObjectContainmentEList<Action>(Action.class, this, Doc2modelPackage.DOC2_MODEL__OWNED_ACTIONS);
		}
		return ownedActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getInitialAction() {
		if (initialAction != null && initialAction.eIsProxy()) {
			InternalEObject oldInitialAction = (InternalEObject)initialAction;
			initialAction = (Action)eResolveProxy(oldInitialAction);
			if (initialAction != oldInitialAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Doc2modelPackage.DOC2_MODEL__INITIAL_ACTION, oldInitialAction, initialAction));
			}
		}
		return initialAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetInitialAction() {
		return initialAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialAction(Action newInitialAction) {
		Action oldInitialAction = initialAction;
		initialAction = newInitialAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.DOC2_MODEL__INITIAL_ACTION, oldInitialAction, initialAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Doc2modelPackage.DOC2_MODEL__CONFIGURATION:
				return basicSetConfiguration(null, msgs);
			case Doc2modelPackage.DOC2_MODEL__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
			case Doc2modelPackage.DOC2_MODEL__OWNED_MATCHES:
				return ((InternalEList<?>)getOwnedMatches()).basicRemove(otherEnd, msgs);
			case Doc2modelPackage.DOC2_MODEL__OWNED_ACTIONS:
				return ((InternalEList<?>)getOwnedActions()).basicRemove(otherEnd, msgs);
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
			case Doc2modelPackage.DOC2_MODEL__CONFIGURATION:
				return getConfiguration();
			case Doc2modelPackage.DOC2_MODEL__RULES:
				return getRules();
			case Doc2modelPackage.DOC2_MODEL__OWNED_MATCHES:
				return getOwnedMatches();
			case Doc2modelPackage.DOC2_MODEL__OWNED_ACTIONS:
				return getOwnedActions();
			case Doc2modelPackage.DOC2_MODEL__INITIAL_ACTION:
				if (resolve) return getInitialAction();
				return basicGetInitialAction();
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
			case Doc2modelPackage.DOC2_MODEL__CONFIGURATION:
				setConfiguration((Configuration)newValue);
				return;
			case Doc2modelPackage.DOC2_MODEL__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends Rule>)newValue);
				return;
			case Doc2modelPackage.DOC2_MODEL__OWNED_MATCHES:
				getOwnedMatches().clear();
				getOwnedMatches().addAll((Collection<? extends Match>)newValue);
				return;
			case Doc2modelPackage.DOC2_MODEL__OWNED_ACTIONS:
				getOwnedActions().clear();
				getOwnedActions().addAll((Collection<? extends Action>)newValue);
				return;
			case Doc2modelPackage.DOC2_MODEL__INITIAL_ACTION:
				setInitialAction((Action)newValue);
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
			case Doc2modelPackage.DOC2_MODEL__CONFIGURATION:
				setConfiguration((Configuration)null);
				return;
			case Doc2modelPackage.DOC2_MODEL__RULES:
				getRules().clear();
				return;
			case Doc2modelPackage.DOC2_MODEL__OWNED_MATCHES:
				getOwnedMatches().clear();
				return;
			case Doc2modelPackage.DOC2_MODEL__OWNED_ACTIONS:
				getOwnedActions().clear();
				return;
			case Doc2modelPackage.DOC2_MODEL__INITIAL_ACTION:
				setInitialAction((Action)null);
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
			case Doc2modelPackage.DOC2_MODEL__CONFIGURATION:
				return configuration != null;
			case Doc2modelPackage.DOC2_MODEL__RULES:
				return rules != null && !rules.isEmpty();
			case Doc2modelPackage.DOC2_MODEL__OWNED_MATCHES:
				return ownedMatches != null && !ownedMatches.isEmpty();
			case Doc2modelPackage.DOC2_MODEL__OWNED_ACTIONS:
				return ownedActions != null && !ownedActions.isEmpty();
			case Doc2modelPackage.DOC2_MODEL__INITIAL_ACTION:
				return initialAction != null;
		}
		return super.eIsSet(featureID);
	}

} //Doc2ModelImpl
