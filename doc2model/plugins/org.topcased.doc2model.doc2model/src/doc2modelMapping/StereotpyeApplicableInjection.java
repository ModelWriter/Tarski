/**
 * <copyright>
 * </copyright>
 *
 * $Id: StereotpyeApplicableInjection.java,v 1.2 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotpye Applicable Injection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.StereotpyeApplicableInjection#getStereotypeToApply <em>Stereotype To Apply</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getStereotpyeApplicableInjection()
 * @model abstract="true"
 * @generated
 */
public interface StereotpyeApplicableInjection extends EObject
{
    /**
     * Returns the value of the '<em><b>Stereotype To Apply</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Stereotype To Apply</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Stereotype To Apply</em>' attribute.
     * @see #setStereotypeToApply(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getStereotpyeApplicableInjection_StereotypeToApply()
     * @model
     * @generated
     */
    String getStereotypeToApply();

    /**
     * Sets the value of the '{@link doc2modelMapping.StereotpyeApplicableInjection#getStereotypeToApply <em>Stereotype To Apply</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Stereotype To Apply</em>' attribute.
     * @see #getStereotypeToApply()
     * @generated
     */
    void setStereotypeToApply(String value);

} // StereotpyeApplicableInjection
