/**
 * <copyright>
 * </copyright>
 *
 * $Id: doc2model.java,v 1.4 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>doc2model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link doc2modelMapping.doc2model#getLinks <em>Links</em>}</li>
 *   <li>{@link doc2modelMapping.doc2model#getHierarchy <em>Hierarchy</em>}</li>
 *   <li>{@link doc2modelMapping.doc2model#getExtension <em>Extension</em>}</li>
 *   <li>{@link doc2modelMapping.doc2model#getMetamodelURI <em>Metamodel URI</em>}</li>
 *   <li>{@link doc2modelMapping.doc2model#getProfileURI <em>Profile URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see doc2modelMapping.Doc2modelMappingPackage#getdoc2model()
 * @model
 * @generated
 */
public interface doc2model extends DynamicElement
{
    /**
     * Returns the value of the '<em><b>Links</b></em>' containment reference list.
     * The list contents are of type {@link doc2modelMapping.LinkedElement}.
     * It is bidirectional and its opposite is '{@link doc2modelMapping.LinkedElement#getOwner <em>Owner</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Links</em>' containment reference list.
     * @see doc2modelMapping.Doc2modelMappingPackage#getdoc2model_Links()
     * @see doc2modelMapping.LinkedElement#getOwner
     * @model opposite="owner" containment="true"
     * @generated
     */
    EList<LinkedElement> getLinks();

    /**
     * Returns the value of the '<em><b>Hierarchy</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hierarchy</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hierarchy</em>' containment reference.
     * @see #setHierarchy(Hierarchy)
     * @see doc2modelMapping.Doc2modelMappingPackage#getdoc2model_Hierarchy()
     * @model containment="true"
     * @generated
     */
    Hierarchy getHierarchy();

    /**
     * Sets the value of the '{@link doc2modelMapping.doc2model#getHierarchy <em>Hierarchy</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Hierarchy</em>' containment reference.
     * @see #getHierarchy()
     * @generated
     */
    void setHierarchy(Hierarchy value);

    /**
     * Returns the value of the '<em><b>Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Extension</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Extension</em>' attribute.
     * @see #setExtension(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getdoc2model_Extension()
     * @model
     * @generated
     */
    String getExtension();

    /**
     * Sets the value of the '{@link doc2modelMapping.doc2model#getExtension <em>Extension</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Extension</em>' attribute.
     * @see #getExtension()
     * @generated
     */
    void setExtension(String value);

    /**
     * Returns the value of the '<em><b>Metamodel URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Metamodel URI</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Metamodel URI</em>' attribute.
     * @see #setMetamodelURI(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getdoc2model_MetamodelURI()
     * @model
     * @generated
     */
    String getMetamodelURI();

    /**
     * Sets the value of the '{@link doc2modelMapping.doc2model#getMetamodelURI <em>Metamodel URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Metamodel URI</em>' attribute.
     * @see #getMetamodelURI()
     * @generated
     */
    void setMetamodelURI(String value);

    /**
     * Returns the value of the '<em><b>Profile URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Profile URI</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Profile URI</em>' attribute.
     * @see #setProfileURI(String)
     * @see doc2modelMapping.Doc2modelMappingPackage#getdoc2model_ProfileURI()
     * @model
     * @generated
     */
    String getProfileURI();

    /**
     * Sets the value of the '{@link doc2modelMapping.doc2model#getProfileURI <em>Profile URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Profile URI</em>' attribute.
     * @see #getProfileURI()
     * @generated
     */
    void setProfileURI(String value);

} // doc2model
