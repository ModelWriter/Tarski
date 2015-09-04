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
 * A representation of the model object '<em><b>Sig Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.SigType#getMixed <em>Mixed</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.SigType#getAtom <em>Atom</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.SigType#getType <em>Type</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.SigType#getAbstract <em>Abstract</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.SigType#getBuiltin <em>Builtin</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.SigType#getEnum <em>Enum</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.SigType#getID <em>ID</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.SigType#getLabel <em>Label</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.SigType#getLone <em>Lone</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.SigType#getMeta <em>Meta</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.SigType#getOne <em>One</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.SigType#getParentID <em>Parent ID</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.SigType#getPrivate <em>Private</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.SigType#getSome <em>Some</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.SigType#getSubset <em>Subset</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.SigType#getSubsig <em>Subsig</em>}</li>
 * </ul>
 *
 * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType()
 * @model extendedMetaData="name='sig_._type' kind='mixed'"
 * @generated
 */
public interface SigType extends EObject {
  /**
   * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mixed</em>' attribute list.
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType_Mixed()
   * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
   *        extendedMetaData="kind='elementWildcard' name=':mixed'"
   * @generated
   */
  FeatureMap getMixed();

  /**
   * Returns the value of the '<em><b>Atom</b></em>' containment reference list.
   * The list contents are of type {@link eu.modelwriter.traceability.core.persistence.AtomType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Atom</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Atom</em>' containment reference list.
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType_Atom()
   * @model containment="true" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='atom' namespace='##targetNamespace'"
   * @generated
   */
  EList<AtomType> getAtom();

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference list.
   * The list contents are of type {@link eu.modelwriter.traceability.core.persistence.TypeType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference list.
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType_Type()
   * @model containment="true" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='type' namespace='##targetNamespace'"
   * @generated
   */
  EList<TypeType> getType();

  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #setAbstract(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType_Abstract()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='abstract' namespace='##targetNamespace'"
   * @generated
   */
  String getAbstract();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #getAbstract()
   * @generated
   */
  void setAbstract(String value);

  /**
   * Returns the value of the '<em><b>Builtin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Builtin</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Builtin</em>' attribute.
   * @see #setBuiltin(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType_Builtin()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='builtin' namespace='##targetNamespace'"
   * @generated
   */
  String getBuiltin();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getBuiltin <em>Builtin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Builtin</em>' attribute.
   * @see #getBuiltin()
   * @generated
   */
  void setBuiltin(String value);

  /**
   * Returns the value of the '<em><b>Enum</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enum</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enum</em>' attribute.
   * @see #setEnum(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType_Enum()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='enum' namespace='##targetNamespace'"
   * @generated
   */
  String getEnum();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getEnum <em>Enum</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enum</em>' attribute.
   * @see #getEnum()
   * @generated
   */
  void setEnum(String value);

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
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType_ID()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='ID' namespace='##targetNamespace'"
   * @generated
   */
  int getID();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getID <em>ID</em>}' attribute.
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
   * Unsets the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getID <em>ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetID()
   * @see #getID()
   * @see #setID(int)
   * @generated
   */
  void unsetID();

  /**
   * Returns whether the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getID <em>ID</em>}' attribute is set.
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
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType_Label()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='label' namespace='##targetNamespace'"
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getLabel <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label</em>' attribute.
   * @see #getLabel()
   * @generated
   */
  void setLabel(String value);

  /**
   * Returns the value of the '<em><b>Lone</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lone</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lone</em>' attribute.
   * @see #setLone(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType_Lone()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='lone' namespace='##targetNamespace'"
   * @generated
   */
  String getLone();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getLone <em>Lone</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lone</em>' attribute.
   * @see #getLone()
   * @generated
   */
  void setLone(String value);

  /**
   * Returns the value of the '<em><b>Meta</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Meta</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Meta</em>' attribute.
   * @see #setMeta(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType_Meta()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='meta' namespace='##targetNamespace'"
   * @generated
   */
  String getMeta();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getMeta <em>Meta</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Meta</em>' attribute.
   * @see #getMeta()
   * @generated
   */
  void setMeta(String value);

  /**
   * Returns the value of the '<em><b>One</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>One</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>One</em>' attribute.
   * @see #setOne(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType_One()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='one' namespace='##targetNamespace'"
   * @generated
   */
  String getOne();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getOne <em>One</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>One</em>' attribute.
   * @see #getOne()
   * @generated
   */
  void setOne(String value);

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
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType_ParentID()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='parentID' namespace='##targetNamespace'"
   * @generated
   */
  int getParentID();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getParentID <em>Parent ID</em>}' attribute.
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
   * Unsets the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getParentID <em>Parent ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetParentID()
   * @see #getParentID()
   * @see #setParentID(int)
   * @generated
   */
  void unsetParentID();

  /**
   * Returns whether the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getParentID <em>Parent ID</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Parent ID</em>' attribute is set.
   * @see #unsetParentID()
   * @see #getParentID()
   * @see #setParentID(int)
   * @generated
   */
  boolean isSetParentID();

  /**
   * Returns the value of the '<em><b>Private</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Private</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Private</em>' attribute.
   * @see #setPrivate(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType_Private()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='private' namespace='##targetNamespace'"
   * @generated
   */
  String getPrivate();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getPrivate <em>Private</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Private</em>' attribute.
   * @see #getPrivate()
   * @generated
   */
  void setPrivate(String value);

  /**
   * Returns the value of the '<em><b>Some</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Some</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Some</em>' attribute.
   * @see #setSome(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType_Some()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='some' namespace='##targetNamespace'"
   * @generated
   */
  String getSome();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getSome <em>Some</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Some</em>' attribute.
   * @see #getSome()
   * @generated
   */
  void setSome(String value);

  /**
   * Returns the value of the '<em><b>Subset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subset</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subset</em>' attribute.
   * @see #setSubset(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType_Subset()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='subset' namespace='##targetNamespace'"
   * @generated
   */
  String getSubset();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getSubset <em>Subset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subset</em>' attribute.
   * @see #getSubset()
   * @generated
   */
  void setSubset(String value);

  /**
   * Returns the value of the '<em><b>Subsig</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subsig</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subsig</em>' attribute.
   * @see #setSubsig(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getSigType_Subsig()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='subsig' namespace='##targetNamespace'"
   * @generated
   */
  String getSubsig();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.SigType#getSubsig <em>Subsig</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subsig</em>' attribute.
   * @see #getSubsig()
   * @generated
   */
  void setSubsig(String value);

} // SigType
