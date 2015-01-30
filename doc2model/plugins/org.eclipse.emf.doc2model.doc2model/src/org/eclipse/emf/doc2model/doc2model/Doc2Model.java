package org.eclipse.emf.doc2model.doc2model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Doc2 Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.Doc2Model#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.Doc2Model#getRules <em>Rules</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.Doc2Model#getOwnedMatches <em>Owned Matches</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.Doc2Model#getOwnedActions <em>Owned Actions</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.Doc2Model#getInitialAction <em>Initial Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getDoc2Model()
 * @model
 * @generated
 */
public interface Doc2Model extends ObjectContainer {
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference.
	 * @see #setConfiguration(Configuration)
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getDoc2Model_Configuration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Configuration getConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.doc2model.doc2model.Doc2Model#getConfiguration <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' containment reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(Configuration value);

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.doc2model.doc2model.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getDoc2Model_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rule> getRules();

	/**
	 * Returns the value of the '<em><b>Owned Matches</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.doc2model.doc2model.Match}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Matches</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Matches</em>' containment reference list.
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getDoc2Model_OwnedMatches()
	 * @model containment="true"
	 * @generated
	 */
	EList<Match> getOwnedMatches();

	/**
	 * Returns the value of the '<em><b>Owned Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.doc2model.doc2model.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Actions</em>' containment reference list.
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getDoc2Model_OwnedActions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getOwnedActions();

	/**
	 * Returns the value of the '<em><b>Initial Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Action</em>' reference.
	 * @see #setInitialAction(Action)
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getDoc2Model_InitialAction()
	 * @model
	 * @generated
	 */
	Action getInitialAction();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.doc2model.doc2model.Doc2Model#getInitialAction <em>Initial Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Action</em>' reference.
	 * @see #getInitialAction()
	 * @generated
	 */
	void setInitialAction(Action value);

} // Doc2Model
