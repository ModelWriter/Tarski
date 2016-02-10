/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ferhat Erata - initial API and implementation
 *     H. Emre Kirmizi - initial API and implementation
 *     Serhat Celik - initial API and implementation
 *     U. Anil Ozturk - initial API and implementation
 *******************************************************************************/
/**
 */
package eu.modelwriter.traceability.core.persistence.impl;

import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.persistencePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atom Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.AtomTypeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.AtomTypeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.AtomTypeImpl#getChanged <em>Changed</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.AtomTypeImpl#getImpact <em>Impact</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.AtomTypeImpl#getBound <em>Bound</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AtomTypeImpl extends MinimalEObjectImpl.Container implements AtomType {
  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabel()
   * @generated
   * @ordered
   */
  protected static final String LABEL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabel()
   * @generated
   * @ordered
   */
  protected String label = LABEL_EDEFAULT;

  /**
   * The default value of the '{@link #getChanged() <em>Changed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChanged()
   * @generated
   * @ordered
   */
  protected static final Boolean CHANGED_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getChanged() <em>Changed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChanged()
   * @generated
   * @ordered
   */
  protected Boolean changed = CHANGED_EDEFAULT;

  /**
   * The default value of the '{@link #getImpact() <em>Impact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImpact()
   * @generated
   * @ordered
   */
  protected static final Boolean IMPACT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getImpact() <em>Impact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImpact()
   * @generated
   * @ordered
   */
  protected Boolean impact = IMPACT_EDEFAULT;

  /**
   * The default value of the '{@link #getBound() <em>Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBound()
   * @generated
   * @ordered
   */
  protected static final String BOUND_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBound() <em>Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBound()
   * @generated
   * @ordered
   */
  protected String bound = BOUND_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AtomTypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return persistencePackage.Literals.ATOM_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue) {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.ATOM_TYPE__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLabel() {
    return label;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLabel(String newLabel) {
    String oldLabel = label;
    label = newLabel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.ATOM_TYPE__LABEL, oldLabel, label));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Boolean getChanged() {
    return changed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChanged(Boolean newChanged) {
    Boolean oldChanged = changed;
    changed = newChanged;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.ATOM_TYPE__CHANGED, oldChanged, changed));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Boolean getImpact() {
    return impact;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImpact(Boolean newImpact) {
    Boolean oldImpact = impact;
    impact = newImpact;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.ATOM_TYPE__IMPACT, oldImpact, impact));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBound() {
    return bound;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBound(String newBound) {
    String oldBound = bound;
    bound = newBound;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.ATOM_TYPE__BOUND, oldBound, bound));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case persistencePackage.ATOM_TYPE__VALUE:
        return getValue();
      case persistencePackage.ATOM_TYPE__LABEL:
        return getLabel();
      case persistencePackage.ATOM_TYPE__CHANGED:
        return getChanged();
      case persistencePackage.ATOM_TYPE__IMPACT:
        return getImpact();
      case persistencePackage.ATOM_TYPE__BOUND:
        return getBound();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case persistencePackage.ATOM_TYPE__VALUE:
        setValue((String)newValue);
        return;
      case persistencePackage.ATOM_TYPE__LABEL:
        setLabel((String)newValue);
        return;
      case persistencePackage.ATOM_TYPE__CHANGED:
        setChanged((Boolean)newValue);
        return;
      case persistencePackage.ATOM_TYPE__IMPACT:
        setImpact((Boolean)newValue);
        return;
      case persistencePackage.ATOM_TYPE__BOUND:
        setBound((String)newValue);
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
  public void eUnset(int featureID) {
    switch (featureID) {
      case persistencePackage.ATOM_TYPE__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case persistencePackage.ATOM_TYPE__LABEL:
        setLabel(LABEL_EDEFAULT);
        return;
      case persistencePackage.ATOM_TYPE__CHANGED:
        setChanged(CHANGED_EDEFAULT);
        return;
      case persistencePackage.ATOM_TYPE__IMPACT:
        setImpact(IMPACT_EDEFAULT);
        return;
      case persistencePackage.ATOM_TYPE__BOUND:
        setBound(BOUND_EDEFAULT);
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
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case persistencePackage.ATOM_TYPE__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
      case persistencePackage.ATOM_TYPE__LABEL:
        return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
      case persistencePackage.ATOM_TYPE__CHANGED:
        return CHANGED_EDEFAULT == null ? changed != null : !CHANGED_EDEFAULT.equals(changed);
      case persistencePackage.ATOM_TYPE__IMPACT:
        return IMPACT_EDEFAULT == null ? impact != null : !IMPACT_EDEFAULT.equals(impact);
      case persistencePackage.ATOM_TYPE__BOUND:
        return BOUND_EDEFAULT == null ? bound != null : !BOUND_EDEFAULT.equals(bound);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (value: ");
    result.append(value);
    result.append(", label: ");
    result.append(label);
    result.append(", changed: ");
    result.append(changed);
    result.append(", impact: ");
    result.append(impact);
    result.append(", bound: ");
    result.append(bound);
    result.append(')');
    return result.toString();
  }

} //AtomTypeImpl
