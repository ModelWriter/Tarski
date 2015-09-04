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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mark Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Marker.MarkElement#getId <em>Id</em>}</li>
 *   <li>{@link Marker.MarkElement#getOffset <em>Offset</em>}</li>
 *   <li>{@link Marker.MarkElement#getLength <em>Length</em>}</li>
 *   <li>{@link Marker.MarkElement#getMessage <em>Message</em>}</li>
 *   <li>{@link Marker.MarkElement#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link Marker.MarkElement#getFullPath <em>Full Path</em>}</li>
 *   <li>{@link Marker.MarkElement#getTarget <em>Target</em>}</li>
 *   <li>{@link Marker.MarkElement#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see Marker.MarkerPackage#getMarkElement()
 * @model
 * @generated
 */
public interface MarkElement extends EObject {
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see Marker.MarkerPackage#getMarkElement_Id()
   * @model id="true"
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link Marker.MarkElement#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Offset</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Offset</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Offset</em>' attribute.
   * @see #setOffset(int)
   * @see Marker.MarkerPackage#getMarkElement_Offset()
   * @model
   * @generated
   */
  int getOffset();

  /**
   * Sets the value of the '{@link Marker.MarkElement#getOffset <em>Offset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Offset</em>' attribute.
   * @see #getOffset()
   * @generated
   */
  void setOffset(int value);

  /**
   * Returns the value of the '<em><b>Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Length</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Length</em>' attribute.
   * @see #setLength(int)
   * @see Marker.MarkerPackage#getMarkElement_Length()
   * @model
   * @generated
   */
  int getLength();

  /**
   * Sets the value of the '{@link Marker.MarkElement#getLength <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Length</em>' attribute.
   * @see #getLength()
   * @generated
   */
  void setLength(int value);

  /**
   * Returns the value of the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message</em>' attribute.
   * @see #setMessage(String)
   * @see Marker.MarkerPackage#getMarkElement_Message()
   * @model
   * @generated
   */
  String getMessage();

  /**
   * Sets the value of the '{@link Marker.MarkElement#getMessage <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message</em>' attribute.
   * @see #getMessage()
   * @generated
   */
  void setMessage(String value);

  /**
   * Returns the value of the '<em><b>Line Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Line Number</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Line Number</em>' attribute.
   * @see #setLineNumber(int)
   * @see Marker.MarkerPackage#getMarkElement_LineNumber()
   * @model
   * @generated
   */
  int getLineNumber();

  /**
   * Sets the value of the '{@link Marker.MarkElement#getLineNumber <em>Line Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Line Number</em>' attribute.
   * @see #getLineNumber()
   * @generated
   */
  void setLineNumber(int value);

  /**
   * Returns the value of the '<em><b>Full Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Full Path</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Full Path</em>' attribute.
   * @see #setFullPath(String)
   * @see Marker.MarkerPackage#getMarkElement_FullPath()
   * @model
   * @generated
   */
  String getFullPath();

  /**
   * Sets the value of the '{@link Marker.MarkElement#getFullPath <em>Full Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Full Path</em>' attribute.
   * @see #getFullPath()
   * @generated
   */
  void setFullPath(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference list.
   * The list contents are of type {@link Marker.MarkElement}.
   * It is bidirectional and its opposite is '{@link Marker.MarkElement#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference list.
   * @see Marker.MarkerPackage#getMarkElement_Target()
   * @see Marker.MarkElement#getSource
   * @model opposite="Source"
   * @generated
   */
  EList<MarkElement> getTarget();

  /**
   * Returns the value of the '<em><b>Source</b></em>' reference list.
   * The list contents are of type {@link Marker.MarkElement}.
   * It is bidirectional and its opposite is '{@link Marker.MarkElement#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference list.
   * @see Marker.MarkerPackage#getMarkElement_Source()
   * @see Marker.MarkElement#getTarget
   * @model opposite="Target"
   * @generated
   */
  EList<MarkElement> getSource();

} // MarkElement
