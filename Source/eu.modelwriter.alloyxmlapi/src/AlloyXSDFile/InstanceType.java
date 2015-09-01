/**
 */
package AlloyXSDFile;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link AlloyXSDFile.InstanceType#getGroup <em>Group</em>}</li>
 *   <li>{@link AlloyXSDFile.InstanceType#getSig <em>Sig</em>}</li>
 *   <li>{@link AlloyXSDFile.InstanceType#getField <em>Field</em>}</li>
 *   <li>{@link AlloyXSDFile.InstanceType#getBitwidth <em>Bitwidth</em>}</li>
 *   <li>{@link AlloyXSDFile.InstanceType#getCommand <em>Command</em>}</li>
 *   <li>{@link AlloyXSDFile.InstanceType#getFilename <em>Filename</em>}</li>
 *   <li>{@link AlloyXSDFile.InstanceType#getMaxseq <em>Maxseq</em>}</li>
 * </ul>
 *
 * @see AlloyXSDFile.AlloyXSDFilePackage#getInstanceType()
 * @model extendedMetaData="name='instance_._type' kind='elementOnly'"
 * @generated
 */
public interface InstanceType extends EObject {
  /**
   * Returns the value of the '<em><b>Group</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group</em>' attribute list.
   * @see AlloyXSDFile.AlloyXSDFilePackage#getInstanceType_Group()
   * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
   *        extendedMetaData="kind='group' name='group:0'"
   * @generated
   */
  FeatureMap getGroup();

  /**
   * Returns the value of the '<em><b>Sig</b></em>' containment reference list.
   * The list contents are of type {@link AlloyXSDFile.SigType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sig</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sig</em>' containment reference list.
   * @see AlloyXSDFile.AlloyXSDFilePackage#getInstanceType_Sig()
   * @model containment="true" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='sig' namespace='##targetNamespace' group='group:0'"
   * @generated
   */
  EList<SigType> getSig();

  /**
   * Returns the value of the '<em><b>Field</b></em>' containment reference list.
   * The list contents are of type {@link AlloyXSDFile.FieldType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field</em>' containment reference list.
   * @see AlloyXSDFile.AlloyXSDFilePackage#getInstanceType_Field()
   * @model containment="true" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='field' namespace='##targetNamespace' group='group:0'"
   * @generated
   */
  EList<FieldType> getField();

  /**
   * Returns the value of the '<em><b>Bitwidth</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bitwidth</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bitwidth</em>' attribute.
   * @see #isSetBitwidth()
   * @see #unsetBitwidth()
   * @see #setBitwidth(byte)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getInstanceType_Bitwidth()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Byte"
   *        extendedMetaData="kind='attribute' name='bitwidth' namespace='##targetNamespace'"
   * @generated
   */
  byte getBitwidth();

  /**
   * Sets the value of the '{@link AlloyXSDFile.InstanceType#getBitwidth <em>Bitwidth</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bitwidth</em>' attribute.
   * @see #isSetBitwidth()
   * @see #unsetBitwidth()
   * @see #getBitwidth()
   * @generated
   */
  void setBitwidth(byte value);

  /**
   * Unsets the value of the '{@link AlloyXSDFile.InstanceType#getBitwidth <em>Bitwidth</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetBitwidth()
   * @see #getBitwidth()
   * @see #setBitwidth(byte)
   * @generated
   */
  void unsetBitwidth();

  /**
   * Returns whether the value of the '{@link AlloyXSDFile.InstanceType#getBitwidth <em>Bitwidth</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Bitwidth</em>' attribute is set.
   * @see #unsetBitwidth()
   * @see #getBitwidth()
   * @see #setBitwidth(byte)
   * @generated
   */
  boolean isSetBitwidth();

  /**
   * Returns the value of the '<em><b>Command</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Command</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Command</em>' attribute.
   * @see #setCommand(String)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getInstanceType_Command()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='command' namespace='##targetNamespace'"
   * @generated
   */
  String getCommand();

  /**
   * Sets the value of the '{@link AlloyXSDFile.InstanceType#getCommand <em>Command</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Command</em>' attribute.
   * @see #getCommand()
   * @generated
   */
  void setCommand(String value);

  /**
   * Returns the value of the '<em><b>Filename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Filename</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Filename</em>' attribute.
   * @see #setFilename(String)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getInstanceType_Filename()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='filename' namespace='##targetNamespace'"
   * @generated
   */
  String getFilename();

  /**
   * Sets the value of the '{@link AlloyXSDFile.InstanceType#getFilename <em>Filename</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Filename</em>' attribute.
   * @see #getFilename()
   * @generated
   */
  void setFilename(String value);

  /**
   * Returns the value of the '<em><b>Maxseq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Maxseq</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Maxseq</em>' attribute.
   * @see #isSetMaxseq()
   * @see #unsetMaxseq()
   * @see #setMaxseq(byte)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getInstanceType_Maxseq()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Byte"
   *        extendedMetaData="kind='attribute' name='maxseq' namespace='##targetNamespace'"
   * @generated
   */
  byte getMaxseq();

  /**
   * Sets the value of the '{@link AlloyXSDFile.InstanceType#getMaxseq <em>Maxseq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Maxseq</em>' attribute.
   * @see #isSetMaxseq()
   * @see #unsetMaxseq()
   * @see #getMaxseq()
   * @generated
   */
  void setMaxseq(byte value);

  /**
   * Unsets the value of the '{@link AlloyXSDFile.InstanceType#getMaxseq <em>Maxseq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMaxseq()
   * @see #getMaxseq()
   * @see #setMaxseq(byte)
   * @generated
   */
  void unsetMaxseq();

  /**
   * Returns whether the value of the '{@link AlloyXSDFile.InstanceType#getMaxseq <em>Maxseq</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Maxseq</em>' attribute is set.
   * @see #unsetMaxseq()
   * @see #getMaxseq()
   * @see #setMaxseq(byte)
   * @generated
   */
  boolean isSetMaxseq();

} // InstanceType
