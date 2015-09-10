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
 * A representation of the model object '<em><b>Alloy Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.AlloyType#getInstance <em>Instance</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.AlloyType#getRepository <em>Repository</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.AlloyType#getSource <em>Source</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.AlloyType#getBuilddate <em>Builddate</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.AlloyType#getRelation <em>Relation</em>}</li>
 * </ul>
 *
 * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getAlloyType()
 * @model extendedMetaData="name='alloy_._type' kind='elementOnly'"
 * @generated
 */
public interface AlloyType extends EObject {
  /**
   * Returns the value of the '<em><b>Instance</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instance</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instance</em>' containment reference.
   * @see #setInstance(InstanceType)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getAlloyType_Instance()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='instance' namespace='##targetNamespace'"
   * @generated
   */
  InstanceType getInstance();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.AlloyType#getInstance <em>Instance</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instance</em>' containment reference.
   * @see #getInstance()
   * @generated
   */
  void setInstance(InstanceType value);

  /**
   * Returns the value of the '<em><b>Repository</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Repository</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Repository</em>' containment reference.
   * @see #setRepository(RepositoryType)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getAlloyType_Repository()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='repository' namespace='##targetNamespace'"
   * @generated
   */
  RepositoryType getRepository();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.AlloyType#getRepository <em>Repository</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Repository</em>' containment reference.
   * @see #getRepository()
   * @generated
   */
  void setRepository(RepositoryType value);

  /**
   * Returns the value of the '<em><b>Source</b></em>' containment reference list.
   * The list contents are of type {@link eu.modelwriter.traceability.core.persistence.SourceType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' containment reference list.
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getAlloyType_Source()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='source' namespace='##targetNamespace'"
   * @generated
   */
  EList<SourceType> getSource();

  /**
   * Returns the value of the '<em><b>Builddate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Builddate</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Builddate</em>' attribute.
   * @see #setBuilddate(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getAlloyType_Builddate()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='builddate' namespace='##targetNamespace'"
   * @generated
   */
  String getBuilddate();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.AlloyType#getBuilddate <em>Builddate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Builddate</em>' attribute.
   * @see #getBuilddate()
   * @generated
   */
  void setBuilddate(String value);

  /**
   * Returns the value of the '<em><b>Relation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relation</em>' containment reference.
   * @see #setRelation(RelationType)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getAlloyType_Relation()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='relation' namespace='##targetNamespace'"
   * @generated
   */
  RelationType getRelation();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.AlloyType#getRelation <em>Relation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relation</em>' containment reference.
   * @see #getRelation()
   * @generated
   */
  void setRelation(RelationType value);

} // AlloyType
