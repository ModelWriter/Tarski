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
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.TypesType;
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
 * An implementation of the model object '<em><b>Field Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.FieldTypeImpl#getTuple <em>Tuple</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.FieldTypeImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.FieldTypeImpl#getID <em>ID</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.FieldTypeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.FieldTypeImpl#getParentID <em>Parent ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FieldTypeImpl extends MinimalEObjectImpl.Container implements FieldType {
  /**
   * The cached value of the '{@link #getTuple() <em>Tuple</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTuple()
   * @generated
   * @ordered
   */
  protected EList<TupleType> tuple;

  /**
   * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypes()
   * @generated
   * @ordered
   */
  protected EList<TypesType> types;

  /**
   * The default value of the '{@link #getID() <em>ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getID()
   * @generated
   * @ordered
   */
  protected static final int ID_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getID()
   * @generated
   * @ordered
   */
  protected int iD = ID_EDEFAULT;

  /**
   * This is true if the ID attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean iDESet;

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
   * The default value of the '{@link #getParentID() <em>Parent ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParentID()
   * @generated
   * @ordered
   */
  protected static final int PARENT_ID_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getParentID() <em>Parent ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParentID()
   * @generated
   * @ordered
   */
  protected int parentID = PARENT_ID_EDEFAULT;

  /**
   * This is true if the Parent ID attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean parentIDESet;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FieldTypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return persistencePackage.Literals.FIELD_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TupleType> getTuple() {
    if (tuple == null) {
      tuple = new EObjectContainmentEList<TupleType>(TupleType.class, this, persistencePackage.FIELD_TYPE__TUPLE);
    }
    return tuple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypesType> getTypes() {
    if (types == null) {
      types = new EObjectContainmentEList<TypesType>(TypesType.class, this, persistencePackage.FIELD_TYPE__TYPES);
    }
    return types;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getID() {
    return iD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setID(int newID) {
    int oldID = iD;
    iD = newID;
    boolean oldIDESet = iDESet;
    iDESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.FIELD_TYPE__ID, oldID, iD, !oldIDESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetID() {
    int oldID = iD;
    boolean oldIDESet = iDESet;
    iD = ID_EDEFAULT;
    iDESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, persistencePackage.FIELD_TYPE__ID, oldID, ID_EDEFAULT, oldIDESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetID() {
    return iDESet;
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
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.FIELD_TYPE__LABEL, oldLabel, label));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getParentID() {
    return parentID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentID(int newParentID) {
    int oldParentID = parentID;
    parentID = newParentID;
    boolean oldParentIDESet = parentIDESet;
    parentIDESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.FIELD_TYPE__PARENT_ID, oldParentID, parentID, !oldParentIDESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetParentID() {
    int oldParentID = parentID;
    boolean oldParentIDESet = parentIDESet;
    parentID = PARENT_ID_EDEFAULT;
    parentIDESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, persistencePackage.FIELD_TYPE__PARENT_ID, oldParentID, PARENT_ID_EDEFAULT, oldParentIDESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetParentID() {
    return parentIDESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case persistencePackage.FIELD_TYPE__TUPLE:
        return ((InternalEList<?>)getTuple()).basicRemove(otherEnd, msgs);
      case persistencePackage.FIELD_TYPE__TYPES:
        return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
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
      case persistencePackage.FIELD_TYPE__TUPLE:
        return getTuple();
      case persistencePackage.FIELD_TYPE__TYPES:
        return getTypes();
      case persistencePackage.FIELD_TYPE__ID:
        return getID();
      case persistencePackage.FIELD_TYPE__LABEL:
        return getLabel();
      case persistencePackage.FIELD_TYPE__PARENT_ID:
        return getParentID();
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
      case persistencePackage.FIELD_TYPE__TUPLE:
        getTuple().clear();
        getTuple().addAll((Collection<? extends TupleType>)newValue);
        return;
      case persistencePackage.FIELD_TYPE__TYPES:
        getTypes().clear();
        getTypes().addAll((Collection<? extends TypesType>)newValue);
        return;
      case persistencePackage.FIELD_TYPE__ID:
        setID((Integer)newValue);
        return;
      case persistencePackage.FIELD_TYPE__LABEL:
        setLabel((String)newValue);
        return;
      case persistencePackage.FIELD_TYPE__PARENT_ID:
        setParentID((Integer)newValue);
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
      case persistencePackage.FIELD_TYPE__TUPLE:
        getTuple().clear();
        return;
      case persistencePackage.FIELD_TYPE__TYPES:
        getTypes().clear();
        return;
      case persistencePackage.FIELD_TYPE__ID:
        unsetID();
        return;
      case persistencePackage.FIELD_TYPE__LABEL:
        setLabel(LABEL_EDEFAULT);
        return;
      case persistencePackage.FIELD_TYPE__PARENT_ID:
        unsetParentID();
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
      case persistencePackage.FIELD_TYPE__TUPLE:
        return tuple != null && !tuple.isEmpty();
      case persistencePackage.FIELD_TYPE__TYPES:
        return types != null && !types.isEmpty();
      case persistencePackage.FIELD_TYPE__ID:
        return isSetID();
      case persistencePackage.FIELD_TYPE__LABEL:
        return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
      case persistencePackage.FIELD_TYPE__PARENT_ID:
        return isSetParentID();
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
    result.append(" (iD: ");
    if (iDESet) result.append(iD); else result.append("<unset>");
    result.append(", label: ");
    result.append(label);
    result.append(", parentID: ");
    if (parentIDESet) result.append(parentID); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //FieldTypeImpl
