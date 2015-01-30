package org.eclipse.emf.doc2model.doc2model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.Configuration#getInitialModel <em>Initial Model</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.Configuration#getEPackages <em>EPackages</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.Configuration#getExtension <em>Extension</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends EObject {
	/**
	 * Returns the value of the '<em><b>Initial Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Model</em>' containment reference.
	 * @see #setInitialModel(InitialModel)
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getConfiguration_InitialModel()
	 * @model containment="true"
	 * @generated
	 */
	InitialModel getInitialModel();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.doc2model.doc2model.Configuration#getInitialModel <em>Initial Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Model</em>' containment reference.
	 * @see #getInitialModel()
	 * @generated
	 */
	void setInitialModel(InitialModel value);

	/**
	 * Returns the value of the '<em><b>EPackages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.doc2model.doc2model.EPackageReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EPackages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EPackages</em>' containment reference list.
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getConfiguration_EPackages()
	 * @model containment="true"
	 * @generated
	 */
	EList<EPackageReference> getEPackages();

	/**
	 * Returns the value of the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' attribute.
	 * @see #setExtension(String)
	 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getConfiguration_Extension()
	 * @model
	 * @generated
	 */
	String getExtension();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.doc2model.doc2model.Configuration#getExtension <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' attribute.
	 * @see #getExtension()
	 * @generated
	 */
	void setExtension(String value);

} // Configuration
