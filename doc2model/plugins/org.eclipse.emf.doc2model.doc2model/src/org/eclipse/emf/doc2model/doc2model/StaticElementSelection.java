package org.eclipse.emf.doc2model.doc2model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Static Element Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.StaticElementSelection#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getStaticElementSelection()
 * @model
 * @generated
 */
public interface StaticElementSelection extends ElementSelection {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EObject)
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getStaticElementSelection_Element()
	 * @model
	 * @generated
	 */
	EObject getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.doc2model.doc2model.StaticElementSelection#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EObject value);

} // StaticElementSelection
