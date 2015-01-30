package org.eclipse.emf.doc2model.doc2model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container Selection Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.ContainerSelectionObject#getSelection <em>Selection</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getContainerSelectionObject()
 * @model
 * @generated
 */
public interface ContainerSelectionObject extends Value {
	/**
	 * Returns the value of the '<em><b>Selection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection</em>' containment reference.
	 * @see #setSelection(ElementSelection)
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getContainerSelectionObject_Selection()
	 * @model containment="true"
	 * @generated
	 */
	ElementSelection getSelection();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.doc2model.doc2model.ContainerSelectionObject#getSelection <em>Selection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection</em>' containment reference.
	 * @see #getSelection()
	 * @generated
	 */
	void setSelection(ElementSelection value);

} // ContainerSelectionObject
