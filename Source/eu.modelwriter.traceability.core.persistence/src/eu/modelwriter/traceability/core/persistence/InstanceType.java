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
 * A representation of the model object '<em><b>Instance Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.InstanceType#getSig <em>Sig</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.InstanceType#getField <em>Field</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.InstanceType#getBitwidth <em>Bitwidth</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.InstanceType#getFilename <em>Filename</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.InstanceType#getMaxseq <em>Maxseq</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.InstanceType#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 *
 * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getInstanceType()
 * @model extendedMetaData="name='instance_._type' kind='elementOnly'"
 * @generated
 */
public interface InstanceType extends EObject {
  /**
   * Returns the value of the '<em><b>Sig</b></em>' containment reference list.
   * The list contents are of type {@link eu.modelwriter.traceability.core.persistence.SigType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sig</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sig</em>' containment reference list.
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getInstanceType_Sig()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='sig' namespace='##targetNamespace'"
   * @generated
   */
  EList<SigType> getSig();

  /**
   * Returns the value of the '<em><b>Field</b></em>' containment reference list.
   * The list contents are of type {@link eu.modelwriter.traceability.core.persistence.FieldType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field</em>' containment reference list.
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getInstanceType_Field()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='field' namespace='##targetNamespace'"
   * @generated
   */
  EList<FieldType> getField();

  /**
   * Returns the value of the '<em><b>Bitwidth</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bitwidth</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bitwidth</em>' attribute.
   * @see #isSetBitwidth()
   * @see #unsetBitwidth()
   * @see #setBitwidth(int)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getInstanceType_Bitwidth()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='bitwidth' namespace='##targetNamespace'"
   * @generated
   */
  int getBitwidth();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.InstanceType#getBitwidth <em>Bitwidth</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bitwidth</em>' attribute.
   * @see #isSetBitwidth()
   * @see #unsetBitwidth()
   * @see #getBitwidth()
   * @generated
   */
  void setBitwidth(int value);

  /**
   * Unsets the value of the '{@link eu.modelwriter.traceability.core.persistence.InstanceType#getBitwidth <em>Bitwidth</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetBitwidth()
   * @see #getBitwidth()
   * @see #setBitwidth(int)
   * @generated
   */
  void unsetBitwidth();

  /**
   * Returns whether the value of the '{@link eu.modelwriter.traceability.core.persistence.InstanceType#getBitwidth <em>Bitwidth</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Bitwidth</em>' attribute is set.
   * @see #unsetBitwidth()
   * @see #getBitwidth()
   * @see #setBitwidth(int)
   * @generated
   */
  boolean isSetBitwidth();

  /**
   * Returns the value of the '<em><b>Filename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Filename</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Filename</em>' attribute.
   * @see #setFilename(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getInstanceType_Filename()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='filename' namespace='##targetNamespace'"
   * @generated
   */
  String getFilename();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.InstanceType#getFilename <em>Filename</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Filename</em>' attribute.
   * @see #getFilename()
   * @generated
   */
  void setFilename(String value);

  /**
   * Returns the value of the '<em><b>Maxseq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Maxseq</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Maxseq</em>' attribute.
   * @see #isSetMaxseq()
   * @see #unsetMaxseq()
   * @see #setMaxseq(int)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getInstanceType_Maxseq()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='maxseq' namespace='##targetNamespace'"
   * @generated
   */
  int getMaxseq();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.InstanceType#getMaxseq <em>Maxseq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Maxseq</em>' attribute.
   * @see #isSetMaxseq()
   * @see #unsetMaxseq()
   * @see #getMaxseq()
   * @generated
   */
  void setMaxseq(int value);

  /**
   * Unsets the value of the '{@link eu.modelwriter.traceability.core.persistence.InstanceType#getMaxseq <em>Maxseq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMaxseq()
   * @see #getMaxseq()
   * @see #setMaxseq(int)
   * @generated
   */
  void unsetMaxseq();

  /**
   * Returns whether the value of the '{@link eu.modelwriter.traceability.core.persistence.InstanceType#getMaxseq <em>Maxseq</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Maxseq</em>' attribute is set.
   * @see #unsetMaxseq()
   * @see #getMaxseq()
   * @see #setMaxseq(int)
   * @generated
   */
  boolean isSetMaxseq();

  /**
   * Returns the value of the '<em><b>Metamodel</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metamodel</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel</em>' attribute.
   * @see #setMetamodel(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getInstanceType_Metamodel()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   * @generated
   */
  String getMetamodel();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.InstanceType#getMetamodel <em>Metamodel</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metamodel</em>' attribute.
   * @see #getMetamodel()
   * @generated
   */
  void setMetamodel(String value);

} // InstanceType
