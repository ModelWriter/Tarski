/**
 * <copyright>
 * </copyright>
 *
 * $Id: ColumnMatchElementImpl.java,v 1.1 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.ColumnElement;
import doc2modelMapping.Attribute;
import doc2modelMapping.ColumnMatchElement;
import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.RegExMatchingElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column Match Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.ColumnMatchElementImpl#getRegExToMatch <em>Reg Ex To Match</em>}</li>
 *   <li>{@link doc2modelMapping.impl.ColumnMatchElementImpl#getNumColumn <em>Num Column</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColumnMatchElementImpl extends LinkedElementImpl implements ColumnMatchElement
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
     * The default value of the '{@link #getNumColumn() <em>Num Column</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNumColumn()
     * @generated
     * @ordered
     */
    protected static final int NUM_COLUMN_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getNumColumn() <em>Num Column</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNumColumn()
     * @generated
     * @ordered
     */
    protected int numColumn = NUM_COLUMN_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ColumnMatchElementImpl()
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
        return Doc2modelMappingPackage.Literals.COLUMN_MATCH_ELEMENT;
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
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.COLUMN_MATCH_ELEMENT__REG_EX_TO_MATCH, oldRegExToMatch, regExToMatch));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getNumColumn()
    {
        return numColumn;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNumColumn(int newNumColumn)
    {
        int oldNumColumn = numColumn;
        numColumn = newNumColumn;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.COLUMN_MATCH_ELEMENT__NUM_COLUMN, oldNumColumn, numColumn));
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
            case Doc2modelMappingPackage.COLUMN_MATCH_ELEMENT__REG_EX_TO_MATCH:
                return getRegExToMatch();
            case Doc2modelMappingPackage.COLUMN_MATCH_ELEMENT__NUM_COLUMN:
                return new Integer(getNumColumn());
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
            case Doc2modelMappingPackage.COLUMN_MATCH_ELEMENT__REG_EX_TO_MATCH:
                setRegExToMatch((String)newValue);
                return;
            case Doc2modelMappingPackage.COLUMN_MATCH_ELEMENT__NUM_COLUMN:
                setNumColumn(((Integer)newValue).intValue());
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
            case Doc2modelMappingPackage.COLUMN_MATCH_ELEMENT__REG_EX_TO_MATCH:
                setRegExToMatch(REG_EX_TO_MATCH_EDEFAULT);
                return;
            case Doc2modelMappingPackage.COLUMN_MATCH_ELEMENT__NUM_COLUMN:
                setNumColumn(NUM_COLUMN_EDEFAULT);
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
            case Doc2modelMappingPackage.COLUMN_MATCH_ELEMENT__REG_EX_TO_MATCH:
                return REG_EX_TO_MATCH_EDEFAULT == null ? regExToMatch != null : !REG_EX_TO_MATCH_EDEFAULT.equals(regExToMatch);
            case Doc2modelMappingPackage.COLUMN_MATCH_ELEMENT__NUM_COLUMN:
                return numColumn != NUM_COLUMN_EDEFAULT;
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
                case Doc2modelMappingPackage.COLUMN_MATCH_ELEMENT__REG_EX_TO_MATCH: return Doc2modelMappingPackage.REG_EX_MATCHING_ELEMENT__REG_EX_TO_MATCH;
                default: return -1;
            }
        }
        if (baseClass == ColumnElement.class)
        {
            switch (derivedFeatureID)
            {
                case Doc2modelMappingPackage.COLUMN_MATCH_ELEMENT__NUM_COLUMN: return Doc2modelMappingPackage.COLUMN_ELEMENT__NUM_COLUMN;
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
                case Doc2modelMappingPackage.REG_EX_MATCHING_ELEMENT__REG_EX_TO_MATCH: return Doc2modelMappingPackage.COLUMN_MATCH_ELEMENT__REG_EX_TO_MATCH;
                default: return -1;
            }
        }
        if (baseClass == ColumnElement.class)
        {
            switch (baseFeatureID)
            {
                case Doc2modelMappingPackage.COLUMN_ELEMENT__NUM_COLUMN: return Doc2modelMappingPackage.COLUMN_MATCH_ELEMENT__NUM_COLUMN;
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
        result.append(", numColumn: ");
        result.append(numColumn);
        result.append(')');
        return result.toString();
    }

} //ColumnMatchElementImpl
