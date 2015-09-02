/**
 */
package eu.modelwriter.alloyxmlapi;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eu.modelwriter.alloyxmlapi.AlloyXSDFilePackage
 * @generated
 */
public interface AlloyXSDFileFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AlloyXSDFileFactory eINSTANCE = eu.modelwriter.alloyxmlapi.impl.AlloyXSDFileFactoryImpl.init();

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
   * Returns a new object of class '<em>Sig Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sig Type</em>'.
   * @generated
   */
  SigType createSigType();

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
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AlloyXSDFilePackage getAlloyXSDFilePackage();

} //AlloyXSDFileFactory
