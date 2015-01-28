/**
 * <copyright>
 * </copyright>
 *
 * $Id: InstanceCreationInjection.java,v 1.1 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Creation Injection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.InstanceCreationInjection#getSpecificNamespaceURI <em>Specific Namespace URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getInstanceCreationInjection()
 * @model abstract="true"
 * @generated
 */
public interface InstanceCreationInjection extends EObject
{
    /**
     * Returns the value of the '<em><b>Specific Namespace URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Specific Namespace URI</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Specific Namespace URI</em>' attribute.
     * @see #setSpecificNamespaceURI(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getInstanceCreationInjection_SpecificNamespaceURI()
     * @model
     * @generated
     */
    String getSpecificNamespaceURI();

    /**
     * Sets the value of the '{@link doc2modelMapping.InstanceCreationInjection#getSpecificNamespaceURI <em>Specific Namespace URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Specific Namespace URI</em>' attribute.
     * @see #getSpecificNamespaceURI()
     * @generated
     */
    void setSpecificNamespaceURI(String value);

} // InstanceCreationInjection
