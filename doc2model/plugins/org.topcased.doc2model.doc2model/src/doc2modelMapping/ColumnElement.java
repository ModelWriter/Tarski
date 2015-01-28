/**
 * <copyright>
 * </copyright>
 *
 * $Id: ColumnElement.java,v 1.1 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.ColumnElement#getNumColumn <em>Num Column</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getColumnElement()
 * @model abstract="true"
 * @generated
 */
public interface ColumnElement extends RegExMatchingElement
{
    /**
     * Returns the value of the '<em><b>Num Column</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Num Column</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Num Column</em>' attribute.
     * @see #setNumColumn(int)
     * @see doc2modelMapping.Doc2modelMappingPackage#getColumnElement_NumColumn()
     * @model
     * @generated
     */
    int getNumColumn();

    /**
     * Sets the value of the '{@link doc2modelMapping.ColumnElement#getNumColumn <em>Num Column</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Num Column</em>' attribute.
     * @see #getNumColumn()
     * @generated
     */
    void setNumColumn(int value);

} // ColumnElement
