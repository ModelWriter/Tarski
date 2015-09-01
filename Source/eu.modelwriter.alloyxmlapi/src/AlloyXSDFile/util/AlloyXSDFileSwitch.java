/**
 */
package AlloyXSDFile.util;

import AlloyXSDFile.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see AlloyXSDFile.AlloyXSDFilePackage
 * @generated
 */
public class AlloyXSDFileSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AlloyXSDFilePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlloyXSDFileSwitch() {
    if (modelPackage == null) {
      modelPackage = AlloyXSDFilePackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
      case AlloyXSDFilePackage.ALLOY_TYPE: {
        AlloyType alloyType = (AlloyType)theEObject;
        T result = caseAlloyType(alloyType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlloyXSDFilePackage.ATOM_TYPE: {
        AtomType atomType = (AtomType)theEObject;
        T result = caseAtomType(atomType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlloyXSDFilePackage.DOCUMENT_ROOT: {
        DocumentRoot documentRoot = (DocumentRoot)theEObject;
        T result = caseDocumentRoot(documentRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlloyXSDFilePackage.FIELD_TYPE: {
        FieldType fieldType = (FieldType)theEObject;
        T result = caseFieldType(fieldType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlloyXSDFilePackage.INSTANCE_TYPE: {
        InstanceType instanceType = (InstanceType)theEObject;
        T result = caseInstanceType(instanceType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlloyXSDFilePackage.SIG_TYPE: {
        SigType sigType = (SigType)theEObject;
        T result = caseSigType(sigType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlloyXSDFilePackage.TUPLE_TYPE: {
        TupleType tupleType = (TupleType)theEObject;
        T result = caseTupleType(tupleType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlloyXSDFilePackage.TYPES_TYPE: {
        TypesType typesType = (TypesType)theEObject;
        T result = caseTypesType(typesType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AlloyXSDFilePackage.TYPE_TYPE: {
        TypeType typeType = (TypeType)theEObject;
        T result = caseTypeType(typeType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Alloy Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Alloy Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlloyType(AlloyType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Atom Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atom Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAtomType(AtomType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDocumentRoot(DocumentRoot object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Field Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Field Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFieldType(FieldType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instance Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstanceType(InstanceType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sig Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sig Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSigType(SigType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTupleType(TupleType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Types Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Types Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypesType(TypesType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeType(TypeType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object) {
    return null;
  }

} //AlloyXSDFileSwitch
