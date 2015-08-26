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
package useCase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link useCase.UseCase#getPrimaryActor <em>Primary Actor</em>}</li>
 *   <li>{@link useCase.UseCase#getOwnedStakeholderInterest <em>Owned Stakeholder Interest</em>}</li>
 *   <li>{@link useCase.UseCase#getOwnedMainFlow <em>Owned Main Flow</em>}</li>
 *   <li>{@link useCase.UseCase#getOwnedAlternativeFlow <em>Owned Alternative Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @see useCase.UseCasePackage#getUseCase()
 * @model
 * @generated
 */
public interface UseCase extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Primary Actor</b></em>' reference list.
	 * The list contents are of type {@link useCase.Actor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Actor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Actor</em>' reference list.
	 * @see useCase.UseCasePackage#getUseCase_PrimaryActor()
	 * @model
	 * @generated
	 */
	EList<Actor> getPrimaryActor();

	/**
	 * Returns the value of the '<em><b>Owned Stakeholder Interest</b></em>' containment reference list.
	 * The list contents are of type {@link useCase.Interest}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Stakeholder Interest</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Stakeholder Interest</em>' containment reference list.
	 * @see useCase.UseCasePackage#getUseCase_OwnedStakeholderInterest()
	 * @model containment="true"
	 * @generated
	 */
	EList<Interest> getOwnedStakeholderInterest();

	/**
	 * Returns the value of the '<em><b>Owned Main Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Main Flow</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Main Flow</em>' containment reference.
	 * @see #setOwnedMainFlow(useCase.Process)
	 * @see useCase.UseCasePackage#getUseCase_OwnedMainFlow()
	 * @model containment="true"
	 * @generated
	 */
	useCase.Process getOwnedMainFlow();

	/**
	 * Sets the value of the '{@link useCase.UseCase#getOwnedMainFlow <em>Owned Main Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Main Flow</em>' containment reference.
	 * @see #getOwnedMainFlow()
	 * @generated
	 */
	void setOwnedMainFlow(useCase.Process value);

	/**
	 * Returns the value of the '<em><b>Owned Alternative Flow</b></em>' containment reference list.
	 * The list contents are of type {@link useCase.Process}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Alternative Flow</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Alternative Flow</em>' containment reference list.
	 * @see useCase.UseCasePackage#getUseCase_OwnedAlternativeFlow()
	 * @model containment="true"
	 * @generated
	 */
	EList<useCase.Process> getOwnedAlternativeFlow();

} // UseCase
