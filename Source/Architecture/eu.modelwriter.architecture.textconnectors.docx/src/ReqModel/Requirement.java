/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    A. Furkan Tanriverdi (UNIT) - initial API and implementation
 *******************************************************************************/
/**
 */
package ReqModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ReqModel.Requirement#getId <em>Id</em>}</li>
 *   <li>{@link ReqModel.Requirement#getDescription <em>Description</em>}</li>
 *   <li>{@link ReqModel.Requirement#getRefine <em>Refine</em>}</li>
 *   <li>{@link ReqModel.Requirement#getDependencyTo <em>Dependency To</em>}</li>
 *   <li>{@link ReqModel.Requirement#getPriorityType <em>Priority Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see ReqModel.ReqModelPackage#getRequirement()
 * @model annotation="gmf.node figure='rounded' label.icon='true' label='Name' label.pattern='{0}'"
 * @generated
 */
public interface Requirement extends Definition {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see ReqModel.ReqModelPackage#getRequirement_Id()
	 * @model default=""
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link ReqModel.Requirement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see ReqModel.ReqModelPackage#getRequirement_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link ReqModel.Requirement#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Refine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refine</em>' reference.
	 * @see #setRefine(Requirement)
	 * @see ReqModel.ReqModelPackage#getRequirement_Refine()
	 * @model annotation="gmf.link target.decoration='arrow' source.decoration='none' style='dash' color='0,0,0'"
	 * @generated
	 */
	Requirement getRefine();

	/**
	 * Sets the value of the '{@link ReqModel.Requirement#getRefine <em>Refine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refine</em>' reference.
	 * @see #getRefine()
	 * @generated
	 */
	void setRefine(Requirement value);

	/**
	 * Returns the value of the '<em><b>Dependency To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependency To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency To</em>' reference.
	 * @see #setDependencyTo(Requirement)
	 * @see ReqModel.ReqModelPackage#getRequirement_DependencyTo()
	 * @model annotation="gmf.link target.decoration='arrow' source.decoration='none' style='dash' color='0,0,0'"
	 * @generated
	 */
	Requirement getDependencyTo();

	/**
	 * Sets the value of the '{@link ReqModel.Requirement#getDependencyTo <em>Dependency To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependency To</em>' reference.
	 * @see #getDependencyTo()
	 * @generated
	 */
	void setDependencyTo(Requirement value);

	/**
	 * Returns the value of the '<em><b>Priority Type</b></em>' attribute.
	 * The literals are from the enumeration {@link ReqModel.Priority}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority Type</em>' attribute.
	 * @see ReqModel.Priority
	 * @see #setPriorityType(Priority)
	 * @see ReqModel.ReqModelPackage#getRequirement_PriorityType()
	 * @model
	 * @generated
	 */
	Priority getPriorityType();

	/**
	 * Sets the value of the '{@link ReqModel.Requirement#getPriorityType <em>Priority Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority Type</em>' attribute.
	 * @see ReqModel.Priority
	 * @see #getPriorityType()
	 * @generated
	 */
	void setPriorityType(Priority value);

} // Requirement
