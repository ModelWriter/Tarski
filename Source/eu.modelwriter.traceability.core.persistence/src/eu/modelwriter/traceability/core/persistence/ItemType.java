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

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.ItemType#getGroup <em>Group</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.ItemType#getEntry <em>Entry</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.ItemType#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getItemType()
 * @model extendedMetaData="name='item_._type' kind='elementOnly'"
 * @generated
 */
public interface ItemType extends EObject {
  /**
   * Returns the value of the '<em><b>Group</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group</em>' attribute list.
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getItemType_Group()
   * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
   *        extendedMetaData="kind='group' name='group:0'"
   * @generated
   */
  FeatureMap getGroup();

  /**
   * Returns the value of the '<em><b>Entry</b></em>' containment reference list.
   * The list contents are of type {@link eu.modelwriter.traceability.core.persistence.EntryType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entry</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entry</em>' containment reference list.
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getItemType_Entry()
   * @model containment="true" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='entry' namespace='##targetNamespace' group='group:0'"
   * @generated
   */
  EList<EntryType> getEntry();

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getItemType_Id()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='id' namespace='##targetNamespace'"
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.ItemType#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

} // ItemType
