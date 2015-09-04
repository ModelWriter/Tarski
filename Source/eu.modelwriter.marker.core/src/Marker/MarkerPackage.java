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
package Marker;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see Marker.MarkerFactory
 * @model kind="package"
 * @generated
 */
public interface MarkerPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "Marker";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "platform:/plugin/eu.modelwriter.marker.core/model/marker.ecore";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "Marker";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MarkerPackage eINSTANCE = Marker.impl.MarkerPackageImpl.init();

  /**
   * The meta object id for the '{@link Marker.impl.MarkElementImpl <em>Mark Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see Marker.impl.MarkElementImpl
   * @see Marker.impl.MarkerPackageImpl#getMarkElement()
   * @generated
   */
  int MARK_ELEMENT = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MARK_ELEMENT__ID = 0;

  /**
   * The feature id for the '<em><b>Offset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MARK_ELEMENT__OFFSET = 1;

  /**
   * The feature id for the '<em><b>Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MARK_ELEMENT__LENGTH = 2;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MARK_ELEMENT__MESSAGE = 3;

  /**
   * The feature id for the '<em><b>Line Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MARK_ELEMENT__LINE_NUMBER = 4;

  /**
   * The feature id for the '<em><b>Full Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MARK_ELEMENT__FULL_PATH = 5;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MARK_ELEMENT__TARGET = 6;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MARK_ELEMENT__SOURCE = 7;

  /**
   * The number of structural features of the '<em>Mark Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MARK_ELEMENT_FEATURE_COUNT = 8;

  /**
   * The number of operations of the '<em>Mark Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MARK_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link Marker.impl.MarkElementCollectionImpl <em>Mark Element Collection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see Marker.impl.MarkElementCollectionImpl
   * @see Marker.impl.MarkerPackageImpl#getMarkElementCollection()
   * @generated
   */
  int MARK_ELEMENT_COLLECTION = 1;

  /**
   * The feature id for the '<em><b>Mark Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MARK_ELEMENT_COLLECTION__MARK_ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Mark Element Collection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MARK_ELEMENT_COLLECTION_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Mark Element Collection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MARK_ELEMENT_COLLECTION_OPERATION_COUNT = 0;


  /**
   * Returns the meta object for class '{@link Marker.MarkElement <em>Mark Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mark Element</em>'.
   * @see Marker.MarkElement
   * @generated
   */
  EClass getMarkElement();

  /**
   * Returns the meta object for the attribute '{@link Marker.MarkElement#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see Marker.MarkElement#getId()
   * @see #getMarkElement()
   * @generated
   */
  EAttribute getMarkElement_Id();

  /**
   * Returns the meta object for the attribute '{@link Marker.MarkElement#getOffset <em>Offset</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Offset</em>'.
   * @see Marker.MarkElement#getOffset()
   * @see #getMarkElement()
   * @generated
   */
  EAttribute getMarkElement_Offset();

  /**
   * Returns the meta object for the attribute '{@link Marker.MarkElement#getLength <em>Length</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Length</em>'.
   * @see Marker.MarkElement#getLength()
   * @see #getMarkElement()
   * @generated
   */
  EAttribute getMarkElement_Length();

  /**
   * Returns the meta object for the attribute '{@link Marker.MarkElement#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see Marker.MarkElement#getMessage()
   * @see #getMarkElement()
   * @generated
   */
  EAttribute getMarkElement_Message();

  /**
   * Returns the meta object for the attribute '{@link Marker.MarkElement#getLineNumber <em>Line Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Line Number</em>'.
   * @see Marker.MarkElement#getLineNumber()
   * @see #getMarkElement()
   * @generated
   */
  EAttribute getMarkElement_LineNumber();

  /**
   * Returns the meta object for the attribute '{@link Marker.MarkElement#getFullPath <em>Full Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Full Path</em>'.
   * @see Marker.MarkElement#getFullPath()
   * @see #getMarkElement()
   * @generated
   */
  EAttribute getMarkElement_FullPath();

  /**
   * Returns the meta object for the reference list '{@link Marker.MarkElement#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Target</em>'.
   * @see Marker.MarkElement#getTarget()
   * @see #getMarkElement()
   * @generated
   */
  EReference getMarkElement_Target();

  /**
   * Returns the meta object for the reference list '{@link Marker.MarkElement#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Source</em>'.
   * @see Marker.MarkElement#getSource()
   * @see #getMarkElement()
   * @generated
   */
  EReference getMarkElement_Source();

  /**
   * Returns the meta object for class '{@link Marker.MarkElementCollection <em>Mark Element Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mark Element Collection</em>'.
   * @see Marker.MarkElementCollection
   * @generated
   */
  EClass getMarkElementCollection();

  /**
   * Returns the meta object for the containment reference list '{@link Marker.MarkElementCollection#getMarkElements <em>Mark Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mark Elements</em>'.
   * @see Marker.MarkElementCollection#getMarkElements()
   * @see #getMarkElementCollection()
   * @generated
   */
  EReference getMarkElementCollection_MarkElements();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MarkerFactory getMarkerFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link Marker.impl.MarkElementImpl <em>Mark Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see Marker.impl.MarkElementImpl
     * @see Marker.impl.MarkerPackageImpl#getMarkElement()
     * @generated
     */
    EClass MARK_ELEMENT = eINSTANCE.getMarkElement();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MARK_ELEMENT__ID = eINSTANCE.getMarkElement_Id();

    /**
     * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MARK_ELEMENT__OFFSET = eINSTANCE.getMarkElement_Offset();

    /**
     * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MARK_ELEMENT__LENGTH = eINSTANCE.getMarkElement_Length();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MARK_ELEMENT__MESSAGE = eINSTANCE.getMarkElement_Message();

    /**
     * The meta object literal for the '<em><b>Line Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MARK_ELEMENT__LINE_NUMBER = eINSTANCE.getMarkElement_LineNumber();

    /**
     * The meta object literal for the '<em><b>Full Path</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MARK_ELEMENT__FULL_PATH = eINSTANCE.getMarkElement_FullPath();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MARK_ELEMENT__TARGET = eINSTANCE.getMarkElement_Target();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MARK_ELEMENT__SOURCE = eINSTANCE.getMarkElement_Source();

    /**
     * The meta object literal for the '{@link Marker.impl.MarkElementCollectionImpl <em>Mark Element Collection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see Marker.impl.MarkElementCollectionImpl
     * @see Marker.impl.MarkerPackageImpl#getMarkElementCollection()
     * @generated
     */
    EClass MARK_ELEMENT_COLLECTION = eINSTANCE.getMarkElementCollection();

    /**
     * The meta object literal for the '<em><b>Mark Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MARK_ELEMENT_COLLECTION__MARK_ELEMENTS = eINSTANCE.getMarkElementCollection_MarkElements();

  }

} //MarkerPackage
