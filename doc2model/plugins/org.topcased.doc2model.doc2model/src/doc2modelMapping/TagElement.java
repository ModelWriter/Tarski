/**
 * <copyright>
 * </copyright>
 *
 * $Id: TagElement.java,v 1.3 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.TagElement#isSingleLine <em>Single Line</em>}</li>
 *   <li>{@link doc2modelMapping.TagElement#getTagValue <em>Tag Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getTagElement()
 * @model
 * @generated
 */
public interface TagElement extends LinkedElement
{
    /**
     * Returns the value of the '<em><b>Single Line</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Single Line</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Single Line</em>' attribute.
     * @see #setSingleLine(boolean)
     * @see doc2modelMapping.Doc2modelMappingPackage#getTagElement_SingleLine()
     * @model default="true"
     * @generated
     */
    boolean isSingleLine();

    /**
     * Sets the value of the '{@link doc2modelMapping.TagElement#isSingleLine <em>Single Line</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Single Line</em>' attribute.
     * @see #isSingleLine()
     * @generated
     */
    void setSingleLine(boolean value);

    /**
     * Returns the value of the '<em><b>Tag Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tag Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tag Value</em>' attribute.
     * @see #setTagValue(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getTagElement_TagValue()
     * @model
     * @generated
     */
    String getTagValue();

    /**
     * Sets the value of the '{@link doc2modelMapping.TagElement#getTagValue <em>Tag Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tag Value</em>' attribute.
     * @see #getTagValue()
     * @generated
     */
    void setTagValue(String value);

} // TagElement
