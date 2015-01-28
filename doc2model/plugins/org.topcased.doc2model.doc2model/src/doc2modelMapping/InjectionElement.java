/**
 * <copyright>
 * </copyright>
 *
 * $Id: InjectionElement.java,v 1.3 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Injection Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.InjectionElement#getStringFormat <em>String Format</em>}</li>
 *   <li>{@link doc2modelMapping.InjectionElement#getStandardOptionalInjections <em>Standard Optional Injections</em>}</li>
 *   <li>{@link doc2modelMapping.InjectionElement#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getInjectionElement()
 * @model abstract="true"
 * @generated
 */
public interface InjectionElement extends EObject
{

    /**
     * Returns the value of the '<em><b>String Format</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>String Format</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>String Format</em>' containment reference.
     * @see #setStringFormat(TextFormatter)
     * @see doc2modelMapping.Doc2modelMappingPackage#getInjectionElement_StringFormat()
     * @model containment="true"
     * @generated
     */
    TextFormatter getStringFormat();

    /**
     * Sets the value of the '{@link doc2modelMapping.InjectionElement#getStringFormat <em>String Format</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>String Format</em>' containment reference.
     * @see #getStringFormat()
     * @generated
     */
    void setStringFormat(TextFormatter value);

    /**
     * Returns the value of the '<em><b>Standard Optional Injections</b></em>' containment reference list.
     * The list contents are of type {@link doc2modelMapping.InjectionElement}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Standard Optional Injections</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Standard Optional Injections</em>' containment reference list.
     * @see doc2modelMapping.Doc2modelMappingPackage#getInjectionElement_StandardOptionalInjections()
     * @model containment="true"
     * @generated
     */
    EList<InjectionElement> getStandardOptionalInjections();

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * The default value is <code>"noname"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getInjectionElement_Name()
     * @model default="noname"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link doc2modelMapping.InjectionElement#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);
} // InjectionElement
