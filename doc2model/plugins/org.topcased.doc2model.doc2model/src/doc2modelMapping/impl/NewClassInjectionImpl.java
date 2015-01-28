/**
 * <copyright>
 * </copyright>
 *
 * $Id: NewClassInjectionImpl.java,v 1.4 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.ElementCreationInjection;
import doc2modelMapping.InstanceCreationInjection;
import doc2modelMapping.NewClassInjection;
import doc2modelMapping.StereotpyeApplicableInjection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Class Injection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.NewClassInjectionImpl#getStereotypeToApply <em>Stereotype To Apply</em>}</li>
 *   <li>{@link doc2modelMapping.impl.NewClassInjectionImpl#getSpecificNamespaceURI <em>Specific Namespace URI</em>}</li>
 *   <li>{@link doc2modelMapping.impl.NewClassInjectionImpl#getInstanceTarget <em>Instance Target</em>}</li>
 *   <li>{@link doc2modelMapping.impl.NewClassInjectionImpl#getOwningClass <em>Owning Class</em>}</li>
 *   <li>{@link doc2modelMapping.impl.NewClassInjectionImpl#getAssociationOwning <em>Association Owning</em>}</li>
 *   <li>{@link doc2modelMapping.impl.NewClassInjectionImpl#getAttributeForValue <em>Attribute For Value</em>}</li>
 *   <li>{@link doc2modelMapping.impl.NewClassInjectionImpl#getStereotypeAttributeForValue <em>Stereotype Attribute For Value</em>}</li>
 *   <li>{@link doc2modelMapping.impl.NewClassInjectionImpl#isBrowseTopContainersForOwner <em>Browse Top Containers For Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NewClassInjectionImpl extends INewClassInjectionImpl implements NewClassInjection
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
     * The default value of the '{@link #getInstanceTarget() <em>Instance Target</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstanceTarget()
     * @generated
     * @ordered
     */
    protected static final String INSTANCE_TARGET_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getInstanceTarget() <em>Instance Target</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstanceTarget()
     * @generated
     * @ordered
     */
    protected String instanceTarget = INSTANCE_TARGET_EDEFAULT;

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
     * The default value of the '{@link #getAssociationOwning() <em>Association Owning</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAssociationOwning()
     * @generated
     * @ordered
     */
    protected static final String ASSOCIATION_OWNING_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAssociationOwning() <em>Association Owning</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAssociationOwning()
     * @generated
     * @ordered
     */
    protected String associationOwning = ASSOCIATION_OWNING_EDEFAULT;

    /**
     * The default value of the '{@link #getAttributeForValue() <em>Attribute For Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttributeForValue()
     * @generated
     * @ordered
     */
    protected static final String ATTRIBUTE_FOR_VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAttributeForValue() <em>Attribute For Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttributeForValue()
     * @generated
     * @ordered
     */
    protected String attributeForValue = ATTRIBUTE_FOR_VALUE_EDEFAULT;

    /**
     * The default value of the '{@link #getStereotypeAttributeForValue() <em>Stereotype Attribute For Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStereotypeAttributeForValue()
     * @generated
     * @ordered
     */
    protected static final String STEREOTYPE_ATTRIBUTE_FOR_VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getStereotypeAttributeForValue() <em>Stereotype Attribute For Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStereotypeAttributeForValue()
     * @generated
     * @ordered
     */
    protected String stereotypeAttributeForValue = STEREOTYPE_ATTRIBUTE_FOR_VALUE_EDEFAULT;

    /**
     * The default value of the '{@link #isBrowseTopContainersForOwner() <em>Browse Top Containers For Owner</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isBrowseTopContainersForOwner()
     * @generated
     * @ordered
     */
    protected static final boolean BROWSE_TOP_CONTAINERS_FOR_OWNER_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isBrowseTopContainersForOwner() <em>Browse Top Containers For Owner</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isBrowseTopContainersForOwner()
     * @generated
     * @ordered
     */
    protected boolean browseTopContainersForOwner = BROWSE_TOP_CONTAINERS_FOR_OWNER_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected NewClassInjectionImpl()
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
        return Doc2modelMappingPackage.Literals.NEW_CLASS_INJECTION;
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
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.NEW_CLASS_INJECTION__STEREOTYPE_TO_APPLY, oldStereotypeToApply, stereotypeToApply));
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
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.NEW_CLASS_INJECTION__SPECIFIC_NAMESPACE_URI, oldSpecificNamespaceURI, specificNamespaceURI));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getInstanceTarget()
    {
        return instanceTarget;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInstanceTarget(String newInstanceTarget)
    {
        String oldInstanceTarget = instanceTarget;
        instanceTarget = newInstanceTarget;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.NEW_CLASS_INJECTION__INSTANCE_TARGET, oldInstanceTarget, instanceTarget));
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
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.NEW_CLASS_INJECTION__OWNING_CLASS, oldOwningClass, owningClass));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAssociationOwning()
    {
        return associationOwning;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAssociationOwning(String newAssociationOwning)
    {
        String oldAssociationOwning = associationOwning;
        associationOwning = newAssociationOwning;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.NEW_CLASS_INJECTION__ASSOCIATION_OWNING, oldAssociationOwning, associationOwning));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAttributeForValue()
    {
        return attributeForValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAttributeForValue(String newAttributeForValue)
    {
        String oldAttributeForValue = attributeForValue;
        attributeForValue = newAttributeForValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.NEW_CLASS_INJECTION__ATTRIBUTE_FOR_VALUE, oldAttributeForValue, attributeForValue));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getStereotypeAttributeForValue()
    {
        return stereotypeAttributeForValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStereotypeAttributeForValue(String newStereotypeAttributeForValue)
    {
        String oldStereotypeAttributeForValue = stereotypeAttributeForValue;
        stereotypeAttributeForValue = newStereotypeAttributeForValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.NEW_CLASS_INJECTION__STEREOTYPE_ATTRIBUTE_FOR_VALUE, oldStereotypeAttributeForValue, stereotypeAttributeForValue));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isBrowseTopContainersForOwner()
    {
        return browseTopContainersForOwner;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBrowseTopContainersForOwner(boolean newBrowseTopContainersForOwner)
    {
        boolean oldBrowseTopContainersForOwner = browseTopContainersForOwner;
        browseTopContainersForOwner = newBrowseTopContainersForOwner;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.NEW_CLASS_INJECTION__BROWSE_TOP_CONTAINERS_FOR_OWNER, oldBrowseTopContainersForOwner, browseTopContainersForOwner));
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
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__STEREOTYPE_TO_APPLY:
                return getStereotypeToApply();
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__SPECIFIC_NAMESPACE_URI:
                return getSpecificNamespaceURI();
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__INSTANCE_TARGET:
                return getInstanceTarget();
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__OWNING_CLASS:
                return getOwningClass();
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__ASSOCIATION_OWNING:
                return getAssociationOwning();
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__ATTRIBUTE_FOR_VALUE:
                return getAttributeForValue();
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__STEREOTYPE_ATTRIBUTE_FOR_VALUE:
                return getStereotypeAttributeForValue();
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__BROWSE_TOP_CONTAINERS_FOR_OWNER:
                return isBrowseTopContainersForOwner() ? Boolean.TRUE : Boolean.FALSE;
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
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__STEREOTYPE_TO_APPLY:
                setStereotypeToApply((String)newValue);
                return;
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__SPECIFIC_NAMESPACE_URI:
                setSpecificNamespaceURI((String)newValue);
                return;
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__INSTANCE_TARGET:
                setInstanceTarget((String)newValue);
                return;
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__OWNING_CLASS:
                setOwningClass((String)newValue);
                return;
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__ASSOCIATION_OWNING:
                setAssociationOwning((String)newValue);
                return;
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__ATTRIBUTE_FOR_VALUE:
                setAttributeForValue((String)newValue);
                return;
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__STEREOTYPE_ATTRIBUTE_FOR_VALUE:
                setStereotypeAttributeForValue((String)newValue);
                return;
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__BROWSE_TOP_CONTAINERS_FOR_OWNER:
                setBrowseTopContainersForOwner(((Boolean)newValue).booleanValue());
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
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__STEREOTYPE_TO_APPLY:
                setStereotypeToApply(STEREOTYPE_TO_APPLY_EDEFAULT);
                return;
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__SPECIFIC_NAMESPACE_URI:
                setSpecificNamespaceURI(SPECIFIC_NAMESPACE_URI_EDEFAULT);
                return;
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__INSTANCE_TARGET:
                setInstanceTarget(INSTANCE_TARGET_EDEFAULT);
                return;
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__OWNING_CLASS:
                setOwningClass(OWNING_CLASS_EDEFAULT);
                return;
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__ASSOCIATION_OWNING:
                setAssociationOwning(ASSOCIATION_OWNING_EDEFAULT);
                return;
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__ATTRIBUTE_FOR_VALUE:
                setAttributeForValue(ATTRIBUTE_FOR_VALUE_EDEFAULT);
                return;
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__STEREOTYPE_ATTRIBUTE_FOR_VALUE:
                setStereotypeAttributeForValue(STEREOTYPE_ATTRIBUTE_FOR_VALUE_EDEFAULT);
                return;
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__BROWSE_TOP_CONTAINERS_FOR_OWNER:
                setBrowseTopContainersForOwner(BROWSE_TOP_CONTAINERS_FOR_OWNER_EDEFAULT);
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
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__STEREOTYPE_TO_APPLY:
                return STEREOTYPE_TO_APPLY_EDEFAULT == null ? stereotypeToApply != null : !STEREOTYPE_TO_APPLY_EDEFAULT.equals(stereotypeToApply);
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__SPECIFIC_NAMESPACE_URI:
                return SPECIFIC_NAMESPACE_URI_EDEFAULT == null ? specificNamespaceURI != null : !SPECIFIC_NAMESPACE_URI_EDEFAULT.equals(specificNamespaceURI);
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__INSTANCE_TARGET:
                return INSTANCE_TARGET_EDEFAULT == null ? instanceTarget != null : !INSTANCE_TARGET_EDEFAULT.equals(instanceTarget);
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__OWNING_CLASS:
                return OWNING_CLASS_EDEFAULT == null ? owningClass != null : !OWNING_CLASS_EDEFAULT.equals(owningClass);
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__ASSOCIATION_OWNING:
                return ASSOCIATION_OWNING_EDEFAULT == null ? associationOwning != null : !ASSOCIATION_OWNING_EDEFAULT.equals(associationOwning);
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__ATTRIBUTE_FOR_VALUE:
                return ATTRIBUTE_FOR_VALUE_EDEFAULT == null ? attributeForValue != null : !ATTRIBUTE_FOR_VALUE_EDEFAULT.equals(attributeForValue);
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__STEREOTYPE_ATTRIBUTE_FOR_VALUE:
                return STEREOTYPE_ATTRIBUTE_FOR_VALUE_EDEFAULT == null ? stereotypeAttributeForValue != null : !STEREOTYPE_ATTRIBUTE_FOR_VALUE_EDEFAULT.equals(stereotypeAttributeForValue);
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION__BROWSE_TOP_CONTAINERS_FOR_OWNER:
                return browseTopContainersForOwner != BROWSE_TOP_CONTAINERS_FOR_OWNER_EDEFAULT;
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
                case Doc2modelMappingPackage.NEW_CLASS_INJECTION__STEREOTYPE_TO_APPLY: return Doc2modelMappingPackage.STEREOTPYE_APPLICABLE_INJECTION__STEREOTYPE_TO_APPLY;
                default: return -1;
            }
        }
        if (baseClass == InstanceCreationInjection.class)
        {
            switch (derivedFeatureID)
            {
                case Doc2modelMappingPackage.NEW_CLASS_INJECTION__SPECIFIC_NAMESPACE_URI: return Doc2modelMappingPackage.INSTANCE_CREATION_INJECTION__SPECIFIC_NAMESPACE_URI;
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
                case Doc2modelMappingPackage.STEREOTPYE_APPLICABLE_INJECTION__STEREOTYPE_TO_APPLY: return Doc2modelMappingPackage.NEW_CLASS_INJECTION__STEREOTYPE_TO_APPLY;
                default: return -1;
            }
        }
        if (baseClass == InstanceCreationInjection.class)
        {
            switch (baseFeatureID)
            {
                case Doc2modelMappingPackage.INSTANCE_CREATION_INJECTION__SPECIFIC_NAMESPACE_URI: return Doc2modelMappingPackage.NEW_CLASS_INJECTION__SPECIFIC_NAMESPACE_URI;
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
        result.append(", instanceTarget: ");
        result.append(instanceTarget);
        result.append(", owningClass: ");
        result.append(owningClass);
        result.append(", associationOwning: ");
        result.append(associationOwning);
        result.append(", attributeForValue: ");
        result.append(attributeForValue);
        result.append(", stereotypeAttributeForValue: ");
        result.append(stereotypeAttributeForValue);
        result.append(", browseTopContainersForOwner: ");
        result.append(browseTopContainersForOwner);
        result.append(')');
        return result.toString();
    }

} //NewClassInjectionImpl
