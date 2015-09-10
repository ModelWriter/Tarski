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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eu.modelwriter.traceability.core.persistence.persistencePackage
 * @generated
 */
public interface persistenceFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  persistenceFactory eINSTANCE = eu.modelwriter.traceability.core.persistence.impl.persistenceFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Alloy Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Alloy Type</em>'.
   * @generated
   */
  AlloyType createAlloyType();

  /**
   * Returns a new object of class '<em>Atom Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Atom Type</em>'.
   * @generated
   */
  AtomType createAtomType();

  /**
   * Returns a new object of class '<em>Document Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Document Root</em>'.
   * @generated
   */
  DocumentRoot createDocumentRoot();

  /**
   * Returns a new object of class '<em>Entry Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entry Type</em>'.
   * @generated
   */
  EntryType createEntryType();

  /**
   * Returns a new object of class '<em>Field Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Field Type</em>'.
   * @generated
   */
  FieldType createFieldType();

  /**
   * Returns a new object of class '<em>Instance Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance Type</em>'.
   * @generated
   */
  InstanceType createInstanceType();

  /**
   * Returns a new object of class '<em>Item Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Item Type</em>'.
   * @generated
   */
  ItemType createItemType();

  /**
   * Returns a new object of class '<em>Repository Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Repository Type</em>'.
   * @generated
   */
  RepositoryType createRepositoryType();

  /**
   * Returns a new object of class '<em>Sig Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sig Type</em>'.
   * @generated
   */
  SigType createSigType();

  /**
   * Returns a new object of class '<em>Source Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Source Type</em>'.
   * @generated
   */
  SourceType createSourceType();

  /**
   * Returns a new object of class '<em>Tuple Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple Type</em>'.
   * @generated
   */
  TupleType createTupleType();

  /**
   * Returns a new object of class '<em>Types Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Types Type</em>'.
   * @generated
   */
  TypesType createTypesType();

  /**
   * Returns a new object of class '<em>Type Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Type</em>'.
   * @generated
   */
  TypeType createTypeType();

  /**
   * Returns a new object of class '<em>Relation Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relation Type</em>'.
   * @generated
   */
  RelationType createRelationType();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  persistencePackage getpersistencePackage();

} //persistenceFactory
