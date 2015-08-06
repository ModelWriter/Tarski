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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Location</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.Location#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.Location#getScope <em>Scope</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.Location#getSourceLinks <em>Source Links</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.Location#getTargetLinks <em>Target Links</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.Location#getContents <em>Contents</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.Location#getContainer <em>Container</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.Location#getReferencingScopes <em>Referencing Scopes</em>}
 * </li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getLocation()
 * @model interface="true" abstract="true"
 * @generated NOT
 */
public interface Location extends IBaseElement, ILocation {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getLocation_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.docs.intent.mapping.Location#getName <em>Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' containment reference. It is bidirectional and its
	 * opposite is '{@link org.eclipse.mylyn.docs.intent.mapping.Scope#getHolder <em>Holder</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' containment reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Scope</em>' containment reference.
	 * @see #setScope(Scope)
	 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getLocation_Scope()
	 * @see org.eclipse.mylyn.docs.intent.mapping.Scope#getHolder
	 * @model opposite="holder" containment="true"
	 * @generated
	 */
	Scope getScope();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.docs.intent.mapping.Location#getScope <em>Scope</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Scope</em>' containment reference.
	 * @see #getScope()
	 * @generated
	 */
	void setScope(Scope value);

	/**
	 * Returns the value of the '<em><b>Source Links</b></em>' reference list. The list contents are of type
	 * {@link org.eclipse.mylyn.docs.intent.mapping.Link}. It is bidirectional and its opposite is '
	 * {@link org.eclipse.mylyn.docs.intent.mapping.Link#getTarget <em>Target</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Links</em>' reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source Links</em>' reference list.
	 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getLocation_SourceLinks()
	 * @see org.eclipse.mylyn.docs.intent.mapping.Link#getTarget
	 * @model opposite="target"
	 * @generated NOT
	 */
	EList<ILink> getSourceLinks();

	/**
	 * Returns the value of the '<em><b>Target Links</b></em>' containment reference list. The list contents
	 * are of type {@link org.eclipse.mylyn.docs.intent.mapping.Link}. It is bidirectional and its opposite is
	 * '{@link org.eclipse.mylyn.docs.intent.mapping.Link#getSource <em>Source</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Links</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target Links</em>' containment reference list.
	 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getLocation_TargetLinks()
	 * @see org.eclipse.mylyn.docs.intent.mapping.Link#getSource
	 * @model opposite="source" containment="true"
	 * @generated NOT
	 */
	EList<ILink> getTargetLinks();

	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list. The list contents are
	 * of type {@link org.eclipse.mylyn.docs.intent.mapping.Location}. It is bidirectional and its opposite is
	 * '{@link org.eclipse.mylyn.docs.intent.mapping.Location#getContainer <em>Container</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getLocation_Contents()
	 * @see org.eclipse.mylyn.docs.intent.mapping.Location#getContainer
	 * @model opposite="container" containment="true"
	 * @generated NOT
	 */
	EList<ILocation> getContents();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link org.eclipse.mylyn.docs.intent.mapping.Location#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(Location)
	 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getLocation_Container()
	 * @see org.eclipse.mylyn.docs.intent.mapping.Location#getContents
	 * @model opposite="contents" transient="false"
	 * @generated
	 */
	Location getContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.docs.intent.mapping.Location#getContainer
	 * <em>Container</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Location value);

	/**
	 * Returns the value of the '<em><b>Referencing Scopes</b></em>' reference list. The list contents are of
	 * type {@link org.eclipse.mylyn.docs.intent.mapping.Scope}. It is bidirectional and its opposite is '
	 * {@link org.eclipse.mylyn.docs.intent.mapping.Scope#getLocations <em>Locations</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referencing Scopes</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Referencing Scopes</em>' reference list.
	 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getLocation_ReferencingScopes()
	 * @see org.eclipse.mylyn.docs.intent.mapping.Scope#getLocations
	 * @model opposite="locations"
	 * @generated NOT
	 */
	EList<IScope> getReferencingScopes();

} // Location
