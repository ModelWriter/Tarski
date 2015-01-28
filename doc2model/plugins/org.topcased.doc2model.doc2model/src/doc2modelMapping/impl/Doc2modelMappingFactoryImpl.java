/**
 * <copyright>
 * </copyright>
 *
 * $Id: Doc2modelMappingFactoryImpl.java,v 1.4 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Doc2modelMappingFactoryImpl extends EFactoryImpl implements Doc2modelMappingFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static Doc2modelMappingFactory init()
    {
        try
        {
            Doc2modelMappingFactory theDoc2modelMappingFactory = (Doc2modelMappingFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.topcased.org/doc2model/doc2modelMapping"); 
            if (theDoc2modelMappingFactory != null)
            {
                return theDoc2modelMappingFactory;
            }
        }
        catch (Exception exception)
        {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new Doc2modelMappingFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Doc2modelMappingFactoryImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass)
    {
        switch (eClass.getClassifierID())
        {
            case Doc2modelMappingPackage.DOC2MODEL: return createdoc2model();
            case Doc2modelMappingPackage.DOC_STYLE: return createDocStyle();
            case Doc2modelMappingPackage.HIERARCHY: return createHierarchy();
            case Doc2modelMappingPackage.ATTRIBUTE_TAG: return createAttributeTag();
            case Doc2modelMappingPackage.TAG_ELEMENT: return createTagElement();
            case Doc2modelMappingPackage.TAG_ATTRIBUTE: return createTagAttribute();
            case Doc2modelMappingPackage.STYLE_ATTRIBUTE: return createStyleAttribute();
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION: return createNewClassInjection();
            case Doc2modelMappingPackage.COMPOSITION_INJECTION: return createCompositionInjection();
            case Doc2modelMappingPackage.ATTRIBUTE_INJECTION: return createAttributeInjection();
            case Doc2modelMappingPackage.REFERENCE_INJECTION: return createReferenceInjection();
            case Doc2modelMappingPackage.REG_EX_ATTRIBUTE: return createRegExAttribute();
            case Doc2modelMappingPackage.REG_EX: return createRegEx();
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION_COMPOSITE: return createNewClassInjectionComposite();
            case Doc2modelMappingPackage.COLUMN_MATCH_ELEMENT: return createColumnMatchElement();
            case Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE: return createColumnMatchAttribute();
            case Doc2modelMappingPackage.TEXT_FORMATTER: return createTextFormatter();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public doc2model createdoc2model()
    {
        doc2modelImpl doc2model = new doc2modelImpl();
        return doc2model;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DocStyle createDocStyle()
    {
        DocStyleImpl docStyle = new DocStyleImpl();
        return docStyle;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Hierarchy createHierarchy()
    {
        HierarchyImpl hierarchy = new HierarchyImpl();
        return hierarchy;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeTag createAttributeTag()
    {
        AttributeTagImpl attributeTag = new AttributeTagImpl();
        return attributeTag;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TagElement createTagElement()
    {
        TagElementImpl tagElement = new TagElementImpl();
        return tagElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TagAttribute createTagAttribute()
    {
        TagAttributeImpl tagAttribute = new TagAttributeImpl();
        return tagAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StyleAttribute createStyleAttribute()
    {
        StyleAttributeImpl styleAttribute = new StyleAttributeImpl();
        return styleAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NewClassInjection createNewClassInjection()
    {
        NewClassInjectionImpl newClassInjection = new NewClassInjectionImpl();
        return newClassInjection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompositionInjection createCompositionInjection()
    {
        CompositionInjectionImpl compositionInjection = new CompositionInjectionImpl();
        return compositionInjection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeInjection createAttributeInjection()
    {
        AttributeInjectionImpl attributeInjection = new AttributeInjectionImpl();
        return attributeInjection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReferenceInjection createReferenceInjection()
    {
        ReferenceInjectionImpl referenceInjection = new ReferenceInjectionImpl();
        return referenceInjection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RegExAttribute createRegExAttribute()
    {
        RegExAttributeImpl regExAttribute = new RegExAttributeImpl();
        return regExAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RegEx createRegEx()
    {
        RegExImpl regEx = new RegExImpl();
        return regEx;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NewClassInjectionComposite createNewClassInjectionComposite()
    {
        NewClassInjectionCompositeImpl newClassInjectionComposite = new NewClassInjectionCompositeImpl();
        return newClassInjectionComposite;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ColumnMatchElement createColumnMatchElement()
    {
        ColumnMatchElementImpl columnMatchElement = new ColumnMatchElementImpl();
        return columnMatchElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ColumnMatchAttribute createColumnMatchAttribute()
    {
        ColumnMatchAttributeImpl columnMatchAttribute = new ColumnMatchAttributeImpl();
        return columnMatchAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TextFormatter createTextFormatter()
    {
        TextFormatterImpl textFormatter = new TextFormatterImpl();
        return textFormatter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Doc2modelMappingPackage getDoc2modelMappingPackage()
    {
        return (Doc2modelMappingPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static Doc2modelMappingPackage getPackage()
    {
        return Doc2modelMappingPackage.eINSTANCE;
    }

} //Doc2modelMappingFactoryImpl
