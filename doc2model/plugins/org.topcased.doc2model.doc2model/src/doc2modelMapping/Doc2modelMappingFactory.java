/**
 * <copyright>
 * </copyright>
 *
 * $Id: Doc2modelMappingFactory.java,v 1.4 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see doc2modelMapping.Doc2modelMappingPackage
 * @generated
 */
public interface Doc2modelMappingFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    Doc2modelMappingFactory eINSTANCE = doc2modelMapping.impl.Doc2modelMappingFactoryImpl.init();

    /**
     * Returns a new object of class '<em>doc2model</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>doc2model</em>'.
     * @generated
     */
    doc2model createdoc2model();

    /**
     * Returns a new object of class '<em>Doc Style</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Doc Style</em>'.
     * @generated
     */
    DocStyle createDocStyle();

    /**
     * Returns a new object of class '<em>Hierarchy</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Hierarchy</em>'.
     * @generated
     */
    Hierarchy createHierarchy();

    /**
     * Returns a new object of class '<em>Attribute Tag</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Attribute Tag</em>'.
     * @generated
     */
    AttributeTag createAttributeTag();

    /**
     * Returns a new object of class '<em>Tag Element</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Tag Element</em>'.
     * @generated
     */
    TagElement createTagElement();

    /**
     * Returns a new object of class '<em>Tag Attribute</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Tag Attribute</em>'.
     * @generated
     */
    TagAttribute createTagAttribute();

    /**
     * Returns a new object of class '<em>Style Attribute</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Style Attribute</em>'.
     * @generated
     */
    StyleAttribute createStyleAttribute();

    /**
     * Returns a new object of class '<em>New Class Injection</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>New Class Injection</em>'.
     * @generated
     */
    NewClassInjection createNewClassInjection();

    /**
     * Returns a new object of class '<em>Composition Injection</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Composition Injection</em>'.
     * @generated
     */
    CompositionInjection createCompositionInjection();

    /**
     * Returns a new object of class '<em>Attribute Injection</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Attribute Injection</em>'.
     * @generated
     */
    AttributeInjection createAttributeInjection();

    /**
     * Returns a new object of class '<em>Reference Injection</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Reference Injection</em>'.
     * @generated
     */
    ReferenceInjection createReferenceInjection();

    /**
     * Returns a new object of class '<em>Reg Ex Attribute</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Reg Ex Attribute</em>'.
     * @generated
     */
    RegExAttribute createRegExAttribute();

    /**
     * Returns a new object of class '<em>Reg Ex</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Reg Ex</em>'.
     * @generated
     */
    RegEx createRegEx();

    /**
     * Returns a new object of class '<em>New Class Injection Composite</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>New Class Injection Composite</em>'.
     * @generated
     */
    NewClassInjectionComposite createNewClassInjectionComposite();

    /**
     * Returns a new object of class '<em>Column Match Element</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Column Match Element</em>'.
     * @generated
     */
    ColumnMatchElement createColumnMatchElement();

    /**
     * Returns a new object of class '<em>Column Match Attribute</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Column Match Attribute</em>'.
     * @generated
     */
    ColumnMatchAttribute createColumnMatchAttribute();

    /**
     * Returns a new object of class '<em>Text Formatter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Text Formatter</em>'.
     * @generated
     */
    TextFormatter createTextFormatter();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    Doc2modelMappingPackage getDoc2modelMappingPackage();

} //Doc2modelMappingFactory
