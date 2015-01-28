/**
 * <copyright>
 * </copyright>
 *
 * $Id: DependantInjection.java,v 1.3 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependant Injection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.DependantInjection#getDependsWith <em>Depends With</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getDependantInjection()
 * @model abstract="true"
 * @generated
 */
public interface DependantInjection extends InjectionElement
{
    /**
     * Returns the value of the '<em><b>Depends With</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Depends With</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Depends With</em>' reference.
     * @see #setDependsWith(ElementCreationInjection)
     * @see doc2modelMapping.Doc2modelMappingPackage#getDependantInjection_DependsWith()
     * @model
     * @generated
     */
    ElementCreationInjection getDependsWith();

    /**
     * Sets the value of the '{@link doc2modelMapping.DependantInjection#getDependsWith <em>Depends With</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Depends With</em>' reference.
     * @see #getDependsWith()
     * @generated
     */
    void setDependsWith(ElementCreationInjection value);

} // DependantInjection
