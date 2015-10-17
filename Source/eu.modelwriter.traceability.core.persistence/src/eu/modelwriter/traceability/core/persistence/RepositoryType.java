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
package eu.modelwriter.traceability.core.persistence;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.RepositoryType#getItem <em>Item</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.RepositoryType#getNextId <em>Next Id</em>}</li>
 * </ul>
 *
 * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getRepositoryType()
 * @model extendedMetaData="name='repository_._type' kind='elementOnly'"
 * @generated
 */
public interface RepositoryType extends EObject {
  /**
   * Returns the value of the '<em><b>Item</b></em>' containment reference list.
   * The list contents are of type {@link eu.modelwriter.traceability.core.persistence.ItemType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Item</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Item</em>' containment reference list.
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getRepositoryType_Item()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='item' namespace='##targetNamespace'"
   * @generated
   */
  EList<ItemType> getItem();

  /**
   * Returns the value of the '<em><b>Next Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Next Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Next Id</em>' attribute.
   * @see #isSetNextId()
   * @see #unsetNextId()
   * @see #setNextId(int)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getRepositoryType_NextId()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   * @generated
   */
  int getNextId();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.RepositoryType#getNextId <em>Next Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Next Id</em>' attribute.
   * @see #isSetNextId()
   * @see #unsetNextId()
   * @see #getNextId()
   * @generated
   */
  void setNextId(int value);

  /**
   * Unsets the value of the '{@link eu.modelwriter.traceability.core.persistence.RepositoryType#getNextId <em>Next Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetNextId()
   * @see #getNextId()
   * @see #setNextId(int)
   * @generated
   */
  void unsetNextId();

  /**
   * Returns whether the value of the '{@link eu.modelwriter.traceability.core.persistence.RepositoryType#getNextId <em>Next Id</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Next Id</em>' attribute is set.
   * @see #unsetNextId()
   * @see #getNextId()
   * @see #setNextId(int)
   * @generated
   */
  boolean isSetNextId();

} // RepositoryType
