/**
 */
package AlloyXSDFile.impl;

import AlloyXSDFile.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlloyXSDFileFactoryImpl extends EFactoryImpl implements AlloyXSDFileFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AlloyXSDFileFactory init() {
    try {
      AlloyXSDFileFactory theAlloyXSDFileFactory = (AlloyXSDFileFactory)EPackage.Registry.INSTANCE.getEFactory(AlloyXSDFilePackage.eNS_URI);
      if (theAlloyXSDFileFactory != null) {
        return theAlloyXSDFileFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AlloyXSDFileFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlloyXSDFileFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case AlloyXSDFilePackage.ALLOY_TYPE: return createAlloyType();
      case AlloyXSDFilePackage.ATOM_TYPE: return createAtomType();
      case AlloyXSDFilePackage.DOCUMENT_ROOT: return createDocumentRoot();
      case AlloyXSDFilePackage.FIELD_TYPE: return createFieldType();
      case AlloyXSDFilePackage.INSTANCE_TYPE: return createInstanceType();
      case AlloyXSDFilePackage.SIG_TYPE: return createSigType();
      case AlloyXSDFilePackage.TUPLE_TYPE: return createTupleType();
      case AlloyXSDFilePackage.TYPES_TYPE: return createTypesType();
      case AlloyXSDFilePackage.TYPE_TYPE: return createTypeType();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlloyType createAlloyType() {
    AlloyTypeImpl alloyType = new AlloyTypeImpl();
    return alloyType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtomType createAtomType() {
    AtomTypeImpl atomType = new AtomTypeImpl();
    return atomType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DocumentRoot createDocumentRoot() {
    DocumentRootImpl documentRoot = new DocumentRootImpl();
    return documentRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FieldType createFieldType() {
    FieldTypeImpl fieldType = new FieldTypeImpl();
    return fieldType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanceType createInstanceType() {
    InstanceTypeImpl instanceType = new InstanceTypeImpl();
    return instanceType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SigType createSigType() {
    SigTypeImpl sigType = new SigTypeImpl();
    return sigType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TupleType createTupleType() {
    TupleTypeImpl tupleType = new TupleTypeImpl();
    return tupleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypesType createTypesType() {
    TypesTypeImpl typesType = new TypesTypeImpl();
    return typesType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeType createTypeType() {
    TypeTypeImpl typeType = new TypeTypeImpl();
    return typeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlloyXSDFilePackage getAlloyXSDFilePackage() {
    return (AlloyXSDFilePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AlloyXSDFilePackage getPackage() {
    return AlloyXSDFilePackage.eINSTANCE;
  }

} //AlloyXSDFileFactoryImpl
