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

import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.InstanceType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.persistencePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.InstanceTypeImpl#getSig <em>Sig</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.InstanceTypeImpl#getField <em>Field</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.InstanceTypeImpl#getBitwidth <em>Bitwidth</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.InstanceTypeImpl#getFilename <em>Filename</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.InstanceTypeImpl#getMaxseq <em>Maxseq</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.InstanceTypeImpl#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstanceTypeImpl extends MinimalEObjectImpl.Container implements InstanceType {
  /**
   * The cached value of the '{@link #getSig() <em>Sig</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSig()
   * @generated
   * @ordered
   */
  protected EList<SigType> sig;

  /**
   * The cached value of the '{@link #getField() <em>Field</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getField()
   * @generated
   * @ordered
   */
  protected EList<FieldType> field;

  /**
   * The default value of the '{@link #getBitwidth() <em>Bitwidth</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBitwidth()
   * @generated
   * @ordered
   */
  protected static final int BITWIDTH_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getBitwidth() <em>Bitwidth</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBitwidth()
   * @generated
   * @ordered
   */
  protected int bitwidth = BITWIDTH_EDEFAULT;

  /**
   * This is true if the Bitwidth attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean bitwidthESet;

  /**
   * The default value of the '{@link #getFilename() <em>Filename</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFilename()
   * @generated
   * @ordered
   */
  protected static final String FILENAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFilename() <em>Filename</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFilename()
   * @generated
   * @ordered
   */
  protected String filename = FILENAME_EDEFAULT;

  /**
   * The default value of the '{@link #getMaxseq() <em>Maxseq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxseq()
   * @generated
   * @ordered
   */
  protected static final int MAXSEQ_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMaxseq() <em>Maxseq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxseq()
   * @generated
   * @ordered
   */
  protected int maxseq = MAXSEQ_EDEFAULT;

  /**
   * This is true if the Maxseq attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean maxseqESet;

  /**
   * The default value of the '{@link #getMetamodel() <em>Metamodel</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodel()
   * @generated
   * @ordered
   */
  protected static final String METAMODEL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodel()
   * @generated
   * @ordered
   */
  protected String metamodel = METAMODEL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InstanceTypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return persistencePackage.Literals.INSTANCE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SigType> getSig() {
    if (sig == null) {
      sig = new EObjectContainmentEList<SigType>(SigType.class, this, persistencePackage.INSTANCE_TYPE__SIG);
    }
    return sig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FieldType> getField() {
    if (field == null) {
      field = new EObjectContainmentEList<FieldType>(FieldType.class, this, persistencePackage.INSTANCE_TYPE__FIELD);
    }
    return field;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getBitwidth() {
    return bitwidth;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBitwidth(int newBitwidth) {
    int oldBitwidth = bitwidth;
    bitwidth = newBitwidth;
    boolean oldBitwidthESet = bitwidthESet;
    bitwidthESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.INSTANCE_TYPE__BITWIDTH, oldBitwidth, bitwidth, !oldBitwidthESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetBitwidth() {
    int oldBitwidth = bitwidth;
    boolean oldBitwidthESet = bitwidthESet;
    bitwidth = BITWIDTH_EDEFAULT;
    bitwidthESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, persistencePackage.INSTANCE_TYPE__BITWIDTH, oldBitwidth, BITWIDTH_EDEFAULT, oldBitwidthESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetBitwidth() {
    return bitwidthESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFilename() {
    return filename;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFilename(String newFilename) {
    String oldFilename = filename;
    filename = newFilename;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.INSTANCE_TYPE__FILENAME, oldFilename, filename));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMaxseq() {
    return maxseq;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMaxseq(int newMaxseq) {
    int oldMaxseq = maxseq;
    maxseq = newMaxseq;
    boolean oldMaxseqESet = maxseqESet;
    maxseqESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.INSTANCE_TYPE__MAXSEQ, oldMaxseq, maxseq, !oldMaxseqESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetMaxseq() {
    int oldMaxseq = maxseq;
    boolean oldMaxseqESet = maxseqESet;
    maxseq = MAXSEQ_EDEFAULT;
    maxseqESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, persistencePackage.INSTANCE_TYPE__MAXSEQ, oldMaxseq, MAXSEQ_EDEFAULT, oldMaxseqESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetMaxseq() {
    return maxseqESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMetamodel() {
    return metamodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMetamodel(String newMetamodel) {
    String oldMetamodel = metamodel;
    metamodel = newMetamodel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.INSTANCE_TYPE__METAMODEL, oldMetamodel, metamodel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case persistencePackage.INSTANCE_TYPE__SIG:
        return ((InternalEList<?>)getSig()).basicRemove(otherEnd, msgs);
      case persistencePackage.INSTANCE_TYPE__FIELD:
        return ((InternalEList<?>)getField()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case persistencePackage.INSTANCE_TYPE__SIG:
        return getSig();
      case persistencePackage.INSTANCE_TYPE__FIELD:
        return getField();
      case persistencePackage.INSTANCE_TYPE__BITWIDTH:
        return getBitwidth();
      case persistencePackage.INSTANCE_TYPE__FILENAME:
        return getFilename();
      case persistencePackage.INSTANCE_TYPE__MAXSEQ:
        return getMaxseq();
      case persistencePackage.INSTANCE_TYPE__METAMODEL:
        return getMetamodel();
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
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case persistencePackage.INSTANCE_TYPE__SIG:
        getSig().clear();
        getSig().addAll((Collection<? extends SigType>)newValue);
        return;
      case persistencePackage.INSTANCE_TYPE__FIELD:
        getField().clear();
        getField().addAll((Collection<? extends FieldType>)newValue);
        return;
      case persistencePackage.INSTANCE_TYPE__BITWIDTH:
        setBitwidth((Integer)newValue);
        return;
      case persistencePackage.INSTANCE_TYPE__FILENAME:
        setFilename((String)newValue);
        return;
      case persistencePackage.INSTANCE_TYPE__MAXSEQ:
        setMaxseq((Integer)newValue);
        return;
      case persistencePackage.INSTANCE_TYPE__METAMODEL:
        setMetamodel((String)newValue);
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
      case persistencePackage.INSTANCE_TYPE__SIG:
        getSig().clear();
        return;
      case persistencePackage.INSTANCE_TYPE__FIELD:
        getField().clear();
        return;
      case persistencePackage.INSTANCE_TYPE__BITWIDTH:
        unsetBitwidth();
        return;
      case persistencePackage.INSTANCE_TYPE__FILENAME:
        setFilename(FILENAME_EDEFAULT);
        return;
      case persistencePackage.INSTANCE_TYPE__MAXSEQ:
        unsetMaxseq();
        return;
      case persistencePackage.INSTANCE_TYPE__METAMODEL:
        setMetamodel(METAMODEL_EDEFAULT);
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
      case persistencePackage.INSTANCE_TYPE__SIG:
        return sig != null && !sig.isEmpty();
      case persistencePackage.INSTANCE_TYPE__FIELD:
        return field != null && !field.isEmpty();
      case persistencePackage.INSTANCE_TYPE__BITWIDTH:
        return isSetBitwidth();
      case persistencePackage.INSTANCE_TYPE__FILENAME:
        return FILENAME_EDEFAULT == null ? filename != null : !FILENAME_EDEFAULT.equals(filename);
      case persistencePackage.INSTANCE_TYPE__MAXSEQ:
        return isSetMaxseq();
      case persistencePackage.INSTANCE_TYPE__METAMODEL:
        return METAMODEL_EDEFAULT == null ? metamodel != null : !METAMODEL_EDEFAULT.equals(metamodel);
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
    result.append(" (bitwidth: ");
    if (bitwidthESet) result.append(bitwidth); else result.append("<unset>");
    result.append(", filename: ");
    result.append(filename);
    result.append(", maxseq: ");
    if (maxseqESet) result.append(maxseq); else result.append("<unset>");
    result.append(", metamodel: ");
    result.append(metamodel);
    result.append(')');
    return result.toString();
  }

} //InstanceTypeImpl
