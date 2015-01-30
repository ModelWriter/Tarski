package org.eclipse.emf.doc2model.doc2model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.CompositeAction#getSubActions <em>Sub Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getCompositeAction()
 * @model
 * @generated
 */
public interface CompositeAction extends Action {
	/**
	 * Returns the value of the '<em><b>Sub Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.doc2model.doc2model.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Actions</em>' containment reference list.
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getCompositeAction_SubActions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getSubActions();

} // CompositeAction
