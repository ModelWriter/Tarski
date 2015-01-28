/**
 * <copyright>
 * </copyright>
 *
 * $Id: StereotpyeApplicableInjectionImpl.java,v 1.2 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.StereotpyeApplicableInjection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotpye Applicable Injection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.StereotpyeApplicableInjectionImpl#getStereotypeToApply <em>Stereotype To Apply</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StereotpyeApplicableInjectionImpl extends EObjectImpl implements StereotpyeApplicableInjection
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected StereotpyeApplicableInjectionImpl()
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
        return Doc2modelMappingPackage.Literals.STEREOTPYE_APPLICABLE_INJECTION;
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
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.STEREOTPYE_APPLICABLE_INJECTION__STEREOTYPE_TO_APPLY, oldStereotypeToApply, stereotypeToApply));
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
            case Doc2modelMappingPackage.STEREOTPYE_APPLICABLE_INJECTION__STEREOTYPE_TO_APPLY:
                return getStereotypeToApply();
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
            case Doc2modelMappingPackage.STEREOTPYE_APPLICABLE_INJECTION__STEREOTYPE_TO_APPLY:
                setStereotypeToApply((String)newValue);
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
            case Doc2modelMappingPackage.STEREOTPYE_APPLICABLE_INJECTION__STEREOTYPE_TO_APPLY:
                setStereotypeToApply(STEREOTYPE_TO_APPLY_EDEFAULT);
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
            case Doc2modelMappingPackage.STEREOTPYE_APPLICABLE_INJECTION__STEREOTYPE_TO_APPLY:
                return STEREOTYPE_TO_APPLY_EDEFAULT == null ? stereotypeToApply != null : !STEREOTYPE_TO_APPLY_EDEFAULT.equals(stereotypeToApply);
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
        result.append(" (stereotypeToApply: ");
        result.append(stereotypeToApply);
        result.append(')');
        return result.toString();
    }

} //StereotpyeApplicableInjectionImpl
