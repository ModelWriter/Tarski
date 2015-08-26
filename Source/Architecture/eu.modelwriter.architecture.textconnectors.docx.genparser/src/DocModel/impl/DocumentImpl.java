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
import DocModel.Document;
import DocModel.Mark;
import DocModel.Paragraph;
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
 * An implementation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DocModel.impl.DocumentImpl#getOwnedParagraph <em>Owned Paragraph</em>}</li>
 *   <li>{@link DocModel.impl.DocumentImpl#getPath <em>Path</em>}</li>
 *   <li>{@link DocModel.impl.DocumentImpl#getOwnedMark <em>Owned Mark</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentImpl extends NamedElementImpl implements Document {
	/**
	 * The cached value of the '{@link #getOwnedParagraph() <em>Owned Paragraph</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedParagraph()
	 * @generated
	 * @ordered
	 */
	protected EList<Paragraph> ownedParagraph;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedMark() <em>Owned Mark</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMark()
	 * @generated
	 * @ordered
	 */
	protected EList<Mark> ownedMark;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DocModelPackage.Literals.DOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Paragraph> getOwnedParagraph() {
		if (ownedParagraph == null) {
			ownedParagraph = new EObjectContainmentEList<Paragraph>(Paragraph.class, this, DocModelPackage.DOCUMENT__OWNED_PARAGRAPH);
		}
		return ownedParagraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DocModelPackage.DOCUMENT__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mark> getOwnedMark() {
		if (ownedMark == null) {
			ownedMark = new EObjectContainmentEList<Mark>(Mark.class, this, DocModelPackage.DOCUMENT__OWNED_MARK);
		}
		return ownedMark;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DocModelPackage.DOCUMENT__OWNED_PARAGRAPH:
				return ((InternalEList<?>)getOwnedParagraph()).basicRemove(otherEnd, msgs);
			case DocModelPackage.DOCUMENT__OWNED_MARK:
				return ((InternalEList<?>)getOwnedMark()).basicRemove(otherEnd, msgs);
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
			case DocModelPackage.DOCUMENT__OWNED_PARAGRAPH:
				return getOwnedParagraph();
			case DocModelPackage.DOCUMENT__PATH:
				return getPath();
			case DocModelPackage.DOCUMENT__OWNED_MARK:
				return getOwnedMark();
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
			case DocModelPackage.DOCUMENT__OWNED_PARAGRAPH:
				getOwnedParagraph().clear();
				getOwnedParagraph().addAll((Collection<? extends Paragraph>)newValue);
				return;
			case DocModelPackage.DOCUMENT__PATH:
				setPath((String)newValue);
				return;
			case DocModelPackage.DOCUMENT__OWNED_MARK:
				getOwnedMark().clear();
				getOwnedMark().addAll((Collection<? extends Mark>)newValue);
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
			case DocModelPackage.DOCUMENT__OWNED_PARAGRAPH:
				getOwnedParagraph().clear();
				return;
			case DocModelPackage.DOCUMENT__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case DocModelPackage.DOCUMENT__OWNED_MARK:
				getOwnedMark().clear();
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
			case DocModelPackage.DOCUMENT__OWNED_PARAGRAPH:
				return ownedParagraph != null && !ownedParagraph.isEmpty();
			case DocModelPackage.DOCUMENT__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case DocModelPackage.DOCUMENT__OWNED_MARK:
				return ownedMark != null && !ownedMark.isEmpty();
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
		result.append(" (path: ");
		result.append(path);
		result.append(')');
		return result.toString();
	}

} //DocumentImpl
