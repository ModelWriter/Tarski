/**
 * <copyright>
 * </copyright>
 *
 * $Id: RegExImpl.java,v 1.4 2009/05/15 13:13:32 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.DependantInjection;
import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.GroupElement;
import doc2modelMapping.RegEx;
import doc2modelMapping.RegExMatchingElement;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reg Ex</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.RegExImpl#getRegExToMatch <em>Reg Ex To Match</em>}</li>
 *   <li>{@link doc2modelMapping.impl.RegExImpl#getSecondaryInjectionsForGroups <em>Secondary Injections For Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegExImpl extends LinkedElementImpl implements RegEx
{
    /**
     * The default value of the '{@link #getRegExToMatch() <em>Reg Ex To Match</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRegExToMatch()
     * @generated
     * @ordered
     */
    protected static final String REG_EX_TO_MATCH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRegExToMatch() <em>Reg Ex To Match</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRegExToMatch()
     * @generated
     * @ordered
     */
    protected String regExToMatch = REG_EX_TO_MATCH_EDEFAULT;

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
    protected RegExImpl()
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
        return Doc2modelMappingPackage.Literals.REG_EX;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getRegExToMatch()
    {
        return regExToMatch;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRegExToMatch(String newRegExToMatch)
    {
        String oldRegExToMatch = regExToMatch;
        regExToMatch = newRegExToMatch;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.REG_EX__REG_EX_TO_MATCH, oldRegExToMatch, regExToMatch));
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
            secondaryInjectionsForGroups = new EObjectContainmentEList<DependantInjection>(DependantInjection.class, this, Doc2modelMappingPackage.REG_EX__SECONDARY_INJECTIONS_FOR_GROUPS);
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
            case Doc2modelMappingPackage.REG_EX__SECONDARY_INJECTIONS_FOR_GROUPS:
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
            case Doc2modelMappingPackage.REG_EX__REG_EX_TO_MATCH:
                return getRegExToMatch();
            case Doc2modelMappingPackage.REG_EX__SECONDARY_INJECTIONS_FOR_GROUPS:
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
            case Doc2modelMappingPackage.REG_EX__REG_EX_TO_MATCH:
                setRegExToMatch((String)newValue);
                return;
            case Doc2modelMappingPackage.REG_EX__SECONDARY_INJECTIONS_FOR_GROUPS:
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
            case Doc2modelMappingPackage.REG_EX__REG_EX_TO_MATCH:
                setRegExToMatch(REG_EX_TO_MATCH_EDEFAULT);
                return;
            case Doc2modelMappingPackage.REG_EX__SECONDARY_INJECTIONS_FOR_GROUPS:
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
            case Doc2modelMappingPackage.REG_EX__REG_EX_TO_MATCH:
                return REG_EX_TO_MATCH_EDEFAULT == null ? regExToMatch != null : !REG_EX_TO_MATCH_EDEFAULT.equals(regExToMatch);
            case Doc2modelMappingPackage.REG_EX__SECONDARY_INJECTIONS_FOR_GROUPS:
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
        if (baseClass == RegExMatchingElement.class)
        {
            switch (derivedFeatureID)
            {
                case Doc2modelMappingPackage.REG_EX__REG_EX_TO_MATCH: return Doc2modelMappingPackage.REG_EX_MATCHING_ELEMENT__REG_EX_TO_MATCH;
                default: return -1;
            }
        }
        if (baseClass == GroupElement.class)
        {
            switch (derivedFeatureID)
            {
                case Doc2modelMappingPackage.REG_EX__SECONDARY_INJECTIONS_FOR_GROUPS: return Doc2modelMappingPackage.GROUP_ELEMENT__SECONDARY_INJECTIONS_FOR_GROUPS;
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
        if (baseClass == RegExMatchingElement.class)
        {
            switch (baseFeatureID)
            {
                case Doc2modelMappingPackage.REG_EX_MATCHING_ELEMENT__REG_EX_TO_MATCH: return Doc2modelMappingPackage.REG_EX__REG_EX_TO_MATCH;
                default: return -1;
            }
        }
        if (baseClass == GroupElement.class)
        {
            switch (baseFeatureID)
            {
                case Doc2modelMappingPackage.GROUP_ELEMENT__SECONDARY_INJECTIONS_FOR_GROUPS: return Doc2modelMappingPackage.REG_EX__SECONDARY_INJECTIONS_FOR_GROUPS;
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
        result.append(" (regExToMatch: ");
        result.append(regExToMatch);
        result.append(')');
        return result.toString();
    }

} //RegExImpl
