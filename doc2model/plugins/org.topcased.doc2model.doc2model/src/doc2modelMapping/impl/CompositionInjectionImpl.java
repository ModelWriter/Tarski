/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompositionInjectionImpl.java,v 1.4 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.CompositionInjection;
import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.ElementCreationInjection;
import doc2modelMapping.InstanceCreationInjection;
import doc2modelMapping.StereotpyeApplicableInjection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composition Injection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.CompositionInjectionImpl#getStereotypeToApply <em>Stereotype To Apply</em>}</li>
 *   <li>{@link doc2modelMapping.impl.CompositionInjectionImpl#getSpecificNamespaceURI <em>Specific Namespace URI</em>}</li>
 *   <li>{@link doc2modelMapping.impl.CompositionInjectionImpl#getOwningClass <em>Owning Class</em>}</li>
 *   <li>{@link doc2modelMapping.impl.CompositionInjectionImpl#getAssociationName <em>Association Name</em>}</li>
 *   <li>{@link doc2modelMapping.impl.CompositionInjectionImpl#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link doc2modelMapping.impl.CompositionInjectionImpl#isNewInstanceForEachComposition <em>New Instance For Each Composition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositionInjectionImpl extends DependantInjectionImpl implements CompositionInjection
{
    /**
     * The default value of the '{@link #getStereotypeToApply() <em>Stereotype To Apply</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStereotypeToApply()
     * @generated
     * @ordered
     */
    protected static final String STEREOTYPE_TO_APPLY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getStereotypeToApply() <em>Stereotype To Apply</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStereotypeToApply()
     * @generated
     * @ordered
     */
    protected String stereotypeToApply = STEREOTYPE_TO_APPLY_EDEFAULT;

    /**
     * The default value of the '{@link #getSpecificNamespaceURI() <em>Specific Namespace URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSpecificNamespaceURI()
     * @generated
     * @ordered
     */
    protected static final String SPECIFIC_NAMESPACE_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSpecificNamespaceURI() <em>Specific Namespace URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSpecificNamespaceURI()
     * @generated
     * @ordered
     */
    protected String specificNamespaceURI = SPECIFIC_NAMESPACE_URI_EDEFAULT;

    /**
     * The default value of the '{@link #getOwningClass() <em>Owning Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOwningClass()
     * @generated
     * @ordered
     */
    protected static final String OWNING_CLASS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOwningClass() <em>Owning Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOwningClass()
     * @generated
     * @ordered
     */
    protected String owningClass = OWNING_CLASS_EDEFAULT;

    /**
     * The default value of the '{@link #getAssociationName() <em>Association Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAssociationName()
     * @generated
     * @ordered
     */
    protected static final String ASSOCIATION_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAssociationName() <em>Association Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAssociationName()
     * @generated
     * @ordered
     */
    protected String associationName = ASSOCIATION_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttributeName()
     * @generated
     * @ordered
     */
    protected static final String ATTRIBUTE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttributeName()
     * @generated
     * @ordered
     */
    protected String attributeName = ATTRIBUTE_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #isNewInstanceForEachComposition() <em>New Instance For Each Composition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNewInstanceForEachComposition()
     * @generated
     * @ordered
     */
    protected static final boolean NEW_INSTANCE_FOR_EACH_COMPOSITION_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isNewInstanceForEachComposition() <em>New Instance For Each Composition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNewInstanceForEachComposition()
     * @generated
     * @ordered
     */
    protected boolean newInstanceForEachComposition = NEW_INSTANCE_FOR_EACH_COMPOSITION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CompositionInjectionImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass()
    {
        return Doc2modelMappingPackage.Literals.COMPOSITION_INJECTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getStereotypeToApply()
    {
        return stereotypeToApply;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStereotypeToApply(String newStereotypeToApply)
    {
        String oldStereotypeToApply = stereotypeToApply;
        stereotypeToApply = newStereotypeToApply;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.COMPOSITION_INJECTION__STEREOTYPE_TO_APPLY, oldStereotypeToApply, stereotypeToApply));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSpecificNamespaceURI()
    {
        return specificNamespaceURI;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSpecificNamespaceURI(String newSpecificNamespaceURI)
    {
        String oldSpecificNamespaceURI = specificNamespaceURI;
        specificNamespaceURI = newSpecificNamespaceURI;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.COMPOSITION_INJECTION__SPECIFIC_NAMESPACE_URI, oldSpecificNamespaceURI, specificNamespaceURI));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOwningClass()
    {
        return owningClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOwningClass(String newOwningClass)
    {
        String oldOwningClass = owningClass;
        owningClass = newOwningClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.COMPOSITION_INJECTION__OWNING_CLASS, oldOwningClass, owningClass));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAssociationName()
    {
        return associationName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAssociationName(String newAssociationName)
    {
        String oldAssociationName = associationName;
        associationName = newAssociationName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.COMPOSITION_INJECTION__ASSOCIATION_NAME, oldAssociationName, associationName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAttributeName()
    {
        return attributeName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAttributeName(String newAttributeName)
    {
        String oldAttributeName = attributeName;
        attributeName = newAttributeName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.COMPOSITION_INJECTION__ATTRIBUTE_NAME, oldAttributeName, attributeName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isNewInstanceForEachComposition()
    {
        return newInstanceForEachComposition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNewInstanceForEachComposition(boolean newNewInstanceForEachComposition)
    {
        boolean oldNewInstanceForEachComposition = newInstanceForEachComposition;
        newInstanceForEachComposition = newNewInstanceForEachComposition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.COMPOSITION_INJECTION__NEW_INSTANCE_FOR_EACH_COMPOSITION, oldNewInstanceForEachComposition, newInstanceForEachComposition));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__STEREOTYPE_TO_APPLY:
                return getStereotypeToApply();
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__SPECIFIC_NAMESPACE_URI:
                return getSpecificNamespaceURI();
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__OWNING_CLASS:
                return getOwningClass();
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__ASSOCIATION_NAME:
                return getAssociationName();
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__ATTRIBUTE_NAME:
                return getAttributeName();
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__NEW_INSTANCE_FOR_EACH_COMPOSITION:
                return isNewInstanceForEachComposition() ? Boolean.TRUE : Boolean.FALSE;
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__STEREOTYPE_TO_APPLY:
                setStereotypeToApply((String)newValue);
                return;
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__SPECIFIC_NAMESPACE_URI:
                setSpecificNamespaceURI((String)newValue);
                return;
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__OWNING_CLASS:
                setOwningClass((String)newValue);
                return;
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__ASSOCIATION_NAME:
                setAssociationName((String)newValue);
                return;
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__ATTRIBUTE_NAME:
                setAttributeName((String)newValue);
                return;
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__NEW_INSTANCE_FOR_EACH_COMPOSITION:
                setNewInstanceForEachComposition(((Boolean)newValue).booleanValue());
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__STEREOTYPE_TO_APPLY:
                setStereotypeToApply(STEREOTYPE_TO_APPLY_EDEFAULT);
                return;
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__SPECIFIC_NAMESPACE_URI:
                setSpecificNamespaceURI(SPECIFIC_NAMESPACE_URI_EDEFAULT);
                return;
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__OWNING_CLASS:
                setOwningClass(OWNING_CLASS_EDEFAULT);
                return;
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__ASSOCIATION_NAME:
                setAssociationName(ASSOCIATION_NAME_EDEFAULT);
                return;
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__ATTRIBUTE_NAME:
                setAttributeName(ATTRIBUTE_NAME_EDEFAULT);
                return;
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__NEW_INSTANCE_FOR_EACH_COMPOSITION:
                setNewInstanceForEachComposition(NEW_INSTANCE_FOR_EACH_COMPOSITION_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__STEREOTYPE_TO_APPLY:
                return STEREOTYPE_TO_APPLY_EDEFAULT == null ? stereotypeToApply != null : !STEREOTYPE_TO_APPLY_EDEFAULT.equals(stereotypeToApply);
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__SPECIFIC_NAMESPACE_URI:
                return SPECIFIC_NAMESPACE_URI_EDEFAULT == null ? specificNamespaceURI != null : !SPECIFIC_NAMESPACE_URI_EDEFAULT.equals(specificNamespaceURI);
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__OWNING_CLASS:
                return OWNING_CLASS_EDEFAULT == null ? owningClass != null : !OWNING_CLASS_EDEFAULT.equals(owningClass);
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__ASSOCIATION_NAME:
                return ASSOCIATION_NAME_EDEFAULT == null ? associationName != null : !ASSOCIATION_NAME_EDEFAULT.equals(associationName);
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__ATTRIBUTE_NAME:
                return ATTRIBUTE_NAME_EDEFAULT == null ? attributeName != null : !ATTRIBUTE_NAME_EDEFAULT.equals(attributeName);
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__NEW_INSTANCE_FOR_EACH_COMPOSITION:
                return newInstanceForEachComposition != NEW_INSTANCE_FOR_EACH_COMPOSITION_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
    {
        if (baseClass == StereotpyeApplicableInjection.class)
        {
            switch (derivedFeatureID)
            {
                case Doc2modelMappingPackage.COMPOSITION_INJECTION__STEREOTYPE_TO_APPLY: return Doc2modelMappingPackage.STEREOTPYE_APPLICABLE_INJECTION__STEREOTYPE_TO_APPLY;
                default: return -1;
            }
        }
        if (baseClass == InstanceCreationInjection.class)
        {
            switch (derivedFeatureID)
            {
                case Doc2modelMappingPackage.COMPOSITION_INJECTION__SPECIFIC_NAMESPACE_URI: return Doc2modelMappingPackage.INSTANCE_CREATION_INJECTION__SPECIFIC_NAMESPACE_URI;
                default: return -1;
            }
        }
        if (baseClass == ElementCreationInjection.class)
        {
            switch (derivedFeatureID)
            {
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
    {
        if (baseClass == StereotpyeApplicableInjection.class)
        {
            switch (baseFeatureID)
            {
                case Doc2modelMappingPackage.STEREOTPYE_APPLICABLE_INJECTION__STEREOTYPE_TO_APPLY: return Doc2modelMappingPackage.COMPOSITION_INJECTION__STEREOTYPE_TO_APPLY;
                default: return -1;
            }
        }
        if (baseClass == InstanceCreationInjection.class)
        {
            switch (baseFeatureID)
            {
                case Doc2modelMappingPackage.INSTANCE_CREATION_INJECTION__SPECIFIC_NAMESPACE_URI: return Doc2modelMappingPackage.COMPOSITION_INJECTION__SPECIFIC_NAMESPACE_URI;
                default: return -1;
            }
        }
        if (baseClass == ElementCreationInjection.class)
        {
            switch (baseFeatureID)
            {
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString()
    {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (stereotypeToApply: ");
        result.append(stereotypeToApply);
        result.append(", specificNamespaceURI: ");
        result.append(specificNamespaceURI);
        result.append(", owningClass: ");
        result.append(owningClass);
        result.append(", associationName: ");
        result.append(associationName);
        result.append(", attributeName: ");
        result.append(attributeName);
        result.append(", newInstanceForEachComposition: ");
        result.append(newInstanceForEachComposition);
        result.append(')');
        return result.toString();
    }

} //CompositionInjectionImpl
