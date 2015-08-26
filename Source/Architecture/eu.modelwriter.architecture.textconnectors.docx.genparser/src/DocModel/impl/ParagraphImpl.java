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
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Paragraph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DocModel.impl.ParagraphImpl#getOwnedNode <em>Owned Node</em>}</li>
 *   <li>{@link DocModel.impl.ParagraphImpl#getOwnedPart <em>Owned Part</em>}</li>
 *   <li>{@link DocModel.impl.ParagraphImpl#getFirstPart <em>First Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParagraphImpl extends NodeImpl implements Paragraph {
	/**
	 * The cached value of the '{@link #getOwnedNode() <em>Owned Node</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedNode()
	 * @generated
	 * @ordered
	 */
	protected EList<Paragraph> ownedNode;

	/**
	 * The cached value of the '{@link #getOwnedPart() <em>Owned Part</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPart()
	 * @generated
	 * @ordered
	 */
	protected EList<Part> ownedPart;

	/**
	 * The cached value of the '{@link #getFirstPart() <em>First Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstPart()
	 * @generated
	 * @ordered
	 */
	protected Part firstPart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParagraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DocModelPackage.Literals.PARAGRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Paragraph> getOwnedNode() {
		if (ownedNode == null) {
			ownedNode = new EObjectContainmentEList<Paragraph>(Paragraph.class, this, DocModelPackage.PARAGRAPH__OWNED_NODE);
		}
		return ownedNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Part> getOwnedPart() {
		if (ownedPart == null) {
			ownedPart = new EObjectContainmentEList<Part>(Part.class, this, DocModelPackage.PARAGRAPH__OWNED_PART);
		}
		return ownedPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part getFirstPart() {
		if (firstPart != null && firstPart.eIsProxy()) {
			InternalEObject oldFirstPart = (InternalEObject)firstPart;
			firstPart = (Part)eResolveProxy(oldFirstPart);
			if (firstPart != oldFirstPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DocModelPackage.PARAGRAPH__FIRST_PART, oldFirstPart, firstPart));
			}
		}
		return firstPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part basicGetFirstPart() {
		return firstPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirstPart(Part newFirstPart, NotificationChain msgs) {
		Part oldFirstPart = firstPart;
		firstPart = newFirstPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DocModelPackage.PARAGRAPH__FIRST_PART, oldFirstPart, newFirstPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstPart(Part newFirstPart) {
		if (newFirstPart != firstPart) {
			NotificationChain msgs = null;
			if (firstPart != null)
				msgs = ((InternalEObject)firstPart).eInverseRemove(this, DocModelPackage.PART__NODE, Part.class, msgs);
			if (newFirstPart != null)
				msgs = ((InternalEObject)newFirstPart).eInverseAdd(this, DocModelPackage.PART__NODE, Part.class, msgs);
			msgs = basicSetFirstPart(newFirstPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DocModelPackage.PARAGRAPH__FIRST_PART, newFirstPart, newFirstPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DocModelPackage.PARAGRAPH__FIRST_PART:
				if (firstPart != null)
					msgs = ((InternalEObject)firstPart).eInverseRemove(this, DocModelPackage.PART__NODE, Part.class, msgs);
				return basicSetFirstPart((Part)otherEnd, msgs);
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
			case DocModelPackage.PARAGRAPH__OWNED_NODE:
				return ((InternalEList<?>)getOwnedNode()).basicRemove(otherEnd, msgs);
			case DocModelPackage.PARAGRAPH__OWNED_PART:
				return ((InternalEList<?>)getOwnedPart()).basicRemove(otherEnd, msgs);
			case DocModelPackage.PARAGRAPH__FIRST_PART:
				return basicSetFirstPart(null, msgs);
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
			case DocModelPackage.PARAGRAPH__OWNED_NODE:
				return getOwnedNode();
			case DocModelPackage.PARAGRAPH__OWNED_PART:
				return getOwnedPart();
			case DocModelPackage.PARAGRAPH__FIRST_PART:
				if (resolve) return getFirstPart();
				return basicGetFirstPart();
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
			case DocModelPackage.PARAGRAPH__OWNED_NODE:
				getOwnedNode().clear();
				getOwnedNode().addAll((Collection<? extends Paragraph>)newValue);
				return;
			case DocModelPackage.PARAGRAPH__OWNED_PART:
				getOwnedPart().clear();
				getOwnedPart().addAll((Collection<? extends Part>)newValue);
				return;
			case DocModelPackage.PARAGRAPH__FIRST_PART:
				setFirstPart((Part)newValue);
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
			case DocModelPackage.PARAGRAPH__OWNED_NODE:
				getOwnedNode().clear();
				return;
			case DocModelPackage.PARAGRAPH__OWNED_PART:
				getOwnedPart().clear();
				return;
			case DocModelPackage.PARAGRAPH__FIRST_PART:
				setFirstPart((Part)null);
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
			case DocModelPackage.PARAGRAPH__OWNED_NODE:
				return ownedNode != null && !ownedNode.isEmpty();
			case DocModelPackage.PARAGRAPH__OWNED_PART:
				return ownedPart != null && !ownedPart.isEmpty();
			case DocModelPackage.PARAGRAPH__FIRST_PART:
				return firstPart != null;
		}
		return super.eIsSet(featureID);
	}

} //ParagraphImpl
