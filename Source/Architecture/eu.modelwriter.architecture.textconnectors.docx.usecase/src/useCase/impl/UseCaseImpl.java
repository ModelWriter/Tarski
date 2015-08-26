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
package useCase.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import useCase.Actor;
import useCase.Interest;
import useCase.UseCase;
import useCase.UseCasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link useCase.impl.UseCaseImpl#getPrimaryActor <em>Primary Actor</em>}</li>
 *   <li>{@link useCase.impl.UseCaseImpl#getOwnedStakeholderInterest <em>Owned Stakeholder Interest</em>}</li>
 *   <li>{@link useCase.impl.UseCaseImpl#getOwnedMainFlow <em>Owned Main Flow</em>}</li>
 *   <li>{@link useCase.impl.UseCaseImpl#getOwnedAlternativeFlow <em>Owned Alternative Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseCaseImpl extends NamedElementImpl implements UseCase {
	/**
	 * The cached value of the '{@link #getPrimaryActor() <em>Primary Actor</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryActor()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> primaryActor;

	/**
	 * The cached value of the '{@link #getOwnedStakeholderInterest() <em>Owned Stakeholder Interest</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedStakeholderInterest()
	 * @generated
	 * @ordered
	 */
	protected EList<Interest> ownedStakeholderInterest;

	/**
	 * The cached value of the '{@link #getOwnedMainFlow() <em>Owned Main Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMainFlow()
	 * @generated
	 * @ordered
	 */
	protected useCase.Process ownedMainFlow;

	/**
	 * The cached value of the '{@link #getOwnedAlternativeFlow() <em>Owned Alternative Flow</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAlternativeFlow()
	 * @generated
	 * @ordered
	 */
	protected EList<useCase.Process> ownedAlternativeFlow;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UseCasePackage.Literals.USE_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getPrimaryActor() {
		if (primaryActor == null) {
			primaryActor = new EObjectResolvingEList<Actor>(Actor.class, this, UseCasePackage.USE_CASE__PRÝMARY_ACTOR);
		}
		return primaryActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interest> getOwnedStakeholderInterest() {
		if (ownedStakeholderInterest == null) {
			ownedStakeholderInterest = new EObjectContainmentEList<Interest>(Interest.class, this, UseCasePackage.USE_CASE__OWNED_STAKEHOLDER_INTEREST);
		}
		return ownedStakeholderInterest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public useCase.Process getOwnedMainFlow() {
		return ownedMainFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedMainFlow(useCase.Process newOwnedMainFlow, NotificationChain msgs) {
		useCase.Process oldOwnedMainFlow = ownedMainFlow;
		ownedMainFlow = newOwnedMainFlow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UseCasePackage.USE_CASE__OWNED_MAÝN_FLOW, oldOwnedMainFlow, newOwnedMainFlow);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedMainFlow(useCase.Process newOwnedMainFlow) {
		if (newOwnedMainFlow != ownedMainFlow) {
			NotificationChain msgs = null;
			if (ownedMainFlow != null)
				msgs = ((InternalEObject)ownedMainFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UseCasePackage.USE_CASE__OWNED_MAÝN_FLOW, null, msgs);
			if (newOwnedMainFlow != null)
				msgs = ((InternalEObject)newOwnedMainFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UseCasePackage.USE_CASE__OWNED_MAÝN_FLOW, null, msgs);
			msgs = basicSetOwnedMainFlow(newOwnedMainFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UseCasePackage.USE_CASE__OWNED_MAÝN_FLOW, newOwnedMainFlow, newOwnedMainFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<useCase.Process> getOwnedAlternativeFlow() {
		if (ownedAlternativeFlow == null) {
			ownedAlternativeFlow = new EObjectContainmentEList<useCase.Process>(useCase.Process.class, this, UseCasePackage.USE_CASE__OWNED_ALTERNATÝVE_FLOW);
		}
		return ownedAlternativeFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UseCasePackage.USE_CASE__OWNED_STAKEHOLDER_INTEREST:
				return ((InternalEList<?>)getOwnedStakeholderInterest()).basicRemove(otherEnd, msgs);
			case UseCasePackage.USE_CASE__OWNED_MAÝN_FLOW:
				return basicSetOwnedMainFlow(null, msgs);
			case UseCasePackage.USE_CASE__OWNED_ALTERNATÝVE_FLOW:
				return ((InternalEList<?>)getOwnedAlternativeFlow()).basicRemove(otherEnd, msgs);
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
			case UseCasePackage.USE_CASE__PRÝMARY_ACTOR:
				return getPrimaryActor();
			case UseCasePackage.USE_CASE__OWNED_STAKEHOLDER_INTEREST:
				return getOwnedStakeholderInterest();
			case UseCasePackage.USE_CASE__OWNED_MAÝN_FLOW:
				return getOwnedMainFlow();
			case UseCasePackage.USE_CASE__OWNED_ALTERNATÝVE_FLOW:
				return getOwnedAlternativeFlow();
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
			case UseCasePackage.USE_CASE__PRÝMARY_ACTOR:
				getPrimaryActor().clear();
				getPrimaryActor().addAll((Collection<? extends Actor>)newValue);
				return;
			case UseCasePackage.USE_CASE__OWNED_STAKEHOLDER_INTEREST:
				getOwnedStakeholderInterest().clear();
				getOwnedStakeholderInterest().addAll((Collection<? extends Interest>)newValue);
				return;
			case UseCasePackage.USE_CASE__OWNED_MAÝN_FLOW:
				setOwnedMainFlow((useCase.Process)newValue);
				return;
			case UseCasePackage.USE_CASE__OWNED_ALTERNATÝVE_FLOW:
				getOwnedAlternativeFlow().clear();
				getOwnedAlternativeFlow().addAll((Collection<? extends useCase.Process>)newValue);
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
			case UseCasePackage.USE_CASE__PRÝMARY_ACTOR:
				getPrimaryActor().clear();
				return;
			case UseCasePackage.USE_CASE__OWNED_STAKEHOLDER_INTEREST:
				getOwnedStakeholderInterest().clear();
				return;
			case UseCasePackage.USE_CASE__OWNED_MAÝN_FLOW:
				setOwnedMainFlow((useCase.Process)null);
				return;
			case UseCasePackage.USE_CASE__OWNED_ALTERNATÝVE_FLOW:
				getOwnedAlternativeFlow().clear();
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
			case UseCasePackage.USE_CASE__PRÝMARY_ACTOR:
				return primaryActor != null && !primaryActor.isEmpty();
			case UseCasePackage.USE_CASE__OWNED_STAKEHOLDER_INTEREST:
				return ownedStakeholderInterest != null && !ownedStakeholderInterest.isEmpty();
			case UseCasePackage.USE_CASE__OWNED_MAÝN_FLOW:
				return ownedMainFlow != null;
			case UseCasePackage.USE_CASE__OWNED_ALTERNATÝVE_FLOW:
				return ownedAlternativeFlow != null && !ownedAlternativeFlow.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UseCaseImpl
