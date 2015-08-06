/**
 *  Copyright (c) 2015 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *     Obeo - initial API and implementation and/or initial documentation
 *     ...
 * 
 */
package org.eclipse.mylyn.docs.intent.mapping;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Link</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.Link#getStatus <em>Status</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.Link#getDescription <em>Description</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.Link#getSource <em>Source</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.Link#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getLink()
 * @model
 * @generated NOT
 */
public interface Link extends IBaseElement, ILink {
	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute. The default value is <code>"VALID"</code>.
	 * The literals are from the enumeration {@link org.eclipse.mylyn.docs.intent.mapping.Status}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.eclipse.mylyn.docs.intent.mapping.Status
	 * @see #setStatus(Status)
	 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getLink_Status()
	 * @model default="VALID" required="true"
	 * @generated
	 */
	Status getStatus();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.docs.intent.mapping.Link#getStatus <em>Status</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Status</em>' attribute.
	 * @see org.eclipse.mylyn.docs.intent.mapping.Status
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(Status value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getLink_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.docs.intent.mapping.Link#getDescription
	 * <em>Description</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link org.eclipse.mylyn.docs.intent.mapping.Location#getTargetLinks
	 * <em>Target Links</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(Location)
	 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getLink_Source()
	 * @see org.eclipse.mylyn.docs.intent.mapping.Location#getTargetLinks
	 * @model opposite="targetLinks" required="true" transient="false"
	 * @generated
	 */
	Location getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.docs.intent.mapping.Link#getSource <em>Source</em>}'
	 * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Location value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference. It is bidirectional and its opposite is '
	 * {@link org.eclipse.mylyn.docs.intent.mapping.Location#getSourceLinks <em>Source Links</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Location)
	 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getLink_Target()
	 * @see org.eclipse.mylyn.docs.intent.mapping.Location#getSourceLinks
	 * @model opposite="sourceLinks" required="true"
	 * @generated
	 */
	Location getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.docs.intent.mapping.Link#getTarget <em>Target</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Location value);

} // Link
