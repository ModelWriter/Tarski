package org.eclipse.emf.doc2model.doc2model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Initial Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.InitialModel#isCopy <em>Copy</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.InitialModel#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getInitialModel()
 * @model
 * @generated
 */
public interface InitialModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Copy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Copy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copy</em>' attribute.
	 * @see #setCopy(boolean)
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getInitialModel_Copy()
	 * @model
	 * @generated
	 */
	boolean isCopy();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.doc2model.doc2model.InitialModel#isCopy <em>Copy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Copy</em>' attribute.
	 * @see #isCopy()
	 * @generated
	 */
	void setCopy(boolean value);

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(EObject)
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getInitialModel_Reference()
	 * @model
	 * @generated
	 */
	EObject getReference();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.doc2model.doc2model.InitialModel#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(EObject value);

} // InitialModel
