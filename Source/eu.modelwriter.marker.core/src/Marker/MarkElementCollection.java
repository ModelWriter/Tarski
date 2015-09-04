/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ferhat Erata - initial API and implementation
 *     H. Emre Kirmizi - initial API and implementation
 *     Serhat Celik - initial API and implementation
 *     U. Anil Ozturk - initial API and implementation
 *******************************************************************************/
/**
 */
package Marker;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mark Element Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Marker.MarkElementCollection#getMarkElements <em>Mark Elements</em>}</li>
 * </ul>
 *
 * @see Marker.MarkerPackage#getMarkElementCollection()
 * @model
 * @generated
 */
public interface MarkElementCollection extends EObject {
  /**
   * Returns the value of the '<em><b>Mark Elements</b></em>' containment reference list.
   * The list contents are of type {@link Marker.MarkElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mark Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mark Elements</em>' containment reference list.
   * @see Marker.MarkerPackage#getMarkElementCollection_MarkElements()
   * @model containment="true"
   * @generated
   */
  EList<MarkElement> getMarkElements();

} // MarkElementCollection
