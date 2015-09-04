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
package Marker.impl;

import Marker.MarkElement;
import Marker.MarkerPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mark Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Marker.impl.MarkElementImpl#getId <em>Id</em>}</li>
 *   <li>{@link Marker.impl.MarkElementImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link Marker.impl.MarkElementImpl#getLength <em>Length</em>}</li>
 *   <li>{@link Marker.impl.MarkElementImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link Marker.impl.MarkElementImpl#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link Marker.impl.MarkElementImpl#getFullPath <em>Full Path</em>}</li>
 *   <li>{@link Marker.impl.MarkElementImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link Marker.impl.MarkElementImpl#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MarkElementImpl extends MinimalEObjectImpl.Container implements MarkElement {
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOffset()
   * @generated
   * @ordered
   */
  protected static final int OFFSET_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOffset()
   * @generated
   * @ordered
   */
  protected int offset = OFFSET_EDEFAULT;

  /**
   * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLength()
   * @generated
   * @ordered
   */
  protected static final int LENGTH_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLength()
   * @generated
   * @ordered
   */
  protected int length = LENGTH_EDEFAULT;

  /**
   * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected static final String MESSAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected String message = MESSAGE_EDEFAULT;

  /**
   * The default value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLineNumber()
   * @generated
   * @ordered
   */
  protected static final int LINE_NUMBER_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLineNumber()
   * @generated
   * @ordered
   */
  protected int lineNumber = LINE_NUMBER_EDEFAULT;

  /**
   * The default value of the '{@link #getFullPath() <em>Full Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFullPath()
   * @generated
   * @ordered
   */
  protected static final String FULL_PATH_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFullPath() <em>Full Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFullPath()
   * @generated
   * @ordered
   */
  protected String fullPath = FULL_PATH_EDEFAULT;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected EList<MarkElement> target;

  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected EList<MarkElement> source;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MarkElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MarkerPackage.Literals.MARK_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId() {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId) {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MarkerPackage.MARK_ELEMENT__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getOffset() {
    return offset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOffset(int newOffset) {
    int oldOffset = offset;
    offset = newOffset;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MarkerPackage.MARK_ELEMENT__OFFSET, oldOffset, offset));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLength() {
    return length;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLength(int newLength) {
    int oldLength = length;
    length = newLength;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MarkerPackage.MARK_ELEMENT__LENGTH, oldLength, length));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMessage() {
    return message;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessage(String newMessage) {
    String oldMessage = message;
    message = newMessage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MarkerPackage.MARK_ELEMENT__MESSAGE, oldMessage, message));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLineNumber() {
    return lineNumber;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLineNumber(int newLineNumber) {
    int oldLineNumber = lineNumber;
    lineNumber = newLineNumber;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MarkerPackage.MARK_ELEMENT__LINE_NUMBER, oldLineNumber, lineNumber));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFullPath() {
    return fullPath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFullPath(String newFullPath) {
    String oldFullPath = fullPath;
    fullPath = newFullPath;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MarkerPackage.MARK_ELEMENT__FULL_PATH, oldFullPath, fullPath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MarkElement> getTarget() {
    if (target == null) {
      target = new EObjectWithInverseResolvingEList.ManyInverse<MarkElement>(MarkElement.class, this, MarkerPackage.MARK_ELEMENT__TARGET, MarkerPackage.MARK_ELEMENT__SOURCE);
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MarkElement> getSource() {
    if (source == null) {
      source = new EObjectWithInverseResolvingEList.ManyInverse<MarkElement>(MarkElement.class, this, MarkerPackage.MARK_ELEMENT__SOURCE, MarkerPackage.MARK_ELEMENT__TARGET);
    }
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case MarkerPackage.MARK_ELEMENT__TARGET:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getTarget()).basicAdd(otherEnd, msgs);
      case MarkerPackage.MARK_ELEMENT__SOURCE:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSource()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case MarkerPackage.MARK_ELEMENT__TARGET:
        return ((InternalEList<?>)getTarget()).basicRemove(otherEnd, msgs);
      case MarkerPackage.MARK_ELEMENT__SOURCE:
        return ((InternalEList<?>)getSource()).basicRemove(otherEnd, msgs);
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
      case MarkerPackage.MARK_ELEMENT__ID:
        return getId();
      case MarkerPackage.MARK_ELEMENT__OFFSET:
        return getOffset();
      case MarkerPackage.MARK_ELEMENT__LENGTH:
        return getLength();
      case MarkerPackage.MARK_ELEMENT__MESSAGE:
        return getMessage();
      case MarkerPackage.MARK_ELEMENT__LINE_NUMBER:
        return getLineNumber();
      case MarkerPackage.MARK_ELEMENT__FULL_PATH:
        return getFullPath();
      case MarkerPackage.MARK_ELEMENT__TARGET:
        return getTarget();
      case MarkerPackage.MARK_ELEMENT__SOURCE:
        return getSource();
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
      case MarkerPackage.MARK_ELEMENT__ID:
        setId((String)newValue);
        return;
      case MarkerPackage.MARK_ELEMENT__OFFSET:
        setOffset((Integer)newValue);
        return;
      case MarkerPackage.MARK_ELEMENT__LENGTH:
        setLength((Integer)newValue);
        return;
      case MarkerPackage.MARK_ELEMENT__MESSAGE:
        setMessage((String)newValue);
        return;
      case MarkerPackage.MARK_ELEMENT__LINE_NUMBER:
        setLineNumber((Integer)newValue);
        return;
      case MarkerPackage.MARK_ELEMENT__FULL_PATH:
        setFullPath((String)newValue);
        return;
      case MarkerPackage.MARK_ELEMENT__TARGET:
        getTarget().clear();
        getTarget().addAll((Collection<? extends MarkElement>)newValue);
        return;
      case MarkerPackage.MARK_ELEMENT__SOURCE:
        getSource().clear();
        getSource().addAll((Collection<? extends MarkElement>)newValue);
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
      case MarkerPackage.MARK_ELEMENT__ID:
        setId(ID_EDEFAULT);
        return;
      case MarkerPackage.MARK_ELEMENT__OFFSET:
        setOffset(OFFSET_EDEFAULT);
        return;
      case MarkerPackage.MARK_ELEMENT__LENGTH:
        setLength(LENGTH_EDEFAULT);
        return;
      case MarkerPackage.MARK_ELEMENT__MESSAGE:
        setMessage(MESSAGE_EDEFAULT);
        return;
      case MarkerPackage.MARK_ELEMENT__LINE_NUMBER:
        setLineNumber(LINE_NUMBER_EDEFAULT);
        return;
      case MarkerPackage.MARK_ELEMENT__FULL_PATH:
        setFullPath(FULL_PATH_EDEFAULT);
        return;
      case MarkerPackage.MARK_ELEMENT__TARGET:
        getTarget().clear();
        return;
      case MarkerPackage.MARK_ELEMENT__SOURCE:
        getSource().clear();
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
      case MarkerPackage.MARK_ELEMENT__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case MarkerPackage.MARK_ELEMENT__OFFSET:
        return offset != OFFSET_EDEFAULT;
      case MarkerPackage.MARK_ELEMENT__LENGTH:
        return length != LENGTH_EDEFAULT;
      case MarkerPackage.MARK_ELEMENT__MESSAGE:
        return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
      case MarkerPackage.MARK_ELEMENT__LINE_NUMBER:
        return lineNumber != LINE_NUMBER_EDEFAULT;
      case MarkerPackage.MARK_ELEMENT__FULL_PATH:
        return FULL_PATH_EDEFAULT == null ? fullPath != null : !FULL_PATH_EDEFAULT.equals(fullPath);
      case MarkerPackage.MARK_ELEMENT__TARGET:
        return target != null && !target.isEmpty();
      case MarkerPackage.MARK_ELEMENT__SOURCE:
        return source != null && !source.isEmpty();
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
    result.append(" (Id: ");
    result.append(id);
    result.append(", Offset: ");
    result.append(offset);
    result.append(", Length: ");
    result.append(length);
    result.append(", Message: ");
    result.append(message);
    result.append(", LineNumber: ");
    result.append(lineNumber);
    result.append(", FullPath: ");
    result.append(fullPath);
    result.append(')');
    return result.toString();
  }

} //MarkElementImpl
