/**
 */
package eu.modelwriter.traceability.core.persistence;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Properties Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.PropertiesType#getValue <em>Value</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.PropertiesType#getGroupID <em>Group ID</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.PropertiesType#getLeaderID <em>Leader ID</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.PropertiesType#getLocation <em>Location</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.PropertiesType#getOffset <em>Offset</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.PropertiesType#getText <em>Text</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.PropertiesType#getUri <em>Uri</em>}</li>
 * </ul>
 *
 * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getPropertiesType()
 * @model extendedMetaData="name='properties_._type' kind='simple'"
 * @generated
 */
public interface PropertiesType extends EObject {
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
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getPropertiesType_Value()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="name=':0' kind='simple'"
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.PropertiesType#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Group ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group ID</em>' attribute.
   * @see #setGroupID(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getPropertiesType_GroupID()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='groupID' namespace='##targetNamespace'"
   * @generated
   */
  String getGroupID();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.PropertiesType#getGroupID <em>Group ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Group ID</em>' attribute.
   * @see #getGroupID()
   * @generated
   */
  void setGroupID(String value);

  /**
   * Returns the value of the '<em><b>Leader ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Leader ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Leader ID</em>' attribute.
   * @see #setLeaderID(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getPropertiesType_LeaderID()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='leaderID' namespace='##targetNamespace'"
   * @generated
   */
  String getLeaderID();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.PropertiesType#getLeaderID <em>Leader ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Leader ID</em>' attribute.
   * @see #getLeaderID()
   * @generated
   */
  void setLeaderID(String value);

  /**
   * Returns the value of the '<em><b>Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Location</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Location</em>' attribute.
   * @see #setLocation(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getPropertiesType_Location()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='location' namespace='##targetNamespace'"
   * @generated
   */
  String getLocation();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.PropertiesType#getLocation <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Location</em>' attribute.
   * @see #getLocation()
   * @generated
   */
  void setLocation(String value);

  /**
   * Returns the value of the '<em><b>Offset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Offset</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Offset</em>' attribute.
   * @see #isSetOffset()
   * @see #unsetOffset()
   * @see #setOffset(int)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getPropertiesType_Offset()
   * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='offset' namespace='##targetNamespace'"
   * @generated
   */
  int getOffset();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.PropertiesType#getOffset <em>Offset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Offset</em>' attribute.
   * @see #isSetOffset()
   * @see #unsetOffset()
   * @see #getOffset()
   * @generated
   */
  void setOffset(int value);

  /**
   * Unsets the value of the '{@link eu.modelwriter.traceability.core.persistence.PropertiesType#getOffset <em>Offset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetOffset()
   * @see #getOffset()
   * @see #setOffset(int)
   * @generated
   */
  void unsetOffset();

  /**
   * Returns whether the value of the '{@link eu.modelwriter.traceability.core.persistence.PropertiesType#getOffset <em>Offset</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Offset</em>' attribute is set.
   * @see #unsetOffset()
   * @see #getOffset()
   * @see #setOffset(int)
   * @generated
   */
  boolean isSetOffset();

  /**
   * Returns the value of the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Text</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Text</em>' attribute.
   * @see #setText(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getPropertiesType_Text()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='text' namespace='##targetNamespace'"
   * @generated
   */
  String getText();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.PropertiesType#getText <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text</em>' attribute.
   * @see #getText()
   * @generated
   */
  void setText(String value);

  /**
   * Returns the value of the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Uri</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uri</em>' attribute.
   * @see #setUri(String)
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getPropertiesType_Uri()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='uri' namespace='##targetNamespace'"
   * @generated
   */
  String getUri();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.PropertiesType#getUri <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Uri</em>' attribute.
   * @see #getUri()
   * @generated
   */
  void setUri(String value);

} // PropertiesType
