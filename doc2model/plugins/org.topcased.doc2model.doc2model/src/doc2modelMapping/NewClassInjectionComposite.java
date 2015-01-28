/**
 * <copyright>
 * </copyright>
 *
 * $Id: NewClassInjectionComposite.java,v 1.2 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Class Injection Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.NewClassInjectionComposite#getInjections <em>Injections</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getNewClassInjectionComposite()
 * @model
 * @generated
 */
public interface NewClassInjectionComposite extends INewClassInjection, ElementCreationInjection
{
    /**
     * Returns the value of the '<em><b>Injections</b></em>' containment reference list.
     * The list contents are of type {@link doc2modelMapping.NewClassInjection}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Injections</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Injections</em>' containment reference list.
     * @see doc2modelMapping.Doc2modelMappingPackage#getNewClassInjectionComposite_Injections()
     * @model containment="true"
     * @generated
     */
    EList<NewClassInjection> getInjections();

} // NewClassInjectionComposite
