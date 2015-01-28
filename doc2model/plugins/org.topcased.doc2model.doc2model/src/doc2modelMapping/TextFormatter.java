/**
 * <copyright>
 * </copyright>
 *
 * $Id: TextFormatter.java,v 1.2 2009/05/18 07:47:02 tfaure Exp $
 */
package doc2modelMapping;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Formatter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.TextFormatter#getPattern <em>Pattern</em>}</li>
 *   <li>{@link doc2modelMapping.TextFormatter#getRegexForConditionOrGroup <em>Regex For Condition Or Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getTextFormatter()
 * @model
 * @generated
 */
public interface TextFormatter extends EObject
{
    /**
     * Returns the value of the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Pattern</em>' attribute.
     * @see #setPattern(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getTextFormatter_Pattern()
     * @model
     * @generated
     */
    String getPattern();

    /**
     * Sets the value of the '{@link doc2modelMapping.TextFormatter#getPattern <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pattern</em>' attribute.
     * @see #getPattern()
     * @generated
     */
    void setPattern(String value);

    /**
     * Returns the value of the '<em><b>Regex For Condition Or Group</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Regex For Condition Or Group</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Regex For Condition Or Group</em>' attribute.
     * @see #setRegexForConditionOrGroup(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getTextFormatter_RegexForConditionOrGroup()
     * @model
     * @generated
     */
    String getRegexForConditionOrGroup();

    /**
     * Sets the value of the '{@link doc2modelMapping.TextFormatter#getRegexForConditionOrGroup <em>Regex For Condition Or Group</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Regex For Condition Or Group</em>' attribute.
     * @see #getRegexForConditionOrGroup()
     * @generated
     */
    void setRegexForConditionOrGroup(String value);

} // TextFormatter
