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
 * A representation of the model object '<em><b>Field Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.FieldType#getTuple <em>Tuple</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.FieldType#getTypes <em>Types</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.FieldType#getID <em>ID</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.FieldType#getLabel <em>Label</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.FieldType#getParentID <em>Parent ID</em>}</li>
 * </ul>
 *
 * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getFieldType()
 * @model extendedMetaData="name='field_._type' kind='elementOnly'"
 * @generated
 */
public interface FieldType extends EObject {
  /**
   * Returns the value of the '<em><b>Tuple</b></em>' containment reference list.
   * The list contents are of type {@link eu.modelwriter.traceability.core.persistence.TupleType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tuple</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tuple</em>' containment reference list.
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getFieldType_Tuple()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='tuple' namespace='##targetNamespace'"
   * @generated
   */
  EList<TupleType> getTuple();

  /**
   * Returns the value of the '<em><b>Types</b></em>' containment reference list.
   * The list contents are of type {@link eu.modelwriter.traceability.core.persistence.TypesType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Types</em>' containment reference list.
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getFieldType_Types()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='types' namespace='##targetNamespace'"
   * @generated
   */
  EList<TypesType> getTypes();

  /**
   * Returns the value of the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>ID</em>' attribute.
   * @see #isSetID()
   * @see #unsetID()
   * @see #setID(int)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getFieldType_ID()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='ID' namespace='##targetNamespace'"
   * @generated
   */
  int getID();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.FieldType#getID <em>ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>ID</em>' attribute.
   * @see #isSetID()
   * @see #unsetID()
   * @see #getID()
   * @generated
   */
  void setID(int value);

  /**
   * Unsets the value of the '{@link eu.modelwriter.traceability.core.persistence.FieldType#getID <em>ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetID()
   * @see #getID()
   * @see #setID(int)
   * @generated
   */
  void unsetID();

  /**
   * Returns whether the value of the '{@link eu.modelwriter.traceability.core.persistence.FieldType#getID <em>ID</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>ID</em>' attribute is set.
   * @see #unsetID()
   * @see #getID()
   * @see #setID(int)
   * @generated
   */
  boolean isSetID();

  /**
   * Returns the value of the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Label</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Label</em>' attribute.
   * @see #setLabel(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getFieldType_Label()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='label' namespace='##targetNamespace'"
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.FieldType#getLabel <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label</em>' attribute.
   * @see #getLabel()
   * @generated
   */
  void setLabel(String value);

  /**
   * Returns the value of the '<em><b>Parent ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parent ID</em>' attribute.
   * @see #isSetParentID()
   * @see #unsetParentID()
   * @see #setParentID(int)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getFieldType_ParentID()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='parentID' namespace='##targetNamespace'"
   * @generated
   */
  int getParentID();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.FieldType#getParentID <em>Parent ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent ID</em>' attribute.
   * @see #isSetParentID()
   * @see #unsetParentID()
   * @see #getParentID()
   * @generated
   */
  void setParentID(int value);

  /**
   * Unsets the value of the '{@link eu.modelwriter.traceability.core.persistence.FieldType#getParentID <em>Parent ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetParentID()
   * @see #getParentID()
   * @see #setParentID(int)
   * @generated
   */
  void unsetParentID();

  /**
   * Returns whether the value of the '{@link eu.modelwriter.traceability.core.persistence.FieldType#getParentID <em>Parent ID</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Parent ID</em>' attribute is set.
   * @see #unsetParentID()
   * @see #getParentID()
   * @see #setParentID(int)
   * @generated
   */
  boolean isSetParentID();

} // FieldType
