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

import eu.modelwriter.traceability.core.persistence.ItemType;
import eu.modelwriter.traceability.core.persistence.RepositoryType;
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
 * An implementation of the model object '<em><b>Repository Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.RepositoryTypeImpl#getItem <em>Item</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.RepositoryTypeImpl#getNextId <em>Next Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepositoryTypeImpl extends MinimalEObjectImpl.Container implements RepositoryType {
  /**
   * The cached value of the '{@link #getItem() <em>Item</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getItem()
   * @generated
   * @ordered
   */
  protected EList<ItemType> item;

  /**
   * The default value of the '{@link #getNextId() <em>Next Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNextId()
   * @generated
   * @ordered
   */
  protected static final int NEXT_ID_EDEFAULT = 0;
  /**
   * The cached value of the '{@link #getNextId() <em>Next Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNextId()
   * @generated
   * @ordered
   */
  protected int nextId = NEXT_ID_EDEFAULT;
  /**
   * This is true if the Next Id attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean nextIdESet;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RepositoryTypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return persistencePackage.Literals.REPOSITORY_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ItemType> getItem() {
    if (item == null) {
      item = new EObjectContainmentEList<ItemType>(ItemType.class, this, persistencePackage.REPOSITORY_TYPE__ITEM);
    }
    return item;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getNextId() {
    return nextId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNextId(int newNextId) {
    int oldNextId = nextId;
    nextId = newNextId;
    boolean oldNextIdESet = nextIdESet;
    nextIdESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.REPOSITORY_TYPE__NEXT_ID, oldNextId, nextId, !oldNextIdESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetNextId() {
    int oldNextId = nextId;
    boolean oldNextIdESet = nextIdESet;
    nextId = NEXT_ID_EDEFAULT;
    nextIdESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, persistencePackage.REPOSITORY_TYPE__NEXT_ID, oldNextId, NEXT_ID_EDEFAULT, oldNextIdESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetNextId() {
    return nextIdESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case persistencePackage.REPOSITORY_TYPE__ITEM:
        return ((InternalEList<?>)getItem()).basicRemove(otherEnd, msgs);
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
      case persistencePackage.REPOSITORY_TYPE__ITEM:
        return getItem();
      case persistencePackage.REPOSITORY_TYPE__NEXT_ID:
        return getNextId();
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
      case persistencePackage.REPOSITORY_TYPE__ITEM:
        getItem().clear();
        getItem().addAll((Collection<? extends ItemType>)newValue);
        return;
      case persistencePackage.REPOSITORY_TYPE__NEXT_ID:
        setNextId((Integer)newValue);
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
      case persistencePackage.REPOSITORY_TYPE__ITEM:
        getItem().clear();
        return;
      case persistencePackage.REPOSITORY_TYPE__NEXT_ID:
        unsetNextId();
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
      case persistencePackage.REPOSITORY_TYPE__ITEM:
        return item != null && !item.isEmpty();
      case persistencePackage.REPOSITORY_TYPE__NEXT_ID:
        return isSetNextId();
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
    result.append(" (nextId: ");
    if (nextIdESet) result.append(nextId); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //RepositoryTypeImpl
