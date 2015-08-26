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
package DocModel.impl;

import DocModel.DocModelPackage;
import DocModel.Paragraph;
import DocModel.Part;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DocModel.impl.PartImpl#getNextPart <em>Next Part</em>}</li>
 *   <li>{@link DocModel.impl.PartImpl#getPrevPart <em>Prev Part</em>}</li>
 *   <li>{@link DocModel.impl.PartImpl#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PartImpl extends NodeImpl implements Part {
	/**
	 * The cached value of the '{@link #getNextPart() <em>Next Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextPart()
	 * @generated
	 * @ordered
	 */
	protected Part nextPart;

	/**
	 * The cached value of the '{@link #getPrevPart() <em>Prev Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrevPart()
	 * @generated
	 * @ordered
	 */
	protected Part prevPart;

	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected Paragraph node;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DocModelPackage.Literals.PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part getNextPart() {
		if (nextPart != null && nextPart.eIsProxy()) {
			InternalEObject oldNextPart = (InternalEObject)nextPart;
			nextPart = (Part)eResolveProxy(oldNextPart);
			if (nextPart != oldNextPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DocModelPackage.PART__NEXT_PART, oldNextPart, nextPart));
			}
		}
		return nextPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part basicGetNextPart() {
		return nextPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNextPart(Part newNextPart, NotificationChain msgs) {
		Part oldNextPart = nextPart;
		nextPart = newNextPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DocModelPackage.PART__NEXT_PART, oldNextPart, newNextPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextPart(Part newNextPart) {
		if (newNextPart != nextPart) {
			NotificationChain msgs = null;
			if (nextPart != null)
				msgs = ((InternalEObject)nextPart).eInverseRemove(this, DocModelPackage.PART__PREV_PART, Part.class, msgs);
			if (newNextPart != null)
				msgs = ((InternalEObject)newNextPart).eInverseAdd(this, DocModelPackage.PART__PREV_PART, Part.class, msgs);
			msgs = basicSetNextPart(newNextPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DocModelPackage.PART__NEXT_PART, newNextPart, newNextPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part getPrevPart() {
		if (prevPart != null && prevPart.eIsProxy()) {
			InternalEObject oldPrevPart = (InternalEObject)prevPart;
			prevPart = (Part)eResolveProxy(oldPrevPart);
			if (prevPart != oldPrevPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DocModelPackage.PART__PREV_PART, oldPrevPart, prevPart));
			}
		}
		return prevPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part basicGetPrevPart() {
		return prevPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrevPart(Part newPrevPart, NotificationChain msgs) {
		Part oldPrevPart = prevPart;
		prevPart = newPrevPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DocModelPackage.PART__PREV_PART, oldPrevPart, newPrevPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrevPart(Part newPrevPart) {
		if (newPrevPart != prevPart) {
			NotificationChain msgs = null;
			if (prevPart != null)
				msgs = ((InternalEObject)prevPart).eInverseRemove(this, DocModelPackage.PART__NEXT_PART, Part.class, msgs);
			if (newPrevPart != null)
				msgs = ((InternalEObject)newPrevPart).eInverseAdd(this, DocModelPackage.PART__NEXT_PART, Part.class, msgs);
			msgs = basicSetPrevPart(newPrevPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DocModelPackage.PART__PREV_PART, newPrevPart, newPrevPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Paragraph getNode() {
		if (node != null && node.eIsProxy()) {
			InternalEObject oldNode = (InternalEObject)node;
			node = (Paragraph)eResolveProxy(oldNode);
			if (node != oldNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DocModelPackage.PART__NODE, oldNode, node));
			}
		}
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Paragraph basicGetNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode(Paragraph newNode, NotificationChain msgs) {
		Paragraph oldNode = node;
		node = newNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DocModelPackage.PART__NODE, oldNode, newNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(Paragraph newNode) {
		if (newNode != node) {
			NotificationChain msgs = null;
			if (node != null)
				msgs = ((InternalEObject)node).eInverseRemove(this, DocModelPackage.PARAGRAPH__FIRST_PART, Paragraph.class, msgs);
			if (newNode != null)
				msgs = ((InternalEObject)newNode).eInverseAdd(this, DocModelPackage.PARAGRAPH__FIRST_PART, Paragraph.class, msgs);
			msgs = basicSetNode(newNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DocModelPackage.PART__NODE, newNode, newNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DocModelPackage.PART__NEXT_PART:
				if (nextPart != null)
					msgs = ((InternalEObject)nextPart).eInverseRemove(this, DocModelPackage.PART__PREV_PART, Part.class, msgs);
				return basicSetNextPart((Part)otherEnd, msgs);
			case DocModelPackage.PART__PREV_PART:
				if (prevPart != null)
					msgs = ((InternalEObject)prevPart).eInverseRemove(this, DocModelPackage.PART__NEXT_PART, Part.class, msgs);
				return basicSetPrevPart((Part)otherEnd, msgs);
			case DocModelPackage.PART__NODE:
				if (node != null)
					msgs = ((InternalEObject)node).eInverseRemove(this, DocModelPackage.PARAGRAPH__FIRST_PART, Paragraph.class, msgs);
				return basicSetNode((Paragraph)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DocModelPackage.PART__NEXT_PART:
				return basicSetNextPart(null, msgs);
			case DocModelPackage.PART__PREV_PART:
				return basicSetPrevPart(null, msgs);
			case DocModelPackage.PART__NODE:
				return basicSetNode(null, msgs);
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
			case DocModelPackage.PART__NEXT_PART:
				if (resolve) return getNextPart();
				return basicGetNextPart();
			case DocModelPackage.PART__PREV_PART:
				if (resolve) return getPrevPart();
				return basicGetPrevPart();
			case DocModelPackage.PART__NODE:
				if (resolve) return getNode();
				return basicGetNode();
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
			case DocModelPackage.PART__NEXT_PART:
				setNextPart((Part)newValue);
				return;
			case DocModelPackage.PART__PREV_PART:
				setPrevPart((Part)newValue);
				return;
			case DocModelPackage.PART__NODE:
				setNode((Paragraph)newValue);
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
			case DocModelPackage.PART__NEXT_PART:
				setNextPart((Part)null);
				return;
			case DocModelPackage.PART__PREV_PART:
				setPrevPart((Part)null);
				return;
			case DocModelPackage.PART__NODE:
				setNode((Paragraph)null);
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
			case DocModelPackage.PART__NEXT_PART:
				return nextPart != null;
			case DocModelPackage.PART__PREV_PART:
				return prevPart != null;
			case DocModelPackage.PART__NODE:
				return node != null;
		}
		return super.eIsSet(featureID);
	}

} //PartImpl
