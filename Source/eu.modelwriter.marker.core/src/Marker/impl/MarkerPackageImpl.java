/**
 */
package Marker.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;

import Marker.MarkElement;
import Marker.MarkElementCollection;
import Marker.MarkerFactory;
import Marker.MarkerPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class MarkerPackageImpl extends EPackageImpl implements MarkerPackage {
  @Override
  protected Resource createResource(String uri) {
    return super.createResource("marker.ecore");
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass markElementEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass markElementCollectionEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
   * value.
   * <p>
   * Note: the correct way to create the package is via the static factory method {@link #init
   * init()}, which also performs initialization of the package, or returns the registered package,
   * if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see Marker.MarkerPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private MarkerPackageImpl() {
    super(eNS_URI, MarkerFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon
   * which it depends.
   * 
   * <p>
   * This method is used to initialize {@link MarkerPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain
   * the package. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static MarkerPackage init() {
    if (isInited)
      return (MarkerPackage) EPackage.Registry.INSTANCE.getEPackage(MarkerPackage.eNS_URI);

    // Obtain or create and register package
    MarkerPackageImpl theMarkerPackage =
        (MarkerPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MarkerPackageImpl
            ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MarkerPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theMarkerPackage.createPackageContents();

    // Initialize created meta-data
    theMarkerPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMarkerPackage.freeze();


    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(MarkerPackage.eNS_URI, theMarkerPackage);
    return theMarkerPackage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getMarkElement() {
    return markElementEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getMarkElement_Id() {
    return (EAttribute) markElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getMarkElement_Offset() {
    return (EAttribute) markElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getMarkElement_Length() {
    return (EAttribute) markElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getMarkElement_Message() {
    return (EAttribute) markElementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getMarkElement_LineNumber() {
    return (EAttribute) markElementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getMarkElement_FullPath() {
    return (EAttribute) markElementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getMarkElement_Target() {
    return (EReference) markElementEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getMarkElement_Source() {
    return (EReference) markElementEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getMarkElementCollection() {
    return markElementCollectionEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EReference getMarkElementCollection_MarkElements() {
    return (EReference) markElementCollectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public MarkerFactory getMarkerFactory() {
    return (MarkerFactory) getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package. This method is guarded to have no affect on any
   * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void createPackageContents() {
    if (isCreated)
      return;
    isCreated = true;

    // Create classes and their features
    markElementEClass = createEClass(MARK_ELEMENT);
    createEAttribute(markElementEClass, MARK_ELEMENT__ID);
    createEAttribute(markElementEClass, MARK_ELEMENT__OFFSET);
    createEAttribute(markElementEClass, MARK_ELEMENT__LENGTH);
    createEAttribute(markElementEClass, MARK_ELEMENT__MESSAGE);
    createEAttribute(markElementEClass, MARK_ELEMENT__LINE_NUMBER);
    createEAttribute(markElementEClass, MARK_ELEMENT__FULL_PATH);
    createEReference(markElementEClass, MARK_ELEMENT__TARGET);
    createEReference(markElementEClass, MARK_ELEMENT__SOURCE);

    markElementCollectionEClass = createEClass(MARK_ELEMENT_COLLECTION);
    createEReference(markElementCollectionEClass, MARK_ELEMENT_COLLECTION__MARK_ELEMENTS);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model. This method is guarded to have
   * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized)
      return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes, features, and operations; add parameters
    initEClass(markElementEClass, MarkElement.class, "MarkElement", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMarkElement_Id(), ecorePackage.getEString(), "Id", null, 0, 1,
        MarkElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMarkElement_Offset(), ecorePackage.getEInt(), "Offset", null, 0, 1,
        MarkElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMarkElement_Length(), ecorePackage.getEInt(), "Length", null, 0, 1,
        MarkElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMarkElement_Message(), ecorePackage.getEString(), "Message", null, 0, 1,
        MarkElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMarkElement_LineNumber(), ecorePackage.getEInt(), "LineNumber", null, 0, 1,
        MarkElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMarkElement_FullPath(), ecorePackage.getEString(), "FullPath", null, 0, 1,
        MarkElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMarkElement_Target(), this.getMarkElement(), this.getMarkElement_Source(),
        "Target", null, 0, -1, MarkElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMarkElement_Source(), this.getMarkElement(), this.getMarkElement_Target(),
        "Source", null, 0, -1, MarkElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(markElementCollectionEClass, MarkElementCollection.class, "MarkElementCollection",
        !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMarkElementCollection_MarkElements(), this.getMarkElement(), null,
        "MarkElements", null, 0, -1, MarkElementCollection.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} // MarkerPackageImpl
