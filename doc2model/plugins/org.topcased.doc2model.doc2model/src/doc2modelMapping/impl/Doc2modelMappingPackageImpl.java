/**
 * <copyright>
 * </copyright>
 *
 * $Id: Doc2modelMappingPackageImpl.java,v 1.6 2009/05/18 07:47:02 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.Attribute;
import doc2modelMapping.AttributeInjection;
import doc2modelMapping.AttributeTag;
import doc2modelMapping.ColumnElement;
import doc2modelMapping.ColumnMatchAttribute;
import doc2modelMapping.AttributeWithValue;
import doc2modelMapping.ColumnMatchElement;
import doc2modelMapping.CompositionInjection;
import doc2modelMapping.DependantInjection;
import doc2modelMapping.Doc2modelMappingFactory;
import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.DocStyle;
import doc2modelMapping.DynamicElement;
import doc2modelMapping.ElementCreationInjection;
import doc2modelMapping.GroupElement;
import doc2modelMapping.Hierarchy;
import doc2modelMapping.INewClassInjection;
import doc2modelMapping.InjectionElement;
import doc2modelMapping.InstanceCreationInjection;
import doc2modelMapping.LinkedElement;
import doc2modelMapping.NewClassInjection;
import doc2modelMapping.NewClassInjectionComposite;
import doc2modelMapping.ReferenceInjection;
import doc2modelMapping.RegEx;
import doc2modelMapping.RegExAttribute;
import doc2modelMapping.RegExMatchingElement;
import doc2modelMapping.StereotpyeApplicableInjection;
import doc2modelMapping.StyleAttribute;
import doc2modelMapping.TagAttribute;
import doc2modelMapping.TagElement;
import doc2modelMapping.TextFormatter;
import doc2modelMapping.doc2model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Doc2modelMappingPackageImpl extends EPackageImpl implements Doc2modelMappingPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass doc2modelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass linkedElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass docStyleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass hierarchyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass attributeTagEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tagElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tagAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dynamicElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass styleAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass attributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass injectionElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass newClassInjectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass compositionInjectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass attributeInjectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dependantInjectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass referenceInjectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass regExAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass regExEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass newClassInjectionCompositeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iNewClassInjectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass stereotpyeApplicableInjectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass columnMatchElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass regExMatchingElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass instanceCreationInjectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass columnMatchAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass columnElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass elementCreationInjectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass textFormatterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass groupElementEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see doc2modelMapping.Doc2modelMappingPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private Doc2modelMappingPackageImpl()
    {
        super(eNS_URI, Doc2modelMappingFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this
     * model, and for any others upon which it depends.  Simple
     * dependencies are satisfied by calling this method on all
     * dependent packages before doing anything else.  This method drives
     * initialization for interdependent packages directly, in parallel
     * with this package, itself.
     * <p>Of this package and its interdependencies, all packages which
     * have not yet been registered by their URI values are first created
     * and registered.  The packages are then initialized in two steps:
     * meta-model objects for all of the packages are created before any
     * are initialized, since one package's meta-model objects may refer to
     * those of another.
     * <p>Invocation of this method will not affect any packages that have
     * already been initialized.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static Doc2modelMappingPackage init()
    {
        if (isInited) return (Doc2modelMappingPackage)EPackage.Registry.INSTANCE.getEPackage(Doc2modelMappingPackage.eNS_URI);

        // Obtain or create and register package
        Doc2modelMappingPackageImpl theDoc2modelMappingPackage = (Doc2modelMappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof Doc2modelMappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new Doc2modelMappingPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theDoc2modelMappingPackage.createPackageContents();

        // Initialize created meta-data
        theDoc2modelMappingPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theDoc2modelMappingPackage.freeze();

        return theDoc2modelMappingPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getdoc2model()
    {
        return doc2modelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getdoc2model_Links()
    {
        return (EReference)doc2modelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getdoc2model_Hierarchy()
    {
        return (EReference)doc2modelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getdoc2model_Extension()
    {
        return (EAttribute)doc2modelEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getdoc2model_MetamodelURI()
    {
        return (EAttribute)doc2modelEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getdoc2model_ProfileURI()
    {
        return (EAttribute)doc2modelEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLinkedElement()
    {
        return linkedElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLinkedElement_Owner()
    {
        return (EReference)linkedElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLinkedElement_Max()
    {
        return (EReference)linkedElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLinkedElement_Attributes()
    {
        return (EReference)linkedElementEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDocStyle()
    {
        return docStyleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDocStyle_StyleName()
    {
        return (EAttribute)docStyleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getHierarchy()
    {
        return hierarchyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHierarchy_Level()
    {
        return (EAttribute)hierarchyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getHierarchy_SubHierarchy()
    {
        return (EReference)hierarchyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHierarchy_StyleValue()
    {
        return (EAttribute)hierarchyEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAttributeTag()
    {
        return attributeTagEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAttributeTag_Value()
    {
        return (EAttribute)attributeTagEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTagElement()
    {
        return tagElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTagElement_SingleLine()
    {
        return (EAttribute)tagElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTagElement_TagValue()
    {
        return (EAttribute)tagElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTagAttribute()
    {
        return tagAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDynamicElement()
    {
        return dynamicElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDynamicElement_Injection()
    {
        return (EReference)dynamicElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStyleAttribute()
    {
        return styleAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAttribute()
    {
        return attributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAttribute_AttributeValue()
    {
        return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInjectionElement()
    {
        return injectionElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInjectionElement_StringFormat()
    {
        return (EReference)injectionElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInjectionElement_StandardOptionalInjections()
    {
        return (EReference)injectionElementEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInjectionElement_Name()
    {
        return (EAttribute)injectionElementEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNewClassInjection()
    {
        return newClassInjectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNewClassInjection_InstanceTarget()
    {
        return (EAttribute)newClassInjectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNewClassInjection_OwningClass()
    {
        return (EAttribute)newClassInjectionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNewClassInjection_AssociationOwning()
    {
        return (EAttribute)newClassInjectionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNewClassInjection_AttributeForValue()
    {
        return (EAttribute)newClassInjectionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNewClassInjection_StereotypeAttributeForValue()
    {
        return (EAttribute)newClassInjectionEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNewClassInjection_BrowseTopContainersForOwner()
    {
        return (EAttribute)newClassInjectionEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCompositionInjection()
    {
        return compositionInjectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCompositionInjection_OwningClass()
    {
        return (EAttribute)compositionInjectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCompositionInjection_AssociationName()
    {
        return (EAttribute)compositionInjectionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCompositionInjection_AttributeName()
    {
        return (EAttribute)compositionInjectionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCompositionInjection_NewInstanceForEachComposition()
    {
        return (EAttribute)compositionInjectionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAttributeInjection()
    {
        return attributeInjectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAttributeInjection_InstanceAttribute()
    {
        return (EAttribute)attributeInjectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAttributeInjection_StereotypeAttribute()
    {
        return (EAttribute)attributeInjectionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDependantInjection()
    {
        return dependantInjectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDependantInjection_DependsWith()
    {
        return (EReference)dependantInjectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getReferenceInjection()
    {
        return referenceInjectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReferenceInjection_AttributeToFind()
    {
        return (EAttribute)referenceInjectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReferenceInjection_ClassReferenced()
    {
        return (EAttribute)referenceInjectionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReferenceInjection_ReferenceAttribute()
    {
        return (EAttribute)referenceInjectionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReferenceInjection_IsStereotypeReference()
    {
        return (EAttribute)referenceInjectionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRegExAttribute()
    {
        return regExAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRegEx()
    {
        return regExEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNewClassInjectionComposite()
    {
        return newClassInjectionCompositeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getNewClassInjectionComposite_Injections()
    {
        return (EReference)newClassInjectionCompositeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getINewClassInjection()
    {
        return iNewClassInjectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStereotpyeApplicableInjection()
    {
        return stereotpyeApplicableInjectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getStereotpyeApplicableInjection_StereotypeToApply()
    {
        return (EAttribute)stereotpyeApplicableInjectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getColumnMatchElement()
    {
        return columnMatchElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRegExMatchingElement()
    {
        return regExMatchingElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRegExMatchingElement_RegExToMatch()
    {
        return (EAttribute)regExMatchingElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInstanceCreationInjection()
    {
        return instanceCreationInjectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInstanceCreationInjection_SpecificNamespaceURI()
    {
        return (EAttribute)instanceCreationInjectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getColumnMatchAttribute()
    {
        return columnMatchAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getColumnElement()
    {
        return columnElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getColumnElement_NumColumn()
    {
        return (EAttribute)columnElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getElementCreationInjection()
    {
        return elementCreationInjectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTextFormatter()
    {
        return textFormatterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextFormatter_Pattern()
    {
        return (EAttribute)textFormatterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextFormatter_RegexForConditionOrGroup()
    {
        return (EAttribute)textFormatterEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGroupElement()
    {
        return groupElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGroupElement_SecondaryInjectionsForGroups()
    {
        return (EReference)groupElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Doc2modelMappingFactory getDoc2modelMappingFactory()
    {
        return (Doc2modelMappingFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents()
    {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        doc2modelEClass = createEClass(DOC2MODEL);
        createEReference(doc2modelEClass, DOC2MODEL__LINKS);
        createEReference(doc2modelEClass, DOC2MODEL__HIERARCHY);
        createEAttribute(doc2modelEClass, DOC2MODEL__EXTENSION);
        createEAttribute(doc2modelEClass, DOC2MODEL__METAMODEL_URI);
        createEAttribute(doc2modelEClass, DOC2MODEL__PROFILE_URI);

        linkedElementEClass = createEClass(LINKED_ELEMENT);
        createEReference(linkedElementEClass, LINKED_ELEMENT__OWNER);
        createEReference(linkedElementEClass, LINKED_ELEMENT__MAX);
        createEReference(linkedElementEClass, LINKED_ELEMENT__ATTRIBUTES);

        docStyleEClass = createEClass(DOC_STYLE);
        createEAttribute(docStyleEClass, DOC_STYLE__STYLE_NAME);

        hierarchyEClass = createEClass(HIERARCHY);
        createEAttribute(hierarchyEClass, HIERARCHY__LEVEL);
        createEReference(hierarchyEClass, HIERARCHY__SUB_HIERARCHY);
        createEAttribute(hierarchyEClass, HIERARCHY__STYLE_VALUE);

        attributeTagEClass = createEClass(ATTRIBUTE_TAG);
        createEAttribute(attributeTagEClass, ATTRIBUTE_TAG__VALUE);

        tagElementEClass = createEClass(TAG_ELEMENT);
        createEAttribute(tagElementEClass, TAG_ELEMENT__SINGLE_LINE);
        createEAttribute(tagElementEClass, TAG_ELEMENT__TAG_VALUE);

        tagAttributeEClass = createEClass(TAG_ATTRIBUTE);

        dynamicElementEClass = createEClass(DYNAMIC_ELEMENT);
        createEReference(dynamicElementEClass, DYNAMIC_ELEMENT__INJECTION);

        styleAttributeEClass = createEClass(STYLE_ATTRIBUTE);

        attributeEClass = createEClass(ATTRIBUTE);
        createEAttribute(attributeEClass, ATTRIBUTE__ATTRIBUTE_VALUE);

        injectionElementEClass = createEClass(INJECTION_ELEMENT);
        createEReference(injectionElementEClass, INJECTION_ELEMENT__STRING_FORMAT);
        createEReference(injectionElementEClass, INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS);
        createEAttribute(injectionElementEClass, INJECTION_ELEMENT__NAME);

        newClassInjectionEClass = createEClass(NEW_CLASS_INJECTION);
        createEAttribute(newClassInjectionEClass, NEW_CLASS_INJECTION__INSTANCE_TARGET);
        createEAttribute(newClassInjectionEClass, NEW_CLASS_INJECTION__OWNING_CLASS);
        createEAttribute(newClassInjectionEClass, NEW_CLASS_INJECTION__ASSOCIATION_OWNING);
        createEAttribute(newClassInjectionEClass, NEW_CLASS_INJECTION__ATTRIBUTE_FOR_VALUE);
        createEAttribute(newClassInjectionEClass, NEW_CLASS_INJECTION__STEREOTYPE_ATTRIBUTE_FOR_VALUE);
        createEAttribute(newClassInjectionEClass, NEW_CLASS_INJECTION__BROWSE_TOP_CONTAINERS_FOR_OWNER);

        compositionInjectionEClass = createEClass(COMPOSITION_INJECTION);
        createEAttribute(compositionInjectionEClass, COMPOSITION_INJECTION__OWNING_CLASS);
        createEAttribute(compositionInjectionEClass, COMPOSITION_INJECTION__ASSOCIATION_NAME);
        createEAttribute(compositionInjectionEClass, COMPOSITION_INJECTION__ATTRIBUTE_NAME);
        createEAttribute(compositionInjectionEClass, COMPOSITION_INJECTION__NEW_INSTANCE_FOR_EACH_COMPOSITION);

        attributeInjectionEClass = createEClass(ATTRIBUTE_INJECTION);
        createEAttribute(attributeInjectionEClass, ATTRIBUTE_INJECTION__INSTANCE_ATTRIBUTE);
        createEAttribute(attributeInjectionEClass, ATTRIBUTE_INJECTION__STEREOTYPE_ATTRIBUTE);

        dependantInjectionEClass = createEClass(DEPENDANT_INJECTION);
        createEReference(dependantInjectionEClass, DEPENDANT_INJECTION__DEPENDS_WITH);

        referenceInjectionEClass = createEClass(REFERENCE_INJECTION);
        createEAttribute(referenceInjectionEClass, REFERENCE_INJECTION__ATTRIBUTE_TO_FIND);
        createEAttribute(referenceInjectionEClass, REFERENCE_INJECTION__CLASS_REFERENCED);
        createEAttribute(referenceInjectionEClass, REFERENCE_INJECTION__REFERENCE_ATTRIBUTE);
        createEAttribute(referenceInjectionEClass, REFERENCE_INJECTION__IS_STEREOTYPE_REFERENCE);

        regExAttributeEClass = createEClass(REG_EX_ATTRIBUTE);

        regExEClass = createEClass(REG_EX);

        newClassInjectionCompositeEClass = createEClass(NEW_CLASS_INJECTION_COMPOSITE);
        createEReference(newClassInjectionCompositeEClass, NEW_CLASS_INJECTION_COMPOSITE__INJECTIONS);

        iNewClassInjectionEClass = createEClass(INEW_CLASS_INJECTION);

        stereotpyeApplicableInjectionEClass = createEClass(STEREOTPYE_APPLICABLE_INJECTION);
        createEAttribute(stereotpyeApplicableInjectionEClass, STEREOTPYE_APPLICABLE_INJECTION__STEREOTYPE_TO_APPLY);

        columnMatchElementEClass = createEClass(COLUMN_MATCH_ELEMENT);

        regExMatchingElementEClass = createEClass(REG_EX_MATCHING_ELEMENT);
        createEAttribute(regExMatchingElementEClass, REG_EX_MATCHING_ELEMENT__REG_EX_TO_MATCH);

        instanceCreationInjectionEClass = createEClass(INSTANCE_CREATION_INJECTION);
        createEAttribute(instanceCreationInjectionEClass, INSTANCE_CREATION_INJECTION__SPECIFIC_NAMESPACE_URI);

        columnMatchAttributeEClass = createEClass(COLUMN_MATCH_ATTRIBUTE);

        columnElementEClass = createEClass(COLUMN_ELEMENT);
        createEAttribute(columnElementEClass, COLUMN_ELEMENT__NUM_COLUMN);

        elementCreationInjectionEClass = createEClass(ELEMENT_CREATION_INJECTION);

        textFormatterEClass = createEClass(TEXT_FORMATTER);
        createEAttribute(textFormatterEClass, TEXT_FORMATTER__PATTERN);
        createEAttribute(textFormatterEClass, TEXT_FORMATTER__REGEX_FOR_CONDITION_OR_GROUP);

        groupElementEClass = createEClass(GROUP_ELEMENT);
        createEReference(groupElementEClass, GROUP_ELEMENT__SECONDARY_INJECTIONS_FOR_GROUPS);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents()
    {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        doc2modelEClass.getESuperTypes().add(this.getDynamicElement());
        linkedElementEClass.getESuperTypes().add(this.getDynamicElement());
        docStyleEClass.getESuperTypes().add(this.getLinkedElement());
        hierarchyEClass.getESuperTypes().add(this.getDynamicElement());
        tagElementEClass.getESuperTypes().add(this.getLinkedElement());
        tagAttributeEClass.getESuperTypes().add(this.getDynamicElement());
        tagAttributeEClass.getESuperTypes().add(this.getAttribute());
        styleAttributeEClass.getESuperTypes().add(this.getAttribute());
        attributeEClass.getESuperTypes().add(this.getDynamicElement());
        newClassInjectionEClass.getESuperTypes().add(this.getINewClassInjection());
        newClassInjectionEClass.getESuperTypes().add(this.getStereotpyeApplicableInjection());
        newClassInjectionEClass.getESuperTypes().add(this.getInstanceCreationInjection());
        newClassInjectionEClass.getESuperTypes().add(this.getElementCreationInjection());
        compositionInjectionEClass.getESuperTypes().add(this.getDependantInjection());
        compositionInjectionEClass.getESuperTypes().add(this.getStereotpyeApplicableInjection());
        compositionInjectionEClass.getESuperTypes().add(this.getInstanceCreationInjection());
        compositionInjectionEClass.getESuperTypes().add(this.getElementCreationInjection());
        attributeInjectionEClass.getESuperTypes().add(this.getDependantInjection());
        dependantInjectionEClass.getESuperTypes().add(this.getInjectionElement());
        referenceInjectionEClass.getESuperTypes().add(this.getDependantInjection());
        regExAttributeEClass.getESuperTypes().add(this.getAttribute());
        regExAttributeEClass.getESuperTypes().add(this.getGroupElement());
        regExEClass.getESuperTypes().add(this.getLinkedElement());
        regExEClass.getESuperTypes().add(this.getRegExMatchingElement());
        regExEClass.getESuperTypes().add(this.getGroupElement());
        newClassInjectionCompositeEClass.getESuperTypes().add(this.getINewClassInjection());
        newClassInjectionCompositeEClass.getESuperTypes().add(this.getElementCreationInjection());
        iNewClassInjectionEClass.getESuperTypes().add(this.getInjectionElement());
        columnMatchElementEClass.getESuperTypes().add(this.getLinkedElement());
        columnMatchElementEClass.getESuperTypes().add(this.getColumnElement());
        columnMatchAttributeEClass.getESuperTypes().add(this.getColumnElement());
        columnMatchAttributeEClass.getESuperTypes().add(this.getAttribute());
        columnElementEClass.getESuperTypes().add(this.getRegExMatchingElement());

        // Initialize classes and features; add operations and parameters
        initEClass(doc2modelEClass, doc2model.class, "doc2model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getdoc2model_Links(), this.getLinkedElement(), this.getLinkedElement_Owner(), "links", null, 0, -1, doc2model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getdoc2model_Hierarchy(), this.getHierarchy(), null, "hierarchy", null, 0, 1, doc2model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getdoc2model_Extension(), ecorePackage.getEString(), "extension", null, 0, 1, doc2model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getdoc2model_MetamodelURI(), ecorePackage.getEString(), "metamodelURI", null, 0, 1, doc2model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getdoc2model_ProfileURI(), ecorePackage.getEString(), "profileURI", null, 0, 1, doc2model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(linkedElementEClass, LinkedElement.class, "LinkedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getLinkedElement_Owner(), this.getdoc2model(), this.getdoc2model_Links(), "owner", null, 0, 1, LinkedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getLinkedElement_Max(), this.getHierarchy(), null, "max", null, 0, 1, LinkedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getLinkedElement_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, LinkedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(docStyleEClass, DocStyle.class, "DocStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDocStyle_StyleName(), ecorePackage.getEString(), "styleName", null, 0, 1, DocStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(hierarchyEClass, Hierarchy.class, "Hierarchy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getHierarchy_Level(), ecorePackage.getEString(), "level", null, 0, 1, Hierarchy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getHierarchy_SubHierarchy(), this.getHierarchy(), null, "subHierarchy", null, 0, 1, Hierarchy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHierarchy_StyleValue(), ecorePackage.getEString(), "styleValue", null, 0, -1, Hierarchy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(attributeTagEClass, AttributeTag.class, "AttributeTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAttributeTag_Value(), ecorePackage.getEString(), "value", null, 0, 1, AttributeTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tagElementEClass, TagElement.class, "TagElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTagElement_SingleLine(), ecorePackage.getEBoolean(), "singleLine", "true", 0, 1, TagElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTagElement_TagValue(), ecorePackage.getEString(), "tagValue", null, 0, 1, TagElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tagAttributeEClass, TagAttribute.class, "TagAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(dynamicElementEClass, DynamicElement.class, "DynamicElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDynamicElement_Injection(), this.getInjectionElement(), null, "injection", null, 1, 1, DynamicElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(styleAttributeEClass, StyleAttribute.class, "StyleAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(attributeEClass, Attribute.class, "Attribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAttribute_AttributeValue(), ecorePackage.getEString(), "attributeValue", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(injectionElementEClass, InjectionElement.class, "InjectionElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getInjectionElement_StringFormat(), this.getTextFormatter(), null, "stringFormat", null, 0, 1, InjectionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInjectionElement_StandardOptionalInjections(), this.getInjectionElement(), null, "standardOptionalInjections", null, 0, -1, InjectionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getInjectionElement_Name(), ecorePackage.getEString(), "name", "noname", 0, 1, InjectionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(newClassInjectionEClass, NewClassInjection.class, "NewClassInjection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNewClassInjection_InstanceTarget(), ecorePackage.getEString(), "instanceTarget", null, 0, 1, NewClassInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNewClassInjection_OwningClass(), ecorePackage.getEString(), "owningClass", null, 0, 1, NewClassInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNewClassInjection_AssociationOwning(), ecorePackage.getEString(), "associationOwning", null, 0, 1, NewClassInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNewClassInjection_AttributeForValue(), ecorePackage.getEString(), "attributeForValue", null, 0, 1, NewClassInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNewClassInjection_StereotypeAttributeForValue(), ecorePackage.getEString(), "stereotypeAttributeForValue", null, 0, 1, NewClassInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNewClassInjection_BrowseTopContainersForOwner(), ecorePackage.getEBoolean(), "browseTopContainersForOwner", "false", 0, 1, NewClassInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(compositionInjectionEClass, CompositionInjection.class, "CompositionInjection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCompositionInjection_OwningClass(), ecorePackage.getEString(), "owningClass", null, 0, 1, CompositionInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCompositionInjection_AssociationName(), ecorePackage.getEString(), "associationName", null, 0, 1, CompositionInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCompositionInjection_AttributeName(), ecorePackage.getEString(), "attributeName", null, 0, 1, CompositionInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCompositionInjection_NewInstanceForEachComposition(), ecorePackage.getEBoolean(), "newInstanceForEachComposition", null, 0, 1, CompositionInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(attributeInjectionEClass, AttributeInjection.class, "AttributeInjection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAttributeInjection_InstanceAttribute(), ecorePackage.getEString(), "instanceAttribute", null, 0, 1, AttributeInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAttributeInjection_StereotypeAttribute(), ecorePackage.getEString(), "stereotypeAttribute", null, 0, 1, AttributeInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dependantInjectionEClass, DependantInjection.class, "DependantInjection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDependantInjection_DependsWith(), this.getElementCreationInjection(), null, "dependsWith", null, 0, 1, DependantInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(referenceInjectionEClass, ReferenceInjection.class, "ReferenceInjection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getReferenceInjection_AttributeToFind(), ecorePackage.getEString(), "attributeToFind", null, 0, 1, ReferenceInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReferenceInjection_ClassReferenced(), ecorePackage.getEString(), "classReferenced", null, 0, 1, ReferenceInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReferenceInjection_ReferenceAttribute(), ecorePackage.getEString(), "referenceAttribute", null, 0, 1, ReferenceInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReferenceInjection_IsStereotypeReference(), ecorePackage.getEBoolean(), "isStereotypeReference", "false", 0, 1, ReferenceInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(regExAttributeEClass, RegExAttribute.class, "RegExAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(regExEClass, RegEx.class, "RegEx", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(newClassInjectionCompositeEClass, NewClassInjectionComposite.class, "NewClassInjectionComposite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getNewClassInjectionComposite_Injections(), this.getNewClassInjection(), null, "injections", null, 0, -1, NewClassInjectionComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(iNewClassInjectionEClass, INewClassInjection.class, "INewClassInjection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(stereotpyeApplicableInjectionEClass, StereotpyeApplicableInjection.class, "StereotpyeApplicableInjection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getStereotpyeApplicableInjection_StereotypeToApply(), ecorePackage.getEString(), "stereotypeToApply", null, 0, 1, StereotpyeApplicableInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(columnMatchElementEClass, ColumnMatchElement.class, "ColumnMatchElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(regExMatchingElementEClass, RegExMatchingElement.class, "RegExMatchingElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRegExMatchingElement_RegExToMatch(), ecorePackage.getEString(), "regExToMatch", null, 0, 1, RegExMatchingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(instanceCreationInjectionEClass, InstanceCreationInjection.class, "InstanceCreationInjection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getInstanceCreationInjection_SpecificNamespaceURI(), ecorePackage.getEString(), "specificNamespaceURI", null, 0, 1, InstanceCreationInjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(columnMatchAttributeEClass, ColumnMatchAttribute.class, "ColumnMatchAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(columnElementEClass, ColumnElement.class, "ColumnElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getColumnElement_NumColumn(), ecorePackage.getEInt(), "numColumn", null, 0, 1, ColumnElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(elementCreationInjectionEClass, ElementCreationInjection.class, "ElementCreationInjection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(textFormatterEClass, TextFormatter.class, "TextFormatter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTextFormatter_Pattern(), ecorePackage.getEString(), "pattern", null, 0, 1, TextFormatter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTextFormatter_RegexForConditionOrGroup(), ecorePackage.getEString(), "regexForConditionOrGroup", null, 0, 1, TextFormatter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(groupElementEClass, GroupElement.class, "GroupElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getGroupElement_SecondaryInjectionsForGroups(), this.getDependantInjection(), null, "secondaryInjectionsForGroups", null, 0, -1, GroupElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //Doc2modelMappingPackageImpl
