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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DocModel.Part#getNextPart <em>Next Part</em>}</li>
 *   <li>{@link DocModel.Part#getPrevPart <em>Prev Part</em>}</li>
 *   <li>{@link DocModel.Part#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see DocModel.DocModelPackage#getPart()
 * @model
 * @generated
 */
public interface Part extends Node {
	/**
	 * Returns the value of the '<em><b>Next Part</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link DocModel.Part#getPrevPart <em>Prev Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Part</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Part</em>' reference.
	 * @see #setNextPart(Part)
	 * @see DocModel.DocModelPackage#getPart_NextPart()
	 * @see DocModel.Part#getPrevPart
	 * @model opposite="prevPart"
	 * @generated
	 */
	Part getNextPart();

	/**
	 * Sets the value of the '{@link DocModel.Part#getNextPart <em>Next Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Part</em>' reference.
	 * @see #getNextPart()
	 * @generated
	 */
	void setNextPart(Part value);

	/**
	 * Returns the value of the '<em><b>Prev Part</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link DocModel.Part#getNextPart <em>Next Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prev Part</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prev Part</em>' reference.
	 * @see #setPrevPart(Part)
	 * @see DocModel.DocModelPackage#getPart_PrevPart()
	 * @see DocModel.Part#getNextPart
	 * @model opposite="nextPart"
	 * @generated
	 */
	Part getPrevPart();

	/**
	 * Sets the value of the '{@link DocModel.Part#getPrevPart <em>Prev Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prev Part</em>' reference.
	 * @see #getPrevPart()
	 * @generated
	 */
	void setPrevPart(Part value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link DocModel.Paragraph#getFirstPart <em>First Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' reference.
	 * @see #setNode(Paragraph)
	 * @see DocModel.DocModelPackage#getPart_Node()
	 * @see DocModel.Paragraph#getFirstPart
	 * @model opposite="firstPart"
	 * @generated
	 */
	Paragraph getNode();

	/**
	 * Sets the value of the '{@link DocModel.Part#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(Paragraph value);

} // Part
