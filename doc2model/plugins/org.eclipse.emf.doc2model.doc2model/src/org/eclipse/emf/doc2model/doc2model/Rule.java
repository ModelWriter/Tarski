package org.eclipse.emf.doc2model.doc2model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.Rule#getMatch <em>Match</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.Rule#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends EObject {
	/**
	 * Returns the value of the '<em><b>Match</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.doc2model.doc2model.Match#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Match</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match</em>' reference.
	 * @see #setMatch(Match)
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getRule_Match()
	 * @see org.eclipse.emf.doc2model.doc2model.Match#getRule
	 * @model opposite="rule"
	 * @generated
	 */
	Match getMatch();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.doc2model.doc2model.Rule#getMatch <em>Match</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Match</em>' reference.
	 * @see #getMatch()
	 * @generated
	 */
	void setMatch(Match value);

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.doc2model.doc2model.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' reference list.
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getRule_Actions()
	 * @model
	 * @generated
	 */
	EList<Action> getActions();

} // Rule
