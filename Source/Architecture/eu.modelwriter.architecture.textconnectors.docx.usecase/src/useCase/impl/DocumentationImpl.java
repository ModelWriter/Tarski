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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import useCase.Documentation;
import useCase.UseCasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Documentation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link useCase.impl.DocumentationImpl#getText <em>Text</em>}</li>
 *   <li>{@link useCase.impl.DocumentationImpl#getTextFormat <em>Text Format</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentationImpl extends ElementImpl implements Documentation {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTextFormat() <em>Text Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTextFormat() <em>Text Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextFormat()
	 * @generated
	 * @ordered
	 */
	protected String textFormat = TEXT_FORMAT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UseCasePackage.Literals.DOCUMENTAT�ON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UseCasePackage.DOCUMENTAT�ON__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextFormat() {
		return textFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextFormat(String newTextFormat) {
		String oldTextFormat = textFormat;
		textFormat = newTextFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UseCasePackage.DOCUMENTAT�ON__TEXT_FORMAT, oldTextFormat, textFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UseCasePackage.DOCUMENTAT�ON__TEXT:
				return getText();
			case UseCasePackage.DOCUMENTAT�ON__TEXT_FORMAT:
				return getTextFormat();
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
			case UseCasePackage.DOCUMENTAT�ON__TEXT:
				setText((String)newValue);
				return;
			case UseCasePackage.DOCUMENTAT�ON__TEXT_FORMAT:
				setTextFormat((String)newValue);
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
			case UseCasePackage.DOCUMENTAT�ON__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case UseCasePackage.DOCUMENTAT�ON__TEXT_FORMAT:
				setTextFormat(TEXT_FORMAT_EDEFAULT);
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
			case UseCasePackage.DOCUMENTAT�ON__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case UseCasePackage.DOCUMENTAT�ON__TEXT_FORMAT:
				return TEXT_FORMAT_EDEFAULT == null ? textFormat != null : !TEXT_FORMAT_EDEFAULT.equals(textFormat);
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
		result.append(" (text: ");
		result.append(text);
		result.append(", textFormat: ");
		result.append(textFormat);
		result.append(')');
		return result.toString();
	}

} //DocumentationImpl
