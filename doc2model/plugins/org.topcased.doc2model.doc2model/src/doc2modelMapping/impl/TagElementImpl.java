/**
 * <copyright>
 * </copyright>
 *
 * $Id: TagElementImpl.java,v 1.3 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.TagElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tag Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.TagElementImpl#isSingleLine <em>Single Line</em>}</li>
 *   <li>{@link doc2modelMapping.impl.TagElementImpl#getTagValue <em>Tag Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TagElementImpl extends LinkedElementImpl implements TagElement
{
    /**
     * The default value of the '{@link #isSingleLine() <em>Single Line</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSingleLine()
     * @generated
     * @ordered
     */
    protected static final boolean SINGLE_LINE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isSingleLine() <em>Single Line</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSingleLine()
     * @generated
     * @ordered
     */
    protected boolean singleLine = SINGLE_LINE_EDEFAULT;

    /**
     * The default value of the '{@link #getTagValue() <em>Tag Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTagValue()
     * @generated
     * @ordered
     */
    protected static final String TAG_VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTagValue() <em>Tag Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTagValue()
     * @generated
     * @ordered
     */
    protected String tagValue = TAG_VALUE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TagElementImpl()
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
        return Doc2modelMappingPackage.Literals.TAG_ELEMENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSingleLine()
    {
        return singleLine;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSingleLine(boolean newSingleLine)
    {
        boolean oldSingleLine = singleLine;
        singleLine = newSingleLine;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.TAG_ELEMENT__SINGLE_LINE, oldSingleLine, singleLine));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTagValue()
    {
        return tagValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTagValue(String newTagValue)
    {
        String oldTagValue = tagValue;
        tagValue = newTagValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.TAG_ELEMENT__TAG_VALUE, oldTagValue, tagValue));
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
            case Doc2modelMappingPackage.TAG_ELEMENT__SINGLE_LINE:
                return isSingleLine() ? Boolean.TRUE : Boolean.FALSE;
            case Doc2modelMappingPackage.TAG_ELEMENT__TAG_VALUE:
                return getTagValue();
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
            case Doc2modelMappingPackage.TAG_ELEMENT__SINGLE_LINE:
                setSingleLine(((Boolean)newValue).booleanValue());
                return;
            case Doc2modelMappingPackage.TAG_ELEMENT__TAG_VALUE:
                setTagValue((String)newValue);
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
            case Doc2modelMappingPackage.TAG_ELEMENT__SINGLE_LINE:
                setSingleLine(SINGLE_LINE_EDEFAULT);
                return;
            case Doc2modelMappingPackage.TAG_ELEMENT__TAG_VALUE:
                setTagValue(TAG_VALUE_EDEFAULT);
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
            case Doc2modelMappingPackage.TAG_ELEMENT__SINGLE_LINE:
                return singleLine != SINGLE_LINE_EDEFAULT;
            case Doc2modelMappingPackage.TAG_ELEMENT__TAG_VALUE:
                return TAG_VALUE_EDEFAULT == null ? tagValue != null : !TAG_VALUE_EDEFAULT.equals(tagValue);
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
        result.append(" (singleLine: ");
        result.append(singleLine);
        result.append(", tagValue: ");
        result.append(tagValue);
        result.append(')');
        return result.toString();
    }

} //TagElementImpl
