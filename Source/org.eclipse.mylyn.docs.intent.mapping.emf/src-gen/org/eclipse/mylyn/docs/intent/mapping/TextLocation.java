/**
 *  Copyright (c) 2015 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *     Obeo - initial API and implementation and/or initial documentation
 *     ...
 * 
 */
package org.eclipse.mylyn.docs.intent.mapping;

import org.eclipse.mylyn.docs.intent.mapping.text.ITextLocation;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Text Location</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.TextLocation#getText <em>Text</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.TextLocation#getTextOffset <em>Text Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getTextLocation()
 * @model
 * @generated NOT
 */
public interface TextLocation extends Location, ITextLocation {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getTextLocation_Text()
	 * @model required="true"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.docs.intent.mapping.TextLocation#getText <em>Text</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Text Offset</b></em>' attribute. The default value is
	 * <code>"-1"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Offset</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Text Offset</em>' attribute.
	 * @see #setTextOffset(int)
	 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getTextLocation_TextOffset()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getTextOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.docs.intent.mapping.TextLocation#getTextOffset
	 * <em>Text Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Text Offset</em>' attribute.
	 * @see #getTextOffset()
	 * @generated
	 */
	void setTextOffset(int value);

} // TextLocation
