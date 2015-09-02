/**
 */
package eu.modelwriter.alloyxmlapi.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import eu.modelwriter.alloyxmlapi.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.modelwriter.alloyxmlapi.AlloyXSDFilePackage
 * @generated
 */
public class AlloyXSDFileAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AlloyXSDFilePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlloyXSDFileAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = AlloyXSDFilePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AlloyXSDFileSwitch<Adapter> modelSwitch =
    new AlloyXSDFileSwitch<Adapter>() {
      @Override
      public Adapter caseAlloyType(AlloyType object) {
        return createAlloyTypeAdapter();
      }
      @Override
      public Adapter caseAtomType(AtomType object) {
        return createAtomTypeAdapter();
      }
      @Override
      public Adapter caseDocumentRoot(DocumentRoot object) {
        return createDocumentRootAdapter();
      }
      @Override
      public Adapter caseFieldType(FieldType object) {
        return createFieldTypeAdapter();
      }
      @Override
      public Adapter caseInstanceType(InstanceType object) {
        return createInstanceTypeAdapter();
      }
      @Override
      public Adapter caseSigType(SigType object) {
        return createSigTypeAdapter();
      }
      @Override
      public Adapter caseTupleType(TupleType object) {
        return createTupleTypeAdapter();
      }
      @Override
      public Adapter caseTypesType(TypesType object) {
        return createTypesTypeAdapter();
      }
      @Override
      public Adapter caseTypeType(TypeType object) {
        return createTypeTypeAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object) {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.alloyxmlapi.AlloyType <em>Alloy Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.alloyxmlapi.AlloyType
   * @generated
   */
  public Adapter createAlloyTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.alloyxmlapi.AtomType <em>Atom Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.alloyxmlapi.AtomType
   * @generated
   */
  public Adapter createAtomTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.alloyxmlapi.DocumentRoot <em>Document Root</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.alloyxmlapi.DocumentRoot
   * @generated
   */
  public Adapter createDocumentRootAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.alloyxmlapi.FieldType <em>Field Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.alloyxmlapi.FieldType
   * @generated
   */
  public Adapter createFieldTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.alloyxmlapi.InstanceType <em>Instance Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.alloyxmlapi.InstanceType
   * @generated
   */
  public Adapter createInstanceTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.alloyxmlapi.SigType <em>Sig Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.alloyxmlapi.SigType
   * @generated
   */
  public Adapter createSigTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.alloyxmlapi.TupleType <em>Tuple Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.alloyxmlapi.TupleType
   * @generated
   */
  public Adapter createTupleTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.alloyxmlapi.TypesType <em>Types Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.alloyxmlapi.TypesType
   * @generated
   */
  public Adapter createTypesTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.alloyxmlapi.TypeType <em>Type Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.alloyxmlapi.TypeType
   * @generated
   */
  public Adapter createTypeTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} //AlloyXSDFileAdapterFactory
