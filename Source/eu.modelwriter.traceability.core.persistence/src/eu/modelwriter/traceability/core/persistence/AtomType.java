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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atom Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.AtomType#getValue <em>Value</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.AtomType#getLabel <em>Label</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.AtomType#getChanged <em>Changed</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.AtomType#getImpact <em>Impact</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.AtomType#getBound <em>Bound</em>}</li>
 * </ul>
 *
 * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getAtomType()
 * @model extendedMetaData="name='atom_._1_._type' kind='simple'"
 * @generated
 */
public interface AtomType extends EObject {
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getAtomType_Value()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="name=':0' kind='simple'"
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.AtomType#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

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
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getAtomType_Label()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='label' namespace='##targetNamespace'"
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.AtomType#getLabel <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label</em>' attribute.
   * @see #getLabel()
   * @generated
   */
  void setLabel(String value);

  /**
   * Returns the value of the '<em><b>Changed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Changed</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Changed</em>' attribute.
   * @see #setChanged(Boolean)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getAtomType_Changed()
   * @model dataType="org.eclipse.emf.ecore.xml.type.BooleanObject"
   * @generated
   */
  Boolean getChanged();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.AtomType#getChanged <em>Changed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Changed</em>' attribute.
   * @see #getChanged()
   * @generated
   */
  void setChanged(Boolean value);

  /**
   * Returns the value of the '<em><b>Impact</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Impact</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Impact</em>' attribute.
   * @see #setImpact(Boolean)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getAtomType_Impact()
   * @model dataType="org.eclipse.emf.ecore.xml.type.BooleanObject"
   * @generated
   */
  Boolean getImpact();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.AtomType#getImpact <em>Impact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Impact</em>' attribute.
   * @see #getImpact()
   * @generated
   */
  void setImpact(Boolean value);

  /**
   * Returns the value of the '<em><b>Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bound</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bound</em>' attribute.
   * @see #setBound(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getAtomType_Bound()
   * @model
   * @generated
   */
  String getBound();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.AtomType#getBound <em>Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bound</em>' attribute.
   * @see #getBound()
   * @generated
   */
  void setBound(String value);

} // AtomType
