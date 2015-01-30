package org.eclipse.emf.doc2model.doc2model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.ElementSelection#getEReferenceOwning <em>EReference Owning</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getElementSelection()
 * @model abstract="true"
 * @generated
 */
public interface ElementSelection extends EObject {

	/**
	 * Returns the value of the '<em><b>EReference Owning</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference Owning</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference Owning</em>' attribute.
	 * @see #setEReferenceOwning(String)
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getElementSelection_EReferenceOwning()
	 * @model
	 * @generated
	 */
	String getEReferenceOwning();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.doc2model.doc2model.ElementSelection#getEReferenceOwning <em>EReference Owning</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference Owning</em>' attribute.
	 * @see #getEReferenceOwning()
	 * @generated
	 */
	void setEReferenceOwning(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EObject getElement();
} // ElementSelection
