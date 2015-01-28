/**
 * <copyright>
 * </copyright>
 *
 * $Id: DynamicElement.java,v 1.3 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.DynamicElement#getInjection <em>Injection</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getDynamicElement()
 * @model abstract="true"
 * @generated
 */
public interface DynamicElement extends EObject
{
    /**
     * Returns the value of the '<em><b>Injection</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Injection</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Injection</em>' containment reference.
     * @see #setInjection(InjectionElement)
     * @see doc2modelMapping.Doc2modelMappingPackage#getDynamicElement_Injection()
     * @model containment="true" required="true"
     * @generated
     */
    InjectionElement getInjection();

    /**
     * Sets the value of the '{@link doc2modelMapping.DynamicElement#getInjection <em>Injection</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Injection</em>' containment reference.
     * @see #getInjection()
     * @generated
     */
    void setInjection(InjectionElement value);

} // DynamicElement
