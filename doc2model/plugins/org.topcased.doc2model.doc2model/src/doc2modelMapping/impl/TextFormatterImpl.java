/**
 * <copyright>
 * </copyright>
 *
 * $Id: TextFormatterImpl.java,v 1.2 2009/05/18 07:47:02 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.TextFormatter;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Formatter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.TextFormatterImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link doc2modelMapping.impl.TextFormatterImpl#getRegexForConditionOrGroup <em>Regex For Condition Or Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextFormatterImpl extends EObjectImpl implements TextFormatter
{
    /**
     * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPattern()
     * @generated
     * @ordered
     */
    protected static final String PATTERN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPattern()
     * @generated
     * @ordered
     */
    protected String pattern = PATTERN_EDEFAULT;

    /**
     * The default value of the '{@link #getRegexForConditionOrGroup() <em>Regex For Condition Or Group</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRegexForConditionOrGroup()
     * @generated
     * @ordered
     */
    protected static final String REGEX_FOR_CONDITION_OR_GROUP_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRegexForConditionOrGroup() <em>Regex For Condition Or Group</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRegexForConditionOrGroup()
     * @generated
     * @ordered
     */
    protected String regexForConditionOrGroup = REGEX_FOR_CONDITION_OR_GROUP_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TextFormatterImpl()
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
        return Doc2modelMappingPackage.Literals.TEXT_FORMATTER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPattern()
    {
        return pattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPattern(String newPattern)
    {
        String oldPattern = pattern;
        pattern = newPattern;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.TEXT_FORMATTER__PATTERN, oldPattern, pattern));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getRegexForConditionOrGroup()
    {
        return regexForConditionOrGroup;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRegexForConditionOrGroup(String newRegexForConditionOrGroup)
    {
        String oldRegexForConditionOrGroup = regexForConditionOrGroup;
        regexForConditionOrGroup = newRegexForConditionOrGroup;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.TEXT_FORMATTER__REGEX_FOR_CONDITION_OR_GROUP, oldRegexForConditionOrGroup, regexForConditionOrGroup));
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
            case Doc2modelMappingPackage.TEXT_FORMATTER__PATTERN:
                return getPattern();
            case Doc2modelMappingPackage.TEXT_FORMATTER__REGEX_FOR_CONDITION_OR_GROUP:
                return getRegexForConditionOrGroup();
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
            case Doc2modelMappingPackage.TEXT_FORMATTER__PATTERN:
                setPattern((String)newValue);
                return;
            case Doc2modelMappingPackage.TEXT_FORMATTER__REGEX_FOR_CONDITION_OR_GROUP:
                setRegexForConditionOrGroup((String)newValue);
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
            case Doc2modelMappingPackage.TEXT_FORMATTER__PATTERN:
                setPattern(PATTERN_EDEFAULT);
                return;
            case Doc2modelMappingPackage.TEXT_FORMATTER__REGEX_FOR_CONDITION_OR_GROUP:
                setRegexForConditionOrGroup(REGEX_FOR_CONDITION_OR_GROUP_EDEFAULT);
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
            case Doc2modelMappingPackage.TEXT_FORMATTER__PATTERN:
                return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
            case Doc2modelMappingPackage.TEXT_FORMATTER__REGEX_FOR_CONDITION_OR_GROUP:
                return REGEX_FOR_CONDITION_OR_GROUP_EDEFAULT == null ? regexForConditionOrGroup != null : !REGEX_FOR_CONDITION_OR_GROUP_EDEFAULT.equals(regexForConditionOrGroup);
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
        result.append(" (pattern: ");
        result.append(pattern);
        result.append(", regexForConditionOrGroup: ");
        result.append(regexForConditionOrGroup);
        result.append(')');
        return result.toString();
    }

} //TextFormatterImpl
