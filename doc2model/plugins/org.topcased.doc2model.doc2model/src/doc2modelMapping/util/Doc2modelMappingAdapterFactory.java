/**
 * <copyright>
 * </copyright>
 *
 * $Id: Doc2modelMappingAdapterFactory.java,v 1.5 2009/05/15 13:13:32 tfaure Exp $
 */
package doc2modelMapping.util;

import doc2modelMapping.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see doc2modelMapping.Doc2modelMappingPackage
 * @generated
 */
public class Doc2modelMappingAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static Doc2modelMappingPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Doc2modelMappingAdapterFactory()
    {
        if (modelPackage == null)
        {
            modelPackage = Doc2modelMappingPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object)
    {
        if (object == modelPackage)
        {
            return true;
        }
        if (object instanceof EObject)
        {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Doc2modelMappingSwitch<Adapter> modelSwitch =
        new Doc2modelMappingSwitch<Adapter>()
        {
            @Override
            public Adapter casedoc2model(doc2model object)
            {
                return createdoc2modelAdapter();
            }
            @Override
            public Adapter caseLinkedElement(LinkedElement object)
            {
                return createLinkedElementAdapter();
            }
            @Override
            public Adapter caseDocStyle(DocStyle object)
            {
                return createDocStyleAdapter();
            }
            @Override
            public Adapter caseHierarchy(Hierarchy object)
            {
                return createHierarchyAdapter();
            }
            @Override
            public Adapter caseAttributeTag(AttributeTag object)
            {
                return createAttributeTagAdapter();
            }
            @Override
            public Adapter caseTagElement(TagElement object)
            {
                return createTagElementAdapter();
            }
            @Override
            public Adapter caseTagAttribute(TagAttribute object)
            {
                return createTagAttributeAdapter();
            }
            @Override
            public Adapter caseDynamicElement(DynamicElement object)
            {
                return createDynamicElementAdapter();
            }
            @Override
            public Adapter caseStyleAttribute(StyleAttribute object)
            {
                return createStyleAttributeAdapter();
            }
            @Override
            public Adapter caseAttribute(Attribute object)
            {
                return createAttributeAdapter();
            }
            @Override
            public Adapter caseInjectionElement(InjectionElement object)
            {
                return createInjectionElementAdapter();
            }
            @Override
            public Adapter caseNewClassInjection(NewClassInjection object)
            {
                return createNewClassInjectionAdapter();
            }
            @Override
            public Adapter caseCompositionInjection(CompositionInjection object)
            {
                return createCompositionInjectionAdapter();
            }
            @Override
            public Adapter caseAttributeInjection(AttributeInjection object)
            {
                return createAttributeInjectionAdapter();
            }
            @Override
            public Adapter caseDependantInjection(DependantInjection object)
            {
                return createDependantInjectionAdapter();
            }
            @Override
            public Adapter caseReferenceInjection(ReferenceInjection object)
            {
                return createReferenceInjectionAdapter();
            }
            @Override
            public Adapter caseRegExAttribute(RegExAttribute object)
            {
                return createRegExAttributeAdapter();
            }
            @Override
            public Adapter caseRegEx(RegEx object)
            {
                return createRegExAdapter();
            }
            @Override
            public Adapter caseNewClassInjectionComposite(NewClassInjectionComposite object)
            {
                return createNewClassInjectionCompositeAdapter();
            }
            @Override
            public Adapter caseINewClassInjection(INewClassInjection object)
            {
                return createINewClassInjectionAdapter();
            }
            @Override
            public Adapter caseStereotpyeApplicableInjection(StereotpyeApplicableInjection object)
            {
                return createStereotpyeApplicableInjectionAdapter();
            }
            @Override
            public Adapter caseColumnMatchElement(ColumnMatchElement object)
            {
                return createColumnMatchElementAdapter();
            }
            @Override
            public Adapter caseRegExMatchingElement(RegExMatchingElement object)
            {
                return createRegExMatchingElementAdapter();
            }
            @Override
            public Adapter caseInstanceCreationInjection(InstanceCreationInjection object)
            {
                return createInstanceCreationInjectionAdapter();
            }
            @Override
            public Adapter caseColumnMatchAttribute(ColumnMatchAttribute object)
            {
                return createColumnMatchAttributeAdapter();
            }
            @Override
            public Adapter caseColumnElement(ColumnElement object)
            {
                return createColumnElementAdapter();
            }
            @Override
            public Adapter caseElementCreationInjection(ElementCreationInjection object)
            {
                return createElementCreationInjectionAdapter();
            }
            @Override
            public Adapter caseTextFormatter(TextFormatter object)
            {
                return createTextFormatterAdapter();
            }
            @Override
            public Adapter caseGroupElement(GroupElement object)
            {
                return createGroupElementAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object)
            {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target)
    {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.doc2model <em>doc2model</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.doc2model
     * @generated
     */
    public Adapter createdoc2modelAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.LinkedElement <em>Linked Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.LinkedElement
     * @generated
     */
    public Adapter createLinkedElementAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.DocStyle <em>Doc Style</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.DocStyle
     * @generated
     */
    public Adapter createDocStyleAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.Hierarchy <em>Hierarchy</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.Hierarchy
     * @generated
     */
    public Adapter createHierarchyAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.AttributeTag <em>Attribute Tag</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.AttributeTag
     * @generated
     */
    public Adapter createAttributeTagAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.TagElement <em>Tag Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.TagElement
     * @generated
     */
    public Adapter createTagElementAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.TagAttribute <em>Tag Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.TagAttribute
     * @generated
     */
    public Adapter createTagAttributeAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.DynamicElement <em>Dynamic Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.DynamicElement
     * @generated
     */
    public Adapter createDynamicElementAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.StyleAttribute <em>Style Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.StyleAttribute
     * @generated
     */
    public Adapter createStyleAttributeAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.Attribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.Attribute
     * @generated
     */
    public Adapter createAttributeAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.InjectionElement <em>Injection Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.InjectionElement
     * @generated
     */
    public Adapter createInjectionElementAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.NewClassInjection <em>New Class Injection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.NewClassInjection
     * @generated
     */
    public Adapter createNewClassInjectionAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.CompositionInjection <em>Composition Injection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.CompositionInjection
     * @generated
     */
    public Adapter createCompositionInjectionAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.AttributeInjection <em>Attribute Injection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.AttributeInjection
     * @generated
     */
    public Adapter createAttributeInjectionAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.DependantInjection <em>Dependant Injection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.DependantInjection
     * @generated
     */
    public Adapter createDependantInjectionAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.ReferenceInjection <em>Reference Injection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.ReferenceInjection
     * @generated
     */
    public Adapter createReferenceInjectionAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.RegExAttribute <em>Reg Ex Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.RegExAttribute
     * @generated
     */
    public Adapter createRegExAttributeAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.RegEx <em>Reg Ex</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.RegEx
     * @generated
     */
    public Adapter createRegExAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.NewClassInjectionComposite <em>New Class Injection Composite</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.NewClassInjectionComposite
     * @generated
     */
    public Adapter createNewClassInjectionCompositeAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.INewClassInjection <em>INew Class Injection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.INewClassInjection
     * @generated
     */
    public Adapter createINewClassInjectionAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.StereotpyeApplicableInjection <em>Stereotpye Applicable Injection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.StereotpyeApplicableInjection
     * @generated
     */
    public Adapter createStereotpyeApplicableInjectionAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.ColumnMatchElement <em>Column Match Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.ColumnMatchElement
     * @generated
     */
    public Adapter createColumnMatchElementAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.RegExMatchingElement <em>Reg Ex Matching Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.RegExMatchingElement
     * @generated
     */
    public Adapter createRegExMatchingElementAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.InstanceCreationInjection <em>Instance Creation Injection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.InstanceCreationInjection
     * @generated
     */
    public Adapter createInstanceCreationInjectionAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.ColumnMatchAttribute <em>Column Match Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.ColumnMatchAttribute
     * @generated
     */
    public Adapter createColumnMatchAttributeAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.ColumnElement <em>Column Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.ColumnElement
     * @generated
     */
    public Adapter createColumnElementAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.ElementCreationInjection <em>Element Creation Injection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.ElementCreationInjection
     * @generated
     */
    public Adapter createElementCreationInjectionAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.TextFormatter <em>Text Formatter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.TextFormatter
     * @generated
     */
    public Adapter createTextFormatterAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link doc2modelMapping.GroupElement <em>Group Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see doc2modelMapping.GroupElement
     * @generated
     */
    public Adapter createGroupElementAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter()
    {
        return null;
    }

} //Doc2modelMappingAdapterFactory
