/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.mylyn.docs.intent.mapping;

import java.util.List;

/**
 * Add visibility to the {@link IScope#getHolder() holder} in order to {@link ILink#getTarget() target} other
 * {@link IScope#getLocations() locations}.
 *
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface IScope extends IMappingElement {

	/**
	 * Sets the {@link ILocation} holding this {@link IScope}.
	 * 
	 * @param location
	 *            the {@link ILocation} holding this {@link IScope}
	 */
	void setHolder(ILocation location);

	/**
	 * Gets the {@link ILocation} holding this {@link IScope}.
	 * 
	 * @return the {@link ILocation} holding this {@link IScope}
	 */
	ILocation getHolder();

	/**
	 * Gets the {@link List} of visible {@link ILocation}.
	 * 
	 * @return the {@link List} of visible {@link ILocation}
	 */
	List<ILocation> getLocations();

	/**
	 * Adds a {@link IScopeListener}.
	 * 
	 * @param listener
	 *            the {@link IScopeListener} to add
	 */
	void addListener(IScopeListener listener);

	/**
	 * Removes a {@link IScopeListener}.
	 * 
	 * @param listener
	 *            the {@link IScopeListener} to remove
	 */
	void removeListener(IScopeListener listener);
}
