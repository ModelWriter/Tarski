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
 *   <li>{@link eu.modelwriter.traceability.core.persistence.RepositoryType#getItem <em>Item</em>}</li>
 * </ul>
 *
 * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getRepositoryType()
 * @model extendedMetaData="name='repository_._type' kind='elementOnly'"
 * @generated
 */
public interface RepositoryType extends EObject {
  /**
   * Returns the value of the '<em><b>Item</b></em>' containment reference list.
   * The list contents are of type {@link eu.modelwriter.traceability.core.persistence.ItemType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Item</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Item</em>' containment reference list.
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getRepositoryType_Item()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='item' namespace='##targetNamespace'"
   * @generated
   */
  EList<ItemType> getItem();

} // RepositoryType
