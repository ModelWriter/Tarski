/**
 */
package Marker;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mark Element Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Marker.MarkElementCollection#getMarkElements <em>Mark Elements</em>}</li>
 * </ul>
 *
 * @see Marker.MarkerPackage#getMarkElementCollection()
 * @model
 * @generated
 */
public interface MarkElementCollection extends EObject {
  /**
   * Returns the value of the '<em><b>Mark Elements</b></em>' containment reference list.
   * The list contents are of type {@link Marker.MarkElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mark Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mark Elements</em>' containment reference list.
   * @see Marker.MarkerPackage#getMarkElementCollection_MarkElements()
   * @model containment="true"
   * @generated
   */
  EList<MarkElement> getMarkElements();

} // MarkElementCollection
