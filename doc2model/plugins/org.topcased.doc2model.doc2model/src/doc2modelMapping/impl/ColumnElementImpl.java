/**
 * <copyright>
 * </copyright>
 *
 * $Id: ColumnElementImpl.java,v 1.1 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.ColumnElement;
import doc2modelMapping.Doc2modelMappingPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.ColumnElementImpl#getNumColumn <em>Num Column</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ColumnElementImpl extends RegExMatchingElementImpl implements ColumnElement
{
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
    protected ColumnElementImpl()
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
        return Doc2modelMappingPackage.Literals.COLUMN_ELEMENT;
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
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.COLUMN_ELEMENT__NUM_COLUMN, oldNumColumn, numColumn));
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
            case Doc2modelMappingPackage.COLUMN_ELEMENT__NUM_COLUMN:
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
            case Doc2modelMappingPackage.COLUMN_ELEMENT__NUM_COLUMN:
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
            case Doc2modelMappingPackage.COLUMN_ELEMENT__NUM_COLUMN:
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
            case Doc2modelMappingPackage.COLUMN_ELEMENT__NUM_COLUMN:
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
    public String toString()
    {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (numColumn: ");
        result.append(numColumn);
        result.append(')');
        return result.toString();
    }

} //ColumnElementImpl
