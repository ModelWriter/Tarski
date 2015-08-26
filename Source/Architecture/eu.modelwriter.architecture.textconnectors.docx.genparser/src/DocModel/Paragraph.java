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
 * A representation of the model object '<em><b>Paragraph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DocModel.Paragraph#getOwnedNode <em>Owned Node</em>}</li>
 *   <li>{@link DocModel.Paragraph#getOwnedPart <em>Owned Part</em>}</li>
 *   <li>{@link DocModel.Paragraph#getFirstPart <em>First Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see DocModel.DocModelPackage#getParagraph()
 * @model
 * @generated
 */
public interface Paragraph extends Node {
	/**
	 * Returns the value of the '<em><b>Owned Node</b></em>' containment reference list.
	 * The list contents are of type {@link DocModel.Paragraph}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Node</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Node</em>' containment reference list.
	 * @see DocModel.DocModelPackage#getParagraph_OwnedNode()
	 * @model containment="true"
	 * @generated
	 */
	EList<Paragraph> getOwnedNode();

	/**
	 * Returns the value of the '<em><b>Owned Part</b></em>' containment reference list.
	 * The list contents are of type {@link DocModel.Part}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Part</em>' containment reference list.
	 * @see DocModel.DocModelPackage#getParagraph_OwnedPart()
	 * @model containment="true"
	 * @generated
	 */
	EList<Part> getOwnedPart();

	/**
	 * Returns the value of the '<em><b>First Part</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link DocModel.Part#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Part</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Part</em>' reference.
	 * @see #setFirstPart(Part)
	 * @see DocModel.DocModelPackage#getParagraph_FirstPart()
	 * @see DocModel.Part#getNode
	 * @model opposite="node"
	 * @generated
	 */
	Part getFirstPart();

	/**
	 * Sets the value of the '{@link DocModel.Paragraph#getFirstPart <em>First Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Part</em>' reference.
	 * @see #getFirstPart()
	 * @generated
	 */
	void setFirstPart(Part value);

} // Paragraph
