/**
 * <copyright>
 * </copyright>
 *
 * $Id: Doc2modelMappingPackage.java,v 1.6 2009/05/18 07:47:02 tfaure Exp $
 */
package doc2modelMapping;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see doc2modelMapping.Doc2modelMappingFactory
 * @model kind="package"
 * @generated
 */
public interface Doc2modelMappingPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "doc2modelMapping";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.topcased.org/doc2model/doc2modelMapping";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "doc2modelMapping";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    Doc2modelMappingPackage eINSTANCE = doc2modelMapping.impl.Doc2modelMappingPackageImpl.init();

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.DynamicElementImpl <em>Dynamic Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.DynamicElementImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getDynamicElement()
     * @generated
     */
    int DYNAMIC_ELEMENT = 7;

    /**
     * The feature id for the '<em><b>Injection</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DYNAMIC_ELEMENT__INJECTION = 0;

    /**
     * The number of structural features of the '<em>Dynamic Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DYNAMIC_ELEMENT_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.doc2modelImpl <em>doc2model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.doc2modelImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getdoc2model()
     * @generated
     */
    int DOC2MODEL = 0;

    /**
     * The feature id for the '<em><b>Injection</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOC2MODEL__INJECTION = DYNAMIC_ELEMENT__INJECTION;

    /**
     * The feature id for the '<em><b>Links</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOC2MODEL__LINKS = DYNAMIC_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Hierarchy</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOC2MODEL__HIERARCHY = DYNAMIC_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Extension</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOC2MODEL__EXTENSION = DYNAMIC_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Metamodel URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOC2MODEL__METAMODEL_URI = DYNAMIC_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Profile URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOC2MODEL__PROFILE_URI = DYNAMIC_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>doc2model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOC2MODEL_FEATURE_COUNT = DYNAMIC_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.LinkedElementImpl <em>Linked Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.LinkedElementImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getLinkedElement()
     * @generated
     */
    int LINKED_ELEMENT = 1;

    /**
     * The feature id for the '<em><b>Injection</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINKED_ELEMENT__INJECTION = DYNAMIC_ELEMENT__INJECTION;

    /**
     * The feature id for the '<em><b>Owner</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINKED_ELEMENT__OWNER = DYNAMIC_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Max</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINKED_ELEMENT__MAX = DYNAMIC_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINKED_ELEMENT__ATTRIBUTES = DYNAMIC_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Linked Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINKED_ELEMENT_FEATURE_COUNT = DYNAMIC_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.DocStyleImpl <em>Doc Style</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.DocStyleImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getDocStyle()
     * @generated
     */
    int DOC_STYLE = 2;

    /**
     * The feature id for the '<em><b>Injection</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOC_STYLE__INJECTION = LINKED_ELEMENT__INJECTION;

    /**
     * The feature id for the '<em><b>Owner</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOC_STYLE__OWNER = LINKED_ELEMENT__OWNER;

    /**
     * The feature id for the '<em><b>Max</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOC_STYLE__MAX = LINKED_ELEMENT__MAX;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOC_STYLE__ATTRIBUTES = LINKED_ELEMENT__ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Style Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOC_STYLE__STYLE_NAME = LINKED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Doc Style</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOC_STYLE_FEATURE_COUNT = LINKED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.HierarchyImpl <em>Hierarchy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.HierarchyImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getHierarchy()
     * @generated
     */
    int HIERARCHY = 3;

    /**
     * The feature id for the '<em><b>Injection</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIERARCHY__INJECTION = DYNAMIC_ELEMENT__INJECTION;

    /**
     * The feature id for the '<em><b>Level</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIERARCHY__LEVEL = DYNAMIC_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Sub Hierarchy</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIERARCHY__SUB_HIERARCHY = DYNAMIC_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Style Value</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIERARCHY__STYLE_VALUE = DYNAMIC_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Hierarchy</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIERARCHY_FEATURE_COUNT = DYNAMIC_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.AttributeTagImpl <em>Attribute Tag</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.AttributeTagImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getAttributeTag()
     * @generated
     */
    int ATTRIBUTE_TAG = 4;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_TAG__VALUE = 0;

    /**
     * The number of structural features of the '<em>Attribute Tag</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_TAG_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.TagElementImpl <em>Tag Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.TagElementImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getTagElement()
     * @generated
     */
    int TAG_ELEMENT = 5;

    /**
     * The feature id for the '<em><b>Injection</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TAG_ELEMENT__INJECTION = LINKED_ELEMENT__INJECTION;

    /**
     * The feature id for the '<em><b>Owner</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TAG_ELEMENT__OWNER = LINKED_ELEMENT__OWNER;

    /**
     * The feature id for the '<em><b>Max</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TAG_ELEMENT__MAX = LINKED_ELEMENT__MAX;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TAG_ELEMENT__ATTRIBUTES = LINKED_ELEMENT__ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Single Line</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TAG_ELEMENT__SINGLE_LINE = LINKED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Tag Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TAG_ELEMENT__TAG_VALUE = LINKED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Tag Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TAG_ELEMENT_FEATURE_COUNT = LINKED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.TagAttributeImpl <em>Tag Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.TagAttributeImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getTagAttribute()
     * @generated
     */
    int TAG_ATTRIBUTE = 6;

    /**
     * The feature id for the '<em><b>Injection</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TAG_ATTRIBUTE__INJECTION = DYNAMIC_ELEMENT__INJECTION;

    /**
     * The feature id for the '<em><b>Attribute Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TAG_ATTRIBUTE__ATTRIBUTE_VALUE = DYNAMIC_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Tag Attribute</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TAG_ATTRIBUTE_FEATURE_COUNT = DYNAMIC_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.AttributeImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getAttribute()
     * @generated
     */
    int ATTRIBUTE = 9;

    /**
     * The feature id for the '<em><b>Injection</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE__INJECTION = DYNAMIC_ELEMENT__INJECTION;

    /**
     * The feature id for the '<em><b>Attribute Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE__ATTRIBUTE_VALUE = DYNAMIC_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Attribute</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_FEATURE_COUNT = DYNAMIC_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.StyleAttributeImpl <em>Style Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.StyleAttributeImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getStyleAttribute()
     * @generated
     */
    int STYLE_ATTRIBUTE = 8;

    /**
     * The feature id for the '<em><b>Injection</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STYLE_ATTRIBUTE__INJECTION = ATTRIBUTE__INJECTION;

    /**
     * The feature id for the '<em><b>Attribute Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STYLE_ATTRIBUTE__ATTRIBUTE_VALUE = ATTRIBUTE__ATTRIBUTE_VALUE;

    /**
     * The number of structural features of the '<em>Style Attribute</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STYLE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.InjectionElementImpl <em>Injection Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.InjectionElementImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getInjectionElement()
     * @generated
     */
    int INJECTION_ELEMENT = 10;

    /**
     * The feature id for the '<em><b>String Format</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INJECTION_ELEMENT__STRING_FORMAT = 0;

    /**
     * The feature id for the '<em><b>Standard Optional Injections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INJECTION_ELEMENT__NAME = 2;

    /**
     * The number of structural features of the '<em>Injection Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INJECTION_ELEMENT_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.INewClassInjectionImpl <em>INew Class Injection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.INewClassInjectionImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getINewClassInjection()
     * @generated
     */
    int INEW_CLASS_INJECTION = 19;

    /**
     * The feature id for the '<em><b>String Format</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INEW_CLASS_INJECTION__STRING_FORMAT = INJECTION_ELEMENT__STRING_FORMAT;

    /**
     * The feature id for the '<em><b>Standard Optional Injections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INEW_CLASS_INJECTION__STANDARD_OPTIONAL_INJECTIONS = INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INEW_CLASS_INJECTION__NAME = INJECTION_ELEMENT__NAME;

    /**
     * The number of structural features of the '<em>INew Class Injection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INEW_CLASS_INJECTION_FEATURE_COUNT = INJECTION_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.NewClassInjectionImpl <em>New Class Injection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.NewClassInjectionImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getNewClassInjection()
     * @generated
     */
    int NEW_CLASS_INJECTION = 11;

    /**
     * The feature id for the '<em><b>String Format</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION__STRING_FORMAT = INEW_CLASS_INJECTION__STRING_FORMAT;

    /**
     * The feature id for the '<em><b>Standard Optional Injections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION__STANDARD_OPTIONAL_INJECTIONS = INEW_CLASS_INJECTION__STANDARD_OPTIONAL_INJECTIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION__NAME = INEW_CLASS_INJECTION__NAME;

    /**
     * The feature id for the '<em><b>Stereotype To Apply</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION__STEREOTYPE_TO_APPLY = INEW_CLASS_INJECTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Specific Namespace URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION__SPECIFIC_NAMESPACE_URI = INEW_CLASS_INJECTION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Instance Target</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION__INSTANCE_TARGET = INEW_CLASS_INJECTION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Owning Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION__OWNING_CLASS = INEW_CLASS_INJECTION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Association Owning</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION__ASSOCIATION_OWNING = INEW_CLASS_INJECTION_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Attribute For Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION__ATTRIBUTE_FOR_VALUE = INEW_CLASS_INJECTION_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Stereotype Attribute For Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION__STEREOTYPE_ATTRIBUTE_FOR_VALUE = INEW_CLASS_INJECTION_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Browse Top Containers For Owner</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION__BROWSE_TOP_CONTAINERS_FOR_OWNER = INEW_CLASS_INJECTION_FEATURE_COUNT + 7;

    /**
     * The number of structural features of the '<em>New Class Injection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION_FEATURE_COUNT = INEW_CLASS_INJECTION_FEATURE_COUNT + 8;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.DependantInjectionImpl <em>Dependant Injection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.DependantInjectionImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getDependantInjection()
     * @generated
     */
    int DEPENDANT_INJECTION = 14;

    /**
     * The feature id for the '<em><b>String Format</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPENDANT_INJECTION__STRING_FORMAT = INJECTION_ELEMENT__STRING_FORMAT;

    /**
     * The feature id for the '<em><b>Standard Optional Injections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPENDANT_INJECTION__STANDARD_OPTIONAL_INJECTIONS = INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPENDANT_INJECTION__NAME = INJECTION_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Depends With</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPENDANT_INJECTION__DEPENDS_WITH = INJECTION_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Dependant Injection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPENDANT_INJECTION_FEATURE_COUNT = INJECTION_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.CompositionInjectionImpl <em>Composition Injection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.CompositionInjectionImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getCompositionInjection()
     * @generated
     */
    int COMPOSITION_INJECTION = 12;

    /**
     * The feature id for the '<em><b>String Format</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITION_INJECTION__STRING_FORMAT = DEPENDANT_INJECTION__STRING_FORMAT;

    /**
     * The feature id for the '<em><b>Standard Optional Injections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITION_INJECTION__STANDARD_OPTIONAL_INJECTIONS = DEPENDANT_INJECTION__STANDARD_OPTIONAL_INJECTIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITION_INJECTION__NAME = DEPENDANT_INJECTION__NAME;

    /**
     * The feature id for the '<em><b>Depends With</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITION_INJECTION__DEPENDS_WITH = DEPENDANT_INJECTION__DEPENDS_WITH;

    /**
     * The feature id for the '<em><b>Stereotype To Apply</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITION_INJECTION__STEREOTYPE_TO_APPLY = DEPENDANT_INJECTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Specific Namespace URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITION_INJECTION__SPECIFIC_NAMESPACE_URI = DEPENDANT_INJECTION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Owning Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITION_INJECTION__OWNING_CLASS = DEPENDANT_INJECTION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Association Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITION_INJECTION__ASSOCIATION_NAME = DEPENDANT_INJECTION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITION_INJECTION__ATTRIBUTE_NAME = DEPENDANT_INJECTION_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>New Instance For Each Composition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITION_INJECTION__NEW_INSTANCE_FOR_EACH_COMPOSITION = DEPENDANT_INJECTION_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Composition Injection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITION_INJECTION_FEATURE_COUNT = DEPENDANT_INJECTION_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.AttributeInjectionImpl <em>Attribute Injection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.AttributeInjectionImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getAttributeInjection()
     * @generated
     */
    int ATTRIBUTE_INJECTION = 13;

    /**
     * The feature id for the '<em><b>String Format</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_INJECTION__STRING_FORMAT = DEPENDANT_INJECTION__STRING_FORMAT;

    /**
     * The feature id for the '<em><b>Standard Optional Injections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_INJECTION__STANDARD_OPTIONAL_INJECTIONS = DEPENDANT_INJECTION__STANDARD_OPTIONAL_INJECTIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_INJECTION__NAME = DEPENDANT_INJECTION__NAME;

    /**
     * The feature id for the '<em><b>Depends With</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_INJECTION__DEPENDS_WITH = DEPENDANT_INJECTION__DEPENDS_WITH;

    /**
     * The feature id for the '<em><b>Instance Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_INJECTION__INSTANCE_ATTRIBUTE = DEPENDANT_INJECTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Stereotype Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_INJECTION__STEREOTYPE_ATTRIBUTE = DEPENDANT_INJECTION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Attribute Injection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_INJECTION_FEATURE_COUNT = DEPENDANT_INJECTION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.ReferenceInjectionImpl <em>Reference Injection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.ReferenceInjectionImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getReferenceInjection()
     * @generated
     */
    int REFERENCE_INJECTION = 15;

    /**
     * The feature id for the '<em><b>String Format</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_INJECTION__STRING_FORMAT = DEPENDANT_INJECTION__STRING_FORMAT;

    /**
     * The feature id for the '<em><b>Standard Optional Injections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_INJECTION__STANDARD_OPTIONAL_INJECTIONS = DEPENDANT_INJECTION__STANDARD_OPTIONAL_INJECTIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_INJECTION__NAME = DEPENDANT_INJECTION__NAME;

    /**
     * The feature id for the '<em><b>Depends With</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_INJECTION__DEPENDS_WITH = DEPENDANT_INJECTION__DEPENDS_WITH;

    /**
     * The feature id for the '<em><b>Attribute To Find</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_INJECTION__ATTRIBUTE_TO_FIND = DEPENDANT_INJECTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Class Referenced</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_INJECTION__CLASS_REFERENCED = DEPENDANT_INJECTION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Reference Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_INJECTION__REFERENCE_ATTRIBUTE = DEPENDANT_INJECTION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Is Stereotype Reference</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_INJECTION__IS_STEREOTYPE_REFERENCE = DEPENDANT_INJECTION_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Reference Injection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_INJECTION_FEATURE_COUNT = DEPENDANT_INJECTION_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.RegExAttributeImpl <em>Reg Ex Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.RegExAttributeImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getRegExAttribute()
     * @generated
     */
    int REG_EX_ATTRIBUTE = 16;

    /**
     * The feature id for the '<em><b>Injection</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX_ATTRIBUTE__INJECTION = ATTRIBUTE__INJECTION;

    /**
     * The feature id for the '<em><b>Attribute Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX_ATTRIBUTE__ATTRIBUTE_VALUE = ATTRIBUTE__ATTRIBUTE_VALUE;

    /**
     * The feature id for the '<em><b>Secondary Injections For Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX_ATTRIBUTE__SECONDARY_INJECTIONS_FOR_GROUPS = ATTRIBUTE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Reg Ex Attribute</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.RegExImpl <em>Reg Ex</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.RegExImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getRegEx()
     * @generated
     */
    int REG_EX = 17;

    /**
     * The feature id for the '<em><b>Injection</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX__INJECTION = LINKED_ELEMENT__INJECTION;

    /**
     * The feature id for the '<em><b>Owner</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX__OWNER = LINKED_ELEMENT__OWNER;

    /**
     * The feature id for the '<em><b>Max</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX__MAX = LINKED_ELEMENT__MAX;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX__ATTRIBUTES = LINKED_ELEMENT__ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Reg Ex To Match</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX__REG_EX_TO_MATCH = LINKED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Secondary Injections For Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX__SECONDARY_INJECTIONS_FOR_GROUPS = LINKED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Reg Ex</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX_FEATURE_COUNT = LINKED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.NewClassInjectionCompositeImpl <em>New Class Injection Composite</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.NewClassInjectionCompositeImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getNewClassInjectionComposite()
     * @generated
     */
    int NEW_CLASS_INJECTION_COMPOSITE = 18;

    /**
     * The feature id for the '<em><b>String Format</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION_COMPOSITE__STRING_FORMAT = INEW_CLASS_INJECTION__STRING_FORMAT;

    /**
     * The feature id for the '<em><b>Standard Optional Injections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION_COMPOSITE__STANDARD_OPTIONAL_INJECTIONS = INEW_CLASS_INJECTION__STANDARD_OPTIONAL_INJECTIONS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION_COMPOSITE__NAME = INEW_CLASS_INJECTION__NAME;

    /**
     * The feature id for the '<em><b>Injections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION_COMPOSITE__INJECTIONS = INEW_CLASS_INJECTION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>New Class Injection Composite</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEW_CLASS_INJECTION_COMPOSITE_FEATURE_COUNT = INEW_CLASS_INJECTION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.StereotpyeApplicableInjectionImpl <em>Stereotpye Applicable Injection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.StereotpyeApplicableInjectionImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getStereotpyeApplicableInjection()
     * @generated
     */
    int STEREOTPYE_APPLICABLE_INJECTION = 20;

    /**
     * The feature id for the '<em><b>Stereotype To Apply</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEREOTPYE_APPLICABLE_INJECTION__STEREOTYPE_TO_APPLY = 0;

    /**
     * The number of structural features of the '<em>Stereotpye Applicable Injection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEREOTPYE_APPLICABLE_INJECTION_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.ColumnMatchElementImpl <em>Column Match Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.ColumnMatchElementImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getColumnMatchElement()
     * @generated
     */
    int COLUMN_MATCH_ELEMENT = 21;

    /**
     * The feature id for the '<em><b>Injection</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MATCH_ELEMENT__INJECTION = LINKED_ELEMENT__INJECTION;

    /**
     * The feature id for the '<em><b>Owner</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MATCH_ELEMENT__OWNER = LINKED_ELEMENT__OWNER;

    /**
     * The feature id for the '<em><b>Max</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MATCH_ELEMENT__MAX = LINKED_ELEMENT__MAX;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MATCH_ELEMENT__ATTRIBUTES = LINKED_ELEMENT__ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Reg Ex To Match</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MATCH_ELEMENT__REG_EX_TO_MATCH = LINKED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Num Column</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MATCH_ELEMENT__NUM_COLUMN = LINKED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Column Match Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MATCH_ELEMENT_FEATURE_COUNT = LINKED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.RegExMatchingElementImpl <em>Reg Ex Matching Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.RegExMatchingElementImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getRegExMatchingElement()
     * @generated
     */
    int REG_EX_MATCHING_ELEMENT = 22;

    /**
     * The feature id for the '<em><b>Reg Ex To Match</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX_MATCHING_ELEMENT__REG_EX_TO_MATCH = 0;

    /**
     * The number of structural features of the '<em>Reg Ex Matching Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX_MATCHING_ELEMENT_FEATURE_COUNT = 1;


    /**
     * The meta object id for the '{@link doc2modelMapping.impl.InstanceCreationInjectionImpl <em>Instance Creation Injection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.InstanceCreationInjectionImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getInstanceCreationInjection()
     * @generated
     */
    int INSTANCE_CREATION_INJECTION = 23;

    /**
     * The feature id for the '<em><b>Specific Namespace URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTANCE_CREATION_INJECTION__SPECIFIC_NAMESPACE_URI = 0;

    /**
     * The number of structural features of the '<em>Instance Creation Injection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INSTANCE_CREATION_INJECTION_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.ColumnElementImpl <em>Column Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.ColumnElementImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getColumnElement()
     * @generated
     */
    int COLUMN_ELEMENT = 25;

    /**
     * The feature id for the '<em><b>Reg Ex To Match</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_ELEMENT__REG_EX_TO_MATCH = REG_EX_MATCHING_ELEMENT__REG_EX_TO_MATCH;

    /**
     * The feature id for the '<em><b>Num Column</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_ELEMENT__NUM_COLUMN = REG_EX_MATCHING_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Column Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_ELEMENT_FEATURE_COUNT = REG_EX_MATCHING_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link doc2modelMapping.impl.ColumnMatchAttributeImpl <em>Column Match Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.ColumnMatchAttributeImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getColumnMatchAttribute()
     * @generated
     */
    int COLUMN_MATCH_ATTRIBUTE = 24;

    /**
     * The feature id for the '<em><b>Reg Ex To Match</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MATCH_ATTRIBUTE__REG_EX_TO_MATCH = COLUMN_ELEMENT__REG_EX_TO_MATCH;

    /**
     * The feature id for the '<em><b>Num Column</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MATCH_ATTRIBUTE__NUM_COLUMN = COLUMN_ELEMENT__NUM_COLUMN;

    /**
     * The feature id for the '<em><b>Injection</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MATCH_ATTRIBUTE__INJECTION = COLUMN_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Attribute Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MATCH_ATTRIBUTE__ATTRIBUTE_VALUE = COLUMN_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Column Match Attribute</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MATCH_ATTRIBUTE_FEATURE_COUNT = COLUMN_ELEMENT_FEATURE_COUNT + 2;


    /**
     * The meta object id for the '{@link doc2modelMapping.impl.ElementCreationInjectionImpl <em>Element Creation Injection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.ElementCreationInjectionImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getElementCreationInjection()
     * @generated
     */
    int ELEMENT_CREATION_INJECTION = 26;

    /**
     * The number of structural features of the '<em>Element Creation Injection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELEMENT_CREATION_INJECTION_FEATURE_COUNT = 0;


    /**
     * The meta object id for the '{@link doc2modelMapping.impl.TextFormatterImpl <em>Text Formatter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.TextFormatterImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getTextFormatter()
     * @generated
     */
    int TEXT_FORMATTER = 27;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORMATTER__PATTERN = 0;

    /**
     * The feature id for the '<em><b>Regex For Condition Or Group</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORMATTER__REGEX_FOR_CONDITION_OR_GROUP = 1;

    /**
     * The number of structural features of the '<em>Text Formatter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FORMATTER_FEATURE_COUNT = 2;


    /**
     * The meta object id for the '{@link doc2modelMapping.impl.GroupElementImpl <em>Group Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see doc2modelMapping.impl.GroupElementImpl
     * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getGroupElement()
     * @generated
     */
    int GROUP_ELEMENT = 28;

    /**
     * The feature id for the '<em><b>Secondary Injections For Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_ELEMENT__SECONDARY_INJECTIONS_FOR_GROUPS = 0;

    /**
     * The number of structural features of the '<em>Group Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GROUP_ELEMENT_FEATURE_COUNT = 1;


    /**
     * Returns the meta object for class '{@link doc2modelMapping.doc2model <em>doc2model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>doc2model</em>'.
     * @see doc2modelMapping.doc2model
     * @generated
     */
    EClass getdoc2model();

    /**
     * Returns the meta object for the containment reference list '{@link doc2modelMapping.doc2model#getLinks <em>Links</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Links</em>'.
     * @see doc2modelMapping.doc2model#getLinks()
     * @see #getdoc2model()
     * @generated
     */
    EReference getdoc2model_Links();

    /**
     * Returns the meta object for the containment reference '{@link doc2modelMapping.doc2model#getHierarchy <em>Hierarchy</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Hierarchy</em>'.
     * @see doc2modelMapping.doc2model#getHierarchy()
     * @see #getdoc2model()
     * @generated
     */
    EReference getdoc2model_Hierarchy();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.doc2model#getExtension <em>Extension</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Extension</em>'.
     * @see doc2modelMapping.doc2model#getExtension()
     * @see #getdoc2model()
     * @generated
     */
    EAttribute getdoc2model_Extension();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.doc2model#getMetamodelURI <em>Metamodel URI</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Metamodel URI</em>'.
     * @see doc2modelMapping.doc2model#getMetamodelURI()
     * @see #getdoc2model()
     * @generated
     */
    EAttribute getdoc2model_MetamodelURI();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.doc2model#getProfileURI <em>Profile URI</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Profile URI</em>'.
     * @see doc2modelMapping.doc2model#getProfileURI()
     * @see #getdoc2model()
     * @generated
     */
    EAttribute getdoc2model_ProfileURI();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.LinkedElement <em>Linked Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Linked Element</em>'.
     * @see doc2modelMapping.LinkedElement
     * @generated
     */
    EClass getLinkedElement();

    /**
     * Returns the meta object for the container reference '{@link doc2modelMapping.LinkedElement#getOwner <em>Owner</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Owner</em>'.
     * @see doc2modelMapping.LinkedElement#getOwner()
     * @see #getLinkedElement()
     * @generated
     */
    EReference getLinkedElement_Owner();

    /**
     * Returns the meta object for the reference '{@link doc2modelMapping.LinkedElement#getMax <em>Max</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Max</em>'.
     * @see doc2modelMapping.LinkedElement#getMax()
     * @see #getLinkedElement()
     * @generated
     */
    EReference getLinkedElement_Max();

    /**
     * Returns the meta object for the containment reference list '{@link doc2modelMapping.LinkedElement#getAttributes <em>Attributes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Attributes</em>'.
     * @see doc2modelMapping.LinkedElement#getAttributes()
     * @see #getLinkedElement()
     * @generated
     */
    EReference getLinkedElement_Attributes();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.DocStyle <em>Doc Style</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Doc Style</em>'.
     * @see doc2modelMapping.DocStyle
     * @generated
     */
    EClass getDocStyle();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.DocStyle#getStyleName <em>Style Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Style Name</em>'.
     * @see doc2modelMapping.DocStyle#getStyleName()
     * @see #getDocStyle()
     * @generated
     */
    EAttribute getDocStyle_StyleName();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.Hierarchy <em>Hierarchy</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Hierarchy</em>'.
     * @see doc2modelMapping.Hierarchy
     * @generated
     */
    EClass getHierarchy();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.Hierarchy#getLevel <em>Level</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Level</em>'.
     * @see doc2modelMapping.Hierarchy#getLevel()
     * @see #getHierarchy()
     * @generated
     */
    EAttribute getHierarchy_Level();

    /**
     * Returns the meta object for the containment reference '{@link doc2modelMapping.Hierarchy#getSubHierarchy <em>Sub Hierarchy</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Sub Hierarchy</em>'.
     * @see doc2modelMapping.Hierarchy#getSubHierarchy()
     * @see #getHierarchy()
     * @generated
     */
    EReference getHierarchy_SubHierarchy();

    /**
     * Returns the meta object for the attribute list '{@link doc2modelMapping.Hierarchy#getStyleValue <em>Style Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Style Value</em>'.
     * @see doc2modelMapping.Hierarchy#getStyleValue()
     * @see #getHierarchy()
     * @generated
     */
    EAttribute getHierarchy_StyleValue();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.AttributeTag <em>Attribute Tag</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute Tag</em>'.
     * @see doc2modelMapping.AttributeTag
     * @generated
     */
    EClass getAttributeTag();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.AttributeTag#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see doc2modelMapping.AttributeTag#getValue()
     * @see #getAttributeTag()
     * @generated
     */
    EAttribute getAttributeTag_Value();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.TagElement <em>Tag Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tag Element</em>'.
     * @see doc2modelMapping.TagElement
     * @generated
     */
    EClass getTagElement();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.TagElement#isSingleLine <em>Single Line</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Single Line</em>'.
     * @see doc2modelMapping.TagElement#isSingleLine()
     * @see #getTagElement()
     * @generated
     */
    EAttribute getTagElement_SingleLine();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.TagElement#getTagValue <em>Tag Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tag Value</em>'.
     * @see doc2modelMapping.TagElement#getTagValue()
     * @see #getTagElement()
     * @generated
     */
    EAttribute getTagElement_TagValue();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.TagAttribute <em>Tag Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tag Attribute</em>'.
     * @see doc2modelMapping.TagAttribute
     * @generated
     */
    EClass getTagAttribute();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.DynamicElement <em>Dynamic Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Dynamic Element</em>'.
     * @see doc2modelMapping.DynamicElement
     * @generated
     */
    EClass getDynamicElement();

    /**
     * Returns the meta object for the containment reference '{@link doc2modelMapping.DynamicElement#getInjection <em>Injection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Injection</em>'.
     * @see doc2modelMapping.DynamicElement#getInjection()
     * @see #getDynamicElement()
     * @generated
     */
    EReference getDynamicElement_Injection();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.StyleAttribute <em>Style Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Style Attribute</em>'.
     * @see doc2modelMapping.StyleAttribute
     * @generated
     */
    EClass getStyleAttribute();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.Attribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute</em>'.
     * @see doc2modelMapping.Attribute
     * @generated
     */
    EClass getAttribute();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.Attribute#getAttributeValue <em>Attribute Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Attribute Value</em>'.
     * @see doc2modelMapping.Attribute#getAttributeValue()
     * @see #getAttribute()
     * @generated
     */
    EAttribute getAttribute_AttributeValue();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.InjectionElement <em>Injection Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Injection Element</em>'.
     * @see doc2modelMapping.InjectionElement
     * @generated
     */
    EClass getInjectionElement();

    /**
     * Returns the meta object for the containment reference '{@link doc2modelMapping.InjectionElement#getStringFormat <em>String Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>String Format</em>'.
     * @see doc2modelMapping.InjectionElement#getStringFormat()
     * @see #getInjectionElement()
     * @generated
     */
    EReference getInjectionElement_StringFormat();

    /**
     * Returns the meta object for the containment reference list '{@link doc2modelMapping.InjectionElement#getStandardOptionalInjections <em>Standard Optional Injections</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Standard Optional Injections</em>'.
     * @see doc2modelMapping.InjectionElement#getStandardOptionalInjections()
     * @see #getInjectionElement()
     * @generated
     */
    EReference getInjectionElement_StandardOptionalInjections();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.InjectionElement#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see doc2modelMapping.InjectionElement#getName()
     * @see #getInjectionElement()
     * @generated
     */
    EAttribute getInjectionElement_Name();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.NewClassInjection <em>New Class Injection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>New Class Injection</em>'.
     * @see doc2modelMapping.NewClassInjection
     * @generated
     */
    EClass getNewClassInjection();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.NewClassInjection#getInstanceTarget <em>Instance Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Instance Target</em>'.
     * @see doc2modelMapping.NewClassInjection#getInstanceTarget()
     * @see #getNewClassInjection()
     * @generated
     */
    EAttribute getNewClassInjection_InstanceTarget();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.NewClassInjection#getOwningClass <em>Owning Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Owning Class</em>'.
     * @see doc2modelMapping.NewClassInjection#getOwningClass()
     * @see #getNewClassInjection()
     * @generated
     */
    EAttribute getNewClassInjection_OwningClass();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.NewClassInjection#getAssociationOwning <em>Association Owning</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Association Owning</em>'.
     * @see doc2modelMapping.NewClassInjection#getAssociationOwning()
     * @see #getNewClassInjection()
     * @generated
     */
    EAttribute getNewClassInjection_AssociationOwning();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.NewClassInjection#getAttributeForValue <em>Attribute For Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Attribute For Value</em>'.
     * @see doc2modelMapping.NewClassInjection#getAttributeForValue()
     * @see #getNewClassInjection()
     * @generated
     */
    EAttribute getNewClassInjection_AttributeForValue();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.NewClassInjection#getStereotypeAttributeForValue <em>Stereotype Attribute For Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Stereotype Attribute For Value</em>'.
     * @see doc2modelMapping.NewClassInjection#getStereotypeAttributeForValue()
     * @see #getNewClassInjection()
     * @generated
     */
    EAttribute getNewClassInjection_StereotypeAttributeForValue();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.NewClassInjection#isBrowseTopContainersForOwner <em>Browse Top Containers For Owner</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Browse Top Containers For Owner</em>'.
     * @see doc2modelMapping.NewClassInjection#isBrowseTopContainersForOwner()
     * @see #getNewClassInjection()
     * @generated
     */
    EAttribute getNewClassInjection_BrowseTopContainersForOwner();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.CompositionInjection <em>Composition Injection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Composition Injection</em>'.
     * @see doc2modelMapping.CompositionInjection
     * @generated
     */
    EClass getCompositionInjection();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.CompositionInjection#getOwningClass <em>Owning Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Owning Class</em>'.
     * @see doc2modelMapping.CompositionInjection#getOwningClass()
     * @see #getCompositionInjection()
     * @generated
     */
    EAttribute getCompositionInjection_OwningClass();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.CompositionInjection#getAssociationName <em>Association Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Association Name</em>'.
     * @see doc2modelMapping.CompositionInjection#getAssociationName()
     * @see #getCompositionInjection()
     * @generated
     */
    EAttribute getCompositionInjection_AssociationName();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.CompositionInjection#getAttributeName <em>Attribute Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Attribute Name</em>'.
     * @see doc2modelMapping.CompositionInjection#getAttributeName()
     * @see #getCompositionInjection()
     * @generated
     */
    EAttribute getCompositionInjection_AttributeName();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.CompositionInjection#isNewInstanceForEachComposition <em>New Instance For Each Composition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>New Instance For Each Composition</em>'.
     * @see doc2modelMapping.CompositionInjection#isNewInstanceForEachComposition()
     * @see #getCompositionInjection()
     * @generated
     */
    EAttribute getCompositionInjection_NewInstanceForEachComposition();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.AttributeInjection <em>Attribute Injection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute Injection</em>'.
     * @see doc2modelMapping.AttributeInjection
     * @generated
     */
    EClass getAttributeInjection();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.AttributeInjection#getInstanceAttribute <em>Instance Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Instance Attribute</em>'.
     * @see doc2modelMapping.AttributeInjection#getInstanceAttribute()
     * @see #getAttributeInjection()
     * @generated
     */
    EAttribute getAttributeInjection_InstanceAttribute();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.AttributeInjection#getStereotypeAttribute <em>Stereotype Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Stereotype Attribute</em>'.
     * @see doc2modelMapping.AttributeInjection#getStereotypeAttribute()
     * @see #getAttributeInjection()
     * @generated
     */
    EAttribute getAttributeInjection_StereotypeAttribute();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.DependantInjection <em>Dependant Injection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Dependant Injection</em>'.
     * @see doc2modelMapping.DependantInjection
     * @generated
     */
    EClass getDependantInjection();

    /**
     * Returns the meta object for the reference '{@link doc2modelMapping.DependantInjection#getDependsWith <em>Depends With</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Depends With</em>'.
     * @see doc2modelMapping.DependantInjection#getDependsWith()
     * @see #getDependantInjection()
     * @generated
     */
    EReference getDependantInjection_DependsWith();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.ReferenceInjection <em>Reference Injection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Reference Injection</em>'.
     * @see doc2modelMapping.ReferenceInjection
     * @generated
     */
    EClass getReferenceInjection();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.ReferenceInjection#getAttributeToFind <em>Attribute To Find</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Attribute To Find</em>'.
     * @see doc2modelMapping.ReferenceInjection#getAttributeToFind()
     * @see #getReferenceInjection()
     * @generated
     */
    EAttribute getReferenceInjection_AttributeToFind();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.ReferenceInjection#getClassReferenced <em>Class Referenced</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Class Referenced</em>'.
     * @see doc2modelMapping.ReferenceInjection#getClassReferenced()
     * @see #getReferenceInjection()
     * @generated
     */
    EAttribute getReferenceInjection_ClassReferenced();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.ReferenceInjection#getReferenceAttribute <em>Reference Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Reference Attribute</em>'.
     * @see doc2modelMapping.ReferenceInjection#getReferenceAttribute()
     * @see #getReferenceInjection()
     * @generated
     */
    EAttribute getReferenceInjection_ReferenceAttribute();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.ReferenceInjection#isIsStereotypeReference <em>Is Stereotype Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Stereotype Reference</em>'.
     * @see doc2modelMapping.ReferenceInjection#isIsStereotypeReference()
     * @see #getReferenceInjection()
     * @generated
     */
    EAttribute getReferenceInjection_IsStereotypeReference();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.RegExAttribute <em>Reg Ex Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Reg Ex Attribute</em>'.
     * @see doc2modelMapping.RegExAttribute
     * @generated
     */
    EClass getRegExAttribute();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.RegEx <em>Reg Ex</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Reg Ex</em>'.
     * @see doc2modelMapping.RegEx
     * @generated
     */
    EClass getRegEx();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.NewClassInjectionComposite <em>New Class Injection Composite</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>New Class Injection Composite</em>'.
     * @see doc2modelMapping.NewClassInjectionComposite
     * @generated
     */
    EClass getNewClassInjectionComposite();

    /**
     * Returns the meta object for the containment reference list '{@link doc2modelMapping.NewClassInjectionComposite#getInjections <em>Injections</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Injections</em>'.
     * @see doc2modelMapping.NewClassInjectionComposite#getInjections()
     * @see #getNewClassInjectionComposite()
     * @generated
     */
    EReference getNewClassInjectionComposite_Injections();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.INewClassInjection <em>INew Class Injection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>INew Class Injection</em>'.
     * @see doc2modelMapping.INewClassInjection
     * @generated
     */
    EClass getINewClassInjection();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.StereotpyeApplicableInjection <em>Stereotpye Applicable Injection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Stereotpye Applicable Injection</em>'.
     * @see doc2modelMapping.StereotpyeApplicableInjection
     * @generated
     */
    EClass getStereotpyeApplicableInjection();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.StereotpyeApplicableInjection#getStereotypeToApply <em>Stereotype To Apply</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Stereotype To Apply</em>'.
     * @see doc2modelMapping.StereotpyeApplicableInjection#getStereotypeToApply()
     * @see #getStereotpyeApplicableInjection()
     * @generated
     */
    EAttribute getStereotpyeApplicableInjection_StereotypeToApply();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.ColumnMatchElement <em>Column Match Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Column Match Element</em>'.
     * @see doc2modelMapping.ColumnMatchElement
     * @generated
     */
    EClass getColumnMatchElement();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.RegExMatchingElement <em>Reg Ex Matching Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Reg Ex Matching Element</em>'.
     * @see doc2modelMapping.RegExMatchingElement
     * @generated
     */
    EClass getRegExMatchingElement();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.RegExMatchingElement#getRegExToMatch <em>Reg Ex To Match</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Reg Ex To Match</em>'.
     * @see doc2modelMapping.RegExMatchingElement#getRegExToMatch()
     * @see #getRegExMatchingElement()
     * @generated
     */
    EAttribute getRegExMatchingElement_RegExToMatch();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.InstanceCreationInjection <em>Instance Creation Injection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Instance Creation Injection</em>'.
     * @see doc2modelMapping.InstanceCreationInjection
     * @generated
     */
    EClass getInstanceCreationInjection();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.InstanceCreationInjection#getSpecificNamespaceURI <em>Specific Namespace URI</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Specific Namespace URI</em>'.
     * @see doc2modelMapping.InstanceCreationInjection#getSpecificNamespaceURI()
     * @see #getInstanceCreationInjection()
     * @generated
     */
    EAttribute getInstanceCreationInjection_SpecificNamespaceURI();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.ColumnMatchAttribute <em>Column Match Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Column Match Attribute</em>'.
     * @see doc2modelMapping.ColumnMatchAttribute
     * @generated
     */
    EClass getColumnMatchAttribute();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.ColumnElement <em>Column Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Column Element</em>'.
     * @see doc2modelMapping.ColumnElement
     * @generated
     */
    EClass getColumnElement();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.ColumnElement#getNumColumn <em>Num Column</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Num Column</em>'.
     * @see doc2modelMapping.ColumnElement#getNumColumn()
     * @see #getColumnElement()
     * @generated
     */
    EAttribute getColumnElement_NumColumn();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.ElementCreationInjection <em>Element Creation Injection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Element Creation Injection</em>'.
     * @see doc2modelMapping.ElementCreationInjection
     * @generated
     */
    EClass getElementCreationInjection();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.TextFormatter <em>Text Formatter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Text Formatter</em>'.
     * @see doc2modelMapping.TextFormatter
     * @generated
     */
    EClass getTextFormatter();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.TextFormatter#getPattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pattern</em>'.
     * @see doc2modelMapping.TextFormatter#getPattern()
     * @see #getTextFormatter()
     * @generated
     */
    EAttribute getTextFormatter_Pattern();

    /**
     * Returns the meta object for the attribute '{@link doc2modelMapping.TextFormatter#getRegexForConditionOrGroup <em>Regex For Condition Or Group</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Regex For Condition Or Group</em>'.
     * @see doc2modelMapping.TextFormatter#getRegexForConditionOrGroup()
     * @see #getTextFormatter()
     * @generated
     */
    EAttribute getTextFormatter_RegexForConditionOrGroup();

    /**
     * Returns the meta object for class '{@link doc2modelMapping.GroupElement <em>Group Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Group Element</em>'.
     * @see doc2modelMapping.GroupElement
     * @generated
     */
    EClass getGroupElement();

    /**
     * Returns the meta object for the containment reference list '{@link doc2modelMapping.GroupElement#getSecondaryInjectionsForGroups <em>Secondary Injections For Groups</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Secondary Injections For Groups</em>'.
     * @see doc2modelMapping.GroupElement#getSecondaryInjectionsForGroups()
     * @see #getGroupElement()
     * @generated
     */
    EReference getGroupElement_SecondaryInjectionsForGroups();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    Doc2modelMappingFactory getDoc2modelMappingFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.doc2modelImpl <em>doc2model</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.doc2modelImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getdoc2model()
         * @generated
         */
        EClass DOC2MODEL = eINSTANCE.getdoc2model();

        /**
         * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOC2MODEL__LINKS = eINSTANCE.getdoc2model_Links();

        /**
         * The meta object literal for the '<em><b>Hierarchy</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOC2MODEL__HIERARCHY = eINSTANCE.getdoc2model_Hierarchy();

        /**
         * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOC2MODEL__EXTENSION = eINSTANCE.getdoc2model_Extension();

        /**
         * The meta object literal for the '<em><b>Metamodel URI</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOC2MODEL__METAMODEL_URI = eINSTANCE.getdoc2model_MetamodelURI();

        /**
         * The meta object literal for the '<em><b>Profile URI</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOC2MODEL__PROFILE_URI = eINSTANCE.getdoc2model_ProfileURI();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.LinkedElementImpl <em>Linked Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.LinkedElementImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getLinkedElement()
         * @generated
         */
        EClass LINKED_ELEMENT = eINSTANCE.getLinkedElement();

        /**
         * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LINKED_ELEMENT__OWNER = eINSTANCE.getLinkedElement_Owner();

        /**
         * The meta object literal for the '<em><b>Max</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LINKED_ELEMENT__MAX = eINSTANCE.getLinkedElement_Max();

        /**
         * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LINKED_ELEMENT__ATTRIBUTES = eINSTANCE.getLinkedElement_Attributes();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.DocStyleImpl <em>Doc Style</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.DocStyleImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getDocStyle()
         * @generated
         */
        EClass DOC_STYLE = eINSTANCE.getDocStyle();

        /**
         * The meta object literal for the '<em><b>Style Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOC_STYLE__STYLE_NAME = eINSTANCE.getDocStyle_StyleName();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.HierarchyImpl <em>Hierarchy</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.HierarchyImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getHierarchy()
         * @generated
         */
        EClass HIERARCHY = eINSTANCE.getHierarchy();

        /**
         * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HIERARCHY__LEVEL = eINSTANCE.getHierarchy_Level();

        /**
         * The meta object literal for the '<em><b>Sub Hierarchy</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HIERARCHY__SUB_HIERARCHY = eINSTANCE.getHierarchy_SubHierarchy();

        /**
         * The meta object literal for the '<em><b>Style Value</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HIERARCHY__STYLE_VALUE = eINSTANCE.getHierarchy_StyleValue();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.AttributeTagImpl <em>Attribute Tag</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.AttributeTagImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getAttributeTag()
         * @generated
         */
        EClass ATTRIBUTE_TAG = eINSTANCE.getAttributeTag();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTE_TAG__VALUE = eINSTANCE.getAttributeTag_Value();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.TagElementImpl <em>Tag Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.TagElementImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getTagElement()
         * @generated
         */
        EClass TAG_ELEMENT = eINSTANCE.getTagElement();

        /**
         * The meta object literal for the '<em><b>Single Line</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TAG_ELEMENT__SINGLE_LINE = eINSTANCE.getTagElement_SingleLine();

        /**
         * The meta object literal for the '<em><b>Tag Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TAG_ELEMENT__TAG_VALUE = eINSTANCE.getTagElement_TagValue();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.TagAttributeImpl <em>Tag Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.TagAttributeImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getTagAttribute()
         * @generated
         */
        EClass TAG_ATTRIBUTE = eINSTANCE.getTagAttribute();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.DynamicElementImpl <em>Dynamic Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.DynamicElementImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getDynamicElement()
         * @generated
         */
        EClass DYNAMIC_ELEMENT = eINSTANCE.getDynamicElement();

        /**
         * The meta object literal for the '<em><b>Injection</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DYNAMIC_ELEMENT__INJECTION = eINSTANCE.getDynamicElement_Injection();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.StyleAttributeImpl <em>Style Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.StyleAttributeImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getStyleAttribute()
         * @generated
         */
        EClass STYLE_ATTRIBUTE = eINSTANCE.getStyleAttribute();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.AttributeImpl <em>Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.AttributeImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getAttribute()
         * @generated
         */
        EClass ATTRIBUTE = eINSTANCE.getAttribute();

        /**
         * The meta object literal for the '<em><b>Attribute Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTE__ATTRIBUTE_VALUE = eINSTANCE.getAttribute_AttributeValue();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.InjectionElementImpl <em>Injection Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.InjectionElementImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getInjectionElement()
         * @generated
         */
        EClass INJECTION_ELEMENT = eINSTANCE.getInjectionElement();

        /**
         * The meta object literal for the '<em><b>String Format</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INJECTION_ELEMENT__STRING_FORMAT = eINSTANCE.getInjectionElement_StringFormat();

        /**
         * The meta object literal for the '<em><b>Standard Optional Injections</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS = eINSTANCE.getInjectionElement_StandardOptionalInjections();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INJECTION_ELEMENT__NAME = eINSTANCE.getInjectionElement_Name();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.NewClassInjectionImpl <em>New Class Injection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.NewClassInjectionImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getNewClassInjection()
         * @generated
         */
        EClass NEW_CLASS_INJECTION = eINSTANCE.getNewClassInjection();

        /**
         * The meta object literal for the '<em><b>Instance Target</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NEW_CLASS_INJECTION__INSTANCE_TARGET = eINSTANCE.getNewClassInjection_InstanceTarget();

        /**
         * The meta object literal for the '<em><b>Owning Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NEW_CLASS_INJECTION__OWNING_CLASS = eINSTANCE.getNewClassInjection_OwningClass();

        /**
         * The meta object literal for the '<em><b>Association Owning</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NEW_CLASS_INJECTION__ASSOCIATION_OWNING = eINSTANCE.getNewClassInjection_AssociationOwning();

        /**
         * The meta object literal for the '<em><b>Attribute For Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NEW_CLASS_INJECTION__ATTRIBUTE_FOR_VALUE = eINSTANCE.getNewClassInjection_AttributeForValue();

        /**
         * The meta object literal for the '<em><b>Stereotype Attribute For Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NEW_CLASS_INJECTION__STEREOTYPE_ATTRIBUTE_FOR_VALUE = eINSTANCE.getNewClassInjection_StereotypeAttributeForValue();

        /**
         * The meta object literal for the '<em><b>Browse Top Containers For Owner</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NEW_CLASS_INJECTION__BROWSE_TOP_CONTAINERS_FOR_OWNER = eINSTANCE.getNewClassInjection_BrowseTopContainersForOwner();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.CompositionInjectionImpl <em>Composition Injection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.CompositionInjectionImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getCompositionInjection()
         * @generated
         */
        EClass COMPOSITION_INJECTION = eINSTANCE.getCompositionInjection();

        /**
         * The meta object literal for the '<em><b>Owning Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMPOSITION_INJECTION__OWNING_CLASS = eINSTANCE.getCompositionInjection_OwningClass();

        /**
         * The meta object literal for the '<em><b>Association Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMPOSITION_INJECTION__ASSOCIATION_NAME = eINSTANCE.getCompositionInjection_AssociationName();

        /**
         * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMPOSITION_INJECTION__ATTRIBUTE_NAME = eINSTANCE.getCompositionInjection_AttributeName();

        /**
         * The meta object literal for the '<em><b>New Instance For Each Composition</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMPOSITION_INJECTION__NEW_INSTANCE_FOR_EACH_COMPOSITION = eINSTANCE.getCompositionInjection_NewInstanceForEachComposition();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.AttributeInjectionImpl <em>Attribute Injection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.AttributeInjectionImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getAttributeInjection()
         * @generated
         */
        EClass ATTRIBUTE_INJECTION = eINSTANCE.getAttributeInjection();

        /**
         * The meta object literal for the '<em><b>Instance Attribute</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTE_INJECTION__INSTANCE_ATTRIBUTE = eINSTANCE.getAttributeInjection_InstanceAttribute();

        /**
         * The meta object literal for the '<em><b>Stereotype Attribute</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTE_INJECTION__STEREOTYPE_ATTRIBUTE = eINSTANCE.getAttributeInjection_StereotypeAttribute();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.DependantInjectionImpl <em>Dependant Injection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.DependantInjectionImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getDependantInjection()
         * @generated
         */
        EClass DEPENDANT_INJECTION = eINSTANCE.getDependantInjection();

        /**
         * The meta object literal for the '<em><b>Depends With</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEPENDANT_INJECTION__DEPENDS_WITH = eINSTANCE.getDependantInjection_DependsWith();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.ReferenceInjectionImpl <em>Reference Injection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.ReferenceInjectionImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getReferenceInjection()
         * @generated
         */
        EClass REFERENCE_INJECTION = eINSTANCE.getReferenceInjection();

        /**
         * The meta object literal for the '<em><b>Attribute To Find</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute REFERENCE_INJECTION__ATTRIBUTE_TO_FIND = eINSTANCE.getReferenceInjection_AttributeToFind();

        /**
         * The meta object literal for the '<em><b>Class Referenced</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute REFERENCE_INJECTION__CLASS_REFERENCED = eINSTANCE.getReferenceInjection_ClassReferenced();

        /**
         * The meta object literal for the '<em><b>Reference Attribute</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute REFERENCE_INJECTION__REFERENCE_ATTRIBUTE = eINSTANCE.getReferenceInjection_ReferenceAttribute();

        /**
         * The meta object literal for the '<em><b>Is Stereotype Reference</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute REFERENCE_INJECTION__IS_STEREOTYPE_REFERENCE = eINSTANCE.getReferenceInjection_IsStereotypeReference();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.RegExAttributeImpl <em>Reg Ex Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.RegExAttributeImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getRegExAttribute()
         * @generated
         */
        EClass REG_EX_ATTRIBUTE = eINSTANCE.getRegExAttribute();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.RegExImpl <em>Reg Ex</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.RegExImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getRegEx()
         * @generated
         */
        EClass REG_EX = eINSTANCE.getRegEx();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.NewClassInjectionCompositeImpl <em>New Class Injection Composite</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.NewClassInjectionCompositeImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getNewClassInjectionComposite()
         * @generated
         */
        EClass NEW_CLASS_INJECTION_COMPOSITE = eINSTANCE.getNewClassInjectionComposite();

        /**
         * The meta object literal for the '<em><b>Injections</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NEW_CLASS_INJECTION_COMPOSITE__INJECTIONS = eINSTANCE.getNewClassInjectionComposite_Injections();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.INewClassInjectionImpl <em>INew Class Injection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.INewClassInjectionImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getINewClassInjection()
         * @generated
         */
        EClass INEW_CLASS_INJECTION = eINSTANCE.getINewClassInjection();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.StereotpyeApplicableInjectionImpl <em>Stereotpye Applicable Injection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.StereotpyeApplicableInjectionImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getStereotpyeApplicableInjection()
         * @generated
         */
        EClass STEREOTPYE_APPLICABLE_INJECTION = eINSTANCE.getStereotpyeApplicableInjection();

        /**
         * The meta object literal for the '<em><b>Stereotype To Apply</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STEREOTPYE_APPLICABLE_INJECTION__STEREOTYPE_TO_APPLY = eINSTANCE.getStereotpyeApplicableInjection_StereotypeToApply();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.ColumnMatchElementImpl <em>Column Match Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.ColumnMatchElementImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getColumnMatchElement()
         * @generated
         */
        EClass COLUMN_MATCH_ELEMENT = eINSTANCE.getColumnMatchElement();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.RegExMatchingElementImpl <em>Reg Ex Matching Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.RegExMatchingElementImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getRegExMatchingElement()
         * @generated
         */
        EClass REG_EX_MATCHING_ELEMENT = eINSTANCE.getRegExMatchingElement();

        /**
         * The meta object literal for the '<em><b>Reg Ex To Match</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute REG_EX_MATCHING_ELEMENT__REG_EX_TO_MATCH = eINSTANCE.getRegExMatchingElement_RegExToMatch();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.InstanceCreationInjectionImpl <em>Instance Creation Injection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.InstanceCreationInjectionImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getInstanceCreationInjection()
         * @generated
         */
        EClass INSTANCE_CREATION_INJECTION = eINSTANCE.getInstanceCreationInjection();

        /**
         * The meta object literal for the '<em><b>Specific Namespace URI</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INSTANCE_CREATION_INJECTION__SPECIFIC_NAMESPACE_URI = eINSTANCE.getInstanceCreationInjection_SpecificNamespaceURI();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.ColumnMatchAttributeImpl <em>Column Match Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.ColumnMatchAttributeImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getColumnMatchAttribute()
         * @generated
         */
        EClass COLUMN_MATCH_ATTRIBUTE = eINSTANCE.getColumnMatchAttribute();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.ColumnElementImpl <em>Column Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.ColumnElementImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getColumnElement()
         * @generated
         */
        EClass COLUMN_ELEMENT = eINSTANCE.getColumnElement();

        /**
         * The meta object literal for the '<em><b>Num Column</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLUMN_ELEMENT__NUM_COLUMN = eINSTANCE.getColumnElement_NumColumn();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.ElementCreationInjectionImpl <em>Element Creation Injection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.ElementCreationInjectionImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getElementCreationInjection()
         * @generated
         */
        EClass ELEMENT_CREATION_INJECTION = eINSTANCE.getElementCreationInjection();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.TextFormatterImpl <em>Text Formatter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.TextFormatterImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getTextFormatter()
         * @generated
         */
        EClass TEXT_FORMATTER = eINSTANCE.getTextFormatter();

        /**
         * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT_FORMATTER__PATTERN = eINSTANCE.getTextFormatter_Pattern();

        /**
         * The meta object literal for the '<em><b>Regex For Condition Or Group</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT_FORMATTER__REGEX_FOR_CONDITION_OR_GROUP = eINSTANCE.getTextFormatter_RegexForConditionOrGroup();

        /**
         * The meta object literal for the '{@link doc2modelMapping.impl.GroupElementImpl <em>Group Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see doc2modelMapping.impl.GroupElementImpl
         * @see doc2modelMapping.impl.Doc2modelMappingPackageImpl#getGroupElement()
         * @generated
         */
        EClass GROUP_ELEMENT = eINSTANCE.getGroupElement();

        /**
         * The meta object literal for the '<em><b>Secondary Injections For Groups</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GROUP_ELEMENT__SECONDARY_INJECTIONS_FOR_GROUPS = eINSTANCE.getGroupElement_SecondaryInjectionsForGroups();

    }

} //Doc2modelMappingPackage
