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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.modelwriter.traceability.core.persistence.persistenceFactory
 * @model kind="package"
 *        extendedMetaData="qualified='false'"
 * @generated
 */
public interface persistencePackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "persistence";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "file:/C:/Users/3/Desktop/eu.modelwriter.traceability.core.persistence/eu.modelwriter.traceability.core.persistence.xsd";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "persistence";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  persistencePackage eINSTANCE = eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl.init();

  /**
   * The meta object id for the '{@link eu.modelwriter.traceability.core.persistence.impl.AlloyTypeImpl <em>Alloy Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.traceability.core.persistence.impl.AlloyTypeImpl
   * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getAlloyType()
   * @generated
   */
  int ALLOY_TYPE = 0;

  /**
   * The feature id for the '<em><b>Instance</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALLOY_TYPE__INSTANCE = 0;

  /**
   * The feature id for the '<em><b>Repository</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALLOY_TYPE__REPOSITORY = 1;

  /**
   * The feature id for the '<em><b>Source</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALLOY_TYPE__SOURCE = 2;

  /**
   * The feature id for the '<em><b>Builddate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALLOY_TYPE__BUILDDATE = 3;

  /**
   * The feature id for the '<em><b>Relation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALLOY_TYPE__RELATION = 4;

  /**
   * The number of structural features of the '<em>Alloy Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALLOY_TYPE_FEATURE_COUNT = 5;

  /**
   * The number of operations of the '<em>Alloy Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALLOY_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.traceability.core.persistence.impl.AtomTypeImpl <em>Atom Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.traceability.core.persistence.impl.AtomTypeImpl
   * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getAtomType()
   * @generated
   */
  int ATOM_TYPE = 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_TYPE__VALUE = 0;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_TYPE__LABEL = 1;

  /**
   * The feature id for the '<em><b>Changed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_TYPE__CHANGED = 2;

  /**
   * The feature id for the '<em><b>Impact</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_TYPE__IMPACT = 3;

  /**
   * The feature id for the '<em><b>Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_TYPE__BOUND = 4;

  /**
   * The number of structural features of the '<em>Atom Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_TYPE_FEATURE_COUNT = 5;

  /**
   * The number of operations of the '<em>Atom Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.traceability.core.persistence.impl.DocumentRootImpl <em>Document Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.traceability.core.persistence.impl.DocumentRootImpl
   * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getDocumentRoot()
   * @generated
   */
  int DOCUMENT_ROOT = 2;

  /**
   * The feature id for the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__MIXED = 0;

  /**
   * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

  /**
   * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

  /**
   * The feature id for the '<em><b>Alloy</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__ALLOY = 3;

  /**
   * The number of structural features of the '<em>Document Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT_FEATURE_COUNT = 4;

  /**
   * The number of operations of the '<em>Document Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.traceability.core.persistence.impl.EntryTypeImpl <em>Entry Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.traceability.core.persistence.impl.EntryTypeImpl
   * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getEntryType()
   * @generated
   */
  int ENTRY_TYPE = 3;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_TYPE__VALUE = 0;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_TYPE__KEY = 1;

  /**
   * The number of structural features of the '<em>Entry Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_TYPE_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Entry Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.traceability.core.persistence.impl.FieldTypeImpl <em>Field Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.traceability.core.persistence.impl.FieldTypeImpl
   * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getFieldType()
   * @generated
   */
  int FIELD_TYPE = 4;

  /**
   * The feature id for the '<em><b>Tuple</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE__TUPLE = 0;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE__TYPES = 1;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE__ID = 2;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE__LABEL = 3;

  /**
   * The feature id for the '<em><b>Parent ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE__PARENT_ID = 4;

  /**
   * The number of structural features of the '<em>Field Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE_FEATURE_COUNT = 5;

  /**
   * The number of operations of the '<em>Field Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.traceability.core.persistence.impl.InstanceTypeImpl <em>Instance Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.traceability.core.persistence.impl.InstanceTypeImpl
   * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getInstanceType()
   * @generated
   */
  int INSTANCE_TYPE = 5;

  /**
   * The feature id for the '<em><b>Sig</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE__SIG = 0;

  /**
   * The feature id for the '<em><b>Field</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE__FIELD = 1;

  /**
   * The feature id for the '<em><b>Bitwidth</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE__BITWIDTH = 2;

  /**
   * The feature id for the '<em><b>Filename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE__FILENAME = 3;

  /**
   * The feature id for the '<em><b>Maxseq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE__MAXSEQ = 4;

  /**
   * The feature id for the '<em><b>Metamodel</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE__METAMODEL = 5;

  /**
   * The number of structural features of the '<em>Instance Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE_FEATURE_COUNT = 6;

  /**
   * The number of operations of the '<em>Instance Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.traceability.core.persistence.impl.ItemTypeImpl <em>Item Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.traceability.core.persistence.impl.ItemTypeImpl
   * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getItemType()
   * @generated
   */
  int ITEM_TYPE = 6;

  /**
   * The feature id for the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITEM_TYPE__GROUP = 0;

  /**
   * The feature id for the '<em><b>Entry</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITEM_TYPE__ENTRY = 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITEM_TYPE__ID = 2;

  /**
   * The number of structural features of the '<em>Item Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITEM_TYPE_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Item Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITEM_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.traceability.core.persistence.impl.RepositoryTypeImpl <em>Repository Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.traceability.core.persistence.impl.RepositoryTypeImpl
   * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getRepositoryType()
   * @generated
   */
  int REPOSITORY_TYPE = 7;

  /**
   * The feature id for the '<em><b>Item</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPOSITORY_TYPE__ITEM = 0;

  /**
   * The feature id for the '<em><b>Next Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPOSITORY_TYPE__NEXT_ID = 1;

  /**
   * The number of structural features of the '<em>Repository Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPOSITORY_TYPE_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Repository Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPOSITORY_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.traceability.core.persistence.impl.SigTypeImpl <em>Sig Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.traceability.core.persistence.impl.SigTypeImpl
   * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getSigType()
   * @generated
   */
  int SIG_TYPE = 8;

  /**
   * The feature id for the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__MIXED = 0;

  /**
   * The feature id for the '<em><b>Atom</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__ATOM = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__TYPE = 2;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__ABSTRACT = 3;

  /**
   * The feature id for the '<em><b>Builtin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__BUILTIN = 4;

  /**
   * The feature id for the '<em><b>Enum</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__ENUM = 5;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__ID = 6;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__LABEL = 7;

  /**
   * The feature id for the '<em><b>Lone</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__LONE = 8;

  /**
   * The feature id for the '<em><b>Meta</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__META = 9;

  /**
   * The feature id for the '<em><b>One</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__ONE = 10;

  /**
   * The feature id for the '<em><b>Parent ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__PARENT_ID = 11;

  /**
   * The feature id for the '<em><b>Private</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__PRIVATE = 12;

  /**
   * The feature id for the '<em><b>Some</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__SOME = 13;

  /**
   * The feature id for the '<em><b>Subset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__SUBSET = 14;

  /**
   * The feature id for the '<em><b>Subsig</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__SUBSIG = 15;

  /**
   * The number of structural features of the '<em>Sig Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE_FEATURE_COUNT = 16;

  /**
   * The number of operations of the '<em>Sig Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.traceability.core.persistence.impl.SourceTypeImpl <em>Source Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.traceability.core.persistence.impl.SourceTypeImpl
   * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getSourceType()
   * @generated
   */
  int SOURCE_TYPE = 9;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_TYPE__VALUE = 0;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_TYPE__CONTENT = 1;

  /**
   * The feature id for the '<em><b>Filename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_TYPE__FILENAME = 2;

  /**
   * The number of structural features of the '<em>Source Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_TYPE_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Source Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.traceability.core.persistence.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.traceability.core.persistence.impl.TupleTypeImpl
   * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getTupleType()
   * @generated
   */
  int TUPLE_TYPE = 10;

  /**
   * The feature id for the '<em><b>Atom</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE__ATOM = 0;

  /**
   * The feature id for the '<em><b>Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE__BOUND = 1;

  /**
   * The number of structural features of the '<em>Tuple Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Tuple Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.traceability.core.persistence.impl.TypesTypeImpl <em>Types Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.traceability.core.persistence.impl.TypesTypeImpl
   * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getTypesType()
   * @generated
   */
  int TYPES_TYPE = 11;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPES_TYPE__TYPE = 0;

  /**
   * The number of structural features of the '<em>Types Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPES_TYPE_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Types Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPES_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.traceability.core.persistence.impl.TypeTypeImpl <em>Type Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.traceability.core.persistence.impl.TypeTypeImpl
   * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getTypeType()
   * @generated
   */
  int TYPE_TYPE = 12;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_TYPE__VALUE = 0;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_TYPE__ID = 1;

  /**
   * The number of structural features of the '<em>Type Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_TYPE_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Type Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_TYPE_OPERATION_COUNT = 0;


  /**
   * The meta object id for the '{@link eu.modelwriter.traceability.core.persistence.impl.RelationTypeImpl <em>Relation Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.traceability.core.persistence.impl.RelationTypeImpl
   * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getRelationType()
   * @generated
   */
  int RELATION_TYPE = 13;

  /**
   * The feature id for the '<em><b>Tuple</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION_TYPE__TUPLE = 0;

  /**
   * The number of structural features of the '<em>Relation Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION_TYPE_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Relation Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION_TYPE_OPERATION_COUNT = 0;


  /**
   * Returns the meta object for class '{@link eu.modelwriter.traceability.core.persistence.AlloyType <em>Alloy Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alloy Type</em>'.
   * @see eu.modelwriter.traceability.core.persistence.AlloyType
   * @generated
   */
  EClass getAlloyType();

  /**
   * Returns the meta object for the containment reference '{@link eu.modelwriter.traceability.core.persistence.AlloyType#getInstance <em>Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Instance</em>'.
   * @see eu.modelwriter.traceability.core.persistence.AlloyType#getInstance()
   * @see #getAlloyType()
   * @generated
   */
  EReference getAlloyType_Instance();

  /**
   * Returns the meta object for the containment reference '{@link eu.modelwriter.traceability.core.persistence.AlloyType#getRepository <em>Repository</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Repository</em>'.
   * @see eu.modelwriter.traceability.core.persistence.AlloyType#getRepository()
   * @see #getAlloyType()
   * @generated
   */
  EReference getAlloyType_Repository();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.traceability.core.persistence.AlloyType#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Source</em>'.
   * @see eu.modelwriter.traceability.core.persistence.AlloyType#getSource()
   * @see #getAlloyType()
   * @generated
   */
  EReference getAlloyType_Source();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.AlloyType#getBuilddate <em>Builddate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Builddate</em>'.
   * @see eu.modelwriter.traceability.core.persistence.AlloyType#getBuilddate()
   * @see #getAlloyType()
   * @generated
   */
  EAttribute getAlloyType_Builddate();

  /**
   * Returns the meta object for the containment reference '{@link eu.modelwriter.traceability.core.persistence.AlloyType#getRelation <em>Relation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Relation</em>'.
   * @see eu.modelwriter.traceability.core.persistence.AlloyType#getRelation()
   * @see #getAlloyType()
   * @generated
   */
  EReference getAlloyType_Relation();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.traceability.core.persistence.AtomType <em>Atom Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atom Type</em>'.
   * @see eu.modelwriter.traceability.core.persistence.AtomType
   * @generated
   */
  EClass getAtomType();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.AtomType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see eu.modelwriter.traceability.core.persistence.AtomType#getValue()
   * @see #getAtomType()
   * @generated
   */
  EAttribute getAtomType_Value();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.AtomType#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see eu.modelwriter.traceability.core.persistence.AtomType#getLabel()
   * @see #getAtomType()
   * @generated
   */
  EAttribute getAtomType_Label();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.AtomType#getChanged <em>Changed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Changed</em>'.
   * @see eu.modelwriter.traceability.core.persistence.AtomType#getChanged()
   * @see #getAtomType()
   * @generated
   */
  EAttribute getAtomType_Changed();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.AtomType#getImpact <em>Impact</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Impact</em>'.
   * @see eu.modelwriter.traceability.core.persistence.AtomType#getImpact()
   * @see #getAtomType()
   * @generated
   */
  EAttribute getAtomType_Impact();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.AtomType#getBound <em>Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bound</em>'.
   * @see eu.modelwriter.traceability.core.persistence.AtomType#getBound()
   * @see #getAtomType()
   * @generated
   */
  EAttribute getAtomType_Bound();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.traceability.core.persistence.DocumentRoot <em>Document Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Document Root</em>'.
   * @see eu.modelwriter.traceability.core.persistence.DocumentRoot
   * @generated
   */
  EClass getDocumentRoot();

  /**
   * Returns the meta object for the attribute list '{@link eu.modelwriter.traceability.core.persistence.DocumentRoot#getMixed <em>Mixed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Mixed</em>'.
   * @see eu.modelwriter.traceability.core.persistence.DocumentRoot#getMixed()
   * @see #getDocumentRoot()
   * @generated
   */
  EAttribute getDocumentRoot_Mixed();

  /**
   * Returns the meta object for the map '{@link eu.modelwriter.traceability.core.persistence.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
   * @see eu.modelwriter.traceability.core.persistence.DocumentRoot#getXMLNSPrefixMap()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_XMLNSPrefixMap();

  /**
   * Returns the meta object for the map '{@link eu.modelwriter.traceability.core.persistence.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>XSI Schema Location</em>'.
   * @see eu.modelwriter.traceability.core.persistence.DocumentRoot#getXSISchemaLocation()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_XSISchemaLocation();

  /**
   * Returns the meta object for the containment reference '{@link eu.modelwriter.traceability.core.persistence.DocumentRoot#getAlloy <em>Alloy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Alloy</em>'.
   * @see eu.modelwriter.traceability.core.persistence.DocumentRoot#getAlloy()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_Alloy();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.traceability.core.persistence.EntryType <em>Entry Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entry Type</em>'.
   * @see eu.modelwriter.traceability.core.persistence.EntryType
   * @generated
   */
  EClass getEntryType();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.EntryType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see eu.modelwriter.traceability.core.persistence.EntryType#getValue()
   * @see #getEntryType()
   * @generated
   */
  EAttribute getEntryType_Value();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.EntryType#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see eu.modelwriter.traceability.core.persistence.EntryType#getKey()
   * @see #getEntryType()
   * @generated
   */
  EAttribute getEntryType_Key();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.traceability.core.persistence.FieldType <em>Field Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field Type</em>'.
   * @see eu.modelwriter.traceability.core.persistence.FieldType
   * @generated
   */
  EClass getFieldType();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.traceability.core.persistence.FieldType#getTuple <em>Tuple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tuple</em>'.
   * @see eu.modelwriter.traceability.core.persistence.FieldType#getTuple()
   * @see #getFieldType()
   * @generated
   */
  EReference getFieldType_Tuple();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.traceability.core.persistence.FieldType#getTypes <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Types</em>'.
   * @see eu.modelwriter.traceability.core.persistence.FieldType#getTypes()
   * @see #getFieldType()
   * @generated
   */
  EReference getFieldType_Types();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.FieldType#getID <em>ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>ID</em>'.
   * @see eu.modelwriter.traceability.core.persistence.FieldType#getID()
   * @see #getFieldType()
   * @generated
   */
  EAttribute getFieldType_ID();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.FieldType#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see eu.modelwriter.traceability.core.persistence.FieldType#getLabel()
   * @see #getFieldType()
   * @generated
   */
  EAttribute getFieldType_Label();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.FieldType#getParentID <em>Parent ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Parent ID</em>'.
   * @see eu.modelwriter.traceability.core.persistence.FieldType#getParentID()
   * @see #getFieldType()
   * @generated
   */
  EAttribute getFieldType_ParentID();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.traceability.core.persistence.InstanceType <em>Instance Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instance Type</em>'.
   * @see eu.modelwriter.traceability.core.persistence.InstanceType
   * @generated
   */
  EClass getInstanceType();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.traceability.core.persistence.InstanceType#getSig <em>Sig</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sig</em>'.
   * @see eu.modelwriter.traceability.core.persistence.InstanceType#getSig()
   * @see #getInstanceType()
   * @generated
   */
  EReference getInstanceType_Sig();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.traceability.core.persistence.InstanceType#getField <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Field</em>'.
   * @see eu.modelwriter.traceability.core.persistence.InstanceType#getField()
   * @see #getInstanceType()
   * @generated
   */
  EReference getInstanceType_Field();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.InstanceType#getBitwidth <em>Bitwidth</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bitwidth</em>'.
   * @see eu.modelwriter.traceability.core.persistence.InstanceType#getBitwidth()
   * @see #getInstanceType()
   * @generated
   */
  EAttribute getInstanceType_Bitwidth();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.InstanceType#getFilename <em>Filename</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Filename</em>'.
   * @see eu.modelwriter.traceability.core.persistence.InstanceType#getFilename()
   * @see #getInstanceType()
   * @generated
   */
  EAttribute getInstanceType_Filename();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.InstanceType#getMaxseq <em>Maxseq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Maxseq</em>'.
   * @see eu.modelwriter.traceability.core.persistence.InstanceType#getMaxseq()
   * @see #getInstanceType()
   * @generated
   */
  EAttribute getInstanceType_Maxseq();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.InstanceType#getMetamodel <em>Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Metamodel</em>'.
   * @see eu.modelwriter.traceability.core.persistence.InstanceType#getMetamodel()
   * @see #getInstanceType()
   * @generated
   */
  EAttribute getInstanceType_Metamodel();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.traceability.core.persistence.ItemType <em>Item Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Item Type</em>'.
   * @see eu.modelwriter.traceability.core.persistence.ItemType
   * @generated
   */
  EClass getItemType();

  /**
   * Returns the meta object for the attribute list '{@link eu.modelwriter.traceability.core.persistence.ItemType#getGroup <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Group</em>'.
   * @see eu.modelwriter.traceability.core.persistence.ItemType#getGroup()
   * @see #getItemType()
   * @generated
   */
  EAttribute getItemType_Group();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.traceability.core.persistence.ItemType#getEntry <em>Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entry</em>'.
   * @see eu.modelwriter.traceability.core.persistence.ItemType#getEntry()
   * @see #getItemType()
   * @generated
   */
  EReference getItemType_Entry();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.ItemType#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see eu.modelwriter.traceability.core.persistence.ItemType#getId()
   * @see #getItemType()
   * @generated
   */
  EAttribute getItemType_Id();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.traceability.core.persistence.RepositoryType <em>Repository Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Repository Type</em>'.
   * @see eu.modelwriter.traceability.core.persistence.RepositoryType
   * @generated
   */
  EClass getRepositoryType();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.traceability.core.persistence.RepositoryType#getItem <em>Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Item</em>'.
   * @see eu.modelwriter.traceability.core.persistence.RepositoryType#getItem()
   * @see #getRepositoryType()
   * @generated
   */
  EReference getRepositoryType_Item();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.RepositoryType#getNextId <em>Next Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Next Id</em>'.
   * @see eu.modelwriter.traceability.core.persistence.RepositoryType#getNextId()
   * @see #getRepositoryType()
   * @generated
   */
  EAttribute getRepositoryType_NextId();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.traceability.core.persistence.SigType <em>Sig Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sig Type</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType
   * @generated
   */
  EClass getSigType();

  /**
   * Returns the meta object for the attribute list '{@link eu.modelwriter.traceability.core.persistence.SigType#getMixed <em>Mixed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Mixed</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType#getMixed()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Mixed();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.traceability.core.persistence.SigType#getAtom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Atom</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType#getAtom()
   * @see #getSigType()
   * @generated
   */
  EReference getSigType_Atom();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.traceability.core.persistence.SigType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType#getType()
   * @see #getSigType()
   * @generated
   */
  EReference getSigType_Type();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.SigType#getAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType#getAbstract()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Abstract();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.SigType#getBuiltin <em>Builtin</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Builtin</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType#getBuiltin()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Builtin();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.SigType#getEnum <em>Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Enum</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType#getEnum()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Enum();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.SigType#getID <em>ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>ID</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType#getID()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_ID();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.SigType#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType#getLabel()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Label();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.SigType#getLone <em>Lone</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lone</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType#getLone()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Lone();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.SigType#getMeta <em>Meta</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Meta</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType#getMeta()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Meta();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.SigType#getOne <em>One</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>One</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType#getOne()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_One();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.SigType#getParentID <em>Parent ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Parent ID</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType#getParentID()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_ParentID();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.SigType#getPrivate <em>Private</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Private</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType#getPrivate()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Private();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.SigType#getSome <em>Some</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Some</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType#getSome()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Some();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.SigType#getSubset <em>Subset</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Subset</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType#getSubset()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Subset();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.SigType#getSubsig <em>Subsig</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Subsig</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SigType#getSubsig()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Subsig();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.traceability.core.persistence.SourceType <em>Source Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Source Type</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SourceType
   * @generated
   */
  EClass getSourceType();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.SourceType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SourceType#getValue()
   * @see #getSourceType()
   * @generated
   */
  EAttribute getSourceType_Value();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.SourceType#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Content</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SourceType#getContent()
   * @see #getSourceType()
   * @generated
   */
  EAttribute getSourceType_Content();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.SourceType#getFilename <em>Filename</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Filename</em>'.
   * @see eu.modelwriter.traceability.core.persistence.SourceType#getFilename()
   * @see #getSourceType()
   * @generated
   */
  EAttribute getSourceType_Filename();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.traceability.core.persistence.TupleType <em>Tuple Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Type</em>'.
   * @see eu.modelwriter.traceability.core.persistence.TupleType
   * @generated
   */
  EClass getTupleType();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.traceability.core.persistence.TupleType#getAtom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Atom</em>'.
   * @see eu.modelwriter.traceability.core.persistence.TupleType#getAtom()
   * @see #getTupleType()
   * @generated
   */
  EReference getTupleType_Atom();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.TupleType#getBound <em>Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bound</em>'.
   * @see eu.modelwriter.traceability.core.persistence.TupleType#getBound()
   * @see #getTupleType()
   * @generated
   */
  EAttribute getTupleType_Bound();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.traceability.core.persistence.TypesType <em>Types Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Types Type</em>'.
   * @see eu.modelwriter.traceability.core.persistence.TypesType
   * @generated
   */
  EClass getTypesType();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.traceability.core.persistence.TypesType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type</em>'.
   * @see eu.modelwriter.traceability.core.persistence.TypesType#getType()
   * @see #getTypesType()
   * @generated
   */
  EReference getTypesType_Type();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.traceability.core.persistence.TypeType <em>Type Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Type</em>'.
   * @see eu.modelwriter.traceability.core.persistence.TypeType
   * @generated
   */
  EClass getTypeType();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.TypeType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see eu.modelwriter.traceability.core.persistence.TypeType#getValue()
   * @see #getTypeType()
   * @generated
   */
  EAttribute getTypeType_Value();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.traceability.core.persistence.TypeType#getID <em>ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>ID</em>'.
   * @see eu.modelwriter.traceability.core.persistence.TypeType#getID()
   * @see #getTypeType()
   * @generated
   */
  EAttribute getTypeType_ID();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.traceability.core.persistence.RelationType <em>Relation Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relation Type</em>'.
   * @see eu.modelwriter.traceability.core.persistence.RelationType
   * @generated
   */
  EClass getRelationType();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.traceability.core.persistence.RelationType#getTuple <em>Tuple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tuple</em>'.
   * @see eu.modelwriter.traceability.core.persistence.RelationType#getTuple()
   * @see #getRelationType()
   * @generated
   */
  EReference getRelationType_Tuple();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  persistenceFactory getpersistenceFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link eu.modelwriter.traceability.core.persistence.impl.AlloyTypeImpl <em>Alloy Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.traceability.core.persistence.impl.AlloyTypeImpl
     * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getAlloyType()
     * @generated
     */
    EClass ALLOY_TYPE = eINSTANCE.getAlloyType();

    /**
     * The meta object literal for the '<em><b>Instance</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALLOY_TYPE__INSTANCE = eINSTANCE.getAlloyType_Instance();

    /**
     * The meta object literal for the '<em><b>Repository</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALLOY_TYPE__REPOSITORY = eINSTANCE.getAlloyType_Repository();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALLOY_TYPE__SOURCE = eINSTANCE.getAlloyType_Source();

    /**
     * The meta object literal for the '<em><b>Builddate</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALLOY_TYPE__BUILDDATE = eINSTANCE.getAlloyType_Builddate();

    /**
     * The meta object literal for the '<em><b>Relation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALLOY_TYPE__RELATION = eINSTANCE.getAlloyType_Relation();

    /**
     * The meta object literal for the '{@link eu.modelwriter.traceability.core.persistence.impl.AtomTypeImpl <em>Atom Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.traceability.core.persistence.impl.AtomTypeImpl
     * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getAtomType()
     * @generated
     */
    EClass ATOM_TYPE = eINSTANCE.getAtomType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATOM_TYPE__VALUE = eINSTANCE.getAtomType_Value();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATOM_TYPE__LABEL = eINSTANCE.getAtomType_Label();

    /**
     * The meta object literal for the '<em><b>Changed</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATOM_TYPE__CHANGED = eINSTANCE.getAtomType_Changed();

    /**
     * The meta object literal for the '<em><b>Impact</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATOM_TYPE__IMPACT = eINSTANCE.getAtomType_Impact();

    /**
     * The meta object literal for the '<em><b>Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATOM_TYPE__BOUND = eINSTANCE.getAtomType_Bound();

    /**
     * The meta object literal for the '{@link eu.modelwriter.traceability.core.persistence.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.traceability.core.persistence.impl.DocumentRootImpl
     * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getDocumentRoot()
     * @generated
     */
    EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

    /**
     * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

    /**
     * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

    /**
     * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

    /**
     * The meta object literal for the '<em><b>Alloy</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__ALLOY = eINSTANCE.getDocumentRoot_Alloy();

    /**
     * The meta object literal for the '{@link eu.modelwriter.traceability.core.persistence.impl.EntryTypeImpl <em>Entry Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.traceability.core.persistence.impl.EntryTypeImpl
     * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getEntryType()
     * @generated
     */
    EClass ENTRY_TYPE = eINSTANCE.getEntryType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTRY_TYPE__VALUE = eINSTANCE.getEntryType_Value();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTRY_TYPE__KEY = eINSTANCE.getEntryType_Key();

    /**
     * The meta object literal for the '{@link eu.modelwriter.traceability.core.persistence.impl.FieldTypeImpl <em>Field Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.traceability.core.persistence.impl.FieldTypeImpl
     * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getFieldType()
     * @generated
     */
    EClass FIELD_TYPE = eINSTANCE.getFieldType();

    /**
     * The meta object literal for the '<em><b>Tuple</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD_TYPE__TUPLE = eINSTANCE.getFieldType_Tuple();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD_TYPE__TYPES = eINSTANCE.getFieldType_Types();

    /**
     * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD_TYPE__ID = eINSTANCE.getFieldType_ID();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD_TYPE__LABEL = eINSTANCE.getFieldType_Label();

    /**
     * The meta object literal for the '<em><b>Parent ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD_TYPE__PARENT_ID = eINSTANCE.getFieldType_ParentID();

    /**
     * The meta object literal for the '{@link eu.modelwriter.traceability.core.persistence.impl.InstanceTypeImpl <em>Instance Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.traceability.core.persistence.impl.InstanceTypeImpl
     * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getInstanceType()
     * @generated
     */
    EClass INSTANCE_TYPE = eINSTANCE.getInstanceType();

    /**
     * The meta object literal for the '<em><b>Sig</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANCE_TYPE__SIG = eINSTANCE.getInstanceType_Sig();

    /**
     * The meta object literal for the '<em><b>Field</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANCE_TYPE__FIELD = eINSTANCE.getInstanceType_Field();

    /**
     * The meta object literal for the '<em><b>Bitwidth</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTANCE_TYPE__BITWIDTH = eINSTANCE.getInstanceType_Bitwidth();

    /**
     * The meta object literal for the '<em><b>Filename</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTANCE_TYPE__FILENAME = eINSTANCE.getInstanceType_Filename();

    /**
     * The meta object literal for the '<em><b>Maxseq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTANCE_TYPE__MAXSEQ = eINSTANCE.getInstanceType_Maxseq();

    /**
     * The meta object literal for the '<em><b>Metamodel</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTANCE_TYPE__METAMODEL = eINSTANCE.getInstanceType_Metamodel();

    /**
     * The meta object literal for the '{@link eu.modelwriter.traceability.core.persistence.impl.ItemTypeImpl <em>Item Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.traceability.core.persistence.impl.ItemTypeImpl
     * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getItemType()
     * @generated
     */
    EClass ITEM_TYPE = eINSTANCE.getItemType();

    /**
     * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ITEM_TYPE__GROUP = eINSTANCE.getItemType_Group();

    /**
     * The meta object literal for the '<em><b>Entry</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ITEM_TYPE__ENTRY = eINSTANCE.getItemType_Entry();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ITEM_TYPE__ID = eINSTANCE.getItemType_Id();

    /**
     * The meta object literal for the '{@link eu.modelwriter.traceability.core.persistence.impl.RepositoryTypeImpl <em>Repository Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.traceability.core.persistence.impl.RepositoryTypeImpl
     * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getRepositoryType()
     * @generated
     */
    EClass REPOSITORY_TYPE = eINSTANCE.getRepositoryType();

    /**
     * The meta object literal for the '<em><b>Item</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REPOSITORY_TYPE__ITEM = eINSTANCE.getRepositoryType_Item();

    /**
     * The meta object literal for the '<em><b>Next Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REPOSITORY_TYPE__NEXT_ID = eINSTANCE.getRepositoryType_NextId();

    /**
     * The meta object literal for the '{@link eu.modelwriter.traceability.core.persistence.impl.SigTypeImpl <em>Sig Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.traceability.core.persistence.impl.SigTypeImpl
     * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getSigType()
     * @generated
     */
    EClass SIG_TYPE = eINSTANCE.getSigType();

    /**
     * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIG_TYPE__MIXED = eINSTANCE.getSigType_Mixed();

    /**
     * The meta object literal for the '<em><b>Atom</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIG_TYPE__ATOM = eINSTANCE.getSigType_Atom();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIG_TYPE__TYPE = eINSTANCE.getSigType_Type();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIG_TYPE__ABSTRACT = eINSTANCE.getSigType_Abstract();

    /**
     * The meta object literal for the '<em><b>Builtin</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIG_TYPE__BUILTIN = eINSTANCE.getSigType_Builtin();

    /**
     * The meta object literal for the '<em><b>Enum</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIG_TYPE__ENUM = eINSTANCE.getSigType_Enum();

    /**
     * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIG_TYPE__ID = eINSTANCE.getSigType_ID();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIG_TYPE__LABEL = eINSTANCE.getSigType_Label();

    /**
     * The meta object literal for the '<em><b>Lone</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIG_TYPE__LONE = eINSTANCE.getSigType_Lone();

    /**
     * The meta object literal for the '<em><b>Meta</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIG_TYPE__META = eINSTANCE.getSigType_Meta();

    /**
     * The meta object literal for the '<em><b>One</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIG_TYPE__ONE = eINSTANCE.getSigType_One();

    /**
     * The meta object literal for the '<em><b>Parent ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIG_TYPE__PARENT_ID = eINSTANCE.getSigType_ParentID();

    /**
     * The meta object literal for the '<em><b>Private</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIG_TYPE__PRIVATE = eINSTANCE.getSigType_Private();

    /**
     * The meta object literal for the '<em><b>Some</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIG_TYPE__SOME = eINSTANCE.getSigType_Some();

    /**
     * The meta object literal for the '<em><b>Subset</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIG_TYPE__SUBSET = eINSTANCE.getSigType_Subset();

    /**
     * The meta object literal for the '<em><b>Subsig</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIG_TYPE__SUBSIG = eINSTANCE.getSigType_Subsig();

    /**
     * The meta object literal for the '{@link eu.modelwriter.traceability.core.persistence.impl.SourceTypeImpl <em>Source Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.traceability.core.persistence.impl.SourceTypeImpl
     * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getSourceType()
     * @generated
     */
    EClass SOURCE_TYPE = eINSTANCE.getSourceType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOURCE_TYPE__VALUE = eINSTANCE.getSourceType_Value();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOURCE_TYPE__CONTENT = eINSTANCE.getSourceType_Content();

    /**
     * The meta object literal for the '<em><b>Filename</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOURCE_TYPE__FILENAME = eINSTANCE.getSourceType_Filename();

    /**
     * The meta object literal for the '{@link eu.modelwriter.traceability.core.persistence.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.traceability.core.persistence.impl.TupleTypeImpl
     * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getTupleType()
     * @generated
     */
    EClass TUPLE_TYPE = eINSTANCE.getTupleType();

    /**
     * The meta object literal for the '<em><b>Atom</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_TYPE__ATOM = eINSTANCE.getTupleType_Atom();

    /**
     * The meta object literal for the '<em><b>Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TUPLE_TYPE__BOUND = eINSTANCE.getTupleType_Bound();

    /**
     * The meta object literal for the '{@link eu.modelwriter.traceability.core.persistence.impl.TypesTypeImpl <em>Types Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.traceability.core.persistence.impl.TypesTypeImpl
     * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getTypesType()
     * @generated
     */
    EClass TYPES_TYPE = eINSTANCE.getTypesType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPES_TYPE__TYPE = eINSTANCE.getTypesType_Type();

    /**
     * The meta object literal for the '{@link eu.modelwriter.traceability.core.persistence.impl.TypeTypeImpl <em>Type Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.traceability.core.persistence.impl.TypeTypeImpl
     * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getTypeType()
     * @generated
     */
    EClass TYPE_TYPE = eINSTANCE.getTypeType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_TYPE__VALUE = eINSTANCE.getTypeType_Value();

    /**
     * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_TYPE__ID = eINSTANCE.getTypeType_ID();

    /**
     * The meta object literal for the '{@link eu.modelwriter.traceability.core.persistence.impl.RelationTypeImpl <em>Relation Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.traceability.core.persistence.impl.RelationTypeImpl
     * @see eu.modelwriter.traceability.core.persistence.impl.persistencePackageImpl#getRelationType()
     * @generated
     */
    EClass RELATION_TYPE = eINSTANCE.getRelationType();

    /**
     * The meta object literal for the '<em><b>Tuple</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATION_TYPE__TUPLE = eINSTANCE.getRelationType_Tuple();

  }

} //persistencePackage
