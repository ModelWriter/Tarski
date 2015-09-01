/**
 */
package AlloyXSDFile;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link AlloyXSDFile.FieldType#getMixed <em>Mixed</em>}</li>
 *   <li>{@link AlloyXSDFile.FieldType#getTuple <em>Tuple</em>}</li>
 *   <li>{@link AlloyXSDFile.FieldType#getTypes <em>Types</em>}</li>
 *   <li>{@link AlloyXSDFile.FieldType#getID <em>ID</em>}</li>
 *   <li>{@link AlloyXSDFile.FieldType#getLabel <em>Label</em>}</li>
 *   <li>{@link AlloyXSDFile.FieldType#getParentID <em>Parent ID</em>}</li>
 *   <li>{@link AlloyXSDFile.FieldType#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see AlloyXSDFile.AlloyXSDFilePackage#getFieldType()
 * @model extendedMetaData="name='field_._type' kind='mixed'"
 * @generated
 */
public interface FieldType extends EObject {
  /**
   * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mixed</em>' attribute list.
   * @see AlloyXSDFile.AlloyXSDFilePackage#getFieldType_Mixed()
   * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
   *        extendedMetaData="kind='elementWildcard' name=':mixed'"
   * @generated
   */
  FeatureMap getMixed();

  /**
   * Returns the value of the '<em><b>Tuple</b></em>' containment reference list.
   * The list contents are of type {@link AlloyXSDFile.TupleType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tuple</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tuple</em>' containment reference list.
   * @see AlloyXSDFile.AlloyXSDFilePackage#getFieldType_Tuple()
   * @model containment="true" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='tuple' namespace='##targetNamespace'"
   * @generated
   */
  EList<TupleType> getTuple();

  /**
   * Returns the value of the '<em><b>Types</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Types</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Types</em>' containment reference.
   * @see #setTypes(TypesType)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getFieldType_Types()
   * @model containment="true" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='types' namespace='##targetNamespace'"
   * @generated
   */
  TypesType getTypes();

  /**
   * Sets the value of the '{@link AlloyXSDFile.FieldType#getTypes <em>Types</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Types</em>' containment reference.
   * @see #getTypes()
   * @generated
   */
  void setTypes(TypesType value);

  /**
   * Returns the value of the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>ID</em>' attribute.
   * @see #isSetID()
   * @see #unsetID()
   * @see #setID(byte)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getFieldType_ID()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Byte"
   *        extendedMetaData="kind='attribute' name='ID' namespace='##targetNamespace'"
   * @generated
   */
  byte getID();

  /**
   * Sets the value of the '{@link AlloyXSDFile.FieldType#getID <em>ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>ID</em>' attribute.
   * @see #isSetID()
   * @see #unsetID()
   * @see #getID()
   * @generated
   */
  void setID(byte value);

  /**
   * Unsets the value of the '{@link AlloyXSDFile.FieldType#getID <em>ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetID()
   * @see #getID()
   * @see #setID(byte)
   * @generated
   */
  void unsetID();

  /**
   * Returns whether the value of the '{@link AlloyXSDFile.FieldType#getID <em>ID</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>ID</em>' attribute is set.
   * @see #unsetID()
   * @see #getID()
   * @see #setID(byte)
   * @generated
   */
  boolean isSetID();

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
   * @see AlloyXSDFile.AlloyXSDFilePackage#getFieldType_Label()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='label' namespace='##targetNamespace'"
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the '{@link AlloyXSDFile.FieldType#getLabel <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label</em>' attribute.
   * @see #getLabel()
   * @generated
   */
  void setLabel(String value);

  /**
   * Returns the value of the '<em><b>Parent ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parent ID</em>' attribute.
   * @see #isSetParentID()
   * @see #unsetParentID()
   * @see #setParentID(byte)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getFieldType_ParentID()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Byte"
   *        extendedMetaData="kind='attribute' name='parentID' namespace='##targetNamespace'"
   * @generated
   */
  byte getParentID();

  /**
   * Sets the value of the '{@link AlloyXSDFile.FieldType#getParentID <em>Parent ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent ID</em>' attribute.
   * @see #isSetParentID()
   * @see #unsetParentID()
   * @see #getParentID()
   * @generated
   */
  void setParentID(byte value);

  /**
   * Unsets the value of the '{@link AlloyXSDFile.FieldType#getParentID <em>Parent ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetParentID()
   * @see #getParentID()
   * @see #setParentID(byte)
   * @generated
   */
  void unsetParentID();

  /**
   * Returns whether the value of the '{@link AlloyXSDFile.FieldType#getParentID <em>Parent ID</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Parent ID</em>' attribute is set.
   * @see #unsetParentID()
   * @see #getParentID()
   * @see #setParentID(byte)
   * @generated
   */
  boolean isSetParentID();

  /**
   * Returns the value of the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' attribute.
   * @see #setExpression(String)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getFieldType_Expression()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='expression' namespace='##targetNamespace'"
   * @generated
   */
  String getExpression();

  /**
   * Sets the value of the '{@link AlloyXSDFile.FieldType#getExpression <em>Expression</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' attribute.
   * @see #getExpression()
   * @generated
   */
  void setExpression(String value);

} // FieldType
