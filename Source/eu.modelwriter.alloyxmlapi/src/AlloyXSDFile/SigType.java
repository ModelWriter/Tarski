/**
 */
package AlloyXSDFile;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sig Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link AlloyXSDFile.SigType#getMixed <em>Mixed</em>}</li>
 *   <li>{@link AlloyXSDFile.SigType#getAtom <em>Atom</em>}</li>
 *   <li>{@link AlloyXSDFile.SigType#getAbstract <em>Abstract</em>}</li>
 *   <li>{@link AlloyXSDFile.SigType#getBuiltin <em>Builtin</em>}</li>
 *   <li>{@link AlloyXSDFile.SigType#getEnum <em>Enum</em>}</li>
 *   <li>{@link AlloyXSDFile.SigType#getID <em>ID</em>}</li>
 *   <li>{@link AlloyXSDFile.SigType#getLabel <em>Label</em>}</li>
 *   <li>{@link AlloyXSDFile.SigType#getLocation <em>Location</em>}</li>
 *   <li>{@link AlloyXSDFile.SigType#getLone <em>Lone</em>}</li>
 *   <li>{@link AlloyXSDFile.SigType#getMeta <em>Meta</em>}</li>
 *   <li>{@link AlloyXSDFile.SigType#getOne <em>One</em>}</li>
 *   <li>{@link AlloyXSDFile.SigType#getParentID <em>Parent ID</em>}</li>
 *   <li>{@link AlloyXSDFile.SigType#getPrivate <em>Private</em>}</li>
 *   <li>{@link AlloyXSDFile.SigType#getSome <em>Some</em>}</li>
 *   <li>{@link AlloyXSDFile.SigType#getSubset <em>Subset</em>}</li>
 *   <li>{@link AlloyXSDFile.SigType#getSubsig <em>Subsig</em>}</li>
 * </ul>
 *
 * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType()
 * @model extendedMetaData="name='sig_._type' kind='mixed'"
 * @generated
 */
public interface SigType extends EObject {
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
   * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType_Mixed()
   * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
   *        extendedMetaData="kind='elementWildcard' name=':mixed'"
   * @generated
   */
  FeatureMap getMixed();

  /**
   * Returns the value of the '<em><b>Atom</b></em>' containment reference list.
   * The list contents are of type {@link AlloyXSDFile.AtomType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Atom</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Atom</em>' containment reference list.
   * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType_Atom()
   * @model containment="true" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='atom' namespace='##targetNamespace'"
   * @generated
   */
  EList<AtomType> getAtom();

  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #setAbstract(String)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType_Abstract()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='abstract' namespace='##targetNamespace'"
   * @generated
   */
  String getAbstract();

  /**
   * Sets the value of the '{@link AlloyXSDFile.SigType#getAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #getAbstract()
   * @generated
   */
  void setAbstract(String value);

  /**
   * Returns the value of the '<em><b>Builtin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Builtin</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Builtin</em>' attribute.
   * @see #setBuiltin(String)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType_Builtin()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='builtin' namespace='##targetNamespace'"
   * @generated
   */
  String getBuiltin();

  /**
   * Sets the value of the '{@link AlloyXSDFile.SigType#getBuiltin <em>Builtin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Builtin</em>' attribute.
   * @see #getBuiltin()
   * @generated
   */
  void setBuiltin(String value);

  /**
   * Returns the value of the '<em><b>Enum</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enum</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enum</em>' attribute.
   * @see #setEnum(String)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType_Enum()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='enum' namespace='##targetNamespace'"
   * @generated
   */
  String getEnum();

  /**
   * Sets the value of the '{@link AlloyXSDFile.SigType#getEnum <em>Enum</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enum</em>' attribute.
   * @see #getEnum()
   * @generated
   */
  void setEnum(String value);

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
   * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType_ID()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Byte"
   *        extendedMetaData="kind='attribute' name='ID' namespace='##targetNamespace'"
   * @generated
   */
  byte getID();

  /**
   * Sets the value of the '{@link AlloyXSDFile.SigType#getID <em>ID</em>}' attribute.
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
   * Unsets the value of the '{@link AlloyXSDFile.SigType#getID <em>ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetID()
   * @see #getID()
   * @see #setID(byte)
   * @generated
   */
  void unsetID();

  /**
   * Returns whether the value of the '{@link AlloyXSDFile.SigType#getID <em>ID</em>}' attribute is set.
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
   * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType_Label()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='label' namespace='##targetNamespace'"
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the '{@link AlloyXSDFile.SigType#getLabel <em>Label</em>}' attribute.
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
   * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType_Location()
   * @model dataType="org.eclipse.emf.ecore.xml.type.AnySimpleType"
   *        extendedMetaData="kind='attribute' name='location' namespace='http://modelwriter.eu/alloyextension'"
   * @generated
   */
  Object getLocation();

  /**
   * Sets the value of the '{@link AlloyXSDFile.SigType#getLocation <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Location</em>' attribute.
   * @see #getLocation()
   * @generated
   */
  void setLocation(Object value);

  /**
   * Returns the value of the '<em><b>Lone</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lone</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lone</em>' attribute.
   * @see #setLone(String)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType_Lone()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='lone' namespace='##targetNamespace'"
   * @generated
   */
  String getLone();

  /**
   * Sets the value of the '{@link AlloyXSDFile.SigType#getLone <em>Lone</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lone</em>' attribute.
   * @see #getLone()
   * @generated
   */
  void setLone(String value);

  /**
   * Returns the value of the '<em><b>Meta</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Meta</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Meta</em>' attribute.
   * @see #setMeta(String)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType_Meta()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='meta' namespace='##targetNamespace'"
   * @generated
   */
  String getMeta();

  /**
   * Sets the value of the '{@link AlloyXSDFile.SigType#getMeta <em>Meta</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Meta</em>' attribute.
   * @see #getMeta()
   * @generated
   */
  void setMeta(String value);

  /**
   * Returns the value of the '<em><b>One</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>One</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>One</em>' attribute.
   * @see #setOne(String)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType_One()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='one' namespace='##targetNamespace'"
   * @generated
   */
  String getOne();

  /**
   * Sets the value of the '{@link AlloyXSDFile.SigType#getOne <em>One</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>One</em>' attribute.
   * @see #getOne()
   * @generated
   */
  void setOne(String value);

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
   * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType_ParentID()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Byte"
   *        extendedMetaData="kind='attribute' name='parentID' namespace='##targetNamespace'"
   * @generated
   */
  byte getParentID();

  /**
   * Sets the value of the '{@link AlloyXSDFile.SigType#getParentID <em>Parent ID</em>}' attribute.
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
   * Unsets the value of the '{@link AlloyXSDFile.SigType#getParentID <em>Parent ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetParentID()
   * @see #getParentID()
   * @see #setParentID(byte)
   * @generated
   */
  void unsetParentID();

  /**
   * Returns whether the value of the '{@link AlloyXSDFile.SigType#getParentID <em>Parent ID</em>}' attribute is set.
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
   * Returns the value of the '<em><b>Private</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Private</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Private</em>' attribute.
   * @see #setPrivate(String)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType_Private()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='private' namespace='##targetNamespace'"
   * @generated
   */
  String getPrivate();

  /**
   * Sets the value of the '{@link AlloyXSDFile.SigType#getPrivate <em>Private</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Private</em>' attribute.
   * @see #getPrivate()
   * @generated
   */
  void setPrivate(String value);

  /**
   * Returns the value of the '<em><b>Some</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Some</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Some</em>' attribute.
   * @see #setSome(String)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType_Some()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='some' namespace='##targetNamespace'"
   * @generated
   */
  String getSome();

  /**
   * Sets the value of the '{@link AlloyXSDFile.SigType#getSome <em>Some</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Some</em>' attribute.
   * @see #getSome()
   * @generated
   */
  void setSome(String value);

  /**
   * Returns the value of the '<em><b>Subset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subset</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subset</em>' attribute.
   * @see #setSubset(String)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType_Subset()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='subset' namespace='##targetNamespace'"
   * @generated
   */
  String getSubset();

  /**
   * Sets the value of the '{@link AlloyXSDFile.SigType#getSubset <em>Subset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subset</em>' attribute.
   * @see #getSubset()
   * @generated
   */
  void setSubset(String value);

  /**
   * Returns the value of the '<em><b>Subsig</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subsig</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subsig</em>' attribute.
   * @see #setSubsig(String)
   * @see AlloyXSDFile.AlloyXSDFilePackage#getSigType_Subsig()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='subsig' namespace='##targetNamespace'"
   * @generated
   */
  String getSubsig();

  /**
   * Sets the value of the '{@link AlloyXSDFile.SigType#getSubsig <em>Subsig</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subsig</em>' attribute.
   * @see #getSubsig()
   * @generated
   */
  void setSubsig(String value);

} // SigType
