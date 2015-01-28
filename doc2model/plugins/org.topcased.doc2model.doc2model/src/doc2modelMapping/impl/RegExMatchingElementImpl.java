/**
 * <copyright>
 * </copyright>
 *
 * $Id: RegExMatchingElementImpl.java,v 1.1 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.RegExMatchingElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reg Ex Matching Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.RegExMatchingElementImpl#getRegExToMatch <em>Reg Ex To Match</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RegExMatchingElementImpl extends EObjectImpl implements RegExMatchingElement
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RegExMatchingElementImpl()
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
        return Doc2modelMappingPackage.Literals.REG_EX_MATCHING_ELEMENT;
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
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.REG_EX_MATCHING_ELEMENT__REG_EX_TO_MATCH, oldRegExToMatch, regExToMatch));
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
            case Doc2modelMappingPackage.REG_EX_MATCHING_ELEMENT__REG_EX_TO_MATCH:
                return getRegExToMatch();
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
            case Doc2modelMappingPackage.REG_EX_MATCHING_ELEMENT__REG_EX_TO_MATCH:
                setRegExToMatch((String)newValue);
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
            case Doc2modelMappingPackage.REG_EX_MATCHING_ELEMENT__REG_EX_TO_MATCH:
                setRegExToMatch(REG_EX_TO_MATCH_EDEFAULT);
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
            case Doc2modelMappingPackage.REG_EX_MATCHING_ELEMENT__REG_EX_TO_MATCH:
                return REG_EX_TO_MATCH_EDEFAULT == null ? regExToMatch != null : !REG_EX_TO_MATCH_EDEFAULT.equals(regExToMatch);
        }
        return super.eIsSet(featureID);
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

} //RegExMatchingElementImpl
