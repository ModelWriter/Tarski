/**
 * <copyright>
 * </copyright>
 *
 * $Id: AttributeInjection.java,v 1.4 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Injection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.AttributeInjection#getInstanceAttribute <em>Instance Attribute</em>}</li>
 *   <li>{@link doc2modelMapping.AttributeInjection#getStereotypeAttribute <em>Stereotype Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getAttributeInjection()
 * @model
 * @generated
 */
public interface AttributeInjection extends DependantInjection
{
    /**
     * Returns the value of the '<em><b>Instance Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Instance Attribute</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Instance Attribute</em>' attribute.
     * @see #setInstanceAttribute(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getAttributeInjection_InstanceAttribute()
     * @model
     * @generated
     */
    String getInstanceAttribute();

    /**
     * Sets the value of the '{@link doc2modelMapping.AttributeInjection#getInstanceAttribute <em>Instance Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Instance Attribute</em>' attribute.
     * @see #getInstanceAttribute()
     * @generated
     */
    void setInstanceAttribute(String value);

    /**
     * Returns the value of the '<em><b>Stereotype Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Stereotype Attribute</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Stereotype Attribute</em>' attribute.
     * @see #setStereotypeAttribute(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getAttributeInjection_StereotypeAttribute()
     * @model
     * @generated
     */
    String getStereotypeAttribute();

    /**
     * Sets the value of the '{@link doc2modelMapping.AttributeInjection#getStereotypeAttribute <em>Stereotype Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Stereotype Attribute</em>' attribute.
     * @see #getStereotypeAttribute()
     * @generated
     */
    void setStereotypeAttribute(String value);

} // AttributeInjection
