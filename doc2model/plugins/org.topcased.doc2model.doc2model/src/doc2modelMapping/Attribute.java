/**
 * <copyright>
 * </copyright>
 *
 * $Id: Attribute.java,v 1.3 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.Attribute#getAttributeValue <em>Attribute Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getAttribute()
 * @model abstract="true"
 * @generated
 */
public interface Attribute extends DynamicElement
{

    /**
     * Returns the value of the '<em><b>Attribute Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attribute Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Attribute Value</em>' attribute.
     * @see #setAttributeValue(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getAttribute_AttributeValue()
     * @model
     * @generated
     */
    String getAttributeValue();

    /**
     * Sets the value of the '{@link doc2modelMapping.Attribute#getAttributeValue <em>Attribute Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Attribute Value</em>' attribute.
     * @see #getAttributeValue()
     * @generated
     */
    void setAttributeValue(String value);

} // Attribute
