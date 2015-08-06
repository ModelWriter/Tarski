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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Scope</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.Scope#getLocations <em>Locations</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.Scope#getHolder <em>Holder</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getScope()
 * @model
 * @generated NOT
 */
public interface Scope extends IBaseElement, IScope {
	/**
	 * Returns the value of the '<em><b>Locations</b></em>' reference list. The list contents are of type
	 * {@link org.eclipse.mylyn.docs.intent.mapping.Location}. It is bidirectional and its opposite is '
	 * {@link org.eclipse.mylyn.docs.intent.mapping.Location#getReferencingScopes <em>Referencing Scopes</em>}
	 * '. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locations</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Locations</em>' reference list.
	 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getScope_Locations()
	 * @see org.eclipse.mylyn.docs.intent.mapping.Location#getReferencingScopes
	 * @model opposite="referencingScopes" required="true"
	 * @generated NOT
	 */
	EList<ILocation> getLocations();

	/**
	 * Returns the value of the '<em><b>Holder</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link org.eclipse.mylyn.docs.intent.mapping.Location#getScope <em>Scope</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Holder</em>' container reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Holder</em>' container reference.
	 * @see #setHolder(Location)
	 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getScope_Holder()
	 * @see org.eclipse.mylyn.docs.intent.mapping.Location#getScope
	 * @model opposite="scope" required="true" transient="false"
	 * @generated
	 */
	Location getHolder();

	/**
	 * Sets the value of the '{@link org.eclipse.mylyn.docs.intent.mapping.Scope#getHolder <em>Holder</em>}'
	 * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Holder</em>' container reference.
	 * @see #getHolder()
	 * @generated
	 */
	void setHolder(Location value);

} // Scope
