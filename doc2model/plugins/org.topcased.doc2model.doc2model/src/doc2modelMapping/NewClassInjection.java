/**
 * <copyright>
 * </copyright>
 *
 * $Id: NewClassInjection.java,v 1.4 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Class Injection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.NewClassInjection#getInstanceTarget <em>Instance Target</em>}</li>
 *   <li>{@link doc2modelMapping.NewClassInjection#getOwningClass <em>Owning Class</em>}</li>
 *   <li>{@link doc2modelMapping.NewClassInjection#getAssociationOwning <em>Association Owning</em>}</li>
 *   <li>{@link doc2modelMapping.NewClassInjection#getAttributeForValue <em>Attribute For Value</em>}</li>
 *   <li>{@link doc2modelMapping.NewClassInjection#getStereotypeAttributeForValue <em>Stereotype Attribute For Value</em>}</li>
 *   <li>{@link doc2modelMapping.NewClassInjection#isBrowseTopContainersForOwner <em>Browse Top Containers For Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getNewClassInjection()
 * @model
 * @generated
 */
public interface NewClassInjection extends INewClassInjection, StereotpyeApplicableInjection, InstanceCreationInjection, ElementCreationInjection
{
    /**
     * Returns the value of the '<em><b>Instance Target</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Instance Target</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Instance Target</em>' attribute.
     * @see #setInstanceTarget(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getNewClassInjection_InstanceTarget()
     * @model
     * @generated
     */
    String getInstanceTarget();

    /**
     * Sets the value of the '{@link doc2modelMapping.NewClassInjection#getInstanceTarget <em>Instance Target</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Instance Target</em>' attribute.
     * @see #getInstanceTarget()
     * @generated
     */
    void setInstanceTarget(String value);

    /**
     * Returns the value of the '<em><b>Owning Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owning Class</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Owning Class</em>' attribute.
     * @see #setOwningClass(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getNewClassInjection_OwningClass()
     * @model
     * @generated
     */
    String getOwningClass();

    /**
     * Sets the value of the '{@link doc2modelMapping.NewClassInjection#getOwningClass <em>Owning Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owning Class</em>' attribute.
     * @see #getOwningClass()
     * @generated
     */
    void setOwningClass(String value);

    /**
     * Returns the value of the '<em><b>Association Owning</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Association Owning</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Association Owning</em>' attribute.
     * @see #setAssociationOwning(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getNewClassInjection_AssociationOwning()
     * @model
     * @generated
     */
    String getAssociationOwning();

    /**
     * Sets the value of the '{@link doc2modelMapping.NewClassInjection#getAssociationOwning <em>Association Owning</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Association Owning</em>' attribute.
     * @see #getAssociationOwning()
     * @generated
     */
    void setAssociationOwning(String value);

    /**
     * Returns the value of the '<em><b>Attribute For Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attribute For Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Attribute For Value</em>' attribute.
     * @see #setAttributeForValue(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getNewClassInjection_AttributeForValue()
     * @model
     * @generated
     */
    String getAttributeForValue();

    /**
     * Sets the value of the '{@link doc2modelMapping.NewClassInjection#getAttributeForValue <em>Attribute For Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Attribute For Value</em>' attribute.
     * @see #getAttributeForValue()
     * @generated
     */
    void setAttributeForValue(String value);

    /**
     * Returns the value of the '<em><b>Stereotype Attribute For Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Stereotype Attribute For Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Stereotype Attribute For Value</em>' attribute.
     * @see #setStereotypeAttributeForValue(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getNewClassInjection_StereotypeAttributeForValue()
     * @model
     * @generated
     */
    String getStereotypeAttributeForValue();

    /**
     * Sets the value of the '{@link doc2modelMapping.NewClassInjection#getStereotypeAttributeForValue <em>Stereotype Attribute For Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Stereotype Attribute For Value</em>' attribute.
     * @see #getStereotypeAttributeForValue()
     * @generated
     */
    void setStereotypeAttributeForValue(String value);

    /**
     * Returns the value of the '<em><b>Browse Top Containers For Owner</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Browse Top Containers For Owner</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Browse Top Containers For Owner</em>' attribute.
     * @see #setBrowseTopContainersForOwner(boolean)
     * @see doc2modelMapping.Doc2modelMappingPackage#getNewClassInjection_BrowseTopContainersForOwner()
     * @model default="false"
     * @generated
     */
    boolean isBrowseTopContainersForOwner();

    /**
     * Sets the value of the '{@link doc2modelMapping.NewClassInjection#isBrowseTopContainersForOwner <em>Browse Top Containers For Owner</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Browse Top Containers For Owner</em>' attribute.
     * @see #isBrowseTopContainersForOwner()
     * @generated
     */
    void setBrowseTopContainersForOwner(boolean value);

} // NewClassInjection
