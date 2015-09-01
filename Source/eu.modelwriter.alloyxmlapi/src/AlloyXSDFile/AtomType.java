/**
 */
package AlloyXSDFile;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atom Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link AlloyXSDFile.AtomType#getValue <em>Value</em>}</li>
 *   <li>{@link AlloyXSDFile.AtomType#getLabel <em>Label</em>}</li>
 *   <li>{@link AlloyXSDFile.AtomType#getLocation <em>Location</em>}</li>
 * </ul>
 *
 * @see AlloyXSDFile.AlloyXSDFilePackage#getAtomType()
 * @model extendedMetaData="name='atom_._1_._type' kind='simple'"
 * @generated
 */
public interface AtomType extends EObject {
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getAtomType_Value()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="name=':0' kind='simple'"
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link AlloyXSDFile.AtomType#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Label</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Label</em>' attribute.
   * @see #setLabel(String)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getAtomType_Label()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='label' namespace='##targetNamespace'"
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the '{@link AlloyXSDFile.AtomType#getLabel <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label</em>' attribute.
   * @see #getLabel()
   * @generated
   */
  void setLabel(String value);

  /**
   * Returns the value of the '<em><b>Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Location</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Location</em>' attribute.
   * @see #setLocation(Object)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getAtomType_Location()
   * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
   *        extendedMetaData="kind='attribute' name='location' namespace='http://modelwriter.eu/alloyextension'"
   * @generated
   */
  Object getLocation();

  /**
   * Sets the value of the '{@link AlloyXSDFile.AtomType#getLocation <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Location</em>' attribute.
   * @see #getLocation()
   * @generated
   */
  void setLocation(Object value);

} // AtomType
