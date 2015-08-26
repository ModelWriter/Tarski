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
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DocModel.Node#getRawText <em>Raw Text</em>}</li>
 *   <li>{@link DocModel.Node#getMark <em>Mark</em>}</li>
 * </ul>
 * </p>
 *
 * @see DocModel.DocModelPackage#getNode()
 * @model abstract="true"
 * @generated
 */
public interface Node extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Raw Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Text</em>' attribute.
	 * @see #setRawText(String)
	 * @see DocModel.DocModelPackage#getNode_RawText()
	 * @model
	 * @generated
	 */
	String getRawText();

	/**
	 * Sets the value of the '{@link DocModel.Node#getRawText <em>Raw Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Text</em>' attribute.
	 * @see #getRawText()
	 * @generated
	 */
	void setRawText(String value);

	/**
	 * Returns the value of the '<em><b>Mark</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link DocModel.Mark#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mark</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mark</em>' reference.
	 * @see #setMark(Mark)
	 * @see DocModel.DocModelPackage#getNode_Mark()
	 * @see DocModel.Mark#getNode
	 * @model opposite="node"
	 * @generated
	 */
	Mark getMark();

	/**
	 * Sets the value of the '{@link DocModel.Node#getMark <em>Mark</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mark</em>' reference.
	 * @see #getMark()
	 * @generated
	 */
	void setMark(Mark value);

} // Node
