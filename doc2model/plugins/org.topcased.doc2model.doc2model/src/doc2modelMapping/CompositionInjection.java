/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompositionInjection.java,v 1.4 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composition Injection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.CompositionInjection#getOwningClass <em>Owning Class</em>}</li>
 *   <li>{@link doc2modelMapping.CompositionInjection#getAssociationName <em>Association Name</em>}</li>
 *   <li>{@link doc2modelMapping.CompositionInjection#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link doc2modelMapping.CompositionInjection#isNewInstanceForEachComposition <em>New Instance For Each Composition</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getCompositionInjection()
 * @model
 * @generated
 */
public interface CompositionInjection extends DependantInjection, StereotpyeApplicableInjection, InstanceCreationInjection, ElementCreationInjection
{
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
     * @see doc2modelMapping.Doc2modelMappingPackage#getCompositionInjection_OwningClass()
     * @model
     * @generated
     */
    String getOwningClass();

    /**
     * Sets the value of the '{@link doc2modelMapping.CompositionInjection#getOwningClass <em>Owning Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owning Class</em>' attribute.
     * @see #getOwningClass()
     * @generated
     */
    void setOwningClass(String value);

    /**
     * Returns the value of the '<em><b>Association Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Association Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Association Name</em>' attribute.
     * @see #setAssociationName(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getCompositionInjection_AssociationName()
     * @model
     * @generated
     */
    String getAssociationName();

    /**
     * Sets the value of the '{@link doc2modelMapping.CompositionInjection#getAssociationName <em>Association Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Association Name</em>' attribute.
     * @see #getAssociationName()
     * @generated
     */
    void setAssociationName(String value);

    /**
     * Returns the value of the '<em><b>Attribute Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attribute Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Attribute Name</em>' attribute.
     * @see #setAttributeName(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getCompositionInjection_AttributeName()
     * @model
     * @generated
     */
    String getAttributeName();

    /**
     * Sets the value of the '{@link doc2modelMapping.CompositionInjection#getAttributeName <em>Attribute Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Attribute Name</em>' attribute.
     * @see #getAttributeName()
     * @generated
     */
    void setAttributeName(String value);

    /**
     * Returns the value of the '<em><b>New Instance For Each Composition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>New Instance For Each Composition</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>New Instance For Each Composition</em>' attribute.
     * @see #setNewInstanceForEachComposition(boolean)
     * @see doc2modelMapping.Doc2modelMappingPackage#getCompositionInjection_NewInstanceForEachComposition()
     * @model
     * @generated
     */
    boolean isNewInstanceForEachComposition();

    /**
     * Sets the value of the '{@link doc2modelMapping.CompositionInjection#isNewInstanceForEachComposition <em>New Instance For Each Composition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>New Instance For Each Composition</em>' attribute.
     * @see #isNewInstanceForEachComposition()
     * @generated
     */
    void setNewInstanceForEachComposition(boolean value);

} // CompositionInjection
