/**
 */
package eu.modelwriter.traceability.core.persistence.impl;

import eu.modelwriter.traceability.core.persistence.PropertiesType;
import eu.modelwriter.traceability.core.persistence.persistencePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Properties Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.PropertiesTypeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.PropertiesTypeImpl#getGroupID <em>Group ID</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.PropertiesTypeImpl#getLeaderID <em>Leader ID</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.PropertiesTypeImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.PropertiesTypeImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.PropertiesTypeImpl#getText <em>Text</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.PropertiesTypeImpl#getUri <em>Uri</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertiesTypeImpl extends MinimalEObjectImpl.Container implements PropertiesType {
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
   * The default value of the '{@link #getGroupID() <em>Group ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroupID()
   * @generated
   * @ordered
   */
  protected static final String GROUP_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGroupID() <em>Group ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroupID()
   * @generated
   * @ordered
   */
  protected String groupID = GROUP_ID_EDEFAULT;

  /**
   * The default value of the '{@link #getLeaderID() <em>Leader ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeaderID()
   * @generated
   * @ordered
   */
  protected static final String LEADER_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLeaderID() <em>Leader ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeaderID()
   * @generated
   * @ordered
   */
  protected String leaderID = LEADER_ID_EDEFAULT;

  /**
   * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocation()
   * @generated
   * @ordered
   */
  protected static final String LOCATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocation()
   * @generated
   * @ordered
   */
  protected String location = LOCATION_EDEFAULT;

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
   * This is true if the Offset attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean offsetESet;

  /**
   * The default value of the '{@link #getText() <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getText()
   * @generated
   * @ordered
   */
  protected static final String TEXT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getText()
   * @generated
   * @ordered
   */
  protected String text = TEXT_EDEFAULT;

  /**
   * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected static final String URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected String uri = URI_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertiesTypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return persistencePackage.Literals.PROPERTIES_TYPE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.PROPERTIES_TYPE__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGroupID() {
    return groupID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGroupID(String newGroupID) {
    String oldGroupID = groupID;
    groupID = newGroupID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.PROPERTIES_TYPE__GROUP_ID, oldGroupID, groupID));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLeaderID() {
    return leaderID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeaderID(String newLeaderID) {
    String oldLeaderID = leaderID;
    leaderID = newLeaderID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.PROPERTIES_TYPE__LEADER_ID, oldLeaderID, leaderID));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLocation() {
    return location;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLocation(String newLocation) {
    String oldLocation = location;
    location = newLocation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.PROPERTIES_TYPE__LOCATION, oldLocation, location));
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
    boolean oldOffsetESet = offsetESet;
    offsetESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.PROPERTIES_TYPE__OFFSET, oldOffset, offset, !oldOffsetESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetOffset() {
    int oldOffset = offset;
    boolean oldOffsetESet = offsetESet;
    offset = OFFSET_EDEFAULT;
    offsetESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, persistencePackage.PROPERTIES_TYPE__OFFSET, oldOffset, OFFSET_EDEFAULT, oldOffsetESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetOffset() {
    return offsetESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getText() {
    return text;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setText(String newText) {
    String oldText = text;
    text = newText;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.PROPERTIES_TYPE__TEXT, oldText, text));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUri() {
    return uri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUri(String newUri) {
    String oldUri = uri;
    uri = newUri;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.PROPERTIES_TYPE__URI, oldUri, uri));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case persistencePackage.PROPERTIES_TYPE__VALUE:
        return getValue();
      case persistencePackage.PROPERTIES_TYPE__GROUP_ID:
        return getGroupID();
      case persistencePackage.PROPERTIES_TYPE__LEADER_ID:
        return getLeaderID();
      case persistencePackage.PROPERTIES_TYPE__LOCATION:
        return getLocation();
      case persistencePackage.PROPERTIES_TYPE__OFFSET:
        return getOffset();
      case persistencePackage.PROPERTIES_TYPE__TEXT:
        return getText();
      case persistencePackage.PROPERTIES_TYPE__URI:
        return getUri();
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
      case persistencePackage.PROPERTIES_TYPE__VALUE:
        setValue((String)newValue);
        return;
      case persistencePackage.PROPERTIES_TYPE__GROUP_ID:
        setGroupID((String)newValue);
        return;
      case persistencePackage.PROPERTIES_TYPE__LEADER_ID:
        setLeaderID((String)newValue);
        return;
      case persistencePackage.PROPERTIES_TYPE__LOCATION:
        setLocation((String)newValue);
        return;
      case persistencePackage.PROPERTIES_TYPE__OFFSET:
        setOffset((Integer)newValue);
        return;
      case persistencePackage.PROPERTIES_TYPE__TEXT:
        setText((String)newValue);
        return;
      case persistencePackage.PROPERTIES_TYPE__URI:
        setUri((String)newValue);
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
      case persistencePackage.PROPERTIES_TYPE__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case persistencePackage.PROPERTIES_TYPE__GROUP_ID:
        setGroupID(GROUP_ID_EDEFAULT);
        return;
      case persistencePackage.PROPERTIES_TYPE__LEADER_ID:
        setLeaderID(LEADER_ID_EDEFAULT);
        return;
      case persistencePackage.PROPERTIES_TYPE__LOCATION:
        setLocation(LOCATION_EDEFAULT);
        return;
      case persistencePackage.PROPERTIES_TYPE__OFFSET:
        unsetOffset();
        return;
      case persistencePackage.PROPERTIES_TYPE__TEXT:
        setText(TEXT_EDEFAULT);
        return;
      case persistencePackage.PROPERTIES_TYPE__URI:
        setUri(URI_EDEFAULT);
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
      case persistencePackage.PROPERTIES_TYPE__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
      case persistencePackage.PROPERTIES_TYPE__GROUP_ID:
        return GROUP_ID_EDEFAULT == null ? groupID != null : !GROUP_ID_EDEFAULT.equals(groupID);
      case persistencePackage.PROPERTIES_TYPE__LEADER_ID:
        return LEADER_ID_EDEFAULT == null ? leaderID != null : !LEADER_ID_EDEFAULT.equals(leaderID);
      case persistencePackage.PROPERTIES_TYPE__LOCATION:
        return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
      case persistencePackage.PROPERTIES_TYPE__OFFSET:
        return isSetOffset();
      case persistencePackage.PROPERTIES_TYPE__TEXT:
        return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
      case persistencePackage.PROPERTIES_TYPE__URI:
        return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
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
    result.append(", groupID: ");
    result.append(groupID);
    result.append(", leaderID: ");
    result.append(leaderID);
    result.append(", location: ");
    result.append(location);
    result.append(", offset: ");
    if (offsetESet) result.append(offset); else result.append("<unset>");
    result.append(", text: ");
    result.append(text);
    result.append(", uri: ");
    result.append(uri);
    result.append(')');
    return result.toString();
  }

} //PropertiesTypeImpl
