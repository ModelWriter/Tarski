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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link useCase.StartEvent#is›sInterrupting <em>›s Interrupting</em>}</li>
 * </ul>
 * </p>
 *
 * @see useCase.UseCasePackage#getStartEvent()
 * @model
 * @generated
 */
public interface StartEvent extends CatchEvent {
	/**
	 * Returns the value of the '<em><b>›s Interrupting</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>›s Interrupting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>›s Interrupting</em>' attribute.
	 * @see #set›sInterrupting(boolean)
	 * @see useCase.UseCasePackage#getStartEvent_›sInterrupting()
	 * @model default="true"
	 * @generated
	 */
	boolean is›sInterrupting();

	/**
	 * Sets the value of the '{@link useCase.StartEvent#is›sInterrupting <em>›s Interrupting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>›s Interrupting</em>' attribute.
	 * @see #is›sInterrupting()
	 * @generated
	 */
	void set›sInterrupting(boolean value);

} // StartEvent
