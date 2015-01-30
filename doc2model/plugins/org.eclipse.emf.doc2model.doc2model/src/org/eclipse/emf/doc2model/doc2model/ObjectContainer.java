package org.eclipse.emf.doc2model.doc2model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.ObjectContainer#getOwnedObjects <em>Owned Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getObjectContainer()
 * @model abstract="true"
 * @generated
 */
public interface ObjectContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Owned Objects</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.doc2model.doc2model.Value}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Objects</em>' containment reference list.
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getObjectContainer_OwnedObjects()
	 * @model containment="true"
	 * @generated
	 */
	EList<Value> getOwnedObjects();

} // ObjectContainer
