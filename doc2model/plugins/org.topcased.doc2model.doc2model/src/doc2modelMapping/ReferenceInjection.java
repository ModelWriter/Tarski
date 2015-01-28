/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReferenceInjection.java,v 1.5 2009/05/18 07:47:02 tfaure Exp $
 */
package doc2modelMapping;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Injection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.ReferenceInjection#getAttributeToFind <em>Attribute To Find</em>}</li>
 *   <li>{@link doc2modelMapping.ReferenceInjection#getClassReferenced <em>Class Referenced</em>}</li>
 *   <li>{@link doc2modelMapping.ReferenceInjection#getReferenceAttribute <em>Reference Attribute</em>}</li>
 *   <li>{@link doc2modelMapping.ReferenceInjection#isIsStereotypeReference <em>Is Stereotype Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getReferenceInjection()
 * @model
 * @generated
 */
public interface ReferenceInjection extends DependantInjection
{
    /**
     * Returns the value of the '<em><b>Attribute To Find</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attribute To Find</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Attribute To Find</em>' attribute.
     * @see #setAttributeToFind(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getReferenceInjection_AttributeToFind()
     * @model
     * @generated
     */
    String getAttributeToFind();

    /**
     * Sets the value of the '{@link doc2modelMapping.ReferenceInjection#getAttributeToFind <em>Attribute To Find</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Attribute To Find</em>' attribute.
     * @see #getAttributeToFind()
     * @generated
     */
    void setAttributeToFind(String value);

    /**
     * Returns the value of the '<em><b>Class Referenced</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Class Referenced</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Class Referenced</em>' attribute.
     * @see #setClassReferenced(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getReferenceInjection_ClassReferenced()
     * @model
     * @generated
     */
    String getClassReferenced();

    /**
     * Sets the value of the '{@link doc2modelMapping.ReferenceInjection#getClassReferenced <em>Class Referenced</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Class Referenced</em>' attribute.
     * @see #getClassReferenced()
     * @generated
     */
    void setClassReferenced(String value);

    /**
     * Returns the value of the '<em><b>Reference Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reference Attribute</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reference Attribute</em>' attribute.
     * @see #setReferenceAttribute(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getReferenceInjection_ReferenceAttribute()
     * @model
     * @generated
     */
    String getReferenceAttribute();

    /**
     * Sets the value of the '{@link doc2modelMapping.ReferenceInjection#getReferenceAttribute <em>Reference Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reference Attribute</em>' attribute.
     * @see #getReferenceAttribute()
     * @generated
     */
    void setReferenceAttribute(String value);

    /**
     * Returns the value of the '<em><b>Is Stereotype Reference</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Stereotype Reference</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Is Stereotype Reference</em>' attribute.
     * @see #setIsStereotypeReference(boolean)
     * @see doc2modelMapping.Doc2modelMappingPackage#getReferenceInjection_IsStereotypeReference()
     * @model default="false"
     * @generated
     */
    boolean isIsStereotypeReference();

    /**
     * Sets the value of the '{@link doc2modelMapping.ReferenceInjection#isIsStereotypeReference <em>Is Stereotype Reference</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Stereotype Reference</em>' attribute.
     * @see #isIsStereotypeReference()
     * @generated
     */
    void setIsStereotypeReference(boolean value);

} // ReferenceInjection
