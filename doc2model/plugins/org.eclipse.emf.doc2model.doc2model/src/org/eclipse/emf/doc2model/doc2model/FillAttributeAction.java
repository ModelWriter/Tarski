package org.eclipse.emf.doc2model.doc2model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fill Attribute Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.FillAttributeAction#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.FillAttributeAction#getEobjectContainingAttribute <em>Eobject Containing Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getFillAttributeAction()
 * @model
 * @generated
 */
public interface FillAttributeAction extends ActionWithInParameter {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' attribute.
	 * @see #setAttribute(String)
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getFillAttributeAction_Attribute()
	 * @model
	 * @generated
	 */
	String getAttribute();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.doc2model.doc2model.FillAttributeAction#getAttribute <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' attribute.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(String value);

	/**
	 * Returns the value of the '<em><b>Eobject Containing Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eobject Containing Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eobject Containing Attribute</em>' reference.
	 * @see #setEobjectContainingAttribute(Value)
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getFillAttributeAction_EobjectContainingAttribute()
	 * @model
	 * @generated
	 */
	Value getEobjectContainingAttribute();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.doc2model.doc2model.FillAttributeAction#getEobjectContainingAttribute <em>Eobject Containing Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eobject Containing Attribute</em>' reference.
	 * @see #getEobjectContainingAttribute()
	 * @generated
	 */
	void setEobjectContainingAttribute(Value value);

} // FillAttributeAction
