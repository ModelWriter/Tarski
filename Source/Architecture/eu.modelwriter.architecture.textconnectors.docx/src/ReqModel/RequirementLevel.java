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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement Level</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ReqModel.RequirementLevel#getOwnedDefinition <em>Owned Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see ReqModel.ReqModelPackage#getRequirementLevel()
 * @model annotation="gmf.node figure='rectangle' label.icon='true' label='Name' label.pattern='{0}'"
 * @generated
 */
public interface RequirementLevel extends Definition {
	/**
	 * Returns the value of the '<em><b>Owned Definition</b></em>' containment reference list.
	 * The list contents are of type {@link ReqModel.Definition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Definition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Definition</em>' containment reference list.
	 * @see ReqModel.ReqModelPackage#getRequirementLevel_OwnedDefinition()
	 * @model containment="true"
	 *        annotation="gmf.compartment collapsible='true' layout='list'"
	 * @generated
	 */
	EList<Definition> getOwnedDefinition();

} // RequirementLevel
