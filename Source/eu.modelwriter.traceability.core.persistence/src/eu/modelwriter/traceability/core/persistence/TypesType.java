/**
 */
package eu.modelwriter.traceability.core.persistence;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Types Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.TypesType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getTypesType()
 * @model extendedMetaData="name='types_._type' kind='elementOnly'"
 * @generated
 */
public interface TypesType extends EObject {
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference list.
   * The list contents are of type {@link eu.modelwriter.traceability.core.persistence.TypeType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference list.
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getTypesType_Type()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='type' namespace='##targetNamespace'"
   * @generated
   */
  EList<TypeType> getType();

} // TypesType
