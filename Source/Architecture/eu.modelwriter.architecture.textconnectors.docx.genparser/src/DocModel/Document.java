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
package DocModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DocModel.Document#getOwnedParagraph <em>Owned Paragraph</em>}</li>
 *   <li>{@link DocModel.Document#getPath <em>Path</em>}</li>
 *   <li>{@link DocModel.Document#getOwnedMark <em>Owned Mark</em>}</li>
 * </ul>
 * </p>
 *
 * @see DocModel.DocModelPackage#getDocument()
 * @model
 * @generated
 */
public interface Document extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Paragraph</b></em>' containment reference list.
	 * The list contents are of type {@link DocModel.Paragraph}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Paragraph</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Paragraph</em>' containment reference list.
	 * @see DocModel.DocModelPackage#getDocument_OwnedParagraph()
	 * @model containment="true"
	 * @generated
	 */
	EList<Paragraph> getOwnedParagraph();

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see DocModel.DocModelPackage#getDocument_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link DocModel.Document#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Owned Mark</b></em>' containment reference list.
	 * The list contents are of type {@link DocModel.Mark}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Mark</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Mark</em>' containment reference list.
	 * @see DocModel.DocModelPackage#getDocument_OwnedMark()
	 * @model containment="true"
	 * @generated
	 */
	EList<Mark> getOwnedMark();

} // Document
