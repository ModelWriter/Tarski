/**
 * <copyright>
 * </copyright>
 *
 * $Id: LinkedElement.java,v 1.3 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Linked Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.LinkedElement#getOwner <em>Owner</em>}</li>
 *   <li>{@link doc2modelMapping.LinkedElement#getMax <em>Max</em>}</li>
 *   <li>{@link doc2modelMapping.LinkedElement#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getLinkedElement()
 * @model abstract="true"
 * @generated
 */
public interface LinkedElement extends DynamicElement
{
    /**
     * Returns the value of the '<em><b>Owner</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link doc2modelMapping.doc2model#getLinks <em>Links</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owner</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Owner</em>' container reference.
     * @see #setOwner(doc2model)
     * @see doc2modelMapping.Doc2modelMappingPackage#getLinkedElement_Owner()
     * @see doc2modelMapping.doc2model#getLinks
     * @model opposite="links" transient="false"
     * @generated
     */
    doc2model getOwner();

    /**
     * Sets the value of the '{@link doc2modelMapping.LinkedElement#getOwner <em>Owner</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owner</em>' container reference.
     * @see #getOwner()
     * @generated
     */
    void setOwner(doc2model value);

    /**
     * Returns the value of the '<em><b>Max</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Max</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Max</em>' reference.
     * @see #setMax(Hierarchy)
     * @see doc2modelMapping.Doc2modelMappingPackage#getLinkedElement_Max()
     * @model
     * @generated
     */
    Hierarchy getMax();

    /**
     * Sets the value of the '{@link doc2modelMapping.LinkedElement#getMax <em>Max</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Max</em>' reference.
     * @see #getMax()
     * @generated
     */
    void setMax(Hierarchy value);

    /**
     * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
     * The list contents are of type {@link doc2modelMapping.Attribute}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Attributes</em>' containment reference list.
     * @see doc2modelMapping.Doc2modelMappingPackage#getLinkedElement_Attributes()
     * @model containment="true"
     * @generated
     */
    EList<Attribute> getAttributes();

} // LinkedElement
