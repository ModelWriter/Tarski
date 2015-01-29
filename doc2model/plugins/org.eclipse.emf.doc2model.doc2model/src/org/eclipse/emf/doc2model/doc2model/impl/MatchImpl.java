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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;
import org.eclipse.emf.doc2model.doc2model.Match;

import org.eclipse.emf.doc2model.doc2model.Rule;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Match</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.impl.MatchImpl#getUri <em>Uri</em>}</li>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.impl.MatchImpl#getHigherThan <em>Higher Than</em>}</li>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.impl.MatchImpl#getLowerThan <em>Lower Than</em>}</li>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.impl.MatchImpl#getRule <em>Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @@generated
 */
public class MatchImpl extends ObjectContainerImpl implements Match {
	/**
	 * The cached value of the '{@@link #getUri() <em>Uri</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see #getUri()
	 * @@generated
	 * @@ordered
	 */
	protected EList<String> uri;

	/**
	 * The cached value of the '{@@link #getHigherThan() <em>Higher Than</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see #getHigherThan()
	 * @@generated
	 * @@ordered
	 */
	protected EList<Match> higherThan;

	/**
	 * The cached value of the '{@@link #getLowerThan() <em>Lower Than</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see #getLowerThan()
	 * @@generated
	 * @@ordered
	 */
	protected EList<Match> lowerThan;

	/**
	 * The cached value of the '{@@link #getRule() <em>Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see #getRule()
	 * @@generated
	 * @@ordered
	 */
	protected Rule rule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	protected MatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	protected EClass eStaticClass() {
		return Doc2modelPackage.Literals.MATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EList<String> getUri() {
		if (uri == null) {
			uri = new EDataTypeUniqueEList<String>(String.class, this, Doc2modelPackage.MATCH__URI);
		}
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EList<Match> getHigherThan() {
		if (higherThan == null) {
			higherThan = new EObjectWithInverseResolvingEList.ManyInverse<Match>(Match.class, this, Doc2modelPackage.MATCH__HIGHER_THAN, Doc2modelPackage.MATCH__LOWER_THAN);
		}
		return higherThan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EList<Match> getLowerThan() {
		if (lowerThan == null) {
			lowerThan = new EObjectWithInverseResolvingEList.ManyInverse<Match>(Match.class, this, Doc2modelPackage.MATCH__LOWER_THAN, Doc2modelPackage.MATCH__HIGHER_THAN);
		}
		return lowerThan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public Rule getRule() {
		if (rule != null && rule.eIsProxy()) {
			InternalEObject oldRule = (InternalEObject)rule;
			rule = (Rule)eResolveProxy(oldRule);
			if (rule != oldRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Doc2modelPackage.MATCH__RULE, oldRule, rule));
			}
		}
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public Rule basicGetRule() {
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public NotificationChain basicSetRule(Rule newRule, NotificationChain msgs) {
		Rule oldRule = rule;
		rule = newRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Doc2modelPackage.MATCH__RULE, oldRule, newRule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public void setRule(Rule newRule) {
		if (newRule != rule) {
			NotificationChain msgs = null;
			if (rule != null)
				msgs = ((InternalEObject)rule).eInverseRemove(this, Doc2modelPackage.RULE__MATCH, Rule.class, msgs);
			if (newRule != null)
				msgs = ((InternalEObject)newRule).eInverseAdd(this, Doc2modelPackage.RULE__MATCH, Rule.class, msgs);
			msgs = basicSetRule(newRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.MATCH__RULE, newRule, newRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated NOT
	 */
	public EList<URI> getURI() {
		EList<URI> result = new BasicEList<URI>();
		EList<String> uris = getUri();
		for (String s : uris)
		{
			result.add(URI.createURI(s));
		}
		return result ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@SuppressWarnings("unchecked")
	@@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Doc2modelPackage.MATCH__HIGHER_THAN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getHigherThan()).basicAdd(otherEnd, msgs);
			case Doc2modelPackage.MATCH__LOWER_THAN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLowerThan()).basicAdd(otherEnd, msgs);
			case Doc2modelPackage.MATCH__RULE:
				if (rule != null)
					msgs = ((InternalEObject)rule).eInverseRemove(this, Doc2modelPackage.RULE__MATCH, Rule.class, msgs);
				return basicSetRule((Rule)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Doc2modelPackage.MATCH__HIGHER_THAN:
				return ((InternalEList<?>)getHigherThan()).basicRemove(otherEnd, msgs);
			case Doc2modelPackage.MATCH__LOWER_THAN:
				return ((InternalEList<?>)getLowerThan()).basicRemove(otherEnd, msgs);
			case Doc2modelPackage.MATCH__RULE:
				return basicSetRule(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Doc2modelPackage.MATCH__URI:
				return getUri();
			case Doc2modelPackage.MATCH__HIGHER_THAN:
				return getHigherThan();
			case Doc2modelPackage.MATCH__LOWER_THAN:
				return getLowerThan();
			case Doc2modelPackage.MATCH__RULE:
				if (resolve) return getRule();
				return basicGetRule();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@SuppressWarnings("unchecked")
	@@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Doc2modelPackage.MATCH__URI:
				getUri().clear();
				getUri().addAll((Collection<? extends String>)newValue);
				return;
			case Doc2modelPackage.MATCH__HIGHER_THAN:
				getHigherThan().clear();
				getHigherThan().addAll((Collection<? extends Match>)newValue);
				return;
			case Doc2modelPackage.MATCH__LOWER_THAN:
				getLowerThan().clear();
				getLowerThan().addAll((Collection<? extends Match>)newValue);
				return;
			case Doc2modelPackage.MATCH__RULE:
				setRule((Rule)newValue);
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
			case Doc2modelPackage.MATCH__URI:
				getUri().clear();
				return;
			case Doc2modelPackage.MATCH__HIGHER_THAN:
				getHigherThan().clear();
				return;
			case Doc2modelPackage.MATCH__LOWER_THAN:
				getLowerThan().clear();
				return;
			case Doc2modelPackage.MATCH__RULE:
				setRule((Rule)null);
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
			case Doc2modelPackage.MATCH__URI:
				return uri != null && !uri.isEmpty();
			case Doc2modelPackage.MATCH__HIGHER_THAN:
				return higherThan != null && !higherThan.isEmpty();
			case Doc2modelPackage.MATCH__LOWER_THAN:
				return lowerThan != null && !lowerThan.isEmpty();
			case Doc2modelPackage.MATCH__RULE:
				return rule != null;
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
		result.append(" (uri: ");
		result.append(uri);
		result.append(')');
		return result.toString();
	}

} //MatchImpl
@
