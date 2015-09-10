/**
 */
package eu.modelwriter.traceability.core.persistence;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.RelationType#getTuple <em>Tuple</em>}</li>
 * </ul>
 *
 * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getRelationType()
 * @model extendedMetaData="name='relation_._type' kind='elementOnly'"
 * @generated
 */
public interface RelationType extends EObject {
  /**
   * Returns the value of the '<em><b>Tuple</b></em>' containment reference list.
   * The list contents are of type {@link eu.modelwriter.traceability.core.persistence.TupleType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tuple</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tuple</em>' containment reference list.
   * @see eu.modelwriter.traceability.core.persistence.persistencePackage#getRelationType_Tuple()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='tuple' namespace='##targetNamespace'"
   * @generated
   */
  EList<TupleType> getTuple();

} // RelationType
