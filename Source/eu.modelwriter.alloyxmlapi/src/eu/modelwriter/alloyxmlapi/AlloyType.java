/**
 */
package eu.modelwriter.alloyxmlapi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alloy Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.alloyxmlapi.AlloyType#getInstance <em>Instance</em>}</li>
 *   <li>{@link eu.modelwriter.alloyxmlapi.AlloyType#getBuilddate <em>Builddate</em>}</li>
 * </ul>
 *
 * @see eu.modelwriter.alloyxmlapi.AlloyXSDFilePackage#getAlloyType()
 * @model extendedMetaData="name='alloy_._type' kind='elementOnly'"
 * @generated
 */
public interface AlloyType extends EObject {
  /**
   * Returns the value of the '<em><b>Instance</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instance</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instance</em>' containment reference.
   * @see #setInstance(InstanceType)
   * @see eu.modelwriter.alloyxmlapi.AlloyXSDFilePackage#getAlloyType_Instance()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='instance' namespace='##targetNamespace'"
   * @generated
   */
  InstanceType getInstance();

  /**
   * Sets the value of the '{@link eu.modelwriter.alloyxmlapi.AlloyType#getInstance <em>Instance</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instance</em>' containment reference.
   * @see #getInstance()
   * @generated
   */
  void setInstance(InstanceType value);

  /**
   * Returns the value of the '<em><b>Builddate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Builddate</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Builddate</em>' attribute.
   * @see #setBuilddate(String)
   * @see eu.modelwriter.alloyxmlapi.AlloyXSDFilePackage#getAlloyType_Builddate()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='builddate' namespace='##targetNamespace'"
   * @generated
   */
  String getBuilddate();

  /**
   * Sets the value of the '{@link eu.modelwriter.alloyxmlapi.AlloyType#getBuilddate <em>Builddate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Builddate</em>' attribute.
   * @see #getBuilddate()
   * @generated
   */
  void setBuilddate(String value);

} // AlloyType
