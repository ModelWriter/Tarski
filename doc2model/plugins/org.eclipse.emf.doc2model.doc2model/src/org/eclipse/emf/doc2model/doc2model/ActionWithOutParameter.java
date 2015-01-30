package org.eclipse.emf.doc2model.doc2model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action With Out Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.ActionWithOutParameter#getOut <em>Out</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getActionWithOutParameter()
 * @model abstract="true"
 * @generated
 */
public interface ActionWithOutParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Out</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out</em>' reference.
	 * @see #setOut(Value)
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getActionWithOutParameter_Out()
	 * @model
	 * @generated
	 */
	Value getOut();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.doc2model.doc2model.ActionWithOutParameter#getOut <em>Out</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out</em>' reference.
	 * @see #getOut()
	 * @generated
	 */
	void setOut(Value value);

} // ActionWithOutParameter
