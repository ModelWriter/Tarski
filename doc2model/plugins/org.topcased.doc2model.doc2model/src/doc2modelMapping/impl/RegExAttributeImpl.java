/**
 * <copyright>
 * </copyright>
 *
 * $Id: RegExAttributeImpl.java,v 1.4 2009/05/15 13:13:32 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.DependantInjection;
import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.GroupElement;
import doc2modelMapping.RegExAttribute;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reg Ex Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.RegExAttributeImpl#getSecondaryInjectionsForGroups <em>Secondary Injections For Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegExAttributeImpl extends AttributeImpl implements RegExAttribute
{
    /**
     * The cached value of the '{@link #getSecondaryInjectionsForGroups() <em>Secondary Injections For Groups</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSecondaryInjectionsForGroups()
     * @generated
     * @ordered
     */
    protected EList<DependantInjection> secondaryInjectionsForGroups;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RegExAttributeImpl()
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
        return Doc2modelMappingPackage.Literals.REG_EX_ATTRIBUTE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DependantInjection> getSecondaryInjectionsForGroups()
    {
        if (secondaryInjectionsForGroups == null)
        {
            secondaryInjectionsForGroups = new EObjectContainmentEList<DependantInjection>(DependantInjection.class, this, Doc2modelMappingPackage.REG_EX_ATTRIBUTE__SECONDARY_INJECTIONS_FOR_GROUPS);
        }
        return secondaryInjectionsForGroups;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case Doc2modelMappingPackage.REG_EX_ATTRIBUTE__SECONDARY_INJECTIONS_FOR_GROUPS:
                return ((InternalEList<?>)getSecondaryInjectionsForGroups()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
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
            case Doc2modelMappingPackage.REG_EX_ATTRIBUTE__SECONDARY_INJECTIONS_FOR_GROUPS:
                return getSecondaryInjectionsForGroups();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case Doc2modelMappingPackage.REG_EX_ATTRIBUTE__SECONDARY_INJECTIONS_FOR_GROUPS:
                getSecondaryInjectionsForGroups().clear();
                getSecondaryInjectionsForGroups().addAll((Collection<? extends DependantInjection>)newValue);
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
            case Doc2modelMappingPackage.REG_EX_ATTRIBUTE__SECONDARY_INJECTIONS_FOR_GROUPS:
                getSecondaryInjectionsForGroups().clear();
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
            case Doc2modelMappingPackage.REG_EX_ATTRIBUTE__SECONDARY_INJECTIONS_FOR_GROUPS:
                return secondaryInjectionsForGroups != null && !secondaryInjectionsForGroups.isEmpty();
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
        if (baseClass == GroupElement.class)
        {
            switch (derivedFeatureID)
            {
                case Doc2modelMappingPackage.REG_EX_ATTRIBUTE__SECONDARY_INJECTIONS_FOR_GROUPS: return Doc2modelMappingPackage.GROUP_ELEMENT__SECONDARY_INJECTIONS_FOR_GROUPS;
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
        if (baseClass == GroupElement.class)
        {
            switch (baseFeatureID)
            {
                case Doc2modelMappingPackage.GROUP_ELEMENT__SECONDARY_INJECTIONS_FOR_GROUPS: return Doc2modelMappingPackage.REG_EX_ATTRIBUTE__SECONDARY_INJECTIONS_FOR_GROUPS;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //RegExAttributeImpl
