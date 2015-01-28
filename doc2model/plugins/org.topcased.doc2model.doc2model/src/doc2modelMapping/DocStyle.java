/**
 * <copyright>
 * </copyright>
 *
 * $Id: DocStyle.java,v 1.3 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Doc Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.DocStyle#getStyleName <em>Style Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getDocStyle()
 * @model
 * @generated
 */
public interface DocStyle extends LinkedElement
{
    /**
     * Returns the value of the '<em><b>Style Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Style Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Style Name</em>' attribute.
     * @see #setStyleName(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getDocStyle_StyleName()
     * @model
     * @generated
     */
    String getStyleName();

    /**
     * Sets the value of the '{@link doc2modelMapping.DocStyle#getStyleName <em>Style Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Style Name</em>' attribute.
     * @see #getStyleName()
     * @generated
     */
    void setStyleName(String value);

} // DocStyle
