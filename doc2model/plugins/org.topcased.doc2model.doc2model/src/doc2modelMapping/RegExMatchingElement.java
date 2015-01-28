/**
 * <copyright>
 * </copyright>
 *
 * $Id: RegExMatchingElement.java,v 1.1 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reg Ex Matching Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.RegExMatchingElement#getRegExToMatch <em>Reg Ex To Match</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getRegExMatchingElement()
 * @model abstract="true"
 * @generated
 */
public interface RegExMatchingElement extends EObject
{
    /**
     * Returns the value of the '<em><b>Reg Ex To Match</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reg Ex To Match</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reg Ex To Match</em>' attribute.
     * @see #setRegExToMatch(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getRegExMatchingElement_RegExToMatch()
     * @model
     * @generated
     */
    String getRegExToMatch();

    /**
     * Sets the value of the '{@link doc2modelMapping.RegExMatchingElement#getRegExToMatch <em>Reg Ex To Match</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reg Ex To Match</em>' attribute.
     * @see #getRegExToMatch()
     * @generated
     */
    void setRegExToMatch(String value);

} // RegExMatchingElement
