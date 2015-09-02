/**
 */
package eu.modelwriter.alloyxmlapi.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import eu.modelwriter.alloyxmlapi.AlloyType;
import eu.modelwriter.alloyxmlapi.AlloyXSDFilePackage;
import eu.modelwriter.alloyxmlapi.DocumentRoot;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link eu.modelwriter.alloyxmlapi.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 * <li>{@link eu.modelwriter.alloyxmlapi.impl.DocumentRootImpl#getXMLNSPrefixMap
 * <em>XMLNS Prefix Map</em>}</li>
 * <li>{@link eu.modelwriter.alloyxmlapi.impl.DocumentRootImpl#getXSISchemaLocation
 * <em>XSI Schema Location</em>}</li>
 * <li>{@link eu.modelwriter.alloyxmlapi.impl.DocumentRootImpl#getAlloy <em>Alloy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DocumentRootImpl extends MinimalEObjectImpl.Container implements DocumentRoot {
  /**
   * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getMixed()
   * @generated
   * @ordered
   */
  protected FeatureMap mixed;

  /**
   * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getXMLNSPrefixMap()
   * @generated
   * @ordered
   */
  protected EMap<String, String> xMLNSPrefixMap;

  /**
   * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getXSISchemaLocation()
   * @generated
   * @ordered
   */
  protected EMap<String, String> xSISchemaLocation;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected DocumentRootImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return AlloyXSDFilePackage.Literals.DOCUMENT_ROOT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public FeatureMap getMixed() {
    if (mixed == null) {
      mixed = new BasicFeatureMap(this, AlloyXSDFilePackage.DOCUMENT_ROOT__MIXED);
    }
    return mixed;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EMap<String, String> getXMLNSPrefixMap() {
    if (xMLNSPrefixMap == null) {
      xMLNSPrefixMap = new EcoreEMap<String, String>(
          EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class,
          this, AlloyXSDFilePackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
    }
    return xMLNSPrefixMap;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EMap<String, String> getXSISchemaLocation() {
    if (xSISchemaLocation == null) {
      xSISchemaLocation = new EcoreEMap<String, String>(
          EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class,
          this, AlloyXSDFilePackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
    }
    return xSISchemaLocation;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public AlloyType getAlloy() {
    return (AlloyType) getMixed().get(AlloyXSDFilePackage.Literals.DOCUMENT_ROOT__ALLOY, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public NotificationChain basicSetAlloy(AlloyType newAlloy, NotificationChain msgs) {
    return ((FeatureMap.Internal) getMixed())
        .basicAdd(AlloyXSDFilePackage.Literals.DOCUMENT_ROOT__ALLOY, newAlloy, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setAlloy(AlloyType newAlloy) {
    ((FeatureMap.Internal) getMixed()).set(AlloyXSDFilePackage.Literals.DOCUMENT_ROOT__ALLOY,
        newAlloy);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch (featureID) {
      case AlloyXSDFilePackage.DOCUMENT_ROOT__MIXED:
        return ((InternalEList<?>) getMixed()).basicRemove(otherEnd, msgs);
      case AlloyXSDFilePackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        return ((InternalEList<?>) getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
      case AlloyXSDFilePackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        return ((InternalEList<?>) getXSISchemaLocation()).basicRemove(otherEnd, msgs);
      case AlloyXSDFilePackage.DOCUMENT_ROOT__ALLOY:
        return basicSetAlloy(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case AlloyXSDFilePackage.DOCUMENT_ROOT__MIXED:
        if (coreType)
          return getMixed();
        return ((FeatureMap.Internal) getMixed()).getWrapper();
      case AlloyXSDFilePackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        if (coreType)
          return getXMLNSPrefixMap();
        else
          return getXMLNSPrefixMap().map();
      case AlloyXSDFilePackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        if (coreType)
          return getXSISchemaLocation();
        else
          return getXSISchemaLocation().map();
      case AlloyXSDFilePackage.DOCUMENT_ROOT__ALLOY:
        return getAlloy();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case AlloyXSDFilePackage.DOCUMENT_ROOT__MIXED:
        ((FeatureMap.Internal) getMixed()).set(newValue);
        return;
      case AlloyXSDFilePackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        ((EStructuralFeature.Setting) getXMLNSPrefixMap()).set(newValue);
        return;
      case AlloyXSDFilePackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        ((EStructuralFeature.Setting) getXSISchemaLocation()).set(newValue);
        return;
      case AlloyXSDFilePackage.DOCUMENT_ROOT__ALLOY:
        setAlloy((AlloyType) newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case AlloyXSDFilePackage.DOCUMENT_ROOT__MIXED:
        getMixed().clear();
        return;
      case AlloyXSDFilePackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        getXMLNSPrefixMap().clear();
        return;
      case AlloyXSDFilePackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        getXSISchemaLocation().clear();
        return;
      case AlloyXSDFilePackage.DOCUMENT_ROOT__ALLOY:
        setAlloy((AlloyType) null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case AlloyXSDFilePackage.DOCUMENT_ROOT__MIXED:
        return mixed != null && !mixed.isEmpty();
      case AlloyXSDFilePackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
        return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
      case AlloyXSDFilePackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
        return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
      case AlloyXSDFilePackage.DOCUMENT_ROOT__ALLOY:
        return getAlloy() != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (mixed: ");
    result.append(mixed);
    result.append(')');
    return result.toString();
  }

} // DocumentRootImpl
