/**
 * <copyright>
 * </copyright>
 *
 * $Id: Hierarchy.java,v 1.4 2009/05/15 13:13:32 tfaure Exp $
 */
package doc2modelMapping;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hierarchy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.Hierarchy#getLevel <em>Level</em>}</li>
 *   <li>{@link doc2modelMapping.Hierarchy#getSubHierarchy <em>Sub Hierarchy</em>}</li>
 *   <li>{@link doc2modelMapping.Hierarchy#getStyleValue <em>Style Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getHierarchy()
 * @model
 * @generated
 */
public interface Hierarchy extends DynamicElement
{
    /**
     * Returns the value of the '<em><b>Level</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Level</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Level</em>' attribute.
     * @see #setLevel(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getHierarchy_Level()
     * @model
     * @generated
     */
    String getLevel();

    /**
     * Sets the value of the '{@link doc2modelMapping.Hierarchy#getLevel <em>Level</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Level</em>' attribute.
     * @see #getLevel()
     * @generated
     */
    void setLevel(String value);

    /**
     * Returns the value of the '<em><b>Sub Hierarchy</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sub Hierarchy</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sub Hierarchy</em>' containment reference.
     * @see #setSubHierarchy(Hierarchy)
     * @see doc2modelMapping.Doc2modelMappingPackage#getHierarchy_SubHierarchy()
     * @model containment="true"
     * @generated
     */
    Hierarchy getSubHierarchy();

    /**
     * Sets the value of the '{@link doc2modelMapping.Hierarchy#getSubHierarchy <em>Sub Hierarchy</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sub Hierarchy</em>' containment reference.
     * @see #getSubHierarchy()
     * @generated
     */
    void setSubHierarchy(Hierarchy value);

    /**
     * Returns the value of the '<em><b>Style Value</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Style Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Style Value</em>' attribute list.
     * @see doc2modelMapping.Doc2modelMappingPackage#getHierarchy_StyleValue()
     * @model
     * @generated
     */
    EList<String> getStyleValue();

} // Hierarchy
