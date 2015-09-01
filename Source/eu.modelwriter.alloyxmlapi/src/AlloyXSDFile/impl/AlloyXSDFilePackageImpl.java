/**
 */
package AlloyXSDFile.impl;

import AlloyXSDFile.AlloyType;
import AlloyXSDFile.AlloyXSDFileFactory;
import AlloyXSDFile.AlloyXSDFilePackage;
import AlloyXSDFile.AtomType;
import AlloyXSDFile.DocumentRoot;
import AlloyXSDFile.FieldType;
import AlloyXSDFile.InstanceType;
import AlloyXSDFile.SigType;
import AlloyXSDFile.TupleType;
import AlloyXSDFile.TypeType;
import AlloyXSDFile.TypesType;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlloyXSDFilePackageImpl extends EPackageImpl implements AlloyXSDFilePackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass alloyTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass atomTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass documentRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fieldTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass instanceTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sigTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tupleTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typesTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeTypeEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see AlloyXSDFile.AlloyXSDFilePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private AlloyXSDFilePackageImpl() {
    super(eNS_URI, AlloyXSDFileFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link AlloyXSDFilePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static AlloyXSDFilePackage init() {
    if (isInited) return (AlloyXSDFilePackage)EPackage.Registry.INSTANCE.getEPackage(AlloyXSDFilePackage.eNS_URI);

    // Obtain or create and register package
    AlloyXSDFilePackageImpl theAlloyXSDFilePackage = (AlloyXSDFilePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AlloyXSDFilePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AlloyXSDFilePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XMLTypePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theAlloyXSDFilePackage.createPackageContents();

    // Initialize created meta-data
    theAlloyXSDFilePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theAlloyXSDFilePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(AlloyXSDFilePackage.eNS_URI, theAlloyXSDFilePackage);
    return theAlloyXSDFilePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAlloyType() {
    return alloyTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAlloyType_Instance() {
    return (EReference)alloyTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAlloyType_Builddate() {
    return (EAttribute)alloyTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAtomType() {
    return atomTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAtomType_Value() {
    return (EAttribute)atomTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAtomType_Label() {
    return (EAttribute)atomTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAtomType_Location() {
    return (EAttribute)atomTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDocumentRoot() {
    return documentRootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDocumentRoot_Mixed() {
    return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentRoot_XMLNSPrefixMap() {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentRoot_XSISchemaLocation() {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentRoot_Alloy() {
    return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFieldType() {
    return fieldTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFieldType_Mixed() {
    return (EAttribute)fieldTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFieldType_Tuple() {
    return (EReference)fieldTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFieldType_Types() {
    return (EReference)fieldTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFieldType_ID() {
    return (EAttribute)fieldTypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFieldType_Label() {
    return (EAttribute)fieldTypeEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFieldType_ParentID() {
    return (EAttribute)fieldTypeEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFieldType_Expression() {
    return (EAttribute)fieldTypeEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInstanceType() {
    return instanceTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInstanceType_Group() {
    return (EAttribute)instanceTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceType_Sig() {
    return (EReference)instanceTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstanceType_Field() {
    return (EReference)instanceTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInstanceType_Bitwidth() {
    return (EAttribute)instanceTypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInstanceType_Command() {
    return (EAttribute)instanceTypeEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInstanceType_Filename() {
    return (EAttribute)instanceTypeEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInstanceType_Maxseq() {
    return (EAttribute)instanceTypeEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSigType() {
    return sigTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigType_Mixed() {
    return (EAttribute)sigTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSigType_Atom() {
    return (EReference)sigTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigType_Abstract() {
    return (EAttribute)sigTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigType_Builtin() {
    return (EAttribute)sigTypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigType_Enum() {
    return (EAttribute)sigTypeEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigType_ID() {
    return (EAttribute)sigTypeEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigType_Label() {
    return (EAttribute)sigTypeEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigType_Location() {
    return (EAttribute)sigTypeEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigType_Lone() {
    return (EAttribute)sigTypeEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigType_Meta() {
    return (EAttribute)sigTypeEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigType_One() {
    return (EAttribute)sigTypeEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigType_ParentID() {
    return (EAttribute)sigTypeEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigType_Private() {
    return (EAttribute)sigTypeEClass.getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigType_Some() {
    return (EAttribute)sigTypeEClass.getEStructuralFeatures().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigType_Subset() {
    return (EAttribute)sigTypeEClass.getEStructuralFeatures().get(14);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSigType_Subsig() {
    return (EAttribute)sigTypeEClass.getEStructuralFeatures().get(15);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTupleType() {
    return tupleTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTupleType_Atom() {
    return (EReference)tupleTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypesType() {
    return typesTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypesType_Type() {
    return (EReference)typesTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeType() {
    return typeTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeType_Value() {
    return (EAttribute)typeTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeType_ID() {
    return (EAttribute)typeTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlloyXSDFileFactory getAlloyXSDFileFactory() {
    return (AlloyXSDFileFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    alloyTypeEClass = createEClass(ALLOY_TYPE);
    createEReference(alloyTypeEClass, ALLOY_TYPE__INSTANCE);
    createEAttribute(alloyTypeEClass, ALLOY_TYPE__BUILDDATE);

    atomTypeEClass = createEClass(ATOM_TYPE);
    createEAttribute(atomTypeEClass, ATOM_TYPE__VALUE);
    createEAttribute(atomTypeEClass, ATOM_TYPE__LABEL);
    createEAttribute(atomTypeEClass, ATOM_TYPE__LOCATION);

    documentRootEClass = createEClass(DOCUMENT_ROOT);
    createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
    createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
    createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
    createEReference(documentRootEClass, DOCUMENT_ROOT__ALLOY);

    fieldTypeEClass = createEClass(FIELD_TYPE);
    createEAttribute(fieldTypeEClass, FIELD_TYPE__MIXED);
    createEReference(fieldTypeEClass, FIELD_TYPE__TUPLE);
    createEReference(fieldTypeEClass, FIELD_TYPE__TYPES);
    createEAttribute(fieldTypeEClass, FIELD_TYPE__ID);
    createEAttribute(fieldTypeEClass, FIELD_TYPE__LABEL);
    createEAttribute(fieldTypeEClass, FIELD_TYPE__PARENT_ID);
    createEAttribute(fieldTypeEClass, FIELD_TYPE__EXPRESSION);

    instanceTypeEClass = createEClass(INSTANCE_TYPE);
    createEAttribute(instanceTypeEClass, INSTANCE_TYPE__GROUP);
    createEReference(instanceTypeEClass, INSTANCE_TYPE__SIG);
    createEReference(instanceTypeEClass, INSTANCE_TYPE__FIELD);
    createEAttribute(instanceTypeEClass, INSTANCE_TYPE__BITWIDTH);
    createEAttribute(instanceTypeEClass, INSTANCE_TYPE__COMMAND);
    createEAttribute(instanceTypeEClass, INSTANCE_TYPE__FILENAME);
    createEAttribute(instanceTypeEClass, INSTANCE_TYPE__MAXSEQ);

    sigTypeEClass = createEClass(SIG_TYPE);
    createEAttribute(sigTypeEClass, SIG_TYPE__MIXED);
    createEReference(sigTypeEClass, SIG_TYPE__ATOM);
    createEAttribute(sigTypeEClass, SIG_TYPE__ABSTRACT);
    createEAttribute(sigTypeEClass, SIG_TYPE__BUILTIN);
    createEAttribute(sigTypeEClass, SIG_TYPE__ENUM);
    createEAttribute(sigTypeEClass, SIG_TYPE__ID);
    createEAttribute(sigTypeEClass, SIG_TYPE__LABEL);
    createEAttribute(sigTypeEClass, SIG_TYPE__LOCATION);
    createEAttribute(sigTypeEClass, SIG_TYPE__LONE);
    createEAttribute(sigTypeEClass, SIG_TYPE__META);
    createEAttribute(sigTypeEClass, SIG_TYPE__ONE);
    createEAttribute(sigTypeEClass, SIG_TYPE__PARENT_ID);
    createEAttribute(sigTypeEClass, SIG_TYPE__PRIVATE);
    createEAttribute(sigTypeEClass, SIG_TYPE__SOME);
    createEAttribute(sigTypeEClass, SIG_TYPE__SUBSET);
    createEAttribute(sigTypeEClass, SIG_TYPE__SUBSIG);

    tupleTypeEClass = createEClass(TUPLE_TYPE);
    createEReference(tupleTypeEClass, TUPLE_TYPE__ATOM);

    typesTypeEClass = createEClass(TYPES_TYPE);
    createEReference(typesTypeEClass, TYPES_TYPE__TYPE);

    typeTypeEClass = createEClass(TYPE_TYPE);
    createEAttribute(typeTypeEClass, TYPE_TYPE__VALUE);
    createEAttribute(typeTypeEClass, TYPE_TYPE__ID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes, features, and operations; add parameters
    initEClass(alloyTypeEClass, AlloyType.class, "AlloyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAlloyType_Instance(), this.getInstanceType(), null, "instance", null, 1, 1, AlloyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAlloyType_Builddate(), theXMLTypePackage.getString(), "builddate", null, 0, 1, AlloyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(atomTypeEClass, AtomType.class, "AtomType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAtomType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, AtomType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAtomType_Label(), theXMLTypePackage.getString(), "label", null, 0, 1, AtomType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAtomType_Location(), theXMLTypePackage.getAnySimpleType(), "location", null, 0, 1, AtomType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentRoot_Alloy(), this.getAlloyType(), null, "alloy", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

    initEClass(fieldTypeEClass, FieldType.class, "FieldType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFieldType_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, FieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFieldType_Tuple(), this.getTupleType(), null, "tuple", null, 0, -1, FieldType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEReference(getFieldType_Types(), this.getTypesType(), null, "types", null, 0, 1, FieldType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEAttribute(getFieldType_ID(), theXMLTypePackage.getByte(), "iD", null, 0, 1, FieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFieldType_Label(), theXMLTypePackage.getString(), "label", null, 0, 1, FieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFieldType_ParentID(), theXMLTypePackage.getByte(), "parentID", null, 0, 1, FieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFieldType_Expression(), theXMLTypePackage.getString(), "expression", null, 0, 1, FieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(instanceTypeEClass, InstanceType.class, "InstanceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInstanceType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, InstanceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInstanceType_Sig(), this.getSigType(), null, "sig", null, 0, -1, InstanceType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEReference(getInstanceType_Field(), this.getFieldType(), null, "field", null, 0, -1, InstanceType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEAttribute(getInstanceType_Bitwidth(), theXMLTypePackage.getByte(), "bitwidth", null, 0, 1, InstanceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInstanceType_Command(), theXMLTypePackage.getString(), "command", null, 0, 1, InstanceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInstanceType_Filename(), theXMLTypePackage.getString(), "filename", null, 0, 1, InstanceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInstanceType_Maxseq(), theXMLTypePackage.getByte(), "maxseq", null, 0, 1, InstanceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sigTypeEClass, SigType.class, "SigType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSigType_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, SigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSigType_Atom(), this.getAtomType(), null, "atom", null, 0, -1, SigType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEAttribute(getSigType_Abstract(), theXMLTypePackage.getString(), "abstract", null, 0, 1, SigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSigType_Builtin(), theXMLTypePackage.getString(), "builtin", null, 0, 1, SigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSigType_Enum(), theXMLTypePackage.getString(), "enum", null, 0, 1, SigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSigType_ID(), theXMLTypePackage.getByte(), "iD", null, 0, 1, SigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSigType_Label(), theXMLTypePackage.getString(), "label", null, 0, 1, SigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSigType_Location(), theXMLTypePackage.getAnySimpleType(), "location", null, 0, 1, SigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSigType_Lone(), theXMLTypePackage.getString(), "lone", null, 0, 1, SigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSigType_Meta(), theXMLTypePackage.getString(), "meta", null, 0, 1, SigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSigType_One(), theXMLTypePackage.getString(), "one", null, 0, 1, SigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSigType_ParentID(), theXMLTypePackage.getByte(), "parentID", null, 0, 1, SigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSigType_Private(), theXMLTypePackage.getString(), "private", null, 0, 1, SigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSigType_Some(), theXMLTypePackage.getString(), "some", null, 0, 1, SigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSigType_Subset(), theXMLTypePackage.getString(), "subset", null, 0, 1, SigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSigType_Subsig(), theXMLTypePackage.getString(), "subsig", null, 0, 1, SigType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tupleTypeEClass, TupleType.class, "TupleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTupleType_Atom(), this.getAtomType(), null, "atom", null, 0, -1, TupleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typesTypeEClass, TypesType.class, "TypesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypesType_Type(), this.getTypeType(), null, "type", null, 0, -1, TypesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeTypeEClass, TypeType.class, "TypeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypeType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, TypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTypeType_ID(), theXMLTypePackage.getByte(), "iD", null, 0, 1, TypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
  }

  /**
   * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createExtendedMetaDataAnnotations() {
    String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
    addAnnotation
      (this, 
       source, 
       new String[] {
       "qualified", "false"
       });	
    addAnnotation
      (alloyTypeEClass, 
       source, 
       new String[] {
       "name", "alloy_._type",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getAlloyType_Instance(), 
       source, 
       new String[] {
       "kind", "element",
       "name", "instance",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getAlloyType_Builddate(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "builddate",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (atomTypeEClass, 
       source, 
       new String[] {
       "name", "atom_._1_._type",
       "kind", "simple"
       });	
    addAnnotation
      (getAtomType_Value(), 
       source, 
       new String[] {
       "name", ":0",
       "kind", "simple"
       });	
    addAnnotation
      (getAtomType_Label(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "label",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getAtomType_Location(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "location",
       "namespace", "http://modelwriter.eu/alloyextension"
       });	
    addAnnotation
      (documentRootEClass, 
       source, 
       new String[] {
       "name", "",
       "kind", "mixed"
       });	
    addAnnotation
      (getDocumentRoot_Mixed(), 
       source, 
       new String[] {
       "kind", "elementWildcard",
       "name", ":mixed"
       });	
    addAnnotation
      (getDocumentRoot_XMLNSPrefixMap(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "xmlns:prefix"
       });	
    addAnnotation
      (getDocumentRoot_XSISchemaLocation(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "xsi:schemaLocation"
       });	
    addAnnotation
      (getDocumentRoot_Alloy(), 
       source, 
       new String[] {
       "kind", "element",
       "name", "alloy",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (fieldTypeEClass, 
       source, 
       new String[] {
       "name", "field_._type",
       "kind", "mixed"
       });	
    addAnnotation
      (getFieldType_Mixed(), 
       source, 
       new String[] {
       "kind", "elementWildcard",
       "name", ":mixed"
       });	
    addAnnotation
      (getFieldType_Tuple(), 
       source, 
       new String[] {
       "kind", "element",
       "name", "tuple",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getFieldType_Types(), 
       source, 
       new String[] {
       "kind", "element",
       "name", "types",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getFieldType_ID(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "ID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getFieldType_Label(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "label",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getFieldType_ParentID(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "parentID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getFieldType_Expression(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "expression",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (instanceTypeEClass, 
       source, 
       new String[] {
       "name", "instance_._type",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getInstanceType_Group(), 
       source, 
       new String[] {
       "kind", "group",
       "name", "group:0"
       });	
    addAnnotation
      (getInstanceType_Sig(), 
       source, 
       new String[] {
       "kind", "element",
       "name", "sig",
       "namespace", "##targetNamespace",
       "group", "group:0"
       });	
    addAnnotation
      (getInstanceType_Field(), 
       source, 
       new String[] {
       "kind", "element",
       "name", "field",
       "namespace", "##targetNamespace",
       "group", "group:0"
       });	
    addAnnotation
      (getInstanceType_Bitwidth(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "bitwidth",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getInstanceType_Command(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "command",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getInstanceType_Filename(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "filename",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getInstanceType_Maxseq(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "maxseq",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (sigTypeEClass, 
       source, 
       new String[] {
       "name", "sig_._type",
       "kind", "mixed"
       });	
    addAnnotation
      (getSigType_Mixed(), 
       source, 
       new String[] {
       "kind", "elementWildcard",
       "name", ":mixed"
       });	
    addAnnotation
      (getSigType_Atom(), 
       source, 
       new String[] {
       "kind", "element",
       "name", "atom",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSigType_Abstract(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "abstract",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSigType_Builtin(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "builtin",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSigType_Enum(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "enum",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSigType_ID(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "ID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSigType_Label(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "label",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSigType_Location(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "location",
       "namespace", "http://modelwriter.eu/alloyextension"
       });	
    addAnnotation
      (getSigType_Lone(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "lone",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSigType_Meta(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "meta",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSigType_One(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "one",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSigType_ParentID(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "parentID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSigType_Private(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "private",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSigType_Some(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "some",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSigType_Subset(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "subset",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSigType_Subsig(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "subsig",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (tupleTypeEClass, 
       source, 
       new String[] {
       "name", "tuple_._type",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getTupleType_Atom(), 
       source, 
       new String[] {
       "kind", "element",
       "name", "atom",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (typesTypeEClass, 
       source, 
       new String[] {
       "name", "types_._type",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getTypesType_Type(), 
       source, 
       new String[] {
       "kind", "element",
       "name", "type",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (typeTypeEClass, 
       source, 
       new String[] {
       "name", "type_._type",
       "kind", "simple"
       });	
    addAnnotation
      (getTypeType_Value(), 
       source, 
       new String[] {
       "name", ":0",
       "kind", "simple"
       });	
    addAnnotation
      (getTypeType_ID(), 
       source, 
       new String[] {
       "kind", "attribute",
       "name", "ID",
       "namespace", "##targetNamespace"
       });
  }

} //AlloyXSDFilePackageImpl
