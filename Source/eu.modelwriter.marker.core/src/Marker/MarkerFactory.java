/**
 */
package Marker;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see Marker.MarkerPackage
 * @generated
 */
public interface MarkerFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MarkerFactory eINSTANCE = Marker.impl.MarkerFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Mark Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mark Element</em>'.
   * @generated
   */
  MarkElement createMarkElement();

  /**
   * Returns a new object of class '<em>Mark Element Collection</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mark Element Collection</em>'.
   * @generated
   */
  MarkElementCollection createMarkElementCollection();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  MarkerPackage getMarkerPackage();

} //MarkerFactory
