/**
 */
package eu.modelwriter.alloyxmlapi;

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
 * @see eu.modelwriter.alloyxmlapi.AlloyXSDFileFactory
 * @model kind="package"
 *        extendedMetaData="qualified='false'"
 * @generated
 */
public interface AlloyXSDFilePackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "AlloyXSDFile";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "file:/C:/Users/3/Desktop/Bilgi/AlloyXSDFile.xsd";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "AlloyXSDFile";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AlloyXSDFilePackage eINSTANCE = eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl.init();

  /**
   * The meta object id for the '{@link eu.modelwriter.alloyxmlapi.impl.AlloyTypeImpl <em>Alloy Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.alloyxmlapi.impl.AlloyTypeImpl
   * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getAlloyType()
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
   * The feature id for the '<em><b>Builddate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALLOY_TYPE__BUILDDATE = 1;

  /**
   * The number of structural features of the '<em>Alloy Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALLOY_TYPE_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Alloy Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALLOY_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.alloyxmlapi.impl.AtomTypeImpl <em>Atom Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.alloyxmlapi.impl.AtomTypeImpl
   * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getAtomType()
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
   * The feature id for the '<em><b>Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_TYPE__LOCATION = 2;

  /**
   * The number of structural features of the '<em>Atom Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_TYPE_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Atom Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.alloyxmlapi.impl.DocumentRootImpl <em>Document Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.alloyxmlapi.impl.DocumentRootImpl
   * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getDocumentRoot()
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
   * The meta object id for the '{@link eu.modelwriter.alloyxmlapi.impl.FieldTypeImpl <em>Field Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.alloyxmlapi.impl.FieldTypeImpl
   * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getFieldType()
   * @generated
   */
  int FIELD_TYPE = 3;

  /**
   * The feature id for the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE__MIXED = 0;

  /**
   * The feature id for the '<em><b>Tuple</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE__TUPLE = 1;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE__TYPES = 2;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE__ID = 3;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE__LABEL = 4;

  /**
   * The feature id for the '<em><b>Parent ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE__PARENT_ID = 5;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE__EXPRESSION = 6;

  /**
   * The number of structural features of the '<em>Field Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE_FEATURE_COUNT = 7;

  /**
   * The number of operations of the '<em>Field Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.alloyxmlapi.impl.InstanceTypeImpl <em>Instance Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.alloyxmlapi.impl.InstanceTypeImpl
   * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getInstanceType()
   * @generated
   */
  int INSTANCE_TYPE = 4;

  /**
   * The feature id for the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE__GROUP = 0;

  /**
   * The feature id for the '<em><b>Sig</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE__SIG = 1;

  /**
   * The feature id for the '<em><b>Field</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE__FIELD = 2;

  /**
   * The feature id for the '<em><b>Bitwidth</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE__BITWIDTH = 3;

  /**
   * The feature id for the '<em><b>Command</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE__COMMAND = 4;

  /**
   * The feature id for the '<em><b>Filename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE__FILENAME = 5;

  /**
   * The feature id for the '<em><b>Maxseq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE__MAXSEQ = 6;

  /**
   * The number of structural features of the '<em>Instance Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE_FEATURE_COUNT = 7;

  /**
   * The number of operations of the '<em>Instance Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.alloyxmlapi.impl.SigTypeImpl <em>Sig Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.alloyxmlapi.impl.SigTypeImpl
   * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getSigType()
   * @generated
   */
  int SIG_TYPE = 5;

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
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__ABSTRACT = 2;

  /**
   * The feature id for the '<em><b>Builtin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__BUILTIN = 3;

  /**
   * The feature id for the '<em><b>Enum</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__ENUM = 4;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__ID = 5;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__LABEL = 6;

  /**
   * The feature id for the '<em><b>Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIG_TYPE__LOCATION = 7;

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
   * The meta object id for the '{@link eu.modelwriter.alloyxmlapi.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.alloyxmlapi.impl.TupleTypeImpl
   * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getTupleType()
   * @generated
   */
  int TUPLE_TYPE = 6;

  /**
   * The feature id for the '<em><b>Atom</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE__ATOM = 0;

  /**
   * The number of structural features of the '<em>Tuple Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Tuple Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.modelwriter.alloyxmlapi.impl.TypesTypeImpl <em>Types Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.alloyxmlapi.impl.TypesTypeImpl
   * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getTypesType()
   * @generated
   */
  int TYPES_TYPE = 7;

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
   * The meta object id for the '{@link eu.modelwriter.alloyxmlapi.impl.TypeTypeImpl <em>Type Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.modelwriter.alloyxmlapi.impl.TypeTypeImpl
   * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getTypeType()
   * @generated
   */
  int TYPE_TYPE = 8;

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
   * Returns the meta object for class '{@link eu.modelwriter.alloyxmlapi.AlloyType <em>Alloy Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alloy Type</em>'.
   * @see eu.modelwriter.alloyxmlapi.AlloyType
   * @generated
   */
  EClass getAlloyType();

  /**
   * Returns the meta object for the containment reference '{@link eu.modelwriter.alloyxmlapi.AlloyType#getInstance <em>Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Instance</em>'.
   * @see eu.modelwriter.alloyxmlapi.AlloyType#getInstance()
   * @see #getAlloyType()
   * @generated
   */
  EReference getAlloyType_Instance();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.AlloyType#getBuilddate <em>Builddate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Builddate</em>'.
   * @see eu.modelwriter.alloyxmlapi.AlloyType#getBuilddate()
   * @see #getAlloyType()
   * @generated
   */
  EAttribute getAlloyType_Builddate();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.alloyxmlapi.AtomType <em>Atom Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atom Type</em>'.
   * @see eu.modelwriter.alloyxmlapi.AtomType
   * @generated
   */
  EClass getAtomType();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.AtomType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see eu.modelwriter.alloyxmlapi.AtomType#getValue()
   * @see #getAtomType()
   * @generated
   */
  EAttribute getAtomType_Value();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.AtomType#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see eu.modelwriter.alloyxmlapi.AtomType#getLabel()
   * @see #getAtomType()
   * @generated
   */
  EAttribute getAtomType_Label();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.AtomType#getLocation <em>Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Location</em>'.
   * @see eu.modelwriter.alloyxmlapi.AtomType#getLocation()
   * @see #getAtomType()
   * @generated
   */
  EAttribute getAtomType_Location();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.alloyxmlapi.DocumentRoot <em>Document Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Document Root</em>'.
   * @see eu.modelwriter.alloyxmlapi.DocumentRoot
   * @generated
   */
  EClass getDocumentRoot();

  /**
   * Returns the meta object for the attribute list '{@link eu.modelwriter.alloyxmlapi.DocumentRoot#getMixed <em>Mixed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Mixed</em>'.
   * @see eu.modelwriter.alloyxmlapi.DocumentRoot#getMixed()
   * @see #getDocumentRoot()
   * @generated
   */
  EAttribute getDocumentRoot_Mixed();

  /**
   * Returns the meta object for the map '{@link eu.modelwriter.alloyxmlapi.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
   * @see eu.modelwriter.alloyxmlapi.DocumentRoot#getXMLNSPrefixMap()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_XMLNSPrefixMap();

  /**
   * Returns the meta object for the map '{@link eu.modelwriter.alloyxmlapi.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>XSI Schema Location</em>'.
   * @see eu.modelwriter.alloyxmlapi.DocumentRoot#getXSISchemaLocation()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_XSISchemaLocation();

  /**
   * Returns the meta object for the containment reference '{@link eu.modelwriter.alloyxmlapi.DocumentRoot#getAlloy <em>Alloy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Alloy</em>'.
   * @see eu.modelwriter.alloyxmlapi.DocumentRoot#getAlloy()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_Alloy();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.alloyxmlapi.FieldType <em>Field Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field Type</em>'.
   * @see eu.modelwriter.alloyxmlapi.FieldType
   * @generated
   */
  EClass getFieldType();

  /**
   * Returns the meta object for the attribute list '{@link eu.modelwriter.alloyxmlapi.FieldType#getMixed <em>Mixed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Mixed</em>'.
   * @see eu.modelwriter.alloyxmlapi.FieldType#getMixed()
   * @see #getFieldType()
   * @generated
   */
  EAttribute getFieldType_Mixed();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.alloyxmlapi.FieldType#getTuple <em>Tuple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tuple</em>'.
   * @see eu.modelwriter.alloyxmlapi.FieldType#getTuple()
   * @see #getFieldType()
   * @generated
   */
  EReference getFieldType_Tuple();

  /**
   * Returns the meta object for the containment reference '{@link eu.modelwriter.alloyxmlapi.FieldType#getTypes <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Types</em>'.
   * @see eu.modelwriter.alloyxmlapi.FieldType#getTypes()
   * @see #getFieldType()
   * @generated
   */
  EReference getFieldType_Types();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.FieldType#getID <em>ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>ID</em>'.
   * @see eu.modelwriter.alloyxmlapi.FieldType#getID()
   * @see #getFieldType()
   * @generated
   */
  EAttribute getFieldType_ID();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.FieldType#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see eu.modelwriter.alloyxmlapi.FieldType#getLabel()
   * @see #getFieldType()
   * @generated
   */
  EAttribute getFieldType_Label();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.FieldType#getParentID <em>Parent ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Parent ID</em>'.
   * @see eu.modelwriter.alloyxmlapi.FieldType#getParentID()
   * @see #getFieldType()
   * @generated
   */
  EAttribute getFieldType_ParentID();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.FieldType#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression</em>'.
   * @see eu.modelwriter.alloyxmlapi.FieldType#getExpression()
   * @see #getFieldType()
   * @generated
   */
  EAttribute getFieldType_Expression();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.alloyxmlapi.InstanceType <em>Instance Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instance Type</em>'.
   * @see eu.modelwriter.alloyxmlapi.InstanceType
   * @generated
   */
  EClass getInstanceType();

  /**
   * Returns the meta object for the attribute list '{@link eu.modelwriter.alloyxmlapi.InstanceType#getGroup <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Group</em>'.
   * @see eu.modelwriter.alloyxmlapi.InstanceType#getGroup()
   * @see #getInstanceType()
   * @generated
   */
  EAttribute getInstanceType_Group();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.alloyxmlapi.InstanceType#getSig <em>Sig</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sig</em>'.
   * @see eu.modelwriter.alloyxmlapi.InstanceType#getSig()
   * @see #getInstanceType()
   * @generated
   */
  EReference getInstanceType_Sig();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.alloyxmlapi.InstanceType#getField <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Field</em>'.
   * @see eu.modelwriter.alloyxmlapi.InstanceType#getField()
   * @see #getInstanceType()
   * @generated
   */
  EReference getInstanceType_Field();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.InstanceType#getBitwidth <em>Bitwidth</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bitwidth</em>'.
   * @see eu.modelwriter.alloyxmlapi.InstanceType#getBitwidth()
   * @see #getInstanceType()
   * @generated
   */
  EAttribute getInstanceType_Bitwidth();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.InstanceType#getCommand <em>Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Command</em>'.
   * @see eu.modelwriter.alloyxmlapi.InstanceType#getCommand()
   * @see #getInstanceType()
   * @generated
   */
  EAttribute getInstanceType_Command();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.InstanceType#getFilename <em>Filename</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Filename</em>'.
   * @see eu.modelwriter.alloyxmlapi.InstanceType#getFilename()
   * @see #getInstanceType()
   * @generated
   */
  EAttribute getInstanceType_Filename();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.InstanceType#getMaxseq <em>Maxseq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Maxseq</em>'.
   * @see eu.modelwriter.alloyxmlapi.InstanceType#getMaxseq()
   * @see #getInstanceType()
   * @generated
   */
  EAttribute getInstanceType_Maxseq();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.alloyxmlapi.SigType <em>Sig Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sig Type</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType
   * @generated
   */
  EClass getSigType();

  /**
   * Returns the meta object for the attribute list '{@link eu.modelwriter.alloyxmlapi.SigType#getMixed <em>Mixed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Mixed</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType#getMixed()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Mixed();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.alloyxmlapi.SigType#getAtom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Atom</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType#getAtom()
   * @see #getSigType()
   * @generated
   */
  EReference getSigType_Atom();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.SigType#getAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType#getAbstract()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Abstract();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.SigType#getBuiltin <em>Builtin</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Builtin</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType#getBuiltin()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Builtin();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.SigType#getEnum <em>Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Enum</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType#getEnum()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Enum();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.SigType#getID <em>ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>ID</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType#getID()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_ID();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.SigType#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType#getLabel()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Label();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.SigType#getLocation <em>Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Location</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType#getLocation()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Location();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.SigType#getLone <em>Lone</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lone</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType#getLone()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Lone();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.SigType#getMeta <em>Meta</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Meta</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType#getMeta()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Meta();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.SigType#getOne <em>One</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>One</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType#getOne()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_One();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.SigType#getParentID <em>Parent ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Parent ID</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType#getParentID()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_ParentID();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.SigType#getPrivate <em>Private</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Private</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType#getPrivate()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Private();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.SigType#getSome <em>Some</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Some</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType#getSome()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Some();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.SigType#getSubset <em>Subset</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Subset</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType#getSubset()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Subset();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.SigType#getSubsig <em>Subsig</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Subsig</em>'.
   * @see eu.modelwriter.alloyxmlapi.SigType#getSubsig()
   * @see #getSigType()
   * @generated
   */
  EAttribute getSigType_Subsig();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.alloyxmlapi.TupleType <em>Tuple Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Type</em>'.
   * @see eu.modelwriter.alloyxmlapi.TupleType
   * @generated
   */
  EClass getTupleType();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.alloyxmlapi.TupleType#getAtom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Atom</em>'.
   * @see eu.modelwriter.alloyxmlapi.TupleType#getAtom()
   * @see #getTupleType()
   * @generated
   */
  EReference getTupleType_Atom();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.alloyxmlapi.TypesType <em>Types Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Types Type</em>'.
   * @see eu.modelwriter.alloyxmlapi.TypesType
   * @generated
   */
  EClass getTypesType();

  /**
   * Returns the meta object for the containment reference list '{@link eu.modelwriter.alloyxmlapi.TypesType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type</em>'.
   * @see eu.modelwriter.alloyxmlapi.TypesType#getType()
   * @see #getTypesType()
   * @generated
   */
  EReference getTypesType_Type();

  /**
   * Returns the meta object for class '{@link eu.modelwriter.alloyxmlapi.TypeType <em>Type Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Type</em>'.
   * @see eu.modelwriter.alloyxmlapi.TypeType
   * @generated
   */
  EClass getTypeType();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.TypeType#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see eu.modelwriter.alloyxmlapi.TypeType#getValue()
   * @see #getTypeType()
   * @generated
   */
  EAttribute getTypeType_Value();

  /**
   * Returns the meta object for the attribute '{@link eu.modelwriter.alloyxmlapi.TypeType#getID <em>ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>ID</em>'.
   * @see eu.modelwriter.alloyxmlapi.TypeType#getID()
   * @see #getTypeType()
   * @generated
   */
  EAttribute getTypeType_ID();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  AlloyXSDFileFactory getAlloyXSDFileFactory();

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
     * The meta object literal for the '{@link eu.modelwriter.alloyxmlapi.impl.AlloyTypeImpl <em>Alloy Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.alloyxmlapi.impl.AlloyTypeImpl
     * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getAlloyType()
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
     * The meta object literal for the '<em><b>Builddate</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALLOY_TYPE__BUILDDATE = eINSTANCE.getAlloyType_Builddate();

    /**
     * The meta object literal for the '{@link eu.modelwriter.alloyxmlapi.impl.AtomTypeImpl <em>Atom Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.alloyxmlapi.impl.AtomTypeImpl
     * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getAtomType()
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
     * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATOM_TYPE__LOCATION = eINSTANCE.getAtomType_Location();

    /**
     * The meta object literal for the '{@link eu.modelwriter.alloyxmlapi.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.alloyxmlapi.impl.DocumentRootImpl
     * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getDocumentRoot()
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
     * The meta object literal for the '{@link eu.modelwriter.alloyxmlapi.impl.FieldTypeImpl <em>Field Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.alloyxmlapi.impl.FieldTypeImpl
     * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getFieldType()
     * @generated
     */
    EClass FIELD_TYPE = eINSTANCE.getFieldType();

    /**
     * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD_TYPE__MIXED = eINSTANCE.getFieldType_Mixed();

    /**
     * The meta object literal for the '<em><b>Tuple</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD_TYPE__TUPLE = eINSTANCE.getFieldType_Tuple();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference feature.
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
     * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD_TYPE__EXPRESSION = eINSTANCE.getFieldType_Expression();

    /**
     * The meta object literal for the '{@link eu.modelwriter.alloyxmlapi.impl.InstanceTypeImpl <em>Instance Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.alloyxmlapi.impl.InstanceTypeImpl
     * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getInstanceType()
     * @generated
     */
    EClass INSTANCE_TYPE = eINSTANCE.getInstanceType();

    /**
     * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTANCE_TYPE__GROUP = eINSTANCE.getInstanceType_Group();

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
     * The meta object literal for the '<em><b>Command</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTANCE_TYPE__COMMAND = eINSTANCE.getInstanceType_Command();

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
     * The meta object literal for the '{@link eu.modelwriter.alloyxmlapi.impl.SigTypeImpl <em>Sig Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.alloyxmlapi.impl.SigTypeImpl
     * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getSigType()
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
     * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIG_TYPE__LOCATION = eINSTANCE.getSigType_Location();

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
     * The meta object literal for the '{@link eu.modelwriter.alloyxmlapi.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.alloyxmlapi.impl.TupleTypeImpl
     * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getTupleType()
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
     * The meta object literal for the '{@link eu.modelwriter.alloyxmlapi.impl.TypesTypeImpl <em>Types Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.alloyxmlapi.impl.TypesTypeImpl
     * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getTypesType()
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
     * The meta object literal for the '{@link eu.modelwriter.alloyxmlapi.impl.TypeTypeImpl <em>Type Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.modelwriter.alloyxmlapi.impl.TypeTypeImpl
     * @see eu.modelwriter.alloyxmlapi.impl.AlloyXSDFilePackageImpl#getTypeType()
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

  }

} //AlloyXSDFilePackage
