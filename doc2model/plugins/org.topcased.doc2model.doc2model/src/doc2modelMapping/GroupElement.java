/**
 * <copyright>
 * </copyright>
 *
 * $Id: GroupElement.java,v 1.1 2009/05/15 13:13:32 tfaure Exp $
 */
package doc2modelMapping;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.GroupElement#getSecondaryInjectionsForGroups <em>Secondary Injections For Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getGroupElement()
 * @model abstract="true"
 * @generated
 */
public interface GroupElement extends EObject
{
    /**
     * Returns the value of the '<em><b>Secondary Injections For Groups</b></em>' containment reference list.
     * The list contents are of type {@link doc2modelMapping.DependantInjection}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Secondary Injections For Groups</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Secondary Injections For Groups</em>' containment reference list.
     * @see doc2modelMapping.Doc2modelMappingPackage#getGroupElement_SecondaryInjectionsForGroups()
     * @model containment="true"
     * @generated
     */
    EList<DependantInjection> getSecondaryInjectionsForGroups();

} // GroupElement
