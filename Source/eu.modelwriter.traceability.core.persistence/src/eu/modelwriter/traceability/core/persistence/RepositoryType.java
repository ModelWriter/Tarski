/**
 */
package eu.modelwriter.traceability.core.persistence;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.RepositoryType#getMarker <em>Marker</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.RepositoryType#getLabel <em>Label</em>}</li>
 * </ul>
 *
 * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getRepositoryType()
 * @model extendedMetaData="name='repository_._type' kind='elementOnly'"
 * @generated
 */
public interface RepositoryType extends EObject {
  /**
   * Returns the value of the '<em><b>Marker</b></em>' containment reference list.
   * The list contents are of type {@link eu.modelwriter.traceability.core.persistence.MarkerType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Marker</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Marker</em>' containment reference list.
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getRepositoryType_Marker()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='marker' namespace='##targetNamespace'"
   * @generated
   */
  EList<MarkerType> getMarker();

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
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getRepositoryType_Label()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='label' namespace='##targetNamespace'"
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the '{@link eu.modelwriter.traceability.core.persistence.RepositoryType#getLabel <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label</em>' attribute.
   * @see #getLabel()
   * @generated
   */
  void setLabel(String value);

} // RepositoryType
