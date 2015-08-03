/**
 */
package Marker.impl;

import Marker.MarkElement;
import Marker.MarkElementCollection;
import Marker.MarkerPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mark Element Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Marker.impl.MarkElementCollectionImpl#getMarkElements <em>Mark Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MarkElementCollectionImpl extends MinimalEObjectImpl.Container implements MarkElementCollection {
  /**
   * The cached value of the '{@link #getMarkElements() <em>Mark Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMarkElements()
   * @generated
   * @ordered
   */
  protected EList<MarkElement> markElements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MarkElementCollectionImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MarkerPackage.Literals.MARK_ELEMENT_COLLECTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MarkElement> getMarkElements() {
    if (markElements == null) {
      markElements = new EObjectContainmentEList<MarkElement>(MarkElement.class, this, MarkerPackage.MARK_ELEMENT_COLLECTION__MARK_ELEMENTS);
    }
    return markElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case MarkerPackage.MARK_ELEMENT_COLLECTION__MARK_ELEMENTS:
        return ((InternalEList<?>)getMarkElements()).basicRemove(otherEnd, msgs);
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
      case MarkerPackage.MARK_ELEMENT_COLLECTION__MARK_ELEMENTS:
        return getMarkElements();
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
      case MarkerPackage.MARK_ELEMENT_COLLECTION__MARK_ELEMENTS:
        getMarkElements().clear();
        getMarkElements().addAll((Collection<? extends MarkElement>)newValue);
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
      case MarkerPackage.MARK_ELEMENT_COLLECTION__MARK_ELEMENTS:
        getMarkElements().clear();
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
      case MarkerPackage.MARK_ELEMENT_COLLECTION__MARK_ELEMENTS:
        return markElements != null && !markElements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MarkElementCollectionImpl
