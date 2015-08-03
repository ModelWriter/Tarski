/**
 */
package Marker.impl;

import Marker.*;

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
public class MarkerFactoryImpl extends EFactoryImpl implements MarkerFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MarkerFactory init() {
    try {
      MarkerFactory theMarkerFactory = (MarkerFactory)EPackage.Registry.INSTANCE.getEFactory(MarkerPackage.eNS_URI);
      if (theMarkerFactory != null) {
        return theMarkerFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MarkerFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MarkerFactoryImpl() {
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
      case MarkerPackage.MARK_ELEMENT: return createMarkElement();
      case MarkerPackage.MARK_ELEMENT_COLLECTION: return createMarkElementCollection();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MarkElement createMarkElement() {
    MarkElementImpl markElement = new MarkElementImpl();
    return markElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MarkElementCollection createMarkElementCollection() {
    MarkElementCollectionImpl markElementCollection = new MarkElementCollectionImpl();
    return markElementCollection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MarkerPackage getMarkerPackage() {
    return (MarkerPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MarkerPackage getPackage() {
    return MarkerPackage.eINSTANCE;
  }

} //MarkerFactoryImpl
